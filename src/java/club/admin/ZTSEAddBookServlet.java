/*  ZTSEAddBookServlet.java
 *  Assignment 2
 * 
 *  Revision History
 *      Zhenzhen Tang, Sydney Dele Enebeli, 2016.02.19: Created
 */

package club.admin;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import club.business.Book;
import club.data.BookIO;

/**
 * Class to add books
 * @author Sydney Dele Enebeli
 */
public class ZTSEAddBookServlet extends HttpServlet
{
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String url = "/ZTSEDisplayBooks";
        String message = "";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null)
        {
            action = "Save";
        }

        // perform action and set URL to appropriate page
        if (action.equals("Save"))
        {
            // get parameters from the request
            String code = request.getParameter("code");
            String description = request.getParameter("description");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            
            // store data in Book object
            Book book = new Book(code, description, quantity);

            // validate the parameters
            
            if (code == null || code.isEmpty()) 
            {
                message += "<p>Book code is required.</p>";
            }
            
            if (description == null || description.isEmpty() || 
                    description.length() <= 1) 
            {
                message += 
                        "<p>Description must have at least 2 characters.</p>";
            }
            
            if (quantity <= 0)
            {
                message += "<p>Quantity must be a positive number.</p>";
            }
            
            if (message != "")
            {
                url = "/ZTSEAddBook.jsp";
            }
            else
            {
                // get a relative file name and insert a record
                ServletContext context = getServletContext();
                String path = context.getRealPath("/WEB-INF/books.txt");
                BookIO.insert(book, path);
            }
            request.setAttribute("message", message);
            request.setAttribute("book", book);
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
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
        processRequest(request, response);
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
