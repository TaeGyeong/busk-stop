<%@ page contentType="text/html;charset=utf-8"%>
<h1>고객센터 글쓰기</h1>


01.<input><br>
02.<input><br>
03.<input><br>
04.<input><br>
05.<input><br>
06.<input><br>
07.<input><br>
08.<input><br>
09.<input><br>
10.<input><br>

<button>등록</button><button>취소</button>
<br>
========================================================<br>
======================이하 수정 등록 예정==================<br>
========================================================<br>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <style type="text/css">
   body { font-family:'돋움'; }
  </style>
  <title>Document</title>
 </head>
 <body>
  
  <hr>
  <h2>공연장 대관 등록(stageReservationView.do)<h2>

   <div style="padding: 0.01em 16px; color:#000!important; background-color: #ddffff!important; border-left: 6px solid #ccc!important; border-color: #2196F3!important;">
	   <p style="color: #000!important; background-color: #ddffff!important ;border-color: #2196F3!important; font-size: 12px; font-weight: normal; line-height: 1.5; color: #000!important; box-sizing: inherit;">
	   
	   <b>요구사항 :</b> 한 개의 공연장 대관정보 글을 등록한다.<br>
 - 내용 : 공연장 이름, 주소(지도확인), 면적, 대관가능 날짜(시간), 시간당가격, 사진, 공급자 정보(이름, 연락처)를 필수로 입력받고<br> 주차장 유무, 음주가능여부, 식사판매여부, 외부음식 반입가능여부를 선택적으로 입력한다.<br>
 - 프리미엄 공급자의 경우 글을 등록 할 시 자동으로 등록글에 프리미엄 표시를 붙여준다.<br>
 + 등록 후에는 글 상세보기 페이지와 같은 페이지를 제공하여 자신의 글을 확인시켜준다.
	   
	   </p>
   </div>
   <hr>
<div style="width:960px; margin:auto;">
<h1>대관 공연장 등록하기</h1>
<div style="font-size: 17px; font-weight: normal; ">
# 별(*) 표시는 필수 입력 사항입니다.
</div>
<form action="./URL" method="post">
   <table style="border-collapse: collapse; width:100%;">
	   <tr style="padding:10px">
		   <td style="border: 1px solid #888; padding:5px; width:25%; font-size: 17px;">*공연장 이름</td>
		   <td style="border: 1px solid #888; padding:10px" ><input type="text" name="text" required placeholder="공연장의 이름을 써 주세요." style="width:100%; vertical-align:middle; font-size: 15px; margin:auto; padding:5px; box-sizing: border-box; "></td>
	   </tr>
	   <tr style="padding:10px">
		   <td style="border: 1px solid #888; padding:5px; width:25%; font-size: 17px;">*공연장 주소</td>
		   <td style="border: 1px solid #888; padding:10px;"><input type="text" name="text" required placeholder="공연장을 찾아갈 수 있는 주소를 써 주세요." style="width:100%; vertical-align:middle; font-size: 15px; margin:auto; padding:5px; box-sizing: border-box;"></td>
	   </tr>
	   <tr style="padding:10px">
		   <td style="border: 1px solid #888; padding:5px; width:25%; font-size: 17px;">*공연장 면적</td>
		   <td style="border: 1px solid #888; padding:10px;"><input type="text" name="text" required placeholder="공연장의 크기를 알 수 있는 면적을 알려주세요" style="width:100%; vertical-align:middle; font-size: 15px; margin:auto; padding:5px; box-sizing: border-box;"></td>
	   </tr>
	   <tr style="padding:10px">
		   <td style="border: 1px solid #888; padding:5px; width:25%; font-size: 17px;">*대관가능 날짜(시간)</td>
		   <td style="border: 1px solid #888; padding:10px;"><input type="date" name="text" required placeholder="대관이 가능 한 날짜를 알려주세요." style="width:100%; vertical-align:middle; font-size: 15px; margin:auto; padding:5px; box-sizing: border-box;"></td>
	   </tr>
	   <tr style="padding:10px">
		   <td style="border: 1px solid #888; padding:5px; width:25%; font-size: 17px;">*사진</td>
		   <td style="border: 1px solid #888; padding:10px;"><input type="text" name="text" required placeholder="공연장의 자세한 사진을 올려주세요." style="width:100%; vertical-align:middle; font-size: 15px; margin:auto; padding:5px; box-sizing: border-box;"></td>
	   </tr>
	   <tr style="padding:10px">
		   <td style="border: 1px solid #888; padding:5px; width:25%; font-size: 17px;">*공연장 담당자 이름</td>
		   <td style="border: 1px solid #888; padding:10px;"><input type="text" name="text" required placeholder="공연장에 대해 문의 할 수 있는분의 성함을 알려주세요." style="width:100%; vertical-align:middle; font-size: 15px; margin:auto; padding:5px; box-sizing: border-box;"></td>
	   </tr>
	   <tr style="padding:10px">
		   <td style="border: 1px solid #888; padding:5px; width:25%; font-size: 17px;">*공연장 연락처</td>
		   <td style="border: 1px solid #888; padding:10px;"><input type="text" name="text" required placeholder="공연장에 대한 문의 할 수 있는 연락처를 알려주세요." style="width:100%; vertical-align:middle; font-size: 15px; margin:auto; padding:5px; box-sizing: border-box;"></td>
	   </tr>
	   <tr style="padding:10px">
		   <td style="border: 1px solid #888; padding:5px; width:25%; font-size: 17px;">주차가능 여부</td>
		   <td style="border: 1px solid #888; padding:10px;"><input type="text" name="text" placeholder="공연장에 주차장이 있거나 혹은 가까운 곳에 주차가 가능한 공간이 있는지 알려주세요." style="width:100%; vertical-align:middle; font-size: 15px; margin:auto; padding:5px; box-sizing: border-box;"></td>
	   </tr>
	   <tr style="padding:10px">
		   <td style="border: 1px solid #888; padding:5px; width:25%; font-size: 17px;">음주 가능 여부</td>
		   <td style="border: 1px solid #888; padding:10px;;"><input type="text" name="text" placeholder="주류를 판매하거나 혹은 주류를 마실 수 있는지 여부를 알려주세요." style="width:100%; vertical-align:middle; font-size: 15px; margin:auto; padding:5px; box-sizing: border-box;"></td>
	   </tr>
	   <tr style="padding:10px">
		   <td style="border: 1px solid #888; padding:5px; width:25%; font-size: 17px;">식사 판매 여부</td>
		   <td style="border: 1px solid #888; padding:10px;"><input type="text" name="text" placeholder="식사를 판매 하는지 알려주세요." style="width:100%; vertical-align:middle; font-size: 15px; margin:auto; padding:5px; box-sizing: border-box;"></td>
	   </tr>
	   <tr style="padding:10px">
		   <td style="border: 1px solid #888; padding:5px; width:25%; font-size: 17px;">외부 음식물 반입 가능 여부</td>
		   <td style="border: 1px solid #888; padding:10px;"><input type="text" name="text" placeholder="외부 음식물을 가져와서 먹을 수 있는지 알려주세요." style="width:100%; vertical-align:middle; font-size: 15px; margin:auto; padding:5px; box-sizing: border-box;"></td>
	   </tr>
	   <tr>
		   <td colspan="2" align="center" style="padding:5px; width:25%; font-size: 17px;">
				<div style="margin:auto;">
					<button type="submit" formtarget="_blank" style="padding:10px 20px">등록</button>
					<button type="reset" style="padding:10px 20px">취소</button>
				</div>
		   </td>
       </tr>
   </table>   
</form>
</div>
 </body>
</html>
