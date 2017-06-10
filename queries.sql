
1. List a company’s workers by names.

"select per_name\n" +
"from person natural join occupation\n" +
"where comp_id = '"+companyCombo.getSelectedItem()+"' and occ_status = 'employed'";

2. List a company’s staff by salary in descending order.  

"select per_name, pay_rate\n" +
"from person natural join occupation natural join job\n" +
"where occ_status = 'employed' and comp_id = '"+companyCombo.getSelectedItem()+"'\n" +
"order by (pay_rate) desc";

3. List companies’ labor cost (total salaries and wage rates by 1920 hours) in descending order.  

"with total_salary as(\n" +
"   select sum (pay_rate) as t_salary, comp_id\n" +
"   from job natural join occupation\n" +
"   where job_type = 'salary' and occ_status = 'employed'\n" +
"   group by comp_id),\n" +
"total_wages as(\n" +
"   select sum(pay_rate) as t_wages,comp_id\n" +
"   from job natural join occupation\n" +
"   where job_type = 'wage' and occ_status = 'employed'\n" +
"   group by comp_id)\n" +
"select (t_wages+t_salary) as total_cost,comp_id\n" +
"from total_salary natural join total_wages\n" +
"order by total_cost desc";

4. Find all the jobs a person is currently holding. 

"select job_code\n" +
"from occupation\n" +
"where per_id = '"+personCombo.getSelectedItem()+"' and occ_status = 'employed'";

5. List a person’s knowledge/skills in a readable format.  

"select sk_title, sk_description\n" +
"from person_skills natural join skills\n" +
"where per_id = '"+personCombo.getSelectedItem()+"'";

6. List the skill gap of a worker between his/her job(s) and his/her skills.  

"with person_jobs (job_code)as(\n" +
"   select  job_code\n" +
"   from occupation\n" +
"   where per_id = '"+personCombo.getSelectedItem()+"' and occ_status = 'employed')\n" +
"(select sk_code\n" +
"from job_profile_skills natural join person_jobs natural join job)\n" +
"minus\n" +
"(select sk_code\n" +
"from person_skills\n" +
"where per_id = '"+personCombo.getSelectedItem()+"')";  

7. List the required knowledge/skills of a job profile in a readable format. 

"select sk_code,sk_description\n" +
"from job_profile_skills natural join skills\n" +
"where pos_code = '"+positionCombo.getSelectedItem()+"'";

8. List a person’s missing knowledge/skills for a specific job in a readable format.  

"(select sk_code,sk_description\n" +
"from job_profile_skills natural join skills natural join job\n" +
"where job_code = '"+jobCombo.getSelectedItem()+"') \n" +
"minus \n" +
"(select sk_code,sk_description\n" +
"from person_skills natural join skills\n" +
"where per_id = '"+personCombo.getSelectedItem()+"')";   

9. Find the courses each of which alone can cover a given skill set. 

"with skills_sets as(\n" +
"   select sk_code\n" +
"   from job_profile_skills\n" +
"   where pos_code = '"+positionCombo.getSelectedItem()+"'\n" +
")\n" +
"select C.course_code\n" +
"from course C\n" +
"where not exists(select *\n" +
"	from skills_sets\n" +
"	minus\n" +
"	select sk_code\n" +
"	from course_skills \n" +
"	where course_skills.course_code = C.course_code)"; 

10. List the courses (course id and title) that each alone teaches all the missing knowledge/skills for a person to pursue a specific job.   

"with skills_sets as(\n" +
"   select sk_code\n" +
"   from job_profile_skills natural join job\n" +
"   where job_code = '"+jobCombo.getSelectedItem()+"'\n" +
"   minus\n" +
"   select sk_code\n" +
"   from person_skills\n" +
"   where per_id = '"+personCombo.getSelectedItem()+"'\n" +
"),\n" +
"the_course_skills as(\n" +
"   select distinct C.course_code,C.title\n" +
"   from course C\n" +
"   where not exists(select *\n" +
"       from skills_sets\n" +
"       minus\n" +
"       select sk_code\n" +
"       from course_skills\n" +
"       where course_skills.course_code = C.course_code\n" +
"))\n" +
"select *\n" +
"from the_course_skills";

11. Suppose the skill gap of a worker and the requirement of a desired job can be covered by one course.  Find the “quickest” solution for this worker.  
	Show the course, section information and the completing date.  

