/* 사용자 */
insert into USERS values('hong1653', '홍길동', 'ewwe12345', '경기도 안산시', '01011112222', 'hong448@naver.com');
insert into USERS values('kim4845', '김경민', 'fdsf84848', '경상도 부산시', '01015849584', 'kim4852@naver.com');
insert into USERS values('beck4848', '백강민', 'asd1234', '전라도 전주시', '01015968447', 'beck4488@naver.com');
insert into USERS values('nam8118', '남승민', '555eee', '충청도 충주시', '01026598554', 'nam5995@naver.com');
insert into USERS values('lee534', '이승민', 'lee888844', '경기도 성남시', '01015622258', 'lee523@naver.com');
insert into USERS values('sim1', '심원', 'sdf8485', '경기도 오산시', '01015985632', 'sim33@gmail.com');
insert into USERS values('yunee33', '윤현', 'sd8899', '경기도 이천시', '01013835896', 'yun88@naver.com');
insert into USERS values('kimp123', '김민혁', 'et18453', '서울시', '01023485126', 'kimp3@nate.com');
insert into USERS values('suck1598', '석민수', '848err2', '인천시', '01015633467', 'suckf111@naver.com');
insert into USERS values('kimjr322', '김진혁', 'ad484as', '경상도 대구시', '01009384852', 'kimjr838@gmail.com');
insert into USERS values('choi22', '최경석', 'sdfsd484894', '전라도 광주시', '01012363059', 'choi85@naver.com');
insert into USERS values('no33432', '노석준', 'fdfd84841', '강원도 원주시', '01095363095', 'noee3@nate.com');
insert into USERS values('kimbo88', '김보남', 'erer88555', '강원도 강릉시', '01095685873', 'kimb22@naver.com');
insert into USERS values('kimdo327', '김회윤', 'qwwq2222', '경기도 평택시', '01009364596', 'kimu33@gmail.com');
insert into USERS values('kimm990', '김원진', 'cvf5558', '경기도 남양주시', '01012650485', 'kimm99855@naver.com');

/* 권한 */
insert into AUTHORITY values('', '');

/* 팔로우 */
insert into FOLLOW values('hong1653', 'kim4845');
insert into FOLLOW values('beck4848', 'kim4845');
insert into FOLLOW values('suck1598', 'kim4845');
insert into FOLLOW values('sim1', 'kim4845');
insert into FOLLOW values('sim1', 'yunee33');

/* 프리미엄 대관 공급자 */
insert into STAGE_SUPPLIER values('', '');

/* 아티스트 */
insert into ARTIST values('kim4845', '메기 매운탕', '모던록밴드', '좋은 음악을 하는 밴드 입니다.', 'c://img/img1', '김경민, 김명민, 김겅민, 김엉민');
insert into ARTIST values('kimp123', '노랑머리', '어쿠스틱듀오', '발라드 합니다.', 'c://img/img2', '김민혁, 김밀현');
insert into ARTIST values('choi22', 'mc경', '힙합', 'wtf', 'c://img/img3', '최경석');
insert into ARTIST values('yunee33', '노래 개잘핵', '발라드', '추천받아요', 'c://img/img4', '윤현');

/* 공연장(공급자 게시물) */
insert into STAGE values('1', '홍대 놀이터', '홍대 어딘가', '200000', '100', '베이스기타, 일렉기타, 드럼, 건반, 앰프', '매우 쾌적한 환경을 조성하고 있습니다.', 1, 0, 1, 0, 1, 'hong1653');
insert into STAGE values('2', '서현 라이브 카페', '서현역 5번 출구', '100000', '85', '드럼, 건반, 앰프', '쾌적한 환경을 조성.', 0, 0, 0, 0, 1, 'sim1');
insert into STAGE values('3', '야탑 라이브', '야탑역 2번 출구', '150000', '120', '일렉기타, 건반, 앰프', '좋아요.', 0, 0, 0, 0, 0, 'suck1598');
insert into STAGE values('4', '부산 놀이터', '부산 해운대', '120000', '100', '드럼, 건반', '오세요.', 1, 1, 1, 0, 1, 'kimm990');
insert into STAGE values('5', '전주 놀이터', '전주 어딘가', '300000', '180', '베이스기타, 일렉기타, 드럼, 건반, 앰프', '매우매우매우 쾌적한 환경을 조성하고 있습니다.', 1, 1, 1, 0, 1, 'lee534');

/* 대관 예약(주문) */
insert into STAGE_RESERVATION values();

/* 공연장 사진 */
insert into STAGE_IMAGE values();

/* 공연장 리뷰 */
insert into STAGE_REVIEW values();

