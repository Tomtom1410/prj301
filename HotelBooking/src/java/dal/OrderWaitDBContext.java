package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.Department;
import model.OrderWait;

public class OrderWaitDBContext extends DBContext {

    PreparedStatement stm;
    ResultSet rs;

    public void orderWait(OrderWait o) {
        try {
            connection.setAutoCommit(false);
            String sql_insertCus = "INSERT INTO [Customer]\n"
                    + "           ([CustomerName]\n"
                    + "           ,[Phone]\n"
                    + "           ,[Email]\n)"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm_cus = connection.prepareStatement(sql_insertCus);
            stm_cus.setString(1, o.getCustomer().getCustomerName());
            stm_cus.setString(2, o.getCustomer().getPhone());
            stm_cus.setString(3, o.getCustomer().getEmail());
            stm_cus.executeUpdate();

            String sql_getCusID = "SELECT @@IDENTITY as customerID";
            PreparedStatement stm_getCusID = connection.prepareStatement(sql_getCusID);
            rs = stm_getCusID.executeQuery();
            if (rs.next()) {
                o.getCustomer().setCustomerID(rs.getInt("customerID"));
            }

            String sql_insertOrder = "INSERT INTO [OrderWait]\n"
                    + "           ([deptName]\n"
                    + "           ,[CustomerID]\n"
                    + "           ,[CheckIn]\n"
                    + "           ,[CheckOut]\n"
                    + "           ,[noOfRooms])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm_o = connection.prepareStatement(sql_insertOrder);
            stm_o.setString(1, o.getDepartment().getDeptName());
            stm_o.setInt(2, o.getCustomer().getCustomerID());
            stm_o.setDate(3, o.getCheckIn());
            stm_o.setDate(4, o.getCheckOut());
            stm_o.setInt(5, o.getNoOfRoom());
            stm_o.executeUpdate();

            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(OrderWaitDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(OrderWaitDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(OrderWaitDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<OrderWait> getInformationOrderWait() {
        ArrayList<OrderWait> orderWaits = new ArrayList<>();
        try {
            String sql = "SELECT Customer.CustomerID, Customer.CustomerName, Customer.Email, Customer.Phone,\n"
                    + "	CheckIn, CheckOut, [Address], deptName, noOfRooms, orderWaitID\n"
                    + "FROM OrderWait\n"
                    + "INNER JOIN Customer ON Customer.CustomerID = OrderWait.CustomerID";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                OrderWait o = new OrderWait();
                Customer c = new Customer();
                c.setCustomerID(rs.getInt("CustomerID"));
                c.setCustomerName(rs.getString("CustomerName"));
                c.setEmail(rs.getString("Email"));
                c.setPhone(rs.getString("Phone"));
                c.setAddress(rs.getString("Address"));
                o.setCustomer(c);
                
                Department d = new  Department();
                d.setDeptName(rs.getString("deptName"));
                o.setDepartment(d);
                o.setNoOfRoom(rs.getInt("noOfRooms"));
                o.setCheckIn(rs.getDate("CheckIn"));
                o.setCheckOut(rs.getDate("CheckOut"));
                o.setOrderWaitID(rs.getInt("orderWaitID"));
                orderWaits.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderWaitDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderWaits;
    }

    public static void main(String[] args) {
        OrderWaitDBContext odb = new OrderWaitDBContext();
        for (OrderWait orderWait : odb.getInformationOrderWait()) {
            System.out.println(orderWait.getOrderWaitID());
        }
    }
}
