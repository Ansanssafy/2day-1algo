-- LV.3
SELECT O.ANIMAL_ID, O.NAME
FROM ANIMAL_INS I FULL OUTER JOIN ANIMAL_OUTS O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.ANIMAL_ID is null
      AND O.ANIMAL_ID is not null
ORDER BY O.ANIMAL_ID;