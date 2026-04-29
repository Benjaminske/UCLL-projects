CREATE TABLE Courses (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    course_title VARCHAR(255),
    credits INT NOT NULL CHECK (credits >= 3 AND credits <= 20),
    semester INT NOT NULL
);