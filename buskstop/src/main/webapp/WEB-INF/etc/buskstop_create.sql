
/* 사용자 */
CREATE TABLE USERS (
	USER_ID VARCHAR2(50) PRIMARY KEY, /* 사용자아이디 */
	USER_NAME VARCHAR2(50) NOT NULL, /* 이름 */
	USER_PASSWORD VARCHAR2(100) NOT NULL, /* 비밀번호 */
	USER_ADDRESS VARCHAR2(100) NOT NULL, /* 주소 */
	USER_PHONE_NUM VARCHAR2(11) NOT NULL, /* 연락처 */
	USER_EMAIL VARCHAR2(100) NOT NULL, /* 이메일 */
	DROP_CHECK NUMBER(1) DEFAULT 0 /* 회원탈퇴유무 */
);

/*------------------------------------------------------------------------------------*/

/* 권한테이블 */
CREATE TABLE AUTHORITY (
	USER_ID VARCHAR2(50), /* 사용자아이디 */
	AUTHORITY VARCHAR2(50), /* 권한 */
	CONSTRAINT AUTHORITY_PK PRIMARY KEY (USER_ID, AUTHORITY),
	CONSTRAINT FK_USER_ID FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)
);

/*------------------------------------------------------------------------------------*/

/* 팔로우 */
CREATE TABLE FOLLOW (
	FOLLOWING_ID VARCHAR2(50), /* 사용자아이디 */
	FOLLOWER_ID VARCHAR2(50), /* 팔로잉당한사람 */
	CONSTRAINT FK_USER_FOLLOW FOREIGN KEY (FOLLOWING_ID) REFERENCES USERS (USER_ID),
	CONSTRAINT FK_FOLLOWER FOREIGN KEY (FOLLOWER_ID) REFERENCES USERS (USER_ID) 
);
/*------------------------------------------------------------------------------------*/


/* 아티스트 */
CREATE TABLE ARTIST (
	ARTIST_USER_ID VARCHAR2(50) NOT NULL, /* 사용자아이디 */
	ARTIST_NAME VARCHAR2(30) NOT NULL, /* 아타스트명(그룹명) */
	ARTIST_PERFORMANCE VARCHAR2(30) NOT NULL, /* 퍼포먼스/장르 */
	ARTIST_PROFILE VARCHAR2(3000) NOT NULL, /* 프로필 */
	ARTIST_IMAGE VARCHAR2(100) NOT NULL, /* 사진 */
	ARTIST_MEMBERS VARCHAR2(200), /* 멤버들 이름 */
	ARTIST_SNS VARCHAR2(100),
	CONSTRAINT PK_ARTIST PRIMARY KEY (ARTIST_USER_ID),
	CONSTRAINT FK_USERS_TO_ARTIST FOREIGN KEY (ARTIST_USER_ID) REFERENCES USERS(USER_ID)
);
/*------------------------------------------------------------------------------------*/

/* 프리미엄 대관 공급장 */
CREATE TABLE PREMIUM_STAGE (
	ESTABLISH_NO NUMBER(10) NOT NULL, /* 사업장 번호 */
	OPERATOR_USER_ID VARCHAR2(50) NOT NULL, /* 공급자 아이디 */
	OPERATOR_NO NUMBER(10) NOT NULL, /* 사업자 번호 */
	STAGE_NAME VARCHAR2(50) NOT NULL, /* 장소명 */
	STAGE_LOCATION VARCHAR2(80) NOT NULL, /* 주소 */
	STAGE_AREA NUMBER(5) NOT NULL, /* 면적 */
	STAGE_INSTRUMENT VARCHAR(100), /* 구비된 악기 */
	STAGE_CONTENT VARCHAR(3000), /* 추가 입력 */
	STAGE_PARKING NUMBER(1), /* 주차장 유무 */
	STAGE_DRINKING NUMBER(1), /* 음주가능 여부 */
	STAGE_FOOD_SELL NUMBER(1), /* 음식 (유료)제공 여부 */
	STAGE_FOOD_RESTRICTION NUMBER(1), /* 외부음식 반입 가능 여부 */
	STAGE_IMAGE VARCHAR2(50) NOT NULL, /* 사진 */
	
	CONSTRAINT PREMIUM_STAGE_PK PRIMARY KEY (ESTABLISH_NO),
	CONSTRAINT FK_USERS_TO_PREMIUM_STAGE FOREIGN KEY (OPERATOR_USER_ID) REFERENCES USERS(USER_ID)
);

	
/*------------------------------------------------------------------------------------*/
	
	/* 프리미엄 공급장 예약 옵션 */
