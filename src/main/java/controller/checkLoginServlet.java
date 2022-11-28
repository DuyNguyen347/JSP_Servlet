package controller;

import model.bean.Admin;
import model.bo.checkLoginBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "checkLoginServlet", value = "/checkLoginServlet")
public class checkLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination = null;
        checkLoginBO checkLoginBo = new checkLoginBO();
        ArrayList<Admin> adminList = null;
        adminList = checkLoginBo.getAdminList("");
        request.setAttribute("adminList", adminList);
        destination = "/welcome.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(destination);
        rd.forward(request, response);
    }

    public checkLoginServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String destination = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        checkLoginBO checkLoginBo = new checkLoginBO();
        ArrayList<Admin> adminList = null;

        try {
            if(checkLoginBo.isValidUser(username, password)) {
                System.out.println("da den day ");
//                adminList = checkLoginBo.getAdminList("");
//                request.setAttribute("adminList", adminList);
//                RequestDispatcher rd = request.getRequestDispatcher("/welcome.jsp");
//                rd.forward(request, response);

                response.sendRedirect("listEmployee");

//                RequestDispatcher rd = request.getRequestDispatcher("/listEmployee");
//                rd.forward(request,response);
//                System.out.println("da den 2");
            }
            else {
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Loi");
            e.printStackTrace();
        }
        //doGet(request, response);
    }
}
