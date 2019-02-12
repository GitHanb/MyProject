/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import businesslogic.AccountService;
import businesslogic.UserService;
import domainmodel.Myuser;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hanzh
 */
public class LoginServlet extends HttpServlet
{

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (action != null)
        {
            if (action.equals("logout"))
            {
                session.invalidate();
                request.setAttribute("successMessage", "You have been successfully logged out.");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || username.equals("") || username.isEmpty())
        {
            //clearMessages(request);
            request.setAttribute("warningMessage", "Username is blank!");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        if (password == null || password.equals("") || password.isEmpty())
        {
            //clearMessages(request);
            request.setAttribute("warningMessage", "Password is blank!");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }

        AccountService as = new AccountService();
        UserService us = new UserService();

        //user does not exist
        if (as.loginHandler(username, password) == 0)
        {
            request.setAttribute("dangerMessage", "User does not exist!");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

        //wrong password
        if (as.loginHandler(username, password) == 1)
        {
            request.setAttribute("warningMessage", "Invalid password!");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

        Myuser currentUser = null;
        try
        {
            currentUser = us.getUser(username);
        } catch (Exception ex)
        {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (currentUser.getActive() == false)
        {
            request.setAttribute("warningMessage", "Account has been locked, please inform administrator.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        session.setAttribute("currentUser", currentUser);
        response.sendRedirect("home");

    }
}
