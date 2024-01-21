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
                String sql = "select [customerID], [email], [password], firstName, lastName, phone, point, member, "
                        + "city, district, street, number "
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
                    int member = rs.getInt("member");
                    String city = rs.getString("city");
                    String district = rs.getString("district");
                    String street = rs.getString("street");
                    String number = rs.getString("number");
                    acc = new CustomerDTO(customerID, email, password, firstName, lastName, phone, point, member, city, district, street, number);
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
    
//    public CustomerDTO createCustomer (String email, String password, String firstName, String lastName, String phone, String city, String district, String street, String number) {
//        Connection con = null;
//        PreparedStatement stm = null;
//        ResultSet rs = null;
//        CustomerDTO acc = null;
//        try {
//            //1. connect DB
//            con = DBHelper.makeConnection();
//            if (con != null) {
//                //2. create SQL String
//                String sql = "INSERT Customer "
//                        + "()";
//                //3. create SQL Statement
//                stm = con.prepareStatement(sql);
//                stm.setString(1, email);
//                stm.setString(2, password);
//                //4. execute query
//                rs = stm.executeQuery();
//                //5. process result   
//                if (rs.next()) {
//                    String customerID = rs.getString("customerID");
//                    String firstName = rs.getString("firstName");
//                    String lastName = rs.getString("lastName");
//                    String phone = rs.getString("phone");
//                    int point = rs.getInt("point");
//                    int member = rs.getInt("member");
//                    String city = rs.getString("city");
//                    String district = rs.getString("district");
//                    String street = rs.getString("street");
//                    String number = rs.getString("number");
//                    acc = new CustomerDTO(customerID, email, password, firstName, lastName, phone, point, member, city, district, street, number);
//                }
//            }
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (stm != null) {
//                stm.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
//        
//        return acc;
//    }

}
