CREATE TABLE accesses
(
    employee_id BIGINT not null,
    module_id   BIGINT not null,
    CONSTRAINT fk_accesses_employees FOREIGN KEY (employee_id) REFERENCES employees (employee_id),
    CONSTRAINT fk_accesses_modules FOREIGN KEY (module_id) REFERENCES modules (module_id),
    PRIMARY KEY (employee_id, module_id)
)