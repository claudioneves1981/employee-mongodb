CREATE TABLE employees(
    id SERIAL not null,
    name VARCHAR(150) not null,
    salary DECIMAL(10,2) not null,
    birthday TIMESTAMP not null,
    PRIMARY KEY(id)
)