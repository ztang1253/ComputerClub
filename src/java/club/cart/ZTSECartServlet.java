/*  ZTSECartServlet.java
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
 * Class to add book into cart
 * @author Zhenzhen Tang
 */
public class ZTSECartServlet extends HttpServlet
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
            String action = request.getParameter("action");
            String code = request.getParameter("code");

            if ("reserve".equals(action) && code != null)
            {
                ArrayList<Book> loanitems
                        = (ArrayList<Book>) sc.getAttribute("loanitems");

                ECart cart = (ECart) session.getAttribute("cart");
                if (cart == null)
                {
                    cart = new ECart();
                }

                Book book = ELoan.findItem(loanitems, code);
                if (book.getQuantity() != 0)
                {
                    cart.addItem(book);
                    ELoan.subtractFromQOH(loanitems, code, 1);
                }

                session.setAttribute("cartItems", cart.getItems());
                session.setAttribute("cart", cart);
                sc.setAttribute("loanitems", loanitems);

                sc.getRequestDispatcher(url).forward(request, response);
            }
            else
            {
                sc.getRequestDispatcher(url).forward(request, response);
            }
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
