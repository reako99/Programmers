
SELECT INFO.ITEM_ID, INFO.ITEM_NAME, INFO.RARITY
FROM ITEM_INFO INFO JOIN (SELECT PARENT.ITEM_ID, COUNT(CHILD.ITEM_ID) AS 'CHILD_COUNT'
FROM ITEM_TREE PARENT LEFT OUTER JOIN ITEM_TREE CHILD ON CHILD.PARENT_ITEM_ID = PARENT.ITEM_ID
GROUP BY PARENT.ITEM_ID) TREE ON INFO.ITEM_ID=TREE.ITEM_ID
WHERE TREE.CHILD_COUNT = 0
ORDER BY INFO.ITEM_ID DESC;