CREATE TABLE PREMIUM_STAGE_OPTION (
	OPTION_NO NUMBER(10) NOT NULL, /* 옵션번호 */
	STAGE_RENTAL_DATE DATE NOT NULL, /* 대관가능 날짜 */
	STAGE_STATE NUMBER(1) DEFAULT 0 NOT NULL, /* 예약상태 */
	STAGE_COST NUMBER(7) NOT NULL, /* 가격 */
	ESTABLISH_NO NUMBER(10) NOT NULL, /* 사업장 번호 */
	
	CONSTRAINT PK_PREMIUM_OPTION
		PRIMARY KEY (OPTION_NO),
		
	CONSTRAINT FK_ESTABLISH_TO_NO
		FOREIGN KEY (ESTABLISH_NO)	REFERENCES PREMIUM_STAGE (ESTABLISH_NO)	
);
/*----------------------------------------------------------------------------------------*/

/* 시간 */
CREATE TABLE PREMIUM_STAGE_TIME (
	OPTION_NO NUMBER(10) NOT NULL, /* 옵션번호 */
	TIME_CODE NUMBER(2) NOT NULL, /* 시간코드 */
	
	CONSTRAINT PK_PREMIUM_TIME
		PRIMARY KEY (OPTION_NO, TIME_CODE),
	CONSTRAINT FK_PREMIUM_TIME
		FOREIGN KEY (OPTION_NO) 
		REFERENCES PREMIUM_STAGE_OPTION (OPTION_NO) ON DELETE CASCADE
);
/*------------------------------------------------------------------------------------*/

	/* 공연장 대관 신청 */
CREATE TABLE PREMIUM_STAGE_RESERVATION (
	RESERVATION_NO NUMBER(10) NOT NULL, /* 신청번호 */
	USER_ID VARCHAR2(50) NOT NULL, /* 사용자아이디 */
	ESTABLISH_NO NUMBER(10) NOT NULL, /* 사업장 번호 */
	RESERVATION_REG_TIME DATE NOT NULL,/* 신청시간 */
	OPTION_NO NUMBER(10) NOT NULL,/* 신청한 옵션번호 */
	
	CONSTRAINT PK_PREMIUM_RESERVATION_NO	
		PRIMARY KEY (RESERVATION_NO),
	CONSTRAINT FK_PREMIUM_RESERVATION
		FOREIGN KEY (ESTABLISH_NO) REFERENCES PREMIUM_STAGE (ESTABLISH_NO),
		
	CONSTRAINT FK_USERS_RESERVATION
		FOREIGN KEY (USER_ID) REFERENCES USERS (USER_ID),
	CONSTRAINT FK_PREMIUM_STAGE_OPTION
		FOREIGN KEY (OPTION_NO) REFERENCES PREMIUM_STAGE_OPTION (OPTION_NO)
	
);


/*------------------------------------------------------------------------------------*/	
	
/* 프리미엄 공연장 사진 */

CREATE TABLE PREMIUM_STAGE_IMAGE (
STAGE_IMAGE_NO NUMBER(10) NOT NULL, /* 사진번호 */
STAGE_IMAGE_LOCATION VARCHAR2(100) NOT NULL, /* 사진위치 */
ESTABLISH_NO NUMBER(10), /* 사업장 번호 */

CONSTRAINT PK_PREMIUM_STAGE_IMAGE PRIMARY KEY (STAGE_IMAGE_NO),
CONSTRAINT FK_ESTABLISH_NO_STAGE_SUPPLIER
	FOREIGN KEY (ESTABLISH_NO) REFERENCES PREMIUM_STAGE (ESTABLISH_NO)	

);

