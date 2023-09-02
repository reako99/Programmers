-- 코드를 입력하세요
SELECT
    TO_CHAR(o.sales_date, 'yyyy') AS year,
    to_number(TO_CHAR(o.sales_date, 'mm')) AS month,
    u.gender,
    count(distinct o.user_id) AS users
FROM
    USER_INFO u
JOIN
    ONLINE_SALE o ON u.user_id = o.user_id
WHERE
    u.gender IS NOT NULL
GROUP BY
    TO_CHAR(o.sales_date, 'yyyy'),
    to_number(TO_CHAR(o.sales_date, 'mm')),
    u.gender
ORDER BY
    TO_CHAR(o.sales_date, 'yyyy'),
    to_number(TO_CHAR(o.sales_date, 'mm')),
    u.gender;