"with person_needs as (\n" +
"   (select sk_code\n" +
"   from job_profile_skills natural join job\n" +
"   where job_code = '"+jobCombo.getSelectedItem()+"') \n" +
"   minus\n" +
"   (select sk_code\n" +
"   from person_skills\n" +
"   where per_id = '"+personCombo.getSelectedItem()+"')\n" +
"),\n" +
"the_course_skills as(\n" +
"   select distinct C.course_code,S.sec_year\n" +
"   from course C, section S\n" +
"   where not exists(select *\n" +
"       from person_needs\n" +
"       minus\n" +
"       select sk_code\n" +
"       from course_skills natural join section\n" +
"       where course_code = C.course_code and sec_year = S.sec_year\n"+
"))\n" +
"select course_code,sec_year\n" +
"from the_course_skills\n" +
"where sec_year >= 2016";

12. If query #9 returns nothing, then find the course sets with the minimum number of courses that their combination covers the given skill set.  
	The considered course sets will not include more than three courses.

"with job_set as(\n" +
"	select job_code,sk_code\n" +
"	from job natural join job_profile_skills\n" +
"	where pos_code = '"+positionCombo.getSelectedItem()+"'\n" +
"),\n" +
"course_sets as(\n" +
"	select course_code as A,null as B,null as C\n" +
"	from course\n" +
"	union\n" +
"	select A.course_code as A,B.course_code as B,null as C\n" +
"	from course A,course B\n" +
"	where A.course_code < B.course_code\n" +
"	union\n" +
"	select A.course_code as A,B.course_code as B,C.course_code as C\n" +
"	from course A,course B,course C\n" +
"	where A.course_code < B.course_code and B.course_code < C.course_code),\n" +
"course_set_skills as(\n" +
"	select A,B,C,sk_code\n" +
"	from course_skills,course_sets\n" +
"	where course_sets.A = course_skills.course_code or\n" +
"		  course_sets.B = course_skills.course_code or\n" +
"		  course_sets.C = course_skills.course_code\n" +
"),\n" +
"good_sets as (\n" +
"	select *\n" +
"	from(\n" +
"		(select A,B,C from course_set_skills)\n" +
"		minus\n" +
"	(select A,B,C\n" +
"		from(select A,B,C,sk_code\n" +
"		from(select A,B,C\n" +
"		from course_set_skills),\n" +
"	(select *\n" +
"		from job_set)\n" +
"		minus\n" +
"	select A,B,C,sk_code\n" +
"	from course_set_skills)))),\n" +
"count_em as(\n" +
"	select A,B,C,\n" +
"	case\n" +
"	when B is null then 1\n" +
"	when C is null then 2\n" +
"	else 3\n" +
"	end as number_of_courses\n" +
"	from good_sets)\n" +
"select A,B,C,number_of_courses\n" +
"from count_em\n" +
"where number_of_courses = (select min(number_of_courses) from count_em)";

13. List the course sets that their combination covers all the missing knowledge/skills for a person to pursue a specific job.  
	The considered course sets will not include more than three courses. 

"with person_needs as (\n" +
"   (select sk_code,sk_description\n" +
"   from job_profile_skills natural join job natural join skills\n" +
"   where job_code = '"+jobCombo.getSelectedItem()+"') \n" +
"   minus\n" +
"   (select sk_code,sk_description\n" +
"   from person_skills natural join skills\n" +
"   where per_id = '"+personCombo.getSelectedItem()+"')\n" +
"),\n" +
"course_sets as(\n" +
"   select course_code as A,null as B,null as C\n" +
"   from course\n" +
"   union\n" +
"   select A.course_code as A,B.course_code as B,null as C\n" +
"   from course A,course B\n" +
"   where A.course_code < B.course_code\n" +
"   union\n" +
"   select A.course_code as A,B.course_code as B,C.course_code as C\n" +
"   from course A,course B,course C\n" +
"   where A.course_code < B.course_code and B.course_code < C.course_code),\n" +
"course_set_skills as(\n" +
"   select A,B,C,sk_code\n" +
"   from course_skills,course_sets\n" +
"   where course_sets.A = course_skills.course_code or\n" +
"       course_sets.B = course_skills.course_code or\n" +
"       course_sets.C = course_skills.course_code\n" +
"),\n" +
"good_sets as (\n" +
"   select *\n" +
"   from(\n" +
"       (select A,B,C from course_set_skills)\n" +
"       minus\n" +
"   (select A,B,C\n" +
"       from(select A,B,C,sk_code\n" +
"       from(select A,B,C\n" +
"       from course_set_skills),\n" +
"   (select *\n" +
"       from person_needs)\n" +
"       minus\n" +
"   select A,B,C,sk_code\n" +
"       from course_set_skills)))),\n" +
"count_em as(\n" +
"   select A,B,C,\n" +
"   case\n" +
"   when B is null then 1\n" +
"   when C is null then 2\n" +
"   else 3\n" +
"   end as number_of_courses\n" +
"from good_sets)\n" +
"select A,B,C,number_of_courses\n" +
"from count_em\n" +
"where number_of_courses = (select min(number_of_courses) from count_em)";

