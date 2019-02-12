/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import businesslogic.DepartmentService;
import businesslogic.UserService;
import domainmodel.Mydepartment;
import domainmodel.Myuser;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 636334
 */
public class UserServlet extends HttpServlet
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
        Myuser currentUser = (Myuser) session.getAttribute("currentUser");
        if (currentUser == null)
        {
            request.setAttribute("dangerMessage", "Log in first!");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        UserService us = new UserService();
        List<Myuser> users = null;
        try
        {
            users = us.getAllUsers();
        } catch (Exception ex)
        {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
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
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        boolean active = request.getParameter("active") != null;

        UserService us = new UserService();

        if (action != null)
        {
            if (action.equals("delete"))
            {
                String selectedUsername = request.getParameter("selectedUser");
                try
                {
                    us.delete(selectedUsername);
                } catch (Exception ex)
                {
                    request.setAttribute("dangerMessage", "Whoops.  Could not perform that action.");
                }
                request.setAttribute("successMessage", "User has been successfully deleted.");

                //list all users
                List<Myuser> users = null;
                try
                {
                    users = us.getAllUsers();
                } catch (Exception ex)
                {
                    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                session.setAttribute("users", users);
                getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
                return;

            }

            if (action.equals("edit"))
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
                
                String selectedUsername = request.getParameter("selectedUser");
                try
                {
                    Myuser selectedUser = us.getUser(selectedUsername);
                    request.setAttribute("selectedUser", selectedUser);

                } catch (Exception ex)
                {
                    request.setAttribute("dangerMessage", "Unable to update user!");
                }

                //list all users
                List<Myuser> users = null;
                try
                {
                    users = us.getAllUsers();
                } catch (Exception ex)
                {
                    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                session.setAttribute("users", users);
                getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
                return;
            }

            if (action.equals("save"))
            {
                DepartmentService ds = new DepartmentService();
                try
                {
                    Integer departmentID = Integer.parseInt(request.getParameter("department"));
                    Mydepartment department = ds.getDepartment(departmentID);
                    us.update(username, department, active);
                    request.setAttribute("successMessage", "User has been successfully updated.");
                } catch (Exception ex)
                {
                    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                //list all users
                List<Myuser> users = null;
                try
                {
                    users = us.getAllUsers();
                } catch (Exception ex)
                {
                    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                session.setAttribute("users", users);
                getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
            }
        }
    }
}