/* 공연정보(아티스트 게시물) */
insert into PERFORMANCE values('1', '서현 공연', '서현으로 오세요!', '서현역 5번 출구', '2017-11-23', 5, '많이 놀러오세요.', 'c://img/img1','kimp123', null);
insert into PERFORMANCE values('2', '야탑 공연', '야탑 정기 공연','야탑 라이브', '2017-11-28', 125, '많이 놀러오세요.', 'c://img/img1','kim4845', '3');
insert into PERFORMANCE values('3', '부산 공연', '붓산 사나이','부산 놀이터', '2017-12-22', 30, '보러오세요.', 'c://img/img1','yunee33', '4');

/* 공연정보 댓글 */
insert into PERFORMANCE_COMMENT values();


/* 공연정보 좋아요 */
insert into PERFORMANCE_LIKE values('1', 'hong1653');
insert into PERFORMANCE_LIKE values('1', 'kim4845');
insert into PERFORMANCE_LIKE values('1', 'beck4848');
insert into PERFORMANCE_LIKE values('1', 'kimm990');
insert into PERFORMANCE_LIKE values('1', 'no33432');
insert into PERFORMANCE_LIKE values('1', 'yunee33');
insert into PERFORMANCE_LIKE values('2', 'kimjr322');
insert into PERFORMANCE_LIKE values('2', 'kimm990');
insert into PERFORMANCE_LIKE values('2', 'kimdo327');

/* 동영상(게시물) */
insert into VIDEO values(1, '공연영상1', 'www.youtube1.com', '경기도 성남시', '좋은 공연이었습니다.', '2017-10-12', '메기 매운탕', 'kimm990');
insert into VIDEO values(2, '공연영상2', 'www.youtube2.com', '경기도 하남시', '재밌는 공연이었습니다.', '2017-11-12', 'mc경', 'kimbo88');
insert into VIDEO values(3, '공연영상3', 'www.youtube3.com', '경상도 부산시', '유쾌한 공연이었습니다.', '2017-09-02', '메기 매운탕, 노래 개잘핵', 'no33432');

/* 동영상 댓글 */
insert into VIDEO_COMMENT values();

/* 동영상 좋아요 */
insert into VIDEO_LIKE values();

/* 중고상품(게시글) */
insert into USED_GOODS values(1, '기타 사세요', '기타1', '데임', 170000, 'c://img/img1', 1, '2017-01-12', '좋은 기타입니다. 사주세요.', 'kimjr322');
insert into USED_GOODS values(2, '기타 좀 사주세요', '기타2', '스윙', 80000, 'c://img/img2', 1, '2017-11-10', '팔아요', 'suck1598');
insert into USED_GOODS values(3, '베이스 팔아요', '베이스1', '데임', 210000, 'c://img/img3', 1, '2017-09-21', '사세요.', 'hong1653');
insert into USED_GOODS values(4, '앰프 상태 상', '앰프1', '애플', 30000, 'c://img/img4', 4, '2017-08-02', '좋아요', 'kimdo327');
insert into USED_GOODS values(5, '건반 거래 합니다', '건반1', '야마하', 300000, 'c://img/img5', 1, '2017-02-28', '깨끗', 'kimjr322');

/* 주문 */
insert into ORDERS values(1, 1, 'sim1', 0);
insert into ORDERS values(2, 5, 'suck1598', 1);
insert into ORDERS values(3, 3, 'nam8118', 0);
insert into ORDERS values(4, 4, 'sim1', 0);

/* 주문정보(배송정보) */
insert into ORDER_DETAIL values(1, '경기도 광주시 오포읍', 1, 170000, '01032362569');
insert into ORDER_DETAIL values(2, '경기도 성남시 분당구', 1, 300000, '01011111111');
insert into ORDER_DETAIL values(3, '경기도 오산시', 1, 210000, '01099558866');
insert into ORDER_DETAIL values(4, '강원도 강릉시', 3, 90000, '01022222224');

/* 장바구니 */
insert into BASKET values(4, 'lee534', 1);
insert into BASKET values(3, 'no33432', 1);
insert into BASKET values(4, 'yunee33', 2);

/* 중고상품 댓글 */
insert into USED_COMMENT values();

/* 구매희망 */
insert into USED_GOODS_WISH values(1, '판매 부탁드려요', '폴앤폴 250', '구매원함', 'sim1');
insert into USED_GOODS_WISH values(2, '급구', '릴리즈 70', '파시오', 'yunee33');
insert into USED_GOODS_WISH values(3, '구해요', '펜더 재즈 usa', '급구', 'kimm990');
insert into USED_GOODS_WISH values(4, '구매 원함', '릴리즈 70 콘서트', '빨리좀', 'kimbo88');
insert into USED_GOODS_WISH values(5, 'please', '데임 폴앤폴 350', '올려요', 'kimbo88');

/* 구인 - 인재구함 */
insert into EMPLOY values();

/* 구직 - 구직희망 - 상품에서 주문테이블 */
insert into APPLICANT values();

/* 레슨 - 선생님 */
insert into TEACHERS values();

/* 레슨 - 학생 */
insert into STUDENTS values();

/* 고객센터 */
insert into HELP values();

/* 고객센터 댓글 */
insert into HELP_COMMENT values();

