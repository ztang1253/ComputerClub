<%-- 
    Document   : ZTSEConfirmMemberDelete
    Created on : Mar 26, 2016, 6:53:27 PM
    Author     : Zhenzhen Tang, Sydney Dele Enebeli
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/ZTSEBanner.jsp" />

<section>
    <h2>Do you want to delete this member?</h2>
    
    <form action="ZTSEMemberAdmin" method="get">
        <label>&nbsp;</label>
        <input type="submit" value="No, keep this member !">
        <br><br>
        
        <input type="hidden" name="action" value="displayMembers">
        <label>Full Name:</label>
        <input type="text" name="fullName" style="width:200px" 
               value ="${member.fullName}"
               disabled="disabled"><br>
        <label>Email:</label>
        <input type="text" name="email" style="width:300px" 
               value ="${member.emailAddress}"
               disabled="disabled"><br>
        <label>Phone:</label>
        <input type="text" name="phone" style="width:100px"
               value ="${member.phoneNumber}"
               disabled="disabled"><br>
        <label>IT Program:</label>
        <select name="itProgram" disabled="disabled">
            <c:if test="${member.programName != null}">
                <option value="${member.programName}">
                    ${member.programName}</option>
            </c:if>            
            <c:if test="${member.programName != 'CAD'}">
                <option value="CAD" >CAD</option>
            </c:if>
            <c:if test="${member.programName != 'CP'}">
                <option value="CP" >CP</option>
            </c:if>
            <c:if test="${member.programName != 'CPA'}">
                <option value="CPA" >CPA</option>
            </c:if>
            <c:if test="${member.programName != 'ITID'}">
                <option value="ITID" >ITID</option>
            </c:if>
            <c:if test="${member.programName != 'ITSS'}">
                <option value="ITSS" >ITSS</option>
            </c:if>
            <c:if test="${member.programName != 'MSD'}">
                <option value="MSD" >MSD</option>
            </c:if>
            <c:if test="${member.programName != 'OTHERS'}">
                <option value="OTHERS" >OTHERS</option>
            </c:if>
        </select><br>
        <label>Year Level:</label>
        <select name="year" disabled="disabled">
            <c:if test="${member.yearLevel != null}">
                <option value="${member.yearLevel}">
                    ${member.yearLevel}</option>
            </c:if>            
            <c:if test="${member.yearLevel != '1'}">
                <option value="1" >1</option>
            </c:if>
            <c:if test="${member.yearLevel != '2'}">
                <option value="2" >2</option>
            </c:if>
            <c:if test="${member.yearLevel != '3'}">
                <option value="3" >3</option>
            </c:if>
            <c:if test="${member.yearLevel != '4'}">
                <option value="4" >4</option>
            </c:if>
        </select><br>
    </form>
    <label>&nbsp;</label>
    <form action="ZTSEMemberAdmin" method="post">
        <input type="hidden" name="action" value="deleteMember">
        <input type="hidden" name="email" value="${member.emailAddress}">
        <input type="submit" value="Yes, delete !">
    </form>

</section>
<jsp:include page="/ZTSEFooter.jsp" />