14. Find the cheapest course choices to make up one’s skill gap by showing the courses to take and the total cost (by section prices).  
	The considered course sets will not include more than three courses. 

"with person_needs as (\n" +
"   (select sk_code,sk_description\n" +
"   from job_profile_skills natural join job natural join skills\n" +
"   where job_code = '"+jobCombo.getSelectedItem()+"') \n" +
"   minus \n" +
"   (select sk_code,sk_description\n" +
"   from person_skills natural join skills\n" +
"   where per_id = '"+personCombo.getSelectedItem()+"')\n" +
"),\n" +
"course_sets as(\n" +
"   select course_code as A,null as B,null as C\n" +
"   from course\n" +
"   union\n" +
"   select A.course_code as A,B.course_code as B,null as C\n" +
"   from course A,course B\n" +
"   where A.course_code < B.course_code\n" +
"   union\n" +
"   select A.course_code as A,B.course_code as B,C.course_code as C\n" +
"   from course A,course B,course C\n" +
"   where A.course_code < B.course_code and B.course_code < C.course_code),\n" +
"course_set_skills as(\n" +
"   select A,B,C,sk_code\n" +
"   from course_skills,course_sets\n" +
"   where course_sets.A = course_skills.course_code or\n" +
"       course_sets.B = course_skills.course_code or\n" +
"       course_sets.C = course_skills.course_code\n" +
"),\n" +
"good_sets as (\n" +
"   select *\n" +
"   from(\n" +
"       (select A,B,C from course_set_skills)\n" +
"       minus\n" +
"       (select A,B,C\n" +
"       from(select A,B,C,K.sk_code\n" +
"       from course_set_skills K,\n" +
"       (select *\n" +
"           from person_needs)\n" +
"           minus\n" +
"	select A,B,C,sk_code\n" +
"	from course_set_skills)))),\n" +
"courses_total as(\n" +
"   select A,B,C,A as course_code\n" +
"   from good_sets\n" +
"   union\n" +
"   select A,B,C,B as course_code\n" +
"   from good_sets\n" +
"   union\n" +
"   select A,B,C,C as course_code\n" +
"   from good_sets\n" +
"),\n" +
"associated_cost as(\n" +
"   select A,B,C,sum(retail_price) as total_cost\n" +
"   from courses_total natural join course\n" +
"   group by A,B,C)	\n" +
"select A,B,C,total_cost\n" +
"from associated_cost\n" +
"where total_cost = (select min(total_cost) from associated_cost)";

15. List all the job profiles that a person is qualified for.  

"with persons_skills as(\n" +
"	select sk_code\n" +
"	from person_skills\n" +
"	where per_id = '"+personCombo.getSelectedItem()+"'\n" +
"),\n" +
"persons_certificates as(\n" +
"	select cert_code\n" +
"	from person_certificates\n" +
"	where per_id = '"+personCombo.getSelectedItem()+"'\n" +
")\n" +
"select pos_code,title\n" +
"from job_profile T\n" +
"where not exists(select sk_code\n" +
"       from job_profile_skills\n" +
"       where T.pos_code = pos_code\n" +
"       minus\n" +
"       select sk_code\n" +
"       from persons_skills)\n" +
"	and\n" +
"	not exists(select cert_code\n" +
"           from profile_certificates\n" +
"           where T.pos_code = pos_code\n" +
"           minus\n" +
"           select cert_code\n" +
"           from persons_certificates)";  

