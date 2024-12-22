-- LV.4
SELECT APNT_NO, PT_NAME, A.PT_NO, A.MCDP_CD, DR_NAME, APNT_YMD
FROM PATIENT P, DOCTOR D, APPOINTMENT A
WHERE P.PT_NO=A.PT_NO
      AND D.DR_ID=A.MDDR_ID
      AND TO_CHAR(APNT_YMD,'yyyy-mm-dd')='2022-04-13'
      AND A.MCDP_CD='CS'
      AND APNT_CNCL_YN='N'
ORDER BY APNT_YMD;