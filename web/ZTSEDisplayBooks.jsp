<%-- 
    Document   : ZTSEDisplayBooks
    Created on : Feb 19, 2016
    Author     : Zhenzhen Tang, Sydney Dele Enebeli
--%>

<jsp:include page="/ZTSEBanner.jsp" />

<section>
    <h2>List of Books</h2>
    <table>
        <tr style="font-weight: bold; text-align: center;">
            <td>Code</td><td>Description</td><td>Quantity</td>
        </tr>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.code}</td>
                <td>${book.description}</td>
                <td>${book.quantity}</td>
            </tr>
        </c:forEach>
        
    </table>
    
    <form action="ZTSEAddBook.jsp" method="post">
        <input type="submit" value="Add Book">
    </form>
</section>

<jsp:include page="/ZTSEFooter.jsp" />