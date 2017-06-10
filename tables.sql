create table person(
	per_id numeric(8,0),
	per_name varchar(20) not null,
	email	varchar(20),
	gender varchar(6) check(gender == 'male' or gender == 'female'),
	primary key(per_id)
);

create table company(
	comp_id numeric(8,0),
	comp_name varchar(35),
	zipcode numeric(5,0),
	primary_sector varchar(15),
	website varchar(30),
	primary key(comp_id)
);

create table skills(
	sk_code numeric(5,0),
	sk_level varchar(15) check(sk_level == 'beginner' or sk_level == 'intermediate' or sk_level == 'advanced'),
	sk_title varchar(15),
	sk_description varchar(30),
	primary key(ks_code)
);

create table certificate(
	cert_code numeric(9,0),
	cert_title varchar(15),
	exp_date numeric(4) check(exp_date > 0),
	primary key(cert_code)
);

create table course(
	course_code varchar(8),
	title varchar(20),
	c_level varchar(8) check(c_level == 'beginner' or c_level == 'intermediate' or c_level == 'advanced'),
	description varchar(30),
	status varchar(8) check(status == 'expired' or status == 'active'),
	retail_price numeric(10,2),
	primary key(course_code)
);

create table section(
	course_code varchar(8),
	sec_no varchar(8),
	year numeric(4,0) check(year > 1701 and year < 2100),
	offered_by varchar(20) check(offered_by == 'university' or offered_by == 'training company'),
	primary key(sec_no,year,course_code),
	foreign key(course_code) references course on delete cascade,
);

create table job_profile(
	pos_code varchar(8),
	sk_code varchar(8),
	cer_code varchar(8),
	avg_pay numeric(8,2) check(avg_pay > 0),
	primary key(pos_code),
	foreign key(ks_code) references skills on delete set null,
	foreign key(cer_code) references certificate on delete set null
);

create table job(
	job_code varchar(8),
	pos_code varchar(8),
	pay_rate numeric(8,2) check(pay_rate > 0),
	pay_type varchar(10) check(pay_type == 'full-time' or pay_type == 'part-time'),
	comp_id varchar(8),
	primary key(job_code),
	foreign key(pos_code) references job_profile on delete set null
);

create table takes(
	per_id varchar(8),
	sec_no varchar(8),
	year numeric(4,0) check(year > 1701 and year < 2100),
	offered_by varchar(20) check(offered_by == 'university' or offered_by == 'training company'),
	primary key(per_id,sec_no,year),
	foreign key(per_id) references person on delete cascade,
	foreign key(sec_no,year) references section on delete cascade,
	foreign key(offered_by) references section on delete set null
);

create table employees(
	comp_id varchar(8),
	per_id varchar(8),
	per_name(20) not null,
	primary_sector varchar(15),
	comp_name(20) not null,
	primary key(comp_id,per_id),
	foreign key(comp_id) references company on delete cascade,
	foreign key(per_id) references person on delete cascade,
	foreign key(primary_sector,comp_name) references company on delete set null,
	foreign key(per_name) references person on delete set null
);

create table positions(
	comp_id varchar(8),
	job_code varchar(8),
	pay_rate numeric(8,2) check(pay_rate > 0),
	per_id varchar(8),
	primary key(comp_id,job_code),
	foreign key(comp_id) references company on delete cascade,
	foreign key(job_code) references job on delete cascade,
	foreign key(pay_rate) references job on delete set null,
	foreign key(per_id) references person on delete set null
);

create table occupation(
	per_id varchar(8),
	per_name varchar(20) not null,
	job_code varchar(8),
	comp_id varchar(8),
	occ_status varchar(15) check(occ_status == 'employed' or occ_status == 'unemployed'),
	primary key(per_id,job_code),
	foreign key(per_id) references person on delete cascade,
	foreign key(job_code) references job on delete cascade,
	foreign key(per_name) references person on delete set null,
	foreign key(comp_id) references company on delete set null
);
