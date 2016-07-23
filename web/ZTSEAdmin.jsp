<%-- 
    Document   : ZTSEAdimin
    Created on : Jan 19, 2016
    Author     : Zhenzhen Tang, Sydney Dele Enebeli
--%>

<jsp:include page="/ZTSEBanner.jsp" />

<section id="ZTSEAdimin">
    <h2>Admin : Data Maintenance</h2>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <a href="<c:url value="ZTSEDisplayBooks" />">Maintain Books</a>
    <br>
    <a href="<c:url value="ZTSEMemberAdmin?action=displayMembers" />">
        Display Members</a>
</section>

<jsp:include page="/ZTSEFooter.jsp" />