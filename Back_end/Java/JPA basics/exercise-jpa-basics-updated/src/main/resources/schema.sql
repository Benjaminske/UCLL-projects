CREATE TABLE IF NOT EXISTS courses (
    id           BIGINT PRIMARY KEY AUTO_INCREMENT,
    course_title VARCHAR(255),
    credits      INT NOT NULL CHECK (credits >= 3 AND credits <= 20),
    semester     INT NOT NULL
);