/*------------------------------------------------------------------------------------*/
/* 공연장(공급자 게시물) */
CREATE TABLE STAGE (
	STAGE_NO NUMBER(10), /* 공연장 번호 */
	STAGE_NAME VARCHAR(50) NOT NULL, /* 공연장 이름 */
	STAGE_LOCATION VARCHAR(100) NOT NULL, /* 공연장 주소 */
	STAGE_RENTAL_DATE DATE NOT NULL, /* 대관일 */
	STAGE_COST NUMBER(7) NOT NULL, /* 가격 */
	STAGE_AREA NUMBER(5) NOT NULL, /* 면적 */
	STAGE_INSTRUMENT VARCHAR(100), /* 구비된 악기 */
	STAGE_CONTENT VARCHAR(3000), /* 추가 입력 */
	STAGE_PARKING NUMBER(1), /* 주차장 유무 */
	STAGE_DRINKING NUMBER(1), /* 음주가능 여부 */
	STAGE_FOOD_SELL NUMBER(1), /* 음식 (유료)제공 여부 */
	STAGE_FOOD_RESTRICTION NUMBER(1), /* 외부음식 반입 가능 여부 */
	STAGE_RESERVATION NUMBER DEFAULT 1 NOT NULL, /* 예약가능여부 */
	STAGE_SELLER_ID VARCHAR2(50) NOT NULL,/* 공연장 공급자 아이디 */
	STAGE_REG_TIME DATE NOT NULL, /* 공연장 등록 시간 */
	STAGE_START_TIME TIMESTAMP NOT NULL,
	STAGE_END_TIME TIMESTAMP NOT NULL,
	
	CONSTRAINT PK_STAGE PRIMARY KEY (STAGE_NO),
	CONSTRAINT FK_USERS_TO_STAGE FOREIGN KEY (STAGE_SELLER_ID) REFERENCES USERS (USER_ID)
);
/*------------------------------------------------------------------------------------*/

	/* 공연장 대관 시간코드 */
	CREATE TABLE STAGE_RESERVATION_TIME(
		TIME_CODE NUMBER(2) NOT NULL, /* 시간코드 */
		STAGE_NO NUMBER(10), /* 공연장 번호 */
	
		CONSTRAINT PK_STAGE_RESERVATION_TIME PRIMARY KEY (TIME_CODE),
		CONSTRAINT FK_STAGE_TO_RESERVATION_TIME
		FOREIGN KEY (STAGE_NO) REFERENCES STAGE (STAGE_NO)
		
	);

/*------------------------------------------------------------------------------------*/


/* 대관 예약(주문) */
CREATE TABLE STAGE_RESERVATION (
	RENTAL_NO NUMBER(10), /* 대관번호 */
	RENTAL_USER_ID VARCHAR2(50) NOT NULL, /* 사용자아이디 */
	STAGE_NO NUMBER(10) NOT NULL, /* 공연장 번호 */
	RENTAL_DATE DATE NOT NULL, /* 대관일 */
	RENTAL_STATE_CODE NUMBER(1) NOT NULL, /* 승인코드 */
	RENTAL_REG_TIME DATE NOT NULL, /* 대관 예약 등록 시간 */
	
	CONSTRAINT PK_STAGE_RESERVATION PRIMARY KEY (RENTAL_NO),
	CONSTRAINT FK_USERS_TO_STAGE_RESERVATION FOREIGN KEY (RENTAL_USER_ID) REFERENCES USERS (USER_ID),
	CONSTRAINT FK_STAGE_TO_STAGE_RESERVATION FOREIGN KEY (STAGE_NO) REFERENCES STAGE (STAGE_NO)
);

/*------------------------------------------------------------------------------------*/

/* 공연장 사진 */
CREATE TABLE STAGE_IMAGE (
	STAGE_IMAGE_NO NUMBER(10), /* 사진번호 */
	STAGE_IMAGE_LOCATION VARCHAR2(100) NOT NULL, /* 사진위치 */
	STAGE_NO NUMBER(10) NOT NULL, /* 공연장 번호 */
	
	CONSTRAINT PK_STAGE_IMAGE PRIMARY KEY (STAGE_IMAGE_NO),
	CONSTRAINT FK_STAGE_TO_STAGE_IMAGE FOREIGN KEY (STAGE_NO) REFERENCES STAGE(STAGE_NO)
);
/*------------------------------------------------------------------------------------*/

/* 공연장 리뷰 */
CREATE TABLE STAGE_REVIEW (
	STAGE_NO NUMBER(10), /* 공연장 번호 */
	STAGE_COMMENT_USER_ID VARCHAR2(50), /* 사용자아이디 */
	STAR_SCORE NUMBER(1) NOT NULL, /* 별점 */
	STAGE_COMMENT VARCHAR2(3000) NOT NULL, /* 댓글내용 */
	STAGE_COMMENT_REG_TIME DATE NOT NULL, /* 공연장 리뷰 등록 시간 */
	
	CONSTRAINT PK_STAGE_REVIEW PRIMARY KEY (STAGE_NO, STAGE_COMMENT_USER_ID),
	CONSTRAINT FK_STAGE_TO_STAGE_REVIEW FOREIGN KEY (STAGE_NO) REFERENCES STAGE(STAGE_NO),
	CONSTRAINT FK_USERS_TO_STAGE_REVIEW FOREIGN KEY (STAGE_COMMENT_USER_ID) REFERENCES USERS(USER_ID)
);