16. Find the job with the highest pay rate for a person according to his/her skill qualification.  

"with persons_skills as(\n" +
"	select sk_code\n" +
"	from person_skills\n" +
"	where per_id = '"+personCombo.getSelectedItem()+"'\n" +
"),\n" +
"persons_certificates as(\n" +
"	select cert_code\n" +
"	from person_certificates\n" +
"	where per_id = '"+personCombo.getSelectedItem()+"'\n" +
"),\n" +
"qualified_for as(\n" +
"	select pos_code,title\n" +
"	from job_profile T\n" +
"	where not exists(select sk_code\n" +
"           from job_profile_skills\n" +
"           where T.pos_code = pos_code\n" +
"           minus\n" +
"           select sk_code\n" +
"           from persons_skills)\n" +
"       and\n" +
"       not exists(select cert_code\n" +
"           from profile_certificates\n" +
"           where T.pos_code = pos_code\n" +
"           minus\n" +
"           select cert_code\n" +
"           from persons_certificates)),\n" +
"jobs_qualified_for as(\n" +
"	select distinct job_code\n" +
"	from qualified_for natural join job),\n" +
"them as (\n" +
"	select distinct job_code,(case\n" +
"           when job_type = 'salary' then pay_rate\n" +
"           when job_type = 'wage' then pay_rate\n" +
"           else null\n" +
"           end) as max_payment\n" +
"       from jobs_qualified_for natural join job),\n" +
"max as (select max(max_payment)\n" +
"from them)\n" +
"select job_code,max_payment\n" +
"from them\n" +
"where max_payment = (select * from max)";   

17. List all the names along with the emails of the persons who are qualified for a job profile.  

"with required_skills as(\n" +
"   select sk_code\n" +
"   from job_profile_skills\n" +
"   where pos_code = '"+positionCombo.getSelectedItem()+"'),\n" +
"required_certificates as(\n" +
"   select cert_code\n" +
"   from profile_certificates\n" +
"   where pos_code = '"+positionCombo.getSelectedItem()+"'\n" +
")\n" +
"select per_name,email\n" +
"from person P\n" +
"where not exists(\n" +
"   select sk_code\n" +
"   from required_skills\n" +
"   minus\n" +
"   select sk_code\n" +
"   from person_skills\n" +
"   where P.per_id = per_id) and not exists(\n" +
"       select cert_code\n" +
"       from required_certificates\n" +
"       minus\n" +
"       select cert_code\n" +
"       from person_certificates\n" +
"       where P.per_id = per_id\n)";        

18. When a company cannot find any qualified person for a job, a secondary solution is to find a person who is almost qualified to the job.  
	Make a “missing-one” list that lists people who miss only one skill for a specified job profile.  

"with skill_codes as(\n" +
"   select sk_code\n" +
"   from job_profile_skills natural join job\n" +
"   where job_code = '"+jobCombo.getSelectedItem()+"'\n" +
"),\n" +
"people_missing as (\n" +
"   select per_id,sk_code" +
"   from person, skill_codes\n" +
"   minus\n" +
"   select per_id, sk_code\n" +
"   from person_skills),\n" +
"num_missing as(\n" +
"   select per_id, count(sk_code) as num\n" +
"   from people_missing\n" +
"   group by per_id\n" +
")\n" +
"select per_id, num\n" +
"from num_missing\n" +
"where  num = 1\n";

19. List the skillID and the number of people in the missing-one list for a given job profile in the ascending order of the people counts.  

"with skill_codes as(\n" +
"   select sk_code\n" +
"   from job_profile_skills\n" +
"   where pos_code = '"+positionCombo.getSelectedItem()+"'\n" +
"),\n" +
"people_missing as (\n" +
"   select per_id, sk_code\n" +
"   from person, skill_codes\n" +
"   minus\n" +
"   select per_id, sk_code\n" +
"   from person_skills),\n" +
"people_missing_skill_count as(\n" +
"   select per_id, count(sk_code) as skills_missing\n" +
"   from people_missing\n" +
"   group by per_id)\n" +
"select count(per_id) as people_count, sk_code\n" +
"from people_missing_skill_count natural join people_missing\n" +
"where skills_missing = 1\n" +
"group by sk_code\n" +
"order by (people_count)\n";

