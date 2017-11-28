/*--------사용자------------------------------------------------------------------------*/
ALTER TABLE USERS
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_USERS;

/* 사용자 */
DROP TABLE USERS 
	CASCADE CONSTRAINTS;
/*------권한테이블--------------------------------------------------------------------------*/

ALTER TABLE AUTHORITY
	DROP
		CONSTRAINT FK_USERS_TO_AUTHORITY
		CASCADE;

ALTER TABLE AUTHORITY
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_AUTHORITY;

/* 권한테이블 */
DROP TABLE AUTHORITY 
	CASCADE CONSTRAINTS;

/*-----팔로우--------------------------------------------------------------------------*/

ALTER TABLE FOLLOW
	DROP
		CONSTRAINT FK_USERS_TO_FOLLOW2
		CASCADE;

ALTER TABLE FOLLOW
	DROP
		CONSTRAINT FK_USERS_TO_FOLLOW
		CASCADE;

ALTER TABLE FOLLOW
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_FOLLOW;

/* 팔로우 */
DROP TABLE FOLLOW 
	CASCADE CONSTRAINTS;

/*---------프리미엄 대관 공급자-----------------------------------------------------------------*/

ALTER TABLE STAGE_SUPPLIER
	DROP
		CONSTRAINT FK_USERS_TO_STAGE_SUPPLIER
		CASCADE;

ALTER TABLE STAGE_SUPPLIER
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_STAGE_SUPPLIER;

/* 프리미엄 대관 공급자 */
DROP TABLE STAGE_SUPPLIER 
	CASCADE CONSTRAINTS;

/*---------아티스트----------------------------------------------------------------------*/

ALTER TABLE ARTIST
	DROP
		CONSTRAINT FK_USERS_TO_ARTIST
		CASCADE;

ALTER TABLE ARTIST
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_ARTIST;

/* 아티스트 */
DROP TABLE ARTIST 
	CASCADE CONSTRAINTS;
/*------------------------------------------------------------------------------------*/



/*------공연장(공급자 게시물)-----------------------------------------------------------------*/

ALTER TABLE STAGE
	DROP
		CONSTRAINT FK_USERS_TO_STAGE
		CASCADE;

ALTER TABLE STAGE
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_STAGE;

/* 공연장(공급자 게시물) */
DROP TABLE STAGE 
	CASCADE CONSTRAINTS;
/*----대관 예약(주문)--------------------------------------------------------------------*/

ALTER TABLE STAGE_RESERVATION
	DROP
		CONSTRAINT FK_USERS_TO_STAGE_RESERVATION
		CASCADE;

ALTER TABLE STAGE_RESERVATION
	DROP
		CONSTRAINT FK_STAGE_TO_STAGE_RESERVATION
		CASCADE;

ALTER TABLE STAGE_RESERVATION
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_STAGE_RESERVATION;

/* 대관 예약(주문) */
DROP TABLE STAGE_RESERVATION 
	CASCADE CONSTRAINTS;

/*---공연장 사진-----------------------------------------------------------------------*/

ALTER TABLE STAGE_IMAGE
	DROP
		CONSTRAINT FK_STAGE_TO_STAGE_IMAGE
		CASCADE;

ALTER TABLE STAGE_IMAGE
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_STAGE_IMAGE;

/* 공연장 사진 */
DROP TABLE STAGE_IMAGE 
	CASCADE CONSTRAINTS;

/*-공연장 리뷰----------------------------------------------------------------------*/

ALTER TABLE STAGE_REVIEW
	DROP
		CONSTRAINT FK_STAGE_TO_STAGE_REVIEW
		CASCADE;

ALTER TABLE STAGE_REVIEW
	DROP
		CONSTRAINT FK_USERS_TO_STAGE_REVIEW
		CASCADE;

ALTER TABLE STAGE_REVIEW
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_STAGE_REVIEW;

/* 공연장 리뷰 */
DROP TABLE STAGE_REVIEW 
	CASCADE CONSTRAINTS;

/*------------------------------------------------------------------------------------*/




/*---공연정보(아티스트 게시물)---------------------------------------------------------------*/

ALTER TABLE PERFORMANCE
	DROP
		CONSTRAINT FK_USERS_TO_PERFORMANCE
		CASCADE;

ALTER TABLE PERFORMANCE
	DROP
		CONSTRAINT FK_STAGE_TO_PERFORMANCE
		CASCADE;

ALTER TABLE PERFORMANCE
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_PERFORMANCE;