insert into STAGE_REVIEW values(25,'yoonkyu',5,'ddd',sysdate);
insert into STAGE_REVIEW values(25,'id2',4,'ddd',sysdate);
/*------------------------------------------------------------------------------------*/

/* 공연정보(아티스트 게시물) */
CREATE TABLE PERFORMANCE (
	PERFORMANCE_NO NUMBER(10), /* 공연정보 번호 */
	PERFORMANCE_NAME VARCHAR2(100) NOT NULL, /* 공연이름 */
	PERFORMANCE_TITLE VARCHAR2(200) NOT NULL, /* 글제목 */
	PERFORMANCE_LOCATION VARCHAR2(100) NOT NULL, /* 공연장소 */
	PERFORMANCE_DATE DATE NOT NULL, /* 공연날짜 */
	PERFORMANCE_HITS NUMBER DEFAULT 0 NOT NULL, /* 조회수 */
	PERFORMANCE_CONTENT VARCHAR(3000), /* 게시자 입력글 */
	PERFORMANCE_IMAGE VARCHAR2(100), /* 사진 */
	PERFORMANCE_USER_ID VARCHAR2(50) NOT NULL, /* 사용자아이디 */
	STAGE_NO NUMBER(10),  /* 공연장 번호 */
	PERFORMANCE_REG_TIME DATE NOT NULL, /* 공연 등록 시간 */
	PERFORMANCE_CODE NUMBER(1) NOT NULL,
	
	CONSTRAINT PK_PERFORMANCE PRIMARY KEY (PERFORMANCE_NO),
	CONSTRAINT FK_USERS_TO_PERFORMANCE FOREIGN KEY (PERFORMANCE_USER_ID) REFERENCES USERS (USER_ID) ON DELETE CASCADE,
	CONSTRAINT FK_STAGE_TO_PERFORMANCE FOREIGN KEY (STAGE_NO) REFERENCES STAGE (STAGE_NO) ON DELETE CASCADE
);

CREATE SEQUENCE STAGE_IMAGE_NO_SEQ;

CREATE SEQUENCE STAGE_NO_SEQ;
CREATE SEQUENCE PERFORMANCE_NO_SEQ;
CREATE SEQUENCE VIDEO_NO_SEQ;
CREATE SEQUENCE VIDEO_COMMENT_NO_SEQ;
CREATE SEQUENCE PREMIUM_RESERVATION_NO_SEQ;
CREATE SEQUENCE PREMIUM_OPTION_NO_SEQ;
CREATE SEQUENCE PREMIUM_STAGE_IMAGE_NO_SEQ;
CREATE SEQUENCE RENTAL_NO_SEQ;


/*------------------------------------------------------------------------------------*/

/* 공연정보 댓글 */
CREATE TABLE PERFORMANCE_COMMENT (
	PERFORMANCE_COMMENT_NO NUMBER(10), /* 댓글번호 */
	PERFORMANCE_NO NUMBER(10), /* 공연정보 번호 */
	PERFORMANCE_COMMENT_USER_ID VARCHAR2(50) NOT NULL, /* 사용자아이디 */
	PERFORMANCE_COMMENT VARCHAR2(3000) NOT NULL, /* 댓글내용 */
	PERFORMANCE_COMMENT_REG_TIME DATE NOT NULL, /* 공연 댓글 등록 시간 */
	
	CONSTRAINT PK_PERFORMANCE_COMMENT PRIMARY KEY (PERFORMANCE_COMMENT_NO,PERFORMANCE_NO),
	CONSTRAINT FK_PERFORMANCE_TO_P_COMMENT FOREIGN KEY (PERFORMANCE_NO) REFERENCES PERFORMANCE (PERFORMANCE_NO) ON DELETE CASCADE,
	CONSTRAINT FK_USERS_TO_P_COMMENT FOREIGN KEY (PERFORMANCE_COMMENT_USER_ID) REFERENCES USERS (USER_ID) ON DELETE CASCADE
);
CREATE SEQUENCE PERFORMANCE_COMMENT_NO_SEQ;

