-- 코드를 작성해주세요
SELECT a.FISH_COUNT, a.MAX_LENGTH, a.FISH_TYPE
FROM (SELECT COUNT(ID) AS 'FISH_COUNT', MAX(LENGTH) AS 'MAX_LENGTH', FISH_TYPE, AVG(LENGTH) AS 'LEN_AVG' 
FROM FISH_INFO
GROUP BY FISH_TYPE) a
WHERE LEN_AVG >=33
ORDER BY FISH_TYPE