CREATE TABLE contacts
(
    id          serial      not null,
    description VARCHAR(50) not null,
    type        VARCHAR(30),
    employee_id  bigint          not null,
    CONSTRAINT fk_contacts_employee FOREIGN KEY (employee_id) REFERENCES employees (id),
    PRIMARY KEY (id)
)