20. Suppose there is a new job profile that has nobody qualified.  List the persons who miss the least number of skills and report the “least number”.  

"with skill_codes as(\n" +
"	select sk_code\n" +
"	from job_profile_skills\n" +
"	where pos_code = '"+positionCombo.getSelectedItem()+"'\n" +
"),\n" +
"people_missing as (\n" +
"	select per_id,sk_code\n" +
"	from person,skill_codes\n" +
"	minus\n" +
"	select per_id,sk_code\n" +
"	from person_skills),\n" +
"num_skills_missing as (\n" +
"	select per_id,count(sk_code) as num_missing\n" +
"	from people_missing\n" +
"	group by per_id),\n" +
"least_missing as(\n" +
"	select min(num_missing) as the_least\n" +
"	from num_skills_missing\n" +
")\n" +
"select per_id,num_missing\n" +
"from least_missing,num_skills_missing\n" +
"where num_missing = the_least";

21. For a specified job profile and a given small number k, make a “missing-k” list that lists the people’s IDs and the number of missing skills for the people who miss only up to k skills in the ascending order of missing skills.   

"with skill_codes as(\n" +
"   select sk_code\n" +
"   from job_profile_skills\n" +
"   where pos_code = '"+positionCombo.getSelectedItem()+"'\n" +
"),\n" +
"people_missing as (\n" +
"   select per_id,sk_code" +
"   from person,skill_codes" +
"   minus\n" +
"   select per_id, sk_code\n" +
"   from person_skills)," +
"num_skills_missing as(" +
"   select per_id,count(sk_code) as num_missing\n" +
"   from people_missing\n" +
"   group by per_id)\n" +
"select per_id,num_missing\n" +
"from num_skills_missing\n" +
"where num_missing <= '"+kText.getText()+"'\n" +
"order by (num_missing) asc";

22. Given a job profile and its corresponding missing-k list specified in Question 22.  Find every skill that is needed by at least one person in the given missing-k list.  
	List each skillID and the number of people who need it in the descending order of the people counts.   

"with skill_codes as(\n" +
"   select sk_code\n" +
"   from job_profile_skills\n" +
"   where pos_code = '"+positionCombo.getSelectedItem()+"'\n" +
"),\n" +
"people_missing as (\n" +
"   select per_id, sk_code\n" +
"   from person,skill_codes \n" +
"   minus\n" +
"   select per_id, sk_code\n" +
"   from person_skills),\n" +
"num_skills_missing as(\n" +
"   select per_id, count(sk_code) as num_missing\n" +
"   from people_missing\n" +
"   group by per_id)\n" +
"select count(per_id) as people_count, sk_code\n" +
"from num_skills_missing natural join people_missing\n" +
"where num_missing = '"+kText.getText()+"'\n" +
"group by sk_code \n" +
"order by (people_count) desc\n";

23. In a local or national crisis, we need to find all the people who once held a job of the special job-profile identifier.  

"select distinct per_id,per_name\n" +
"from occupation natural join job natural join person\n" +
"where pos_code = '"+positionCombo.getSelectedItem()+"'";

24. Find all the unemployed people who once held a job of the given job-profile identifier. 

"with unemployed as(\n" +
"   select per_id\n" +
"   from person\n" +
"   minus\n" +
"   select distinct per_id\n" +
"   from occupation\n" +
"   where occ_status = 'employed'\n" +
")\n" +
"select distinct per_id,job_code,pos_code\n" +
"from occupation natural join job natural join unemployed\n" +
"where pos_code = '"+positionCombo.getSelectedItem()+"'";

25. Find out the biggest employer in terms of number of employees or the total amount of salaries and wages paid to employees.  

"with employer_count as (select count(pay_rate) as num_employees,comp_id\n" +
"   from job natural join occupation\n" +
"   where occ_status = 'employed'\n" +
"   group by comp_id)\n" +
"select comp_id,num_employees\n" +
"from employer_count\n" +
"order by (num_employees) desc";

26. Find out the job distribution among business sectors; find out the biggest sector in terms of number of employees or the total amount of salaries and wages paid to employees.

