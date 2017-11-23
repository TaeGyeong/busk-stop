/*-----------------------------공연정보(아티스트 게시판)---------------------------------*/
/* 공연정보 목록 조회 */
select p.*, pl.like_count /* like_count = 좋아요 수 */
from PERFORMANCE p, (
	select performance_like_no, count(*) like_count
	from performance_like
	group by performance_like_no
	) pl
where p.performance_no = pl.performance_like_no(+);

/* 공연정보 검색 */
select p.*, pl.like_count /* like_count = 좋아요 수 */
from PERFORMANCE p, (
	select performance_like_no, count(*) like_count
	from performance_like
	group by performance_like_no
	) pl
where p.performance_no = pl.performance_like_no
/*and p.performance_name like '%서현%';*/ /* 공연이름으로 검색 */
/*and p.performance_location like '%서현%';*/ /* 공연장소로 검색 */
and p.performance_date >= '2017-11-23' /* 공연날짜로 검색 */		/* 시작 날짜 */
and p.performance_date <= '2017-11-28';						/* 종료 날짜 */

/* 공연자 정보 조회 */
select a.*
from PERFORMANCE p, ARTIST a
where p.performance_user_id = a.artist_user_id /* 공연정보에 게시글을 올린 아티스트만 조회됨 */
and p.performance_no = 1; /* 조회할 공연정보 id */

/* 공연장 정보 조회 */
select s.*
from PERFORMANCE p, STAGE s
where p.stage_no = s.stage_no
and p.performance_no = 3; /* 조회할 공연정보 id */

/* 공연자 영상 조회 */
select v.*
from VIDEO v, (
	select a.artist_name
	from PERFORMANCE p, ARTIST a
	where p.performance_user_id = a.artist_user_id
	and p.performance_no = 2 /* 조회할 공연정보 id */
	)
where v.video_artist like '%'||artist_name||'%';

/***********************************중고거래*************************************************/
/* 거래등록글 조회 */
select *
from USED_GOODS;

/* 거래 상세 정보 조회 */
select *
from USED_GOODS
where used_goods_no = 3; /* 조회할 게시글 id */

/* 장바구니 조회 */
select u.used_goods_model, u.used_goods_brand, u.used_goods_cost, u.used_goods_image,
	u.used_goods_seller_id, b.basket_ea
from USED_GOODS u, BASKET b
where u.used_goods_no = b.used_goods_no
and b.basket_consumer_id = 'lee534'; /* 조회할 사용자 id */

/* 주문 정보 조회 */
select o.used_goods_image, o.used_goods_model, o.used_goods_brand, o.used_goods_seller_id,
	d.shipping_address, d.order_ea, d.PURCHASE_COST, d.ADDRESSEE_PHONE_NUM,
	o.cancel_code
from ORDER_DETAIL d, (
	select *
	from ORDERS o, USED_GOODS u
	where o.used_goods_no = u.used_goods_no
	) o
where d.order_no = o.order_no
and o.consumer_id = 'sim1'; /* 조회할 구매자 id */

/* 구매 희망 글 목록 조회 */
select *
from USED_GOODS_WISH;

/* 구매 희망 검색 후 목록 조회 */
select *
from USED_GOODS_WISH
where used_goods_wish_title like '%구매%' /* 글제목으로 검색 또는 */
or used_goods_wish_model like '%폴앤폴%'; /* 모델명으로 검색*/

/* 구매 희망 글 상세 조회 */
select *
from USED_GOODS_WISH
where used_goods_wish_no = 1; /* 조회할 게시판 번호 */

/**********************************마이페이지******************************************/
/* 대관정보 전체 조회(id로 등록한(공급자)) */
select stage_name, stage_location, stage_cost, stage_area, stage_resurvation
from STAGE
where stage_seller_id = 'id3'; /* 조회할 공급자 id */

/* 대관정보 전체 조회(신청한 장소) */
select s.stage_name, s.stage_location, s.stage_cost, s.stage_area, s.stage_seller_id,
	r.rental_date, r.rental_state_code
from STAGE s, STAGE_RESERVATION r
where s.stage_no = r.stage_no
and r.rental_user_id = 'id2'; /* 조회할 신청자 id */

/* 공연 정보 조회(id로 등록한) */
select p.*, pl.like_count /* like_count = 좋아요 수 */
from PERFORMANCE p, (
	select performance_like_no, count(*) like_count
	from performance_like
	group by performance_like_no
	) pl
where p.performance_no = pl.performance_like_no(+)
and p.performance_user_id = 'id2'; /* 조회할 게시자 id */

/* 중고거래 정보 조회(장바구니) */
select u.used_goods_model, u.used_goods_brand, u.used_goods_cost, u.used_goods_image,
	u.used_goods_seller_id, b.basket_ea
from USED_GOODS u, BASKET b
where u.used_goods_no = b.used_goods_no
and b.basket_consumer_id = 'lee534'; /* 조회할 구매자 id */

/* 중고거래 정보 조회(주문내역) */
select o.used_goods_image, o.used_goods_model, o.used_goods_brand, o.used_goods_seller_id,
	d.shipping_address, d.order_ea, d.PURCHASE_COST, d.ADDRESSEE_PHONE_NUM,
	o.cancel_code
from ORDER_DETAIL d, (
	select *
	from ORDERS o, USED_GOODS u
	where o.used_goods_no = u.used_goods_no
	) o
where d.order_no = o.order_no
and o.consumer_id = 'sim1'; /* 조회할 구매자 id */

/* 중고거래 정보 조회(등록한 상품 조회) */
select *
from USED_GOODS
where used_goods_seller_id = 'kimjr322'; /* 조회할 등록자 id */

/* 중고거래 정보 조회(등록한 구매희망 조회) */
select *
from USED_GOODS_WISH
where used_goods_wish_user_id = 'kimbo88' /* 조회할 등록자 id */

/* 구인구직(등록한 레슨) */

/* 구인구직 */

/* 팔로우한 아티스트 정보 조회 */

/* 회원 정보 조회(회원) */
select user_id, user_name, user_address, user_phone_num, user_email
from USERS
where user_id = 'suck1598'; /* 조회할 회원 id */

/* 회원 정보 조회(아티스트) */
select a.artist_name, a.artist_performance, a.artist_profile, a.artist_image, a.artist_members
from USERS u, ARTIST a
where u.user_id = a.artist_user_id
and u.user_id = 'kim4845'; /* 조회할 회원 id */

/* 회원 정보 조회(대관공급자) */
select *
from USERS u, STAGE_SUPPLIER s
where u.user_id = s.operator_user_id
and u.user_id = 'id2'; /* 조회할 회원 id */
