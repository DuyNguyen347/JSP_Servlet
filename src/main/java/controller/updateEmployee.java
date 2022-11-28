package controller;

import model.bean.Admin;
import model.dao.employeeDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "updateEmployee", value = "/updateEmployee")
public class updateEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt( request.getParameter("id"));
        employeeDAO employeeDAO = new employeeDAO();
        try {
            Admin admin = employeeDAO.getAdminById(id);
            request.setAttribute("admin",admin);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/updateEmployee.jsp");
            dispatcher.forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String id = request.getParameter("id");
        Admin admin = new Admin(id,username,password,name,age,email,phone);
        employeeDAO employeeDAO = new employeeDAO();
        try {
            employeeDAO.updateEmployee(admin);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("listEmployee");
    }
}
