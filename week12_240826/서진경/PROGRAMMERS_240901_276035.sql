-- LV.4
SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS
where skill_code & (SELECT SUM(CODE) 
                    FROM SKILLCODES 
                    WHERE CATEGORY LIKE 'Front End')
ORDER BY ID;