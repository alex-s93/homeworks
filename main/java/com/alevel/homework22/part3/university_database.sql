create database university_db;

use university_db;

create table Student
(
    student_id    int AUTO_INCREMENT PRIMARY KEY,
    first_name    varchar(50) NOT NULL,
    last_name     varchar(50) NOT NULL,
    data_of_birth date
);

create table Module
(
    module_id    int AUTO_INCREMENT PRIMARY KEY,
    module_title varchar(50) NOT NULL,
    level        int         NOT NULL,
    credits      int         NOT NULL DEFAULT 20
);

create table registration
(
    student_id int,
    module_id  int,
    result     double(10, 1),
    FOREIGN KEY (student_id) REFERENCES Student (student_id),
    FOREIGN KEY (module_id) REFERENCES Module (module_id)
);

insert into Student (first_name, last_name, data_of_birth) VALUES ('Daniel', 'Radcliffe', '1995-04-23');
insert into Student (first_name, last_name, data_of_birth) VALUES ('Emma', 'Watson', '1994-07-15');
insert into Student (first_name, last_name, data_of_birth) VALUES ('Rupert', 'Grint', '1995-10-24');

insert into Module (module_title, level, credits) VALUES ('Math', 1, 30);
insert into Module (module_title, level) VALUES ('Physics', 1);
insert into Module (module_title, level, credits) VALUES ('Chemistry', 1, 15);

insert into registration (student_id, module_id) values (1, 1);
insert into registration (student_id, module_id) values (1, 2);
insert into registration (student_id, module_id) values (1, 3);

insert into registration (student_id, module_id) values (2, 3);
insert into registration (student_id, module_id) values (2, 1);

insert into registration (student_id, module_id) values (3, 2);
insert into registration (student_id, module_id) values (3, 1);

# Check results of SQL queries:
select first_name, last_name, module_title
from registration
         join Student S on registration.student_id = S.student_id
         join Module M on registration.module_id = M.module_id;

# Result:
# +------------+-----------+--------------+
# | first_name | last_name | module_title |
# +------------+-----------+--------------+
# | Daniel     | Radcliffe | Chemistry    |
# | Daniel     | Radcliffe | Physics      |
# | Daniel     | Radcliffe | Math         |
# | Emma       | Watson    | Chemistry    |
# | Emma       | Watson    | Math         |
# | Rupert     | Grint     | Physics      |
# | Rupert     | Grint     | Math         |
# +------------+-----------+--------------+
