package database;

import java.sql.*;
import javax.swing.JOptionPane;

public class Tables {

    public static void main(String[] args) {
        Connection con = null;
        String query = "";

        try {
            con = Conn.getCon();
            DatabaseMetaData metaData = con.getMetaData();

            //appuser Table
            //query = "CREATE TABLE appuser(appuser_pk int AUTO_INCREMENT primary key, userRole varchar(50),name varchar(200),mobileNumber varchar(50),email varchar(200),password varchar(50),address varchar(200),status varchar(50))";
            //query = "INSERT into appuser(userRole,name,mobileNumber,email,password,address,status)values('superAdmin','Super Admin',12345,'admin@gmail.com','root','Jammu','Active')";
            
            //Catagory Table.
            //query = "CREATE TABLE CatagoryTable(Id int AUTO_INCREMENT primary key, Catagory varchar(100))";
           
            //Product Table
            //query = "CREATE TABLE ProductTable(Id int AUTO_INCREMENT primary key, Name varchar(200), Quantity int, Price float, Description varchar(500), catagory_Id int)";
            
            //Customer Table
            //query = "CREATE TABLE customerTable(Id int AUTO_INCREMENT primary key, Name varchar(200), mobile_number int(100), email varchar(300))";
            
            //cart table (not used 
//           query = "CREATE TABLE cartTable(Product_Id int AUTO_INCREMENT primary key, Name varchar(200), Quantity int, Price float, Description varchar(500), SubToal float)";
            
            //orderDetails table
            query = "CREATE TABLE orderDetails(order_pk int AUTO_INCREMENT primary key, orderId varchar(200), customer_id int, orderDate varchar(100), totalPaid float)";

            PreparedStatement ps = con.prepareStatement(query);
            int i = ps.executeUpdate();
            if (i == 0) {
               JOptionPane.showMessageDialog(null, "Table Created secessfully");
            } else {
                JOptionPane.showMessageDialog(null, "Table not Created");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
