/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.CustomerDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBHelper;

/**
 *
 * @author Admin
 */
public class CustomerDAO {

    public CustomerDTO checkLogin(String email, String password) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        CustomerDTO acc = null;
        try {
            //1. connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. create SQL String
                String sql = "select [customerID], [email], [password], firstName, lastName, phone, point, member, status "
                        + "FROM [dbo].[Customer] "
                        + "WHERE [email] = ? "
                        + "AND [password] = ?";
                //3. create SQL Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, password);
                //4. execute query
                rs = stm.executeQuery();
                //5. process result   
                if (rs.next()) {
                    String customerID = rs.getString("customerID");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String phone = rs.getString("phone");
                    int point = rs.getInt("point");
                    String member = rs.getString("member");
                    boolean status = rs.getBoolean("status");
                    acc = new CustomerDTO(customerID, email, password, firstName, lastName, phone, point, member, status);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return acc;
    }

    public CustomerDTO searchCustomerByEmail(String email) throws ClassNotFoundException, SQLException {

        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            String sql = "select * from customer "
                    + "where email = ?";
            st = con.prepareStatement(sql);
            st.setString(1, email);
            rs = st.executeQuery();
            if (rs.next()) {
                CustomerDTO c = new CustomerDTO(rs.getString("customerId"), rs.getString("email"),
                        rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"),
                        rs.getString("phone"), rs.getInt("point"), rs.getString("member"), rs.getBoolean("status"));
                return c;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public boolean isExisted(String email) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select [email] from [dbo].[Customer] where  [email] = ?";
                st = con.prepareStatement(sql);
                st.setString(1, email);
                rs = st.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean insertCustomer(String email, String firstName, String lastName, String password, String phone) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        int rs = 0;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO [dbo].[Customer]\n"
                        + "           ([CustomerID]\n"
                        + "           ,[email]\n"
                        + "           ,[password]\n"
                        + "           ,[firstName]\n"
                        + "           ,[lastName]\n"
                        + "           ,[phone]\n"
                        + "           ,[point]\n"
                        + "           ,[member]\n"
                        + "           ,[img]\n"
                        + "           ,[status])\n"
                        + "    VALUES (?,?,?,?,?,?,?,?,?,?)";

                stm = con.prepareStatement(sql);

                stm.setString(1, this.createCustomerId());
                stm.setString(2, email);
                stm.setString(3, password);
                stm.setString(4, firstName);
                stm.setString(5, lastName);
                stm.setString(6, phone);
                stm.setInt(7, 0);
                stm.setString(8, "Basic");
                stm.setString(9, "CC_C3-scaled-e1695366218592");
                stm.setBoolean(10, true);

                rs = stm.executeUpdate();
                if (rs != 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public String createCustomerId() throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int count = 0;
        try {
            con = DBHelper.makeConnection();
            String sql = "SELECT [CustomerID]\n"
                    + "  FROM [dbo].[Customer] ";
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                count++;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return "C" + (count + 1);
    }

}
