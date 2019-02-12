/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import businesslogic.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 636334
 */
public class RegisterServlet extends HttpServlet
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
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
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
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");


        UserService us = new UserService();

        if (username == null || username.equals("") || username.isEmpty())
        {
            request.setAttribute("warningMessage", "Username is blank!");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        if (password1 == null || password1.equals("") || password1.isEmpty())
        {
            request.setAttribute("warningMessage", "Password is blank!");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        if (password2 == null || password2.equals("") || password2.isEmpty())
        {
            request.setAttribute("warningMessage", "Please repeat your password!");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        if (!password1.equals(password2))
        {
            request.setAttribute("warningMessage", "Password doesn't match, please re-type your password!");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        if (firstname == null || firstname.equals("") || firstname.isEmpty())
        {
            request.setAttribute("warningMessage", "First name is blank!");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        if (lastname == null || lastname.equals("") || lastname.isEmpty())
        {
            request.setAttribute("warningMessage", "Last name is blank!");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        try
        {
            us.insert(username, password1, email, phone, true, firstname, lastname);
            request.setAttribute("successMessage", "Registered successfully.");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } catch (Exception ex)
        {
            request.setAttribute("dangerMessage", "Unable to register.");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }
}
