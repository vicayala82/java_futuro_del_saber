CREATE TABLE IF NOT EXISTS ADDRESS (
   ID bigserial NOT NULL,
   CITY VARCHAR(100),
   ADDRESS VARCHAR(100),
   CONSTRAINT PK_ADDRESS PRIMARY KEY (ID)
);
CREATE TABLE IF NOT EXISTS TEACHER (
    ID BIGINT NOT NULL,
    DOCUMENT_TYPE VARCHAR(50),
    NAME VARCHAR(100),
    LAST_NAME VARCHAR(100),
    BIRTHDAY date,
    EMAIL VARCHAR(100),
    PHONE_NUMBER VARCHAR(20),
    CELL_NUMBER VARCHAR(20),
    LAST_GRADE VARCHAR(255),
    CONSTRAINT PK_TEACHER PRIMARY KEY (ID)
);
CREATE TABLE IF NOT EXISTS COURSE (
    ID bigserial NOT NULL,
    LEVEL_COURSE VARCHAR(10),
    COURSE_DIRECTOR_ID BIGINT,
    CONSTRAINT PK_COURSE PRIMARY KEY (ID),
    CONSTRAINT AK_LEVEL_COURSE UNIQUE (LEVEL_COURSE),
    CONSTRAINT FK_COURSE_DIRECTOR_ID FOREIGN KEY (COURSE_DIRECTOR_ID) REFERENCES TEACHER (ID)
);

CREATE TABLE IF NOT EXISTS STUDENT (
    ID BIGINT NOT NULL,
    DOCUMENT_TYPE VARCHAR(50),
    NAME VARCHAR(100),
    LAST_NAME VARCHAR(100),
    BIRTHDAY date,
    EMAIL VARCHAR(100),
    PHONE_NUMBER VARCHAR(20),
    CELL_NUMBER VARCHAR(20),
    CUSTODIAN_NAME VARCHAR(100),
    ADDRESS_ID BIGINT,
    COURSE_ID BIGINT,
    CONSTRAINT PK_STUDENT PRIMARY KEY (ID),
    CONSTRAINT FK_STUDENT_ON_ADDRESS FOREIGN KEY (ADDRESS_ID) REFERENCES ADDRESS (ID),
    CONSTRAINT FK_STUDENT_ON_COURSE FOREIGN KEY (COURSE_ID) REFERENCES COURSE (ID)
);

CREATE TABLE IF NOT EXISTS SIGNATURE (
  ID BIGSERIAL NOT NULL,
  NAME VARCHAR(100),
  TEACHER_ID BIGINT,
  CONSTRAINT PK_SIGNATURE PRIMARY KEY (ID),
  CONSTRAINT FK_SIGNATURE_ON_TEACHER FOREIGN KEY (TEACHER_ID) REFERENCES TEACHER (ID)
);

CREATE TABLE IF NOT EXISTS STUDENT_SIGNATURE (
    STUDENT_ID BIGINT,
    SIGNATURE_ID BIGINT,
    CONSTRAINT FK_STUDENT_ON_STUDENT FOREIGN KEY (STUDENT_ID) REFERENCES STUDENT (ID),
    CONSTRAINT FK_SIGNATURE_ON_SIGNATURE FOREIGN KEY (SIGNATURE_ID) REFERENCES SIGNATURE (ID)
);

CREATE TABLE IF NOT EXISTS GRADE (
  ID BIGSERIAL NOT NULL,
  VALUE DOUBLE PRECISION,
  STUDENT_ID BIGINT,
  SIGNATURE_ID BIGINT,
  CONSTRAINT FK_STUDENT_ON_STUDENT FOREIGN KEY (STUDENT_ID) REFERENCES STUDENT (ID),
  CONSTRAINT FK_SIGNATURE_ON_SIGNATURE FOREIGN KEY (SIGNATURE_ID) REFERENCES SIGNATURE (ID)
);

CREATE TABLE IF NOT EXISTS COURSE_SIGNATURE (
    COURSE_ID BIGINT,
    SIGNATURE_ID BIGINT,
    CONSTRAINT FK_COURSE_ON_COURSE FOREIGN KEY (COURSE_ID) REFERENCES COURSE (ID),
    CONSTRAINT FK_SIGNATURE_ON_SIGNATURE FOREIGN KEY (SIGNATURE_ID) REFERENCES SIGNATURE (ID)
);