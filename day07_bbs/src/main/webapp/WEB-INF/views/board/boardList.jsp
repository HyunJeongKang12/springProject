<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<jsp:include page="../inc/header.jsp" />

<div class="container mt-5">
<h3>스프링 게시판</h3>
<table class="table">
   <thead class="table-dark">
      <tr>
         <th>번호</th>
         <th>제목</th>
         <th>조회수</th>
         <th>글쓴이</th>
         <th>등록일</th>
      </tr>
   </thead>
   <tbody>
      <c:forEach var="dto" items="${list}">
      <tr>
         <td>${dto.bid }</td>
         <td><a href="<c:url value="/board/view.do?bid=${dto.bid}&viewPage=${pDto.viewPage}"/>"> ${dto.subject}</a></td>
         <td>${dto.hit}</td>
         <td>${dto.writer }</td>
         <td>${dto.reg_date }</td>
      </tr>
      </c:forEach>
      <tr>
         <td colspan="5" class="text-center">
            <button class="btn btn-primary" id="btn-write"> 글쓰기</button>
         </td>
      </tr>
   </tbody>
</table>

<!-- pagination -->
<ul class="pagination justify-content-center my-5">
  <li class="page-item ${pDto.prevPage<=0 ? 'disabled' : '' }"> <!-- class안에 -->
     <a class="page-link" href="list.do?viewPage=${pDto.prevPage}">이전</a>
  </li>
  
  <c:forEach var="i" begin="${pDto.blockStart }" end="${pDto.blockEnd }">
     <li class="page-item ${pDto.viewPage == i ? 'active' : ''}" ><!-- class안에 -->
        <a class="page-link" href="<c:url value='/board/list.do?viewPage=${i}'/>">${i}</a>
     </li>
  </c:forEach>
  
  <li class="page-item ${pDto.blockEnd >= pDto.totalPage ? 'disabled' : '' }">
     <a class="page-link" href="list.do?viewPage=${pDto.nextPage}">다음</a>
  </li>
</ul>

<script>
	$(document).ready(function(){
		$("#btn-write").click(()=>{
			location.href = "<c:url value='/board/register.do'/>";
		});
	});
</script>
<jsp:include page="../inc/footer.jsp" />