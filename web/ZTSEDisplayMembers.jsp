<%-- 
    Document   : ZTSEDisplayMembers
    Created on : Mar 26, 2016, 6:49:03 AM
    Author     : Zhenzhen Tang, Sydney Dele Enebeli
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/ZTSEBanner.jsp" />

<section>
    <h2>List of Members</h2>
    <p style="color: red;">${message}</p>
    <table>
        <tr style="font-weight: bold; text-align: left;">
            <td>Email</td><td>Program</td><td>Year</td><td></td><td></td>
        </tr>
        <c:forEach items="${members}" var="member">
            <tr>
                <td>${member.emailAddress}</td>
                <td>${member.programName}</td>
                <td>${member.yearLevel}</td>
                <td><a href="<c:url value=
"ZTSEMemberAdmin?action=displayMember&email=${member.emailAddress}"/>">
                        Update</a>
                </td>
                <td><a href="<c:url value=
"ZTSEMemberAdmin?action=confirmDeleteMember&email=${member.emailAddress}"/>">
                        Delete</a></td>
            </tr>
        </c:forEach>

    </table>

    <form action="ZTSEMember.jsp" method="get">
        <input type="submit" value="Add Member">
    </form>

</section>

<jsp:include page="/ZTSEFooter.jsp" />