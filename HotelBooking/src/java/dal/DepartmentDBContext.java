/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Department;

/**
 *
 * @author Tom
 */
public class DepartmentDBContext extends DBContext {

    PreparedStatement stm;
    ResultSet rs;

    public ArrayList<String> getRoomType() {
        ArrayList<String> types = new ArrayList<>();
        try {
            String sql = "SELECT [roomType]\n"
                    + "  FROM [RoomTypeAndUrl]"
                    + "order by roomType desc";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                types.add(rs.getString("roomType"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return types;
    }

    public ArrayList<Department> getRoomModel() {
        ArrayList<Department> depts = new ArrayList<>();
        try {
            String sql = "select deptID, deptName, [Status], price, Department.roomType,\n"
                    + "		url_image, url_1, url_2, url_3\n"
                    + "from Department\n"
                    + "inner join RoomTypeAndUrl\n"
                    + "on Department.roomType = RoomTypeAndUrl.roomType\n"
                    + "where deptID >=101 and deptID <=112";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Department d = new Department();
                d.setDeptID(rs.getInt("deptID"));
                d.setDeptName(rs.getString("deptName"));
                d.setStatus(rs.getBoolean("Status"));
                d.setPrice(rs.getInt("price"));
                d.setTypeDept(rs.getString("roomType"));
                String url_img = rs.getString("url_image");
                d.getUrl().add(url_img);
                depts.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return depts;
    }

    public Department getRoomByName(String name) {
        try {
            String sql = "select deptID, deptName, [Status], price, Department.roomType,\n"
                    + "		url_image, url_1, url_2, url_3\n"
                    + "from Department\n"
                    + "inner join RoomTypeAndUrl\n"
                    + "on Department.roomType = RoomTypeAndUrl.roomType\n"
                    + "where deptName = ? AND [Status] = 0";
            stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            rs = stm.executeQuery();
            Department d = new Department();
            if (rs.next()) {

                d.setDeptID(rs.getInt("deptID"));
                d.setDeptName(rs.getString("deptName"));
                d.setStatus(rs.getBoolean("Status"));
                d.setPrice(rs.getInt("price"));
                d.setTypeDept(rs.getString("roomType"));
                String url_img = rs.getString("url_image");
                d.getUrl().add(url_img);
                String url_1 = rs.getString("url_1");
                d.getUrl().add(url_1);
                String url_2 = rs.getString("url_2");
                d.getUrl().add(url_2);
                String url_3 = rs.getString("url_3");
                d.getUrl().add(url_3);
            }
            return d;
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public ArrayList<Department> getRoomByKey(String status) {
        ArrayList<Department> depts = new ArrayList<>();
        try {
            String sql = "select Department.deptID, deptName,[Status], CheckIn, CheckOut\n"
                    + "from Department\n"
                    + "left join OrderWait on Department.deptID = OrderWait.deptID\n"
                    + "where [Status] = ?";
            stm = connection.prepareStatement(sql);
//            stm.setString(1, "%" + keyString + "%");
            stm.setString(1, status);
            rs = stm.executeQuery();

            while (rs.next()) {
                Department d = new Department();
                d.setDeptID(rs.getInt("deptID"));
                d.setDeptName(rs.getString("deptName"));
                d.setStatus(rs.getBoolean("Status"));
                if (status.equals("0")) {
                    d.setTime(rs.getDate("CheckIn"));
                } else if (status.equals("1")) {
                    d.setTime(rs.getDate("CheckOut"));
                }
                depts.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return depts;
    }

    public static void main(String[] args) {
        DepartmentDBContext db = new DepartmentDBContext();
        Department d = db.getRoomByName("SILVER SINGLE ROOM");
        for (Department d1 : db.getRoomByKey( "0")) {
            if (d1.getTime() == null) 
                System.out.println("none");
        }
    }
}
