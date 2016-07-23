<%-- 
    Document   : ZTSEECart
    Created on : Mar 14, 2016, 7:51:10 PM
    Author     : Zhenzhen Tang, Sydney Dele Enebeli
--%>

<jsp:include page="/ZTSEBanner.jsp" />

<section>
    <table>
        <tr style="font-weight: bold; text-align: center;">
            <td></td>
            <td>Your Loan Cart</td>
            <td></td>
        </tr>
        <tr style="font-weight: bold;">
            <td>Code</td>
            <td>Description</td>
            <td>Quantity</td>
        </tr>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:set var="total" value="${0}"></c:set>
        <c:forEach items="${cartItems}" var="book">
            <tr>
                <td>${book.code}</td>
                <td>${book.description}</td>
                <td style="text-align: right;">${book.quantity}</td>
                <c:set var="quantity" value="${book.quantity}"/>
                <c:set var="total" value="${total+quantity}"/>
            </tr>                   
        </c:forEach>
            <tr><td></td></tr>
            <tr><td></td></tr>   
            <tr><td></td></tr>   
            <tr style="text-align: right;">
                <td></td>                
                <td>Total:</td>
                <td>${total}</td>
            </tr>        
    </table>
            <br><br>
            <p>
                <a href="<c:url value="ZTSEClearCart" />">
                    Clear the cart
                </a>
            </p>
            <p>
                <a href="<c:url value="ZTSELoan" />">
                    Return to eLoan
                </a>
            </p>
</section>

<jsp:include page="/ZTSEFooter.jsp" />