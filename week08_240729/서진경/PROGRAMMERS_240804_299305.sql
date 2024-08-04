-- LV.3
SELECT ID, IFNULL(cnt, 0) AS CHILD_COUNT
FROM ECOLI_DATA a LEFT JOIN (SELECT PARENT_ID, COUNT(*) cnt
                             FROM ECOLI_DATA
                             GROUP BY PARENT_ID) b
ON a.ID = b.PARENT_ID
ORDER BY ID;