/*------------------------------------------------------------------------------------*/

/* 공연정보 좋아요 */
CREATE TABLE PERFORMANCE_LIKE (
	PERFORMANCE_LIKE_NO NUMBER(10), /* 공연정보 번호 */
	PERFORMANCE_LIKE_USER_ID VARCHAR2(50), /* 사용자아이디 */
	
	CONSTRAINT PK_PERFORMANCE_LIKE PRIMARY KEY (PERFORMANCE_LIKE_NO,PERFORMANCE_LIKE_USER_ID),
	CONSTRAINT FK_PERFORMANCE_TO_P_LIKE FOREIGN KEY (PERFORMANCE_LIKE_NO)  REFERENCES PERFORMANCE (PERFORMANCE_NO) ON DELETE CASCADE,
	CONSTRAINT FK_USERS_TO_P_LIKE FOREIGN KEY (PERFORMANCE_LIKE_USER_ID) REFERENCES USERS (USER_ID) ON DELETE CASCADE
);
/*------------------------------------------------------------------------------------*/
/* 동영상(게시물) */
CREATE TABLE VIDEO (
	VIDEO_NO NUMBER(10), /* 동영상번호 */
	VIDEO_TITLE VARCHAR2(100) NOT NULL, /* 제목 */
	VIDEO_LINK VARCHAR2(400) NOT NULL, /* 링크 */
	VIDEO_LOCATION VARCHAR2(30), /* 장소 */
	VIDEO_CONTENT VARCHAR2(3000), /* 게시자 등록글 */
	VIDEO_DATE DATE, /* 등록일자 */
	VIDEO_ARTIST VARCHAR2(200), /* 아티스트 */
	VIDEO_CATEGORY VARCHAR2(20), /* 영상 카테고리 */
	VIDEO_USER_ID VARCHAR2(50) NOT NULL, /* 사용자아이디 */
	VIDEO_REG_TIME DATE NOT NULL, /* 동영상 등록 시간 */
	VIDEO_HITS NUMBER DEFAULT 0 NOT NULL, /* 조회수 */
	
	CONSTRAINT PK_VIDEO PRIMARY KEY (VIDEO_NO),
	CONSTRAINT FK_USERS_TO_VIDEO FOREIGN KEY (VIDEO_USER_ID) REFERENCES USERS (USER_ID)

);

/*------------------------------------------------------------------------------------*/

/* 동영상 댓글 */
CREATE TABLE VIDEO_COMMENT (
   VIDEO_COMMENT_NO NUMBER(10) NOT NULL, /* 동영상 댓글번호  */
   VIDEO_NO NUMBER(10) NOT NULL, /* 동영상번호 */
   VIDEO_COMMENT_USER_ID VARCHAR2(50) NOT NULL, /* 사용자아이디 */
   VIDEO_COMMENT VARCHAR2(3000),/* 글내용 */
   VIDEO_COMMENT_REG_TIME DATE NOT NULL, /* 동영상 댓글 등록 시간 */
   
   CONSTRAINT PK_VIDEO_COMMENT PRIMARY KEY (VIDEO_NO, VIDEO_COMMENT_NO),
   CONSTRAINT FK_VIDEO_TO_VIDEO_COMMENT FOREIGN KEY (VIDEO_NO) REFERENCES VIDEO (VIDEO_NO),
   CONSTRAINT FK_USERS_TO_VIDEO_COMMENT FOREIGN KEY (VIDEO_COMMENT_USER_ID) REFERENCES USERS (USER_ID)
);

/*------------------------------------------------------------------------------------*/

/* 동영상 좋아요 */
CREATE TABLE VIDEO_LIKE (
	VIDEO_LIKE_NO NUMBER(10), /* 동영상번호 */
	VIDEO_LIKE_USER_ID VARCHAR2(50), /* 사용자아이디 */
	
	CONSTRAINT PK_VIDEO_LIKE PRIMARY KEY (VIDEO_LIKE_NO,VIDEO_LIKE_USER_ID),
	CONSTRAINT FK_VIDEO_TO_VIDEO_LIKE FOREIGN KEY (VIDEO_LIKE_NO) REFERENCES VIDEO (VIDEO_NO),
	CONSTRAINT FK_USERS_TO_VIDEO_LIKE FOREIGN KEY (VIDEO_LIKE_USER_ID) REFERENCES USERS (USER_ID)
);

