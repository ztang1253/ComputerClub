/*  ZTSEMemberAdminController.java
 *  Assignment 4
 * 
 *  Revision History
 *      Zhenzhen Tang, Sydney Dele Enebeli, 2016.03.26: Created
 */

package club.admin;

import club.business.Member;
import club.data.MemberDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class to handle all CRUD actions for Member
 *
 * @author Sydney Dele Enebeli
 */
public class ZTSEMemberAdminController extends HttpServlet
{
    /**
     * Processes requests for both HTTP <code>GET</code> 
     * and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException
    {
        String url = "/ZTSEDisplayMembers.jsp";
        ServletContext sc = getServletContext();

        String action = request.getParameter("action");
        if (action == null)
        {
            action = "displayMembers";  // default action
        }

        // display members link clicked & no btn clicked
        if (action.equals("displayMembers"))
        {
            ArrayList<Member> members = MemberDB.selectMembers();
            request.setAttribute("members", members);
        }
        else if (action.equals("addMember")) //add btn & register link clicked
        {
            url = "/ZTSEMember.jsp";
        }
        else if (action.equals("displayMember")) //update link clicked
        {
            String email = request.getParameter("email");
            Member member = MemberDB.selectMember(email);
            if (member == null)
            {
                // if there is wrong url input
                member = new Member();
                member.setEmailAddress(email);
                member.setProgramName("CAD");
                member.setYearLevel(1);
            }
            request.setAttribute("member", member);
            url = "/ZTSEMember.jsp";
        }
        else if (action.equals("confirmDeleteMember")) //delete link clicked
        {
            String email = request.getParameter("email");
            Member member = MemberDB.selectMember(email);
            if (member != null)
            {
                request.setAttribute("member", member);
                url = "/ZTSEConfirmMemberDelete.jsp";
            }
            else
            {
                request.setAttribute("message",
                        "Sorry, no such user with this email address. ("
                        + email + ")");
                ArrayList<Member> members = MemberDB.selectMembers();
                request.setAttribute("members", members);
            }

        }

        sc.getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException
    {
        String url = "/ZTSEDisplayMembers.jsp";
        ServletContext sc = getServletContext();

        String action = request.getParameter("action");
        if (action.equals("updateMember")) //update member btn clicked
        {
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String itProgram = request.getParameter("itProgram");
            String year = request.getParameter("year");

            Member member = new Member(fullName, email);
            if (member.isValid())
            {
                if (MemberDB.emailExists(email))
                {
                    // update
                    member.setPhoneNumber(phone);
                    member.setProgramName(itProgram);
                    member.setYearLevel(Integer.parseInt(year));

                    MemberDB.update(member);
                }
                else
                {
                    // add new member
                    member.setPhoneNumber(phone);
                    member.setProgramName(itProgram);
                    member.setYearLevel(Integer.parseInt(year));

                    MemberDB.insert(member);
                }
            }
            else
            {
                request.setAttribute("errorMessage", 
                        "Member information is not valid. " + 
                                "You must enter a valid name and email. ");
                member.setProgramName("CAD");
                member.setYearLevel(1);
                request.setAttribute("member", member);
                url = "/ZTSEMember.jsp";
            }
            ArrayList<Member> members = MemberDB.selectMembers();
            request.setAttribute("members", members);
        }
        else if (action.equals("deleteMember")) //yes btn clicked
        {
            //delete member
            String email = request.getParameter("email");
            Member member = MemberDB.selectMember(email);
            if (member != null)
            {
                MemberDB.delete(member);
            }
            ArrayList<Member> members = MemberDB.selectMembers();
            request.setAttribute("members", members);
        }

        sc.getRequestDispatcher(url).forward(request, response);
    }
}
