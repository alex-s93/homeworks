SELECT OrderID
    FROM OrderDetails
    GROUP BY OrderID
    HAVING SUM(Quantity) > 100;