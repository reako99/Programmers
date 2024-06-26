SELECT SCORE, EMP_NO, EMP_NAME, POSITION, EMAIL FROM
(SELECT SUM(c.SCORE) AS 'SCORE', c.EMP_NO, b.EMP_NAME, b.POSITION, b.EMAIL
FROM HR_EMPLOYEES b, HR_GRADE c
WHERE b.EMP_NO = c.EMP_NO
GROUP BY c.EMP_NO) d
WHERE SCORE = (SELECT MAX(SCORE) FROM (SELECT EMP_NO, SUM(SCORE) as 'SCORE' FROM HR_GRADE GROUP BY EMP_NO) a)
