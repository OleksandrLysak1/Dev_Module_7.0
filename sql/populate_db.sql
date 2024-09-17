INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES
    ('John Smith', '1985-04-12', 'Senior', 8000),
    ('Alice Johnson', '1990-06-23', 'Middle', 4000),
    ('Bob Brown', '1995-11-30', 'Junior', 1500),
    ('Emma White', '1980-08-15', 'Senior', 10000),
    ('Oliver Green', '1999-03-22', 'Trainee', 900),
    ('Sophia Blue', '1988-01-01', 'Middle', 3500),
    ('Mia Black', '2000-10-11', 'Junior', 1800),
    ('Liam Grey', '1978-07-09', 'Senior', 9000),
    ('Ethan Red', '1993-05-05', 'Middle', 4500),
    ('Olivia Yellow', '2001-12-21', 'Trainee', 950);

INSERT INTO client (NAME)
VALUES
    ('Client A'),
    ('Client B'),
    ('Client C'),
    ('Client D'),
    ('Client E');

INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE)
VALUES
    (1, '2023-01-01', '2023-06-01'),
    (2, '2022-04-01', '2022-12-01'),
    (3, '2021-07-15', '2022-07-15'),
    (4, '2020-03-01', '2021-03-01'),
    (5, '2019-10-01', '2020-02-01'),
    (1, '2023-07-01', '2023-09-01'),
    (3, '2021-01-01', '2022-01-01'),
    (5, '2022-09-15', '2023-01-15'),
    (4, '2018-01-01', '2018-05-01'),
    (2, '2020-05-01', '2021-01-01');

INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES
    (1, 1), (1, 3), (1, 5),
    (2, 2), (2, 4),
    (3, 3), (3, 6), (3, 9),
    (4, 1), (4, 8), (4, 9),
    (5, 2), (5, 7),
    (6, 1), (6, 4),
    (7, 3), (7, 8),
    (8, 6), (8, 9),
    (9, 2), (9, 10),
    (10, 4), (10, 5);
