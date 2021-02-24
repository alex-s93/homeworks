SELECT LastName, COUNT(OrderID) as order_count
    FROM Employees
    JOIN Orders ON Employees.EmployeeID = Orders.EmployeeID
    GROUP BY Orders.EmployeeID
    ORDER BY order_count;