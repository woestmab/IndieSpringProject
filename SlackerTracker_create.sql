-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2016-02-13 06:57:32.694




-- tables
-- Table appointments
CREATE TABLE appointments (
    apt_id int  NOT NULL  AUTO_INCREMENT,
    title varchar(50)  NOT NULL,
    url int  NULL,
    class varchar(25)  NOT NULL,
    start int  NOT NULL,
    end int  NOT NULL,
    calendar_id int  NOT NULL,
    CONSTRAINT appointments_pk PRIMARY KEY (apt_id)
);

-- Table calendar
CREATE TABLE calendar (
    cal_id int  NOT NULL  AUTO_INCREMENT,
    user_id int  NOT NULL,
    appointment_id int  NOT NULL,
    users_id int  NOT NULL,
    CONSTRAINT calendar_pk PRIMARY KEY (cal_id)
);

-- Table users
CREATE TABLE users (
    user_id int  NOT NULL  AUTO_INCREMENT,
    user_name varchar(25)  NOT NULL,
    first_name varchar(25)  NULL,
    last_name int  NULL,
    password varchar(25)  NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (user_id)
);





-- foreign keys
-- Reference:  appointments_calendar (table: appointments)

ALTER TABLE appointments ADD CONSTRAINT appointments_calendar FOREIGN KEY appointments_calendar (calendar_id)
    REFERENCES calendar (cal_id);
-- Reference:  calendar_users (table: calendar)

ALTER TABLE calendar ADD CONSTRAINT calendar_users FOREIGN KEY calendar_users (users_id)
    REFERENCES users (user_id);



-- End of file.

