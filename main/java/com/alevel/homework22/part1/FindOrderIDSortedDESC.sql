SELECT OrderID, SUM(Quantity) AS q_sum
    FROM OrderDetails
    GROUP BY OrderID
    HAVING q_sum > 100
    ORDER BY q_sum DESC;