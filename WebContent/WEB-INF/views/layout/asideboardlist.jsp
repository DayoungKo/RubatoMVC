<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<aside>
	<jsp:include page="loginarticle.jsp" />
	<nav id="sub_menu">
    <ul>
      <li><a href="./boardlist.do?search_cookie_check=removeCookie">+ 자유 게시판</a></li>
      <li><a href="#">+ 방명록</a></li>
      <li><a href="#">+ 공지사항</a></li>
      <li><a href="#">+ 등업요청</a></li>
      <li><a href="#">+ 포토갤러리</a></li>
    </ul>
  </nav>
  <article id="sub_banner">
    <ul>
      <li><img src="img/banner1.png"></li>
      <li><img src="img/banner2.png"></li>		
      <li><img src="img/banner3.png"></li>
    </ul>	
  </article>
</aside>