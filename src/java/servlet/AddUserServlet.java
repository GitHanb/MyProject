/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import businesslogic.DepartmentService;
import businesslogic.UserService;
import domainmodel.Mydepartment;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hanzh
 */
public class AddUserServlet extends HttpServlet
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
        DepartmentService ds = new DepartmentService();
        List<Mydepartment> departments = null;
        try
        {
            departments = ds.getAll();
        } catch (Exception ex)
        {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("departments", departments);
        getServletContext().getRequestDispatcher("/WEB-INF/addUser.jsp").forward(request, response);
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
        Integer departmentID = Integer.parseInt(request.getParameter("department"));

        UserService us = new UserService();
        DepartmentService ds = new DepartmentService();

        if (username == null || username.equals("") || username.isEmpty())
        {
            request.setAttribute("warningMessage", "Username is blank!");
            List<Mydepartment> departments = null;
            try
            {
                departments = ds.getAll();
            } catch (Exception ex)
            {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("departments", departments);
            getServletContext().getRequestDispatcher("/WEB-INF/addUser.jsp").forward(request, response);
            return;
        }

        if (password1 == null || password1.equals("") || password1.isEmpty())
        {
            request.setAttribute("warningMessage", "Password is blank!");
            List<Mydepartment> departments = null;
            try
            {
                departments = ds.getAll();
            } catch (Exception ex)
            {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("departments", departments);
            getServletContext().getRequestDispatcher("/WEB-INF/addUser.jsp").forward(request, response);
            return;
        }

        if (password2 == null || password2.equals("") || password2.isEmpty())
        {
            request.setAttribute("warningMessage", "Please repeat your password!");
            List<Mydepartment> departments = null;
            try
            {
                departments = ds.getAll();
            } catch (Exception ex)
            {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("departments", departments);
            getServletContext().getRequestDispatcher("/WEB-INF/addUser.jsp").forward(request, response);
            return;
        }

        if (!password1.equals(password2))
        {
            request.setAttribute("warningMessage", "Password doesn't match, please re-type your password!");
            List<Mydepartment> departments = null;
            try
            {
                departments = ds.getAll();
            } catch (Exception ex)
            {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("departments", departments);
            getServletContext().getRequestDispatcher("/WEB-INF/addUser.jsp").forward(request, response);
            return;
        }

        if (firstname == null || firstname.equals("") || firstname.isEmpty())
        {
            request.setAttribute("warningMessage", "First name is blank!");
            List<Mydepartment> departments = null;
            try
            {
                departments = ds.getAll();
            } catch (Exception ex)
            {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("departments", departments);
            getServletContext().getRequestDispatcher("/WEB-INF/addUser.jsp").forward(request, response);
            return;
        }

        if (lastname == null || lastname.equals("") || lastname.isEmpty())
        {
            request.setAttribute("warningMessage", "Last name is blank!");
            List<Mydepartment> departments = null;
            try
            {
                departments = ds.getAll();
            } catch (Exception ex)
            {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("departments", departments);
            getServletContext().getRequestDispatcher("/WEB-INF/addUser.jsp").forward(request, response);
            return;
        }

        try
        {
            Mydepartment department = ds.getDepartment(departmentID);
            us.insert(username, password1, email, phone, true, firstname, lastname);
            us.update(username, department, true);
            request.setAttribute("successMessage", "Registered successfully.");
            response.sendRedirect("user");
        } catch (Exception ex)
        {
            request.setAttribute("dangerMessage", "Unable to register.");
            getServletContext().getRequestDispatcher("/WEB-INF/addUser.jsp").forward(request, response);
        }
    }
}