"with employer_count as ( \n" +
"	select count(pay_rate) as num_employees,comp_id\n" +
"	from job natural join occupation\n" +
"	where occ_status = 'employed'\n" +
"	group by comp_id),\n" +
"count_per_sector as(\n" +
"	select primary_sector,sum(num_employees) as sector_employee_count\n" +
"	from employer_count natural join company\n" +
"	group by primary_sector),\n" +
"max_count as(\n" +
"	select max(sector_employee_count) as the_max\n" +
"	from count_per_sector\n" +
")\n" +
"select primary_sector\n" +
"from max_count,count_per_sector\n" +
"where the_max = sector_employee_count";   

27. Find out the ratio between the people whose earnings increase and those whose earning decrease; find the average rate of earning improvement for the workers in a specific business sector.  

"with previous_salary as(\n" +
"   select distinct max(pay_rate) as past_pay,per_id\n" +
"   from occupation natural join job natural join company\n" +
"   where occ_status = 'unemployed' and primary_sector = '"+sectorCombo.getSelectedItem()+"'\n" +
"   group by per_id\n" +
"),\n" +
"current_salary as(\n" +
"   select distinct max(pay_rate) as now_pay,per_id\n" +
"   from occupation natural join job natural join company\n" +
"   where occ_status = 'employed' and primary_sector = '"+sectorCombo.getSelectedItem()+"'\n" +
"   group by per_id\n" +
"),\n" +
"decrease_people as(\n" +
"   select count(per_id) as decrease\n" +
"   from previous_salary natural join current_salary\n" +
"   where now_pay < past_pay\n" +
"),\n" +
"increase_people as(\n" +
"   select count(per_id) as increase\n" +
"   from previous_salary natural join current_salary\n" +
"   where now_pay > past_pay\n" +
")\n" +
"select sum(increase) as increase_ratio,sum(decrease) as decrease_ratio\n" +
"from increase_people natural join decrease_people";

28. Find the job profiles that have the most openings due to lack of qualified workers.  If there are many opening jobs of a job profile but at the same time there are many qualified jobless people.  Then training cannot help fill up this type of job.  
	What we want to find is such a job profile that has the largest difference between vacancies (the unfilled jobs of this job profile) and the number of jobless people who are qualified for this job profile.  

"with unemployed_people as(\n" +
"	select per_id\n" +
"	from person\n" +
"	minus\n" +
"	select distinct per_id\n" +
"	from occupation\n" +
"	where occ_status = 'employed'\n" +
"	),\n" +
"employed_people as(\n" +
"	select distinct per_id\n" +
"	from occupation\n" +
"	where occ_status = 'employed'\n" +
"),\n" +
"job_openings as(\n" +
"	select distinct job_code\n" +
"	from (\n" +
"           select job_code\n" +
"           from unemployed_people natural join occupation\n" +
"           minus\n" +
"           select job_code\n" +
"           from employed_people natural join occupation\n" +
")),\n" +
"profile_num_jobs as(\n" +
"   select pos_code,count(job_code) as num_jobs_open\n" +
"   from job_openings natural join job\n" +
"   group by pos_code\n" +
"),\n" +
"qualified_people as(\n" +
"	select pos_code,count(per_id) as num_qualified\n" +
"	from profile_num_jobs J,person P\n" +
"	where not exists(\n" +
"       select sk_code\n" +
"       from profile_num_jobs natural join job_profile_skills\n" +
"       where J.pos_code = pos_code\n" +
"       minus\n" +
"       select distinct sk_code\n" +
"       from profile_num_jobs natural join job_profile_skills natural join person_skills\n" +
"       where P.per_id = per_id\n" +
"	)\n" +
"	group by pos_code),\n" +
"lacking as (\n" +
"	select pos_code, (num_jobs_open - num_qualified) as lack_qualified\n" +
"	from qualified_people natural join profile_num_jobs),\n" +
"max_lacking as(\n" +
"	select max(lack_qualified) as max_lack\n" +
"	from lacking\n" +
")\n" +
"select pos_code\n" +
"from lacking,max_lacking\n" +
"where lack_qualified = max_lack";

29. Find the courses that can help most jobless people find a job by training them toward the job profiles that have the most openings due to lack of qualified workers.  

