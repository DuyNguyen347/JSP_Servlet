package controller;

import model.bean.Admin;
import model.bo.checkLoginBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "listEmployee", value = "/listEmployee")
public class listEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkLoginBO checkLoginBo = new checkLoginBO();
        ArrayList<Admin> adminList = null;
        adminList = checkLoginBo.getAdminList("");
        request.setAttribute("adminList", adminList);
        String destination = "/welcome.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(destination);
        rd.forward(request, response);
    }

    public listEmployee() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
