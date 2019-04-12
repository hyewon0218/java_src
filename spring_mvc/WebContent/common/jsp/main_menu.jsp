<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--smartmenu 시작  -->
  <!-- SmartMenus core CSS (required) -->
    <link href="http://localhost:8080/spring_mvc/common/smartmenu/css/sm-core-css.css" rel="stylesheet" type="text/css" />

    <!-- "sm-blue" menu theme (optional, you can use your own CSS, too) -->
    <link href="http://localhost:8080/spring_mvc/common/smartmenu/css/sm-simple/sm-simple.css" rel="stylesheet" type="text/css" />
    
    <!-- jQuery -->
  <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> -->

    <!-- SmartMenus jQuery plugin -->
    <script type="text/javascript" src="http://localhost:8080/spring_mvc/common/smartmenu/jquery.smartmenus.min.js"></script>

    <!-- SmartMenus jQuery init -->
    <script type="text/javascript">
    	$(function() {
    		$('#main-menu').smartmenus({
    			subMenusSubOffsetX: 1,
    			subMenusSubOffsetY: -8
    		});
    	});
    	
    	function requestAll() {
    		var method="";
    		if(confirm("GET방식으로 요청하시겠습니까?")) {
    			method="GET";
    		}else{
    			alert("POST방식으로 요청합니다.")
    			method="POST";
    		}//else
    			document.hidFrm.action="request_all.do";
    			document.hidFrm.method=method;
    			document.hidFrm.submit();
    	}//requestAll
    	//chrome은 JavaScript에서 action을 변경하면 from의 action이 계속 유지된다.
    	function sendPost() {
    		document.hidFrm.action="request_post.do";
    		document.hidFrm.submit();
    	}//sendPost
    	
    </script>
    <form action="request_post.do" name="hidFrm" id="hidFrm" method="post"></form>
<!--smartmenu 끝-->
     <nav id="main-nav">
      <!-- Sample menu definition -->
      <ul id="main-menu" class="sm sm-simple">
        <li><a href="#void">홈으로</a></li>
        <li><a href="#void">spring mvc 사용</a>
          <ul>
            <li><a href="#void">1일차</a>
              <ul>
                <li><a href="request_get.do">GET방식의 요청</a></li>
                <li><a href="#void" onclick="sendPost()">POST방식 요청</a></li>
                <li><a href="#void" onclick="requestAll()">GET/POST 모두 요청</a></li>
                <li><a href="request_form.do">HttpServletRequest로 파라메터 처리</a></li>
                <li><a href="request_vo_form.do">VO 파라메터 처리</a></li>
              </ul>
            </li>
        </ul>
        <li><a href="#">동기방식 차량조회</a></li>
      </ul>
    </nav>
    