INSERT INTO Persons (
    PERSON_ID, ADDRESS, DATE_OF_BIRTH, EMAIL, FIRST_NAME, LAST_NAME, PHONE_NUMBER, TAX_IDENTIFIER
) VALUES
-- Record 1
(10, '123 Oak St, Anytown', '1985-04-15', 'alice.s@work.com', 'Alice', 'Smith', '555-1001', 'TS-9001'),
-- Record 2
(21, '45 Pine Ln, Smallville', '1992-11-20', 'bob.j@mail.net', 'Bob', 'Johnson', '555-1002', 'TS-9002'),
-- Record 3 (Example with NULL values)
(31, '78 Elm Blvd, Big City', '2000-01-01', 'charlie.b@web.org', 'Charlie', 'Brown', '555-1003',  'TS-9003'),

(100, '99 Main St, Metro', '1970-07-25', 'last.person@test.com', 'Laura', 'Perry', '555-1100', 'TS-9100');