/* 공연정보(아티스트 게시물) */
DROP TABLE PERFORMANCE 
	CASCADE CONSTRAINTS;

	
DROP SEQUENCE PERFORMANCE_NO_SEQ;
/*--공연정보 댓글-----------------------------------------------------------------------*/

ALTER TABLE PERFORMANCE_COMMENT
	DROP
		CONSTRAINT FK_PERFORMANCE_TO_P_COMMENT
		CASCADE;

ALTER TABLE PERFORMANCE_COMMENT
	DROP
		CONSTRAINT FK_USERS_TO_P_COMMENT
		CASCADE;

ALTER TABLE PERFORMANCE_COMMENT
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_PERFORMANCE_COMMENT;

/* 공연정보 댓글 */
DROP TABLE PERFORMANCE_COMMENT 
	CASCADE CONSTRAINTS;
/*--- 공연정보 좋아요----------------------------------------------------------------------*/

ALTER TABLE PERFORMANCE_LIKE
	DROP
		CONSTRAINT FK_PERFORMANCE_TO_P_LIKE
		CASCADE;

ALTER TABLE PERFORMANCE_LIKE
	DROP
		CONSTRAINT FK_USERS_TO_P_LIKE
		CASCADE;

ALTER TABLE PERFORMANCE_LIKE
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_PERFORMANCE_LIKE;

/* 공연정보 좋아요 */
DROP TABLE PERFORMANCE_LIKE 
	CASCADE CONSTRAINTS;
/*------------------------------------------------------------------------------------*/




/*---동영상(게시물)-----------------------------------------------------------------------*/

ALTER TABLE VIDEO
	DROP
		CONSTRAINT FK_USERS_TO_VIDEO
		CASCADE;

ALTER TABLE VIDEO
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_VIDEO;

/* 동영상(게시물) */
DROP TABLE VIDEO 
	CASCADE CONSTRAINTS;
/*---동영상 댓글-------------------------------------------------------------------*/

ALTER TABLE VIDEO_COMMENT
	DROP
		CONSTRAINT FK_VIDEO_TO_VIDEO_COMMENT
		CASCADE;

ALTER TABLE VIDEO_COMMENT
	DROP
		CONSTRAINT FK_USERS_TO_VIDEO_COMMENT
		CASCADE;

ALTER TABLE VIDEO_COMMENT
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_VIDEO_COMMENT;

/* 동영상 댓글 */
DROP TABLE VIDEO_COMMENT 
	CASCADE CONSTRAINTS;

/*-동영상 좋아요-----------------------------------------------------------------------*/

ALTER TABLE VIDEO_LIKE
	DROP
		CONSTRAINT FK_VIDEO_TO_VIDEO_LIKE
		CASCADE;

ALTER TABLE VIDEO_LIKE
	DROP
		CONSTRAINT FK_USERS_TO_VIDEO_LIKE
		CASCADE;

ALTER TABLE VIDEO_LIKE
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_VIDEO_LIKE;

/* 동영상 좋아요 */
DROP TABLE VIDEO_LIKE 
	CASCADE CONSTRAINTS;

/*------------------------------------------------------------------------------------*/




/*---중고상품(게시글)---------------------------------------------------------------------*/

ALTER TABLE USED_GOODS
	DROP
		CONSTRAINT FK_USERS_TO_USED_GOODS
		CASCADE;

ALTER TABLE USED_GOODS
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_USED_GOODS;

/* 중고상품(게시글) */
DROP TABLE USED_GOODS 
	CASCADE CONSTRAINTS;

/*----주문---------------------------------------------------------------------------*/
		
ALTER TABLE ORDERS
	DROP
		CONSTRAINT FK_USED_GOODS_TO_ORDERS
		CASCADE;

ALTER TABLE ORDERS
	DROP
		CONSTRAINT FK_USERS_TO_ORDERS
		CASCADE;

ALTER TABLE ORDERS
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_ORDERS;

/* 주문 */
DROP TABLE ORDERS 
	CASCADE CONSTRAINTS;
/*----주문정보(배송정보)----------------------------------------------------------------------*/

ALTER TABLE ORDER_DETAIL
	DROP
		CONSTRAINT FK_ORDERS_TO_ORDER_DETAIL
		CASCADE;

ALTER TABLE ORDER_DETAIL
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_ORDER_DETAIL;

/* 주문정보(배송정보) */
DROP TABLE ORDER_DETAIL 
	CASCADE CONSTRAINTS;

