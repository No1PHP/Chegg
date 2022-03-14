CREATE SCHEMA IF NOT EXISTS Chegg;
USE Chegg;
DROP TABLE IF EXISTS professor_course;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS professor;

CREATE TABLE professor
(
    professorId BIGINT(60) AUTO_INCREMENT,
    name VARCHAR(50),
    email VARCHAR(50),
    school VARCHAR(50),
    CONSTRAINT pk_professor_professorId PRIMARY KEY (professorId)
);
CREATE TABLE student
(
    studentId BIGINT(60) AUTO_INCREMENT,
    name VARCHAR(50),
    email VARCHAR(50),
    school VARCHAR(50),
    CONSTRAINT pk_student_studentId PRIMARY KEY (studentId)
);
CREATE TABLE course
(
  courseId BIGINT(60) AUTO_INCREMENT,
  courseName VARCHAR(50),
  CONSTRAINT pk_course_courseId PRIMARY KEY (courseId)
);
CREATE TABLE professor_course
(
    pcId BIGINT(60) AUTO_INCREMENT,
    professorId BIGINT(60),
    courseId BIGINT(60),
    CONSTRAINT fk_pc_professorId FOREIGN KEY (professorId) REFERENCES professor(professorId),
    CONSTRAINT fk_pc_courseId FOREIGN KEY (courseId) REFERENCES course(courseId),
    CONSTRAINT pk_pc_pcId PRIMARY KEY (pcId)
);

INSERT INTO professor(name, email, school) VALUES ('harold', 'aaa', 'neu'), ('brian', 'bbb', 'neu'), ('alex', 'ccc', 'nwu');
INSERT INTO course(courseName) VALUES ('cs5500'), ('cs5800'), ('cs5010');
INSERT INTO professor_course(professorId, courseId) VALUES (1,1), (2,1), (2,2), (2,3);
Insert INTO student(name, email, school) VALUES  ('john', 'ddd', 'uw'), ('Sierra', 'eee', 'mit');


