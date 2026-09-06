create database sub;
use sub;


CREATE TABLE departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50),
    location VARCHAR(50)
);

INSERT INTO departments(dept_id, dept_name, location) VALUES
(10, 'Engineering', 'Chennai'),
(20, 'Sales', 'Hyderabad'),
(30, 'HR', 'Bengaluru'),
(40, 'Research', 'Pune'),
(50, 'Support', 'Chennai');



CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    dept_id INT,
    salary INT,
    manager_id INT,
    FOREIGN KEY (dept_id) REFERENCES Departments(dept_id)
);

select *from employees;

INSERT INTO employees (emp_id, emp_name, dept_id, salary, manager_id) VALUES
(101, 'Arun', 10, 50000, 103),
(102, 'Bala', 20, 45000, 106),
(103, 'Charan', 10, 80000, NULL),
(104, 'Divya', 30, 40000, 108),
(105, 'Ezhil', 10, 65000, 103),
(106, 'Farah', 20, 75000, NULL),
(107, 'Gokul', 40, 55000, 109),
(108, 'Harini', 30, 70000, NULL),
(109, 'Irfan', 40, 90000, NULL),
(110, 'Janani', 10, 60000, 103);


CREATE TABLE projects (
    project_id INT PRIMARY KEY,
    project_name VARCHAR(100),
    dept_id INT,
    budget INT,
    FOREIGN KEY (dept_id) REFERENCES Departments(dept_id)
);

INSERT INTO projects (project_id, project_name, dept_id, budget) VALUES
(1, 'Cloud Migration', 10, 500000),
(2, 'Mobile App', 10, 300000),
(3, 'CRM Upgrade', 20, 250000),
(4, 'Recruitment AI', 30, 200000);





-- 1. Employees Above Their Department Average Display emp_id, emp_name, dept_id, 
-- and salary for employees whose salary is greater than the average salary of their own department. Do not use JOIN.

select emp_id,emp_name,dept_id and salary from employees as e where salary>(select avg(salary) from employees where dept_id=e.dept_id);

-- Display the highest-paid employee or employees from each department. 
-- If multiple employees in the same department share the highest salary, return all of them.

select emp_id,emp_name,dept_id and salary from employees as e where salary=(select max(salary) from employees where dept_id=e.dept_id);

--  Second Highest Distinct Salary Find the second-highest distinct salary in the company without using LIMIT, OFFSET, or JOIN.

select max(salary) as second_highest from employees where salary<(select max(salary) from employees);


--  Employees Receiving the Second Highest Distinct Salary 
-- Display the employee name and salary of every employee whose salary equals the second-highest distinct salary in the company.
 
 
select emp_name,salary from employees where salary=(select max(salary) from employees where salary<(select max(salary) from employees));

--  Employees Earning More Than Their Manager Display employees whose salary is greater than the salary of their own manager. 
-- Employees without a manager should not appear. Do not use a self JOIN.

select emp_id,emp_name,salary,manager_id from employees as e 
where manager_id is not null  and salary>(select salary from employees where manager_id=e.emp_id);

 
select emp_id, emp_name, salary from Employees e
WHERE EXISTS (
    SELECT 1
    FROM Employees
    WHERE manager_id = e.emp_id
      AND salary > e.salary
);


SELECT dept_id
FROM Employees
GROUP BY dept_id
HAVING AVG(salary) > (
    SELECT AVG(salary)
    FROM Employees
);



SELECT emp_id, emp_name, dept_id, salary
FROM Employees
WHERE dept_id IN (
    SELECT dept_id
    FROM Employees
    GROUP BY dept_id
    HAVING AVG(salary) > (
        SELECT AVG(salary)
        FROM Employees
    )
);







SELECT emp_id, emp_name, salary
FROM Employees
WHERE salary > ALL (
    SELECT salary
    FROM Employees
    WHERE dept_id = (
        SELECT dept_id
        FROM Departments
        WHERE dept_name = 'HR'
    )
);


SELECT emp_id, emp_name, salary
FROM Employees
WHERE salary > ANY (
    SELECT salary
    FROM Employees
    WHERE dept_id = (
        SELECT dept_id
        FROM Departments
        WHERE dept_name = 'Research'
    )
);


SELECT dept_id, dept_name
FROM Departments d
WHERE NOT EXISTS (
    SELECT 1
    FROM Projects p
    WHERE p.dept_id = d.dept_id
);


