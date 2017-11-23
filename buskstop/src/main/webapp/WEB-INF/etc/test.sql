/*-----------------------------공연정보(아티스트 게시판)---------------------------------*/
/* 공연정보 목록 조회 */
select p.*, pl.like_count /* like_count = 좋아요 수 */
from PERFORMANCE p, (
	select performance_like_no, count(*) like_count
	from performance_like
	group by performance_like_no
	) pl
where p.performance_no = pl.performance_like_no;

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