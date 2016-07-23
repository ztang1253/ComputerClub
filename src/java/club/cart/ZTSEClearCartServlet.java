/*  ZTSEClearCartServlet.java
 *  Assignment 3
 * 
 *  Revision History
 *      Zhenzhen Tang, Sydney Dele Enebeli, 2016.03.14: Created
 */

package club.cart;

import club.business.Book;
import club.business.ECart;
import club.business.ELoan;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Class to clear books in cart
 * @author Zhenzhen Tang
 */
public class ZTSEClearCartServlet extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> 
     * and <code>POST</code> methods.
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
        String url = "/ZTSEECart.jsp";
        HttpSession session = request.getSession();
        ServletContext sc = getServletContext();
        try
        {
            ArrayList<Book> loanitems = 
                    (ArrayList<Book>)sc.getAttribute("loanitems");
            ECart cart = (ECart)session.getAttribute("cart");
            
            ArrayList<Book> cartItems = cart.getItems();
            int cartSize = cart.getCount();
            for (int i = 0; i < cartSize; i++)
            {
                Book book = (Book)cartItems.get(0);
                ELoan.addToQOH(loanitems, book.getCode(), book.getQuantity());
                cart.removeItem(book);
            }
            
            sc.setAttribute("loanitems", loanitems);
            sc.getRequestDispatcher(url).forward(request, response);
        }
        finally
        {
            sc.getRequestDispatcher(url).forward(request, response);
        }
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
        doPost(request, response);
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
        processRequest(request, response);
    }
}
