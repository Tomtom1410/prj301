/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BookingDetail;
import model.Customer;
import model.Department;
import model.OrderWait;

/**
 *
 * @author Tom
 */
public class BookingDBContext extends DBContext {

    PreparedStatement stm;
    ResultSet rs;

    public void insertBooking(BookingDetail b) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO [Booking_Detail]\n"
                    + "           ([orderWaitID]\n"
                    + "           ,[status]\n"
                    + "           ,[deptID])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?)";
            stm = connection.prepareStatement(sql);
            for (Department d : b.getDepartments()) {
                stm.setInt(1, b.getOrderWait().getOrderWaitID());
                stm.setBoolean(2, false);
                stm.setInt(3, d.getDeptID());
                stm.executeUpdate();

                String sql_updateDept = "UPDATE [Department]\n"
                        + "   SET [Status] = ?\n"
                        + " WHERE deptID = ?";
                PreparedStatement stm_dept = connection.prepareStatement(sql_updateDept);
                stm_dept.setBoolean(1, true);
                stm_dept.setInt(2, d.getDeptID());
                stm_dept.executeUpdate();
            }

            String sql_order = "UPDATE [OrderWait]\n"
                    + "   SET [Rented] = ?\n"
                    + " WHERE orderWaitID = ?";
            stm = connection.prepareStatement(sql_order);
            stm.setBoolean(1, true);
            stm.setInt(2, b.getOrderWait().getOrderWaitID());
            stm.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(BookingDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException e) {
                Logger.getLogger(OrderWaitDBContext.class.getName()).log(Level.SEVERE, null, e);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(OrderWaitDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public BookingDetail getBookingDetail(int orderWaitID) {
        try {
            String sql = "SELECT DISTINCT BookingID, OrderWait.orderWaitID, noOfRooms, Customer.CustomerID, \n"
                    + "		CustomerName, Customer.Email, Phone, [Address], Rented, CheckIn, CheckOut,\n"
                    + "		deptID\n"
                    + "FROM Booking_Detail\n"
                    + "inner JOIN OrderWait ON OrderWait.orderWaitID = Booking_Detail.orderWaitID\n"
                    + "INNER JOIN Customer ON OrderWait.CustomerID = Customer.CustomerID\n"
                    + "WHERE OrderWait.orderWaitID = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, orderWaitID);
            rs = stm.executeQuery();
            BookingDetail bookingDetail = null;
            OrderWait o = new OrderWait();
            while (rs.next()) {
                if (bookingDetail == null) {
                    o = new OrderWait();
                    o.setOrderWaitID(rs.getInt("orderWaitID"));
                    o.setNoOfRoom(rs.getInt("noOfRooms"));
                    o.setRented(true);
                    o.setCheckIn(rs.getDate("CheckIn"));
                    o.setCheckOut(rs.getDate("CheckOut"));

                    Customer c = new Customer();
                    c.setCustomerID(rs.getInt("CustomerID"));
                    c.setCustomerName(rs.getString("CustomerName"));
                    c.setEmail(rs.getString("Email"));
                    c.setPhone(rs.getString("Phone"));
                    c.setAddress(rs.getString("Address"));
                    o.setCustomer(c);

                    bookingDetail = new BookingDetail();
                    bookingDetail.setOrderWait(o);
                }
                Department d = new Department();
                d.setDeptID(rs.getInt("deptID"));
                bookingDetail.getDepartments().add(d);
            }

            return bookingDetail;
        } catch (SQLException ex) {
            Logger.getLogger(BookingDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    public static void main(String[] args) {
//        BookingDBContext bdb = new BookingDBContext();
//        BookingDetail b = bdb.getBookingDetail(2);
//        System.out.println(b.getBookingID());
//        for (Department d : b.getDepartments()) {
//            System.out.println(d.getDeptID());
//        }
//    }
}
