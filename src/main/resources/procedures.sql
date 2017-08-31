CREATE PROCEDURE find_all_customers()
BEGIN
    SELECT id, first_name, last_name FROM customers;
END

