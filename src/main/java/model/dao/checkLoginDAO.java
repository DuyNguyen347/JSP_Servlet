package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import model.bean.Admin;

public class checkLoginDAO {
    public boolean isExistUser(String username, String password) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu_1","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = null;
            String sql = "select count(*) as count from admin where Username='" + username + "' and Password='" + password + "'";
            rs = (stmt).executeQuery(sql);
            while(rs.next()) {
                return rs.getInt("count") > 0;
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }

    public ArrayList<Admin> getAdminList(String username){
        ArrayList<Admin> result = new ArrayList<Admin>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu_1","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = null;
            String sql = "select * from admin where 1";
            rs = ((java.sql.Statement) stmt).executeQuery(sql);
            while(rs.next()) {
                result.add(new Admin(rs.getString("Id"), rs.getString("Username"), rs.getString("Password"),rs.getString("Name"),rs.getString("Age"),rs.getString("Email"),rs.getString("Phone")));
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}