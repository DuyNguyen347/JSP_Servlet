package model.dao;

import model.bean.Admin;

import java.sql.*;

public class employeeDAO {
    Connection con = null;
    Statement st = null;
    PreparedStatement prst = null;

    public int insertemployee(Admin admin) throws SQLException, ClassNotFoundException {
        System.out.println("Adding");
        if (con == null) {
            con = ConnectionDatabase.getMySQLConnection();
        }
        String sql = "insert into admin (Id,Username,Password,Name,Age,Email,Phone) values (NULL,?,?,?,?,?,?)";
        prst = (PreparedStatement) con.prepareStatement(sql);
        prst.setString(1,admin.getUsername());
        prst.setString(2,admin.getPassword());
        prst.setString(3,admin.getName());
        prst.setString(4,admin.getAge());
        prst.setString(5,admin.getEmail());
        prst.setString(6,admin.getPhone());
        System.out.println("vao toi day");
        System.out.println(prst);
        try{
            int result = prst.executeUpdate();
            System.out.println("ket qua update" + result);
            return result;
        }
        catch (Exception e)
        {
            System.out.println("Loi khi them: ");
            e.printStackTrace();
        }
        return 0;
    }
    public void deleteEmployee(int id) throws SQLException, ClassNotFoundException {
        if (con == null) {
            con = ConnectionDatabase.getMySQLConnection();
        }
        String sql = "delete from admin where Id  = ?";
        prst = (PreparedStatement) con.prepareStatement(sql);
        prst.setInt(1,id);
        try{
            prst.executeUpdate();
            System.out.println("Xoa thanh cong");
        }
        catch (Exception e)
        {
            System.out.println("Loi khi xoa");
            e.printStackTrace();
        }
    }
    public  void updateEmployee(Admin admin) throws SQLException, ClassNotFoundException {
        System.out.println("updating");
        if (con == null) {
            con = ConnectionDatabase.getMySQLConnection();
        }
        String sql = "UPDATE admin SET Username = ?,Password = ?,Name = ?, Age =? ,Email = ?, Phone = ?  WHERE Id = ?";
        prst = con.prepareStatement(sql);
        prst.setString(1,admin.getUsername());
        prst.setString(2,admin.getPassword());
        prst.setString(3,admin.getName());
        prst.setString(4,admin.getAge());
        prst.setString(5,admin.getEmail());
        prst.setString(6,admin.getPhone());
        prst.setInt(7,Integer.parseInt(admin.getId()));
        try{
            prst.executeUpdate();
            System.out.println("Cap nhat thanh cong");
        }
        catch (Exception e)
        {
            System.out.println("Loi khi cap nhat");
            e.printStackTrace();
        }
    }
    public Admin getAdminById(int id) throws SQLException, ClassNotFoundException {
        if (con == null) {
            con = ConnectionDatabase.getMySQLConnection();
        }
            String sql = "SELECT * FROM admin WHERE Id = ? LIMIT 1";
            prst = con.prepareStatement(sql);
            prst.setInt(1,id);
            ResultSet rs = null;
            rs = prst.executeQuery();
            while (rs.next())
            {
                return new Admin(rs.getString("Id"),rs.getString("Username"),rs.getString("Password"),rs.getString("Name"),rs.getString("Age"),rs.getString("Email"), rs.getString("Phone"));
            }
            return null;
    }
}
