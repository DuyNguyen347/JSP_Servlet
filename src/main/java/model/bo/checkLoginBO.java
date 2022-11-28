package model.bo;
import  model.dao.checkLoginDAO;
import  model.bean.Admin;

import java.sql.SQLException;
import java.util.ArrayList;

public class checkLoginBO {
    checkLoginDAO checkLoginDao = new checkLoginDAO();

    public boolean isValidUser(String username, String password) throws ClassNotFoundException, SQLException {
        return checkLoginDao.isExistUser(username, password);
    }

    public ArrayList<Admin> getAdminList(String username){
        return checkLoginDao.getAdminList(username);
    }
}
