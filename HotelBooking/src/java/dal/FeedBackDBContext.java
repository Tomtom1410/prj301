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
import model.Customer;
import model.Feedback;

/**
 *
 * @author Tom
 */
public class FeedBackDBContext extends DBContext {

    PreparedStatement stm;
    ResultSet rs;

    public void insertFeedBack(Feedback f) {
        try {
            connection.setAutoCommit(false);
            CustomerDBContext cdb = new CustomerDBContext();
            Customer c = cdb.customerExits(f.getCustomer());
            if (c == null) {
                String sql_insertC = "INSERT INTO [Customer]\n"
                        + "           ([CustomerName]\n"
                        + "           ,[Phone]\n"
                        + "           ,[Email]\n"
                        + "           ,[Address])\n"
                        + "     VALUES\n"
                        + "           (?\n"
                        + "           ,?\n"
                        + "           ,?\n"
                        + "           ,?)";
                PreparedStatement stm_C = connection.prepareStatement(sql_insertC);
                stm_C.setString(1, f.getCustomer().getCustomerName());
                stm_C.setString(2, f.getCustomer().getPhone());
                stm_C.setString(3, f.getCustomer().getEmail());
                stm_C.setString(4, f.getCustomer().getAddress());
                stm_C.executeUpdate();

                String sql_getCusID = "SELECT @@IDENTITY as customerID";
                PreparedStatement stm_getCusID = connection.prepareStatement(sql_getCusID);
                rs = stm_getCusID.executeQuery();
                if (rs.next()) {
                    c.setCustomerID(rs.getInt("customerID"));
                }
            } else {
                String sql = "INSERT INTO [Feedback]\n"
                        + "           ([FeedBack]\n"
                        + "           ,[CustomerID])\n"
                        + "     VALUES\n"
                        + "           (?\n"
                        + "           ,?)";
                stm = connection.prepareStatement(sql);
                stm.setString(1, f.getFeedbackContent());
                stm.setInt(2, c.getCustomerID());
                stm.executeUpdate();

            }
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FeedBackDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(FeedBackDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(FeedBackDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