/*------------------------------------------------------------------------------------*/

/* 중고상품(게시글) */
CREATE TABLE USED_GOODS (
	USED_GOODS_NO NUMBER(10), /* 중고상품 번호 */
	USED_GOODS_TITLE VARCHAR2(200) NOT NULL, /* 글제목 */
	USED_GOODS_MODEL VARCHAR2(10) NOT NULL, /* 모델명 */
	USED_GOODS_BRAND VARCHAR2(15) NOT NULL, /* 브랜드 */
	USED_GOODS_COST NUMBER(8) NOT NULL, /* 가격 */
	USED_GOODS_IMAGE VARCHAR2(100) NOT NULL, /* 사진 */
	USED_GOODS_EA NUMBER(2) NOT NULL, /* 수량 */
	USED_GOODS_DATE DATE NOT NULL, /* 등록일자 */
	USED_GOODS_CONTENT VARCHAR2(3000), /* 설명 */
	USED_GOODS_SELLER_ID VARCHAR2(50) NOT NULL, /* 판매자 아이디 */
	USED_GOODS_REG_TIME DATE NOT NULL, /* 중고상품 등록 시간 */
	
	CONSTRAINT PK_USED_GOODS PRIMARY KEY (USED_GOODS_NO),
	CONSTRAINT FK_USERS_TO_USED_GOODS FOREIGN KEY (USED_GOODS_SELLER_ID) REFERENCES USERS (USER_ID)
);

/*------------------------------------------------------------------------------------*/

/* 주문 */
CREATE TABLE ORDERS (
	ORDER_NO NUMBER(10), /* 주문번호 */
	USED_GOODS_NO NUMBER(10) NOT NULL, /* 중고상품 번호 */
	CONSUMER_ID VARCHAR2(50) NOT NULL, /* 구매자 아이디 */
	CANCEL_CODE NUMBER(1) NOT NULL, /* 주문취소코드 */
	ORDERS_REG_TIME DATE NOT NULL, /* 주문 등록 시간 */
	
	CONSTRAINT PK_ORDERS PRIMARY KEY (ORDER_NO),
	CONSTRAINT FK_USED_GOODS_TO_ORDERS FOREIGN KEY (USED_GOODS_NO) REFERENCES USED_GOODS (USED_GOODS_NO),
	CONSTRAINT FK_USERS_TO_ORDERS FOREIGN KEY (CONSUMER_ID) REFERENCES USERS (USER_ID)
);
/*------------------------------------------------------------------------------------*/

/* 주문정보(배송정보) */
CREATE TABLE ORDER_DETAIL (
	ORDER_NO NUMBER(10), /* 주문번호 */
	SHIPPING_ADDRESS VARCHAR2(80) NOT NULL, /* 배송지 주소 */
	ORDER_EA NUMBER(2) NOT NULL, /* 수량 */
	PURCHASE_COST NUMBER(8) NOT NULL, /* 가격 */
	ADDRESSEE_PHONE_NUM VARCHAR2(11) NOT NULL, /* 받는분연락처 */
	
	CONSTRAINT PK_ORDER_DETAIL PRIMARY KEY (ORDER_NO),
	CONSTRAINT FK_ORDERS_TO_ORDER_DETAIL FOREIGN KEY (ORDER_NO) REFERENCES ORDERS (ORDER_NO)
);

/*------------------------------------------------------------------------------------*/

/* 장바구니 */
CREATE TABLE BASKET (
	USED_GOODS_NO NUMBER(10), /* 중고상품 번호 */
	BASKET_CONSUMER_ID VARCHAR2(50), /* 사용자아이디 */
	BASKET_EA NUMBER(3) NOT NULL,/* 담은수량 */
	
	CONSTRAINT PK_BASKET PRIMARY KEY (USED_GOODS_NO,BASKET_CONSUMER_ID),
	CONSTRAINT FK_USED_GOODS_TO_BASKET FOREIGN KEY (USED_GOODS_NO) REFERENCES USED_GOODS (USED_GOODS_NO),
	CONSTRAINT FK_USERS_TO_BASKET FOREIGN KEY (BASKET_CONSUMER_ID) REFERENCES USERS (USER_ID)
);

/*------------------------------------------------------------------------------------*/

