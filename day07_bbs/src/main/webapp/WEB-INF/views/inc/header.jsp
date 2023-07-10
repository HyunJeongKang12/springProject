<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <!-- 개별 적용 -->
  <link href="<c:url value="/css/main.css" />" rel="stylesheet" >
</head>
<body style="height:1500px">

<div class="container-fluid mt-3">
  <br>
  <h3>ACADEMY</h3>
</div>

<nav class="navbar navbar-expand-sm sticky-top">
  <div class="container">
  	<ul class="navbar-nav">
  		<li class="nav-item">
		    <a class="nav-link" href="<c:url value="/"/>">HOME</a>
  		</li>
  		<li class="nav-item">
		    <a class="nav-link" href="<c:url value="/board/list.do"/>">게시판</a>
  		</li>
  	</ul>
  </div>
</nav>

