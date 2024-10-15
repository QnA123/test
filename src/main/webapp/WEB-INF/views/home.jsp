<!-- 한글 깨짐 방지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.org.koseaQnA.boards.util.Paging"%>

<%
	Date currentDate = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String today = dateFormat.format(currentDate);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body>
   <div >
     <div >
       <h1>게시판</h1>
     </div>
     <div >
       <table >
         <thead >
           <tr>
             <th>번호</th>
             <th>제목</th>
             <th>조회수</th>
             <th>이름</th>
             <th>작성일</th>
           </tr>
         </thead>
         <tbody>
           <c:forEach var="item" items="${items}">
              <tr>
                <td>${item.id}</td>
                <td>${item.title}</td>
                <td>${item.hit}</td>
                <td>${item.user_name}</td>
                <td>${item.created_at.substring(0,10)}</td>
              </tr>
            </c:forEach>
         </tbody>
       </table>
     </div>
   </div>

   <!-- 페이징 -->
<div>
   <div>

      <!-- 처음으로 버튼 -->
      <c:if test="${paging.page > 1}">
         <a href="javascript:;" onclick="pageGrouping(1, 1, 0, 0)">처음으로</a>
      </c:if>

      <!-- 이전 페이지 그룹으로 이동 -->
      <c:if test="${paging.pgn > 1}">
         <a href="javascript:;" onclick="pageGrouping(${paging.pgn - 1}, 1, ${paging.tpgn}, ${paging.total_page})">이전</a>
      </c:if>

      <!-- 페이지 번호 목록 -->
      <c:forEach var="i" begin="${(paging.pgn - 1) * paging.pageNums + 1}" end="${(paging.pgn * paging.pageNums < paging.total_page) ? paging.pgn * paging.pageNums : paging.total_page}">
         <c:choose>
            <c:when test="${paging.page == i}">
               <a href="javascript:;"><span>${i}</span></a>
            </c:when>
            <c:otherwise>
               <a href="javascript:;" onclick="allBoardList(${paging.pgn}, ${i})"><span>${i}</span></a>
            </c:otherwise>
         </c:choose>
      </c:forEach>

      <!-- 다음 페이지 그룹으로 이동 -->
      <c:if test="${paging.pgn < paging.tpgn}">
         <a href="javascript:;" onclick="pageGrouping(${paging.pgn + 1}, 2, ${paging.tpgn}, ${paging.total_page})">다음</a>
      </c:if>

      <!-- 끝으로 버튼 -->
      <c:if test="${paging.page < paging.total_page}">
         <a href="javascript:;" onclick="pageGrouping(${paging.tpgn}, 2, ${paging.tpgn}, ${paging.total_page})">끝으로</a>
      </c:if>
   </div>
</div>

</body>
<script>

function pageGrouping(pGroup, direct, total_page_group_num, total_page) {
	   let pNum = 0;
	   if (direct == 1 && pGroup == 1) {
	      pNum = 1;
	   } else if (direct == 1 && pGroup > 1) {
	      pGroup = pGroup - 1;
	      pNum = pGroup * 10 - 9;
	   } else if (direct == 2 && pGroup < total_page_group_num) {
	      pGroup = pGroup + 1;
	      pNum = pGroup * 10 - 9;
	   } else if (direct == 2 && pGroup == total_page_group_num) {
	      pNum = total_page;
	   }

	   console.log(pGroup, pNum);

	   window.location.href = "/api/boards?pageNum=" + pNum + "&pageGroup=" + pGroup;
	}
   </script>

   <script>
      function allBoardList(pageGroup, pageNum) {
         window.location.href = "/api/boards?pageNum="+pageNum+"&pageGroup="+pageGroup;
         }
   </script>
</html>