/* 중고상품 댓글 */
CREATE TABLE USED_COMMENT (

	USED_GOODS_COMMENT_NO NUMBER(10) NOT NULL, /* 댓글번호 */
	USED_GOODS_NO NUMBER(10) NOT NULL, /* 중고상품 번호 */
	USED_GOODS_COMMENT_ID VARCHAR2(50) NOT NULL, /* 사용자아이디 */
	USED_GOODS_COMMENT VARCHAR2(3000), /* 글내용 */
	USED_GOODS_COMMENT_REG_TIME DATE NOT NULL, /* 중고상품 댓글 등록 시간 */
	
	CONSTRAINT PK_USED_COMMENT PRIMARY KEY (USED_GOODS_NO,USED_GOODS_COMMENT_NO),
	CONSTRAINT FK_USED_GOODS_TO_USED_COMMENT FOREIGN KEY (USED_GOODS_NO) REFERENCES USED_GOODS (USED_GOODS_NO),
	CONSTRAINT FK_USERS_TO_USED_COMMENT FOREIGN KEY (USED_GOODS_COMMENT_ID) REFERENCES USERS (USER_ID) 
);

/*------------------------------------------------------------------------------------*/

/* 구매희망 */
CREATE TABLE USED_GOODS_WISH (
	USED_GOODS_WISH_NO NUMBER(10), /* 등록번호 */
	USED_GOODS_WISH_TITLE VARCHAR2(200) NOT NULL, /* 글제목 */
	USED_GOODS_WISH_MODEL VARCHAR2(50) NOT NULL, /* 모델명 */
	USED_GOODS_WISH_CONTENT VARCHAR2(3000), /* 글 내용 */
	USED_GOODS_WISH_USER_ID VARCHAR2(50) NOT NULL, /* 사용자아이디 */
	USED_GOODS_WISH_REG_TIME DATE NOT NULL, /* 구매희망 등록 시간 */
	
	CONSTRAINT PK_USED_GOODS_WISH PRIMARY KEY (USED_GOODS_WISH_NO),
	CONSTRAINT FK_USERS_TO_USED_GOODS_WISH FOREIGN KEY (USED_GOODS_WISH_USER_ID) REFERENCES USERS (USER_ID)
);

/*------------------------------------------------------------------------------------*/

/* 구인 - 인재구함 */
CREATE TABLE EMPLOY (
	EMPLOY_NO NUMBER(10), /* 거래번호 */
	EMPLOY_TITLE VARCHAR2(200) NOT NULL, /* 글제목 */
	EMPLOY_CONTENT VARCHAR2(3000) NOT NULL, /* 내용 */
	EMPLOY_LOCATION VARCHAR2(100) NOT NULL, /* 장소 */
	EMPLOY_DATE DATE NOT NULL, /* 날짜 */
	EMPLOY_COST NUMBER(8) NOT NULL, /* 가격 */
	EMPLOY_TALENT VARCHAR2(800) NOT NULL, /* 필요한 재능 */
	EMPLOY_USER_ID VARCHAR2(50) NOT NULL, /* 사용자아이디 */
	EMPLOY_REG_TIME DATE NOT NULL, /* 구인 등록 시간 */
	
	CONSTRAINT PK_EMPLOY PRIMARY KEY (EMPLOY_NO),
	CONSTRAINT FK_USERS_TO_EMPLOY FOREIGN KEY (EMPLOY_USER_ID) REFERENCES USERS (USER_ID)
);

/*------------------------------------------------------------------------------------*/

/* 구직 - 구직희망 - 상품에서 주문테이블 */
CREATE TABLE APPLICANT (
	EMPLOY_NO NUMBER(10), /* 거래번호 */
	APPLICANT_PROFILE VARCHAR2(3000), /* 구직희망자 추가 프로필 */
	APPLICANT_ID VARCHAR2(50) NOT NULL, /* 사용자아이디 */
	APPLICANT_REG_TIME DATE NOT NULL, /* 구직희망 등록 시간 */
	
	CONSTRAINT PK_APPLICANT PRIMARY KEY (EMPLOY_NO,APPLICANT_ID),
	CONSTRAINT FK_USERS_TO_APPLICANT FOREIGN KEY (APPLICANT_ID) REFERENCES USERS (USER_ID),
	CONSTRAINT FK_EMPLOY_TO_APPLICANT FOREIGN KEY (EMPLOY_NO) REFERENCES EMPLOY (EMPLOY_NO)
);

