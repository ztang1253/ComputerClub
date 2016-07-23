<%-- 
    Document   : ZTSERegister
    Created on : Jan 19, 2016
    Author     : Zhenzhen Tang, Sydney Dele Enebeli
--%>

<jsp:include page="/ZTSEBanner.jsp" />

<section id="ZTSERegister">
    <h2>New Member Registration Form</h2><br>
    <form action="ZTSEDisplayMember.jsp" method="post">
        <label>Full Name:</label>
        <input type="text" name="fullName" style="width:200px" 
               required="required"><br>
        <label>Email:</label>
        <input type="text" name="email" style="width:300px" 
               required="required"><br>
        <label>Phone:</label>
        <input type="text" name="phone" style="width:100px"><br>
        <label>IT Program:</label>
        <select name="itProgram">
            <option value="CAD">CAD</option>
            <option value="CP">CP</option>
            <option value="CPA">CPA</option>
            <option value="ITID">ITID</option>
            <option value="ITSS">ITSS</option>
            <option value="MSD">MSD</option>
            <option value="OTHERS">OTHERS</option>
        </select><br>
        <label>Year Level:</label>
        <select name="year">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
        </select><br>
        <label>&nbsp;</label>
        <input type="submit" value="Register Now!">&nbsp;
        <input type="reset" value="Reset">
    </form>
</section>
<jsp:include page="/ZTSEFooter.jsp" />