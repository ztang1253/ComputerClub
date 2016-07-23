<%-- 
    Document   : ZTSEBanner
    Created on : Jan 19, 2016
    Author     : Zhenzhen Tang, Sydney Dele Enebeli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ZTSE Programming Club</title>
        <link rel="shortcut icon" href="images/ZTSEComputerClub.ico" />
        <link rel="stylesheet" type="text/css" href="styles/main.css">
        <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js">
        </script>
    </head>

    <body>
        <header>
            <img src="images/ZTSEComputerClub.png" 
                 alt="ZTSE Computer Club Logo" width="58">
            <h1>ZTSE Computer Programming Club</h1>
            <h2>IT@Conestoga</h2>
        </header>
        <nav id="nav_bar">
            <ul>
                <li>
                    <a href="<c:url value="ZTSEIndex.jsp" />">Home</a>
                </li>
                <li>
                    <a href="<c:url value="ZTSEMemberAdmin?action=addMember" />">Register</a>
                </li>
                <li>
                    <a href="<c:url value="ZTSELoan" />">eLoan</a>
                </li>
                <li>
                    <a href="<c:url value="ZTSECart" />">eCart</a>
                </li>
                <li>
                    <a href="<c:url value="ZTSEAdmin.jsp" />">Admin</a>
                </li>
            </ul>
        </nav>