/*--장바구니------------------------------------------------------------------------*/

ALTER TABLE BASKET
	DROP
		CONSTRAINT FK_USED_GOODS_TO_BASKET
		CASCADE;

ALTER TABLE BASKET
	DROP
		CONSTRAINT FK_USERS_TO_BASKET
		CASCADE;

ALTER TABLE BASKET
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_BASKET;

/* 장바구니 */
DROP TABLE BASKET 
	CASCADE CONSTRAINTS;

/*---중고상품 댓글------------------------------------------------------------------------*/

ALTER TABLE USED_COMMENT
	DROP
		CONSTRAINT FK_USED_GOODS_TO_USED_COMMENT
		CASCADE;

ALTER TABLE USED_COMMENT
	DROP
		CONSTRAINT FK_USERS_TO_USED_COMMENT
		CASCADE;

ALTER TABLE USED_COMMENT
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_USED_COMMENT;

/* 중고상품 댓글 */
DROP TABLE USED_COMMENT 
	CASCADE CONSTRAINTS;

/*-----구매희망-----------------------------------------------------------------------*/

ALTER TABLE USED_GOODS_WISH
	DROP
		CONSTRAINT FK_USERS_TO_USED_GOODS_WISH
		CASCADE;

ALTER TABLE USED_GOODS_WISH
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_USED_GOODS_WISH;

/* 구매희망 */
DROP TABLE USED_GOODS_WISH 
	CASCADE CONSTRAINTS;

/*------------------------------------------------------------------------------------*/




/*---구인 - 인재구함-----------------------------------------------------------------------*/

ALTER TABLE EMPLOY
	DROP
		CONSTRAINT FK_USERS_TO_EMPLOY
		CASCADE;

ALTER TABLE EMPLOY
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_EMPLOY;

/* 구인 - 인재구함 */
DROP TABLE EMPLOY 
	CASCADE CONSTRAINTS;

/*----구직 - 구직희망 - 상품에서 주문테이블------------------------------------------------------------------*/

ALTER TABLE APPLICANT
	DROP
		CONSTRAINT FK_USERS_TO_APPLICANT
		CASCADE;

ALTER TABLE APPLICANT
	DROP
		CONSTRAINT FK_EMPLOY_TO_APPLICANT
		CASCADE;

ALTER TABLE APPLICANT
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_APPLICANT;

/* 구직 - 구직희망 - 상품에서 주문테이블 */
DROP TABLE APPLICANT 
	CASCADE CONSTRAINTS;

/*----- 레슨 - 선생님-----------------------------------------------------------------------*/

ALTER TABLE TEACHERS
	DROP
		CONSTRAINT FK_USERS_TO_TEACHERS
		CASCADE;

ALTER TABLE TEACHERS
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_TEACHERS;

/* 레슨 - 선생님 */
DROP TABLE TEACHERS 
	CASCADE CONSTRAINTS;
/*----- 레슨-학생------------------------------------------------------------------------*/

ALTER TABLE STUDENTS
	DROP
		CONSTRAINT FK_TEACHERS_TO_STUDENTS
		CASCADE;

ALTER TABLE STUDENTS
	DROP
		CONSTRAINT FK_USERS_TO_STUDENTS
		CASCADE;

ALTER TABLE STUDENTS
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_STUDENTS;

/* 레슨-학생 */
DROP TABLE STUDENTS 
	CASCADE CONSTRAINTS;

/*------------------------------------------------------------------------------------*/




/*---고객센터----------------------------------------------------------------------*/

ALTER TABLE HELP
	DROP
		CONSTRAINT FK_USERS_TO_HELP
		CASCADE;

ALTER TABLE HELP
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_HELP;

/* 고객센터 */
DROP TABLE HELP 
	CASCADE CONSTRAINTS;

/*---고객센터댓글------------------------------------------------------------------------*/

ALTER TABLE HELP_COMMENT
	DROP
		CONSTRAINT FK_HELP_TO_HELP_COMMENT
		CASCADE;

ALTER TABLE HELP_COMMENT
	DROP
		CONSTRAINT FK_USERS_TO_HELP_COMMENT
		CASCADE;

ALTER TABLE HELP_COMMENT
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_HELP_COMMENT;

/* 고객센터댓글 */
DROP TABLE HELP_COMMENT 
	CASCADE CONSTRAINTS;

/*------------------------------------------------------------------------------------*/



/*------------------------------------------------------------------------------------*/
