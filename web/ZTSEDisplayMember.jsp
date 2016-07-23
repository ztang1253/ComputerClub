<%-- 
    Document   : ZTSEDisplayMember
    Created on : Jan 19, 2016
    Author     : Zhenzhen Tang, Sydney Dele Enebeli
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/ZTSEBanner.jsp" />

<section id="ZTSEDisplayMember">
    <h2>Thanks for joining our club!</h2><br>
    <p>Here is the information you entered:</p>
    <label>Full Name:</label>${param.fullName}<br>
    <label>Email: </label>${param.email}<br>
    <label>Phone:</label>${param.phone}<br>
    <label>IT Program:</label>${param.itProgram}<br>
    <label>Year Level:</label>${param.year}<br>
    <p>To register another member, click on the Back 
        button in your browser or 
        <br>the Return button shown below.
    </p>
    <input type="button" onclick="javascript:history.back(-1);" 
           value=" Return ">
</section>

<jsp:include page="/ZTSEFooter.jsp" />