/*------------------------------------------------------------------------------------*/

/* 레슨 - 선생님 */
CREATE TABLE TEACHERS (
	TEACHERS_NO NUMBER(10), /* 거래번호 */
	TEACHERS_TITLE VARCHAR2(200) NOT NULL, /* 글제목 */
	TEACHERS_COMMENT VARCHAR2(3000) NOT NULL, /* 내용 */
	TEACHERS_LOCATION VARCHAR2(100) NOT NULL, /* 장소 */
	TEACHERS_DATE DATE NOT NULL, /* 날짜 */
	TEACHERS_COST NUMBER(8) NOT NULL, /* 가격 */
	TEACHERS_INSTRUMENT VARCHAR2(800), /* 갖춰진 장비 */
	TEACHERS_ID VARCHAR2(50) NOT NULL, /* 사용자아이디 */
	TEACHERS_REG_TIME DATE NOT NULL, /* 레슨 등록 시간 */
	
	CONSTRAINT PK_TEACHERS PRIMARY KEY (TEACHERS_NO),
	CONSTRAINT FK_USERS_TO_TEACHERS FOREIGN KEY (TEACHERS_ID) REFERENCES USERS (USER_ID)
);

/*------------------------------------------------------------------------------------*/

/* 레슨-학생 */
CREATE TABLE STUDENTS (
	TEACHERS_NO NUMBER(10), /* 거래번호 */
	STUDENTS_COMMENT VARCHAR2(3000), /* 학생 추가 입력 */
	STUDENTS_ID VARCHAR2(50) NOT NULL, /* 사용자아이디 */
	STUDENTS_REG_TIME DATE NOT NULL, /* 레슨-학생 등록 시간 */
	
	CONSTRAINT PK_STUDENTS PRIMARY KEY (TEACHERS_NO, STUDENTS_ID),
	CONSTRAINT FK_TEACHERS_TO_STUDENTS FOREIGN KEY (TEACHERS_NO) REFERENCES TEACHERS (TEACHERS_NO),
	CONSTRAINT FK_USERS_TO_STUDENTS FOREIGN KEY (STUDENTS_ID) REFERENCES USERS (USER_ID)
);

/*------------------------------------------------------------------------------------*/
select * from help

/* 고객센터 */
CREATE TABLE HELP (
	HELP_NO NUMBER(10), /* Q&A 게시글 번호 */
	HELP_CATEGORY VARCHAR2(3000) NOT NULL, /* 카테고리 */
	HELP_TITLE VARCHAR2(200) NOT NULL, /* 글제목 */
	HELP_CONTENT VARCHAR2(3000) NOT NULL, /* 내용 */
	HELP_IMAGE VARCHAR2(100), /* 사진1 */
	HELP_IMAGE2 VARCHAR2(100), /* 사진2 */
	HELP_USER_ID VARCHAR2(50) NOT NULL, /* 사용자아이디 */
	HELP_REG_TIME DATE NOT NULL, /* 고객센터 등록 시간 */
	
	CONSTRAINT PK_HELP PRIMARY KEY (HELP_NO),
	CONSTRAINT FK_USERS_TO_HELP FOREIGN KEY (HELP_USER_ID) REFERENCES USERS (USER_ID)
);

CREATE SEQUENCE HELP_NO_SEQ;


/*------------------------------------------------------------------------------------*/

/* 고객센터댓글 */
CREATE TABLE HELP_COMMENT (
	HELP_COMMENT_NO NUMBER(10), /* 댓글번호 */
	HELP_NO NUMBER(10), /* Q&A 게시글 번호 */
	HELP_COMMENT VARCHAR2(3000), /* 글내용 */
	HELP_COMMENT_ID VARCHAR2(50), /* 사용자아이디 */
	HELP_COMMENT_REG_TIME DATE NOT NULL, /* 고객센터 댓글 등록 시간 */
	
	CONSTRAINT PK_HELP_COMMENT PRIMARY KEY (HELP_COMMENT_NO,HELP_NO),
	CONSTRAINT FK_HELP_TO_HELP_COMMENT FOREIGN KEY (HELP_NO) REFERENCES HELP (HELP_NO),
	CONSTRAINT FK_USERS_TO_HELP_COMMENT FOREIGN KEY (HELP_COMMENT_ID) REFERENCES USERS (USER_ID)
);

CREATE SEQUENCE HELP_COMMENT_NO_SEQ;