"with unemployed_people as(\n" +
"	select per_id\n" +
"	from person\n" +
"	minus\n" +
"	select distinct per_id\n" +
"	from occupation\n" +
"	where occ_status = 'employed'\n" +
"	),\n" +
"employed_people as(\n" +
"	select distinct per_id\n" +
"	from occupation\n" +
"	where occ_status = 'employed'\n" +
"),\n" +
"job_openings as(\n" +
"	select distinct job_code\n" +
"	from (\n" +
"       select job_code\n" +
"       from unemployed_people natural join occupation\n" +
"       minus\n" +
"       select job_code\n" +
"       from employed_people natural join occupation\n" +
"	)),\n" +
"profile_num_jobs as(\n" +
"	select pos_code,count(job_code) as num_jobs_open\n" +
"	from job_openings natural join job\n" +
"	group by pos_code\n" +
"),\n" +
"qualified_people as(\n" +
"	select pos_code,count(per_id) as num_qualified\n" +
"	from profile_num_jobs J,person P\n" +
"	where not exists(\n" +
"       select sk_code\n" +
"       from profile_num_jobs natural join job_profile_skills\n" +
"       where J.pos_code = pos_code\n" +
"       minus\n" +
"       select distinct sk_code\n" +
"       from profile_num_jobs natural join job_profile_skills natural join person_skills\n" +
"       where P.per_id = per_id\n" +
"	)\n" +
"	group by pos_code),\n" +
"lacking as (\n" +
"	select pos_code, (num_jobs_open - num_qualified) as lack_qualified\n" +
"	from qualified_people natural join profile_num_jobs),\n" +
"max_lacking as(\n" +
"	select max(lack_qualified) as max_lack\n" +
"	from lacking\n" +
"),\n" +
"max_lacking_job as(\n" +
"	select pos_code\n" +
"	from lacking,max_lacking\n" +
"	where lack_qualified = max_lack),\n" +
"course_sets as(\n" +
"	select course_code as A,null as B,null as C\n" +
"	from course\n" +
"	union\n" +
"	select A.course_code as A,B.course_code as B,null as C\n" +
"	from course A,course B\n" +
"	where A.course_code < B.course_code\n" +
"	union\n" +
"	select A.course_code as A,B.course_code as B,C.course_code as C\n" +
"	from course A,course B,course C\n" +
"	where A.course_code < B.course_code and B.course_code < C.course_code),\n" +
"course_set_skills as(\n" +
"	select A,B,C,sk_code\n" +
"	from course_skills,course_sets\n" +
"	where course_sets.A = course_skills.course_code or\n" +
"		  course_sets.B = course_skills.course_code or\n" +
"		  course_sets.C = course_skills.course_code)\n" +
"select *\n" +
"from (\n" +
"	(select A,B,C,pos_code\n" +
"           from course_set_skills,max_lacking_job)\n" +
"           minus\n" +
"               (select A,B,C,pos_code\n" +
"                   from(\n" +
"                   select A,B,C,pos_code,sk_code\n" +
"                   from(select A,B,C\n" +
"                   from course_set_skills),\n" +
"                   (select pos_code,sk_code\n" +
"                   from max_lacking_job natural join job_profile_skills)\n" +
"                   minus\n" +
"                   select A,B,C,pos_code,sk_code\n" +
"                   from course_set_skills,max_lacking_job)))";

30. List all the courses, directly or indirectly required, that a person has to take in order to be qualified for a job of the given profile, according to his/her skills possessed and courses taken.  

"with this_guys_skills as(\n" +
"   select sk_code\n" +
"   from person_skills\n" +
"   where per_id = '"+personCombo.getSelectedItem()+"'\n" +
"),\n" +
"this_guys_courses as(" +
"   select course_code\n" +
"   from takes\n" +
"   where per_id = '"+personCombo.getSelectedItem()+"'\n" +
"),\n" +
"needed_skills as(\n" +
"   select sk_code\n" +
"   from job_profile_skills\n" +
"   where pos_code = '"+positionCombo.getSelectedItem()+"'\n" +
"   minus\n" +
"   select sk_code\n" +
"   from this_guys_skills\n" +
"),\n" +
"courses_needed as(\n" +
"   select course_code\n" +
"   from needed_skills natural join course_skills\n" +
")\n" +
"select distinct course_code\n" +
"from courses_needed C\n" +
"where not exists(\n" +
"   select course_code\n" +
"   from this_guys_courses\n" +
"   where C.course_code = course_code)\n";
