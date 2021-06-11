<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인페이지</title>
    <link href="/css/teststyle.css" type="text/css" rel="stylesheet">

</head>
<body>
    <!-- header 영역 -->
    <tiles:insertAttribute name="header" />
    
    <!-- aside 영역 -->
    <tiles:insertAttribute name="aside" />

	<!-- main 영역 -->
    <tiles:insertAttribute name="main" />  

	<!-- navbar 영역 -->
    <tiles:insertAttribute name="navbar" />

</body>
</html>
