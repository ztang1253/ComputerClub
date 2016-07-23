<%-- 
    Document   : ZTSEAddBook
    Created on : Feb 19, 2016
    Author     : Zhenzhen Tang, Sydney Dele Enebeli
--%>

<jsp:include page="/ZTSEBanner.jsp" />

<section>
    <h2>Add a Book</h2>
    <div style="color: red;">${message}</div>
    <form action="ZTSEAddBook" method="post">
        <label for="code">Code:</label>
        <input type="text" id="code" name="code" style="width:200px" 
               value="${book.code}"><br>
        <label for="description">Description</label>
        <input type="text" id="description" name="description" 
               style="width:300px"  value="${book.description}"><br>
        <label for="quantity">Quantity:</label>
        <input type="text" id="quantity" name="quantity" 
               style="width:100px"  value="${book.quantity}"><br>
        <label></label>
        <input type="submit" name="action" value="Save">
        <input type="submit" name="action" value="Cancel">    
    </form>         
</section>

<jsp:include page="/ZTSEFooter.jsp" />