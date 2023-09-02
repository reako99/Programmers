select u.user_id, u.nickname, concat(concat(concat(concat(u.city, ' '),u.street_address1),' '), u.street_address2) as "전체주소",
concat(concat(concat(concat(substr(u.tlno,0,3),'-'),substr(u.tlno,4,4)),'-'),substr(u.tlno,8,4)) as "전화번호"
from USED_GOODS_USER u, (select count(board_id) as cnt, writer_id from USED_GOODS_BOARD group by writer_id) s 
where s.cnt>=3 and u.user_id=s.writer_id
order by user_id desc;