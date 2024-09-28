-- LV.4
SELECT O.ANIMAL_ID, O.ANIMAL_TYPE, O.NAME
FROM ANIMAL_INS I, ANIMAL_OUTS O
WHERE I.ANIMAL_ID = O.ANIMAL_ID
      AND I.SEX_UPON_INTAKE LIKE 'Intact%'
      AND O.SEX_UPON_OUTCOME IN ('Spayed%','Neutered%')
ORDER BY O.ANIMAL_ID;