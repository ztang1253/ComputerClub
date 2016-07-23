<%-- 
    Document   : ZTSEELoan.jsp
    Created on : Mar 14, 2016, 12:34:33 PM
    Author     : Zhenzhen Tang, Sydney Dele Enebeli
--%>

<jsp:include page="/ZTSEBanner.jsp" />

<section>
    <table>
        <tr style="font-weight: bold; text-align: center;">
            <td>Code</td>
            <td style="text-align: left;">Description</td>
            <td>QOH</td>
            <td  style="text-align: left;">Action</td>
        </tr>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:forEach items="${loanitems}" var="book">
            <tr>
                <td>${book.code}</td>
                <td>${book.description}</td>
                <td style="text-align: right;">${book.quantity}</td>
                <c:if test="${book.quantity != 0}">
                    <td>
<a href="<c:url value="ZTSECart?action=reserve&amp;code=${book.code}" />">
                            Reserve
                        </a>
                    </td>
                </c:if>
                <c:if test="${book.quantity == 0}">
                    <td style="text-align: right;">N/A</td>
                </c:if>

            </tr>
        </c:forEach>

    </table>
</section>

<jsp:include page="/ZTSEFooter.jsp" />