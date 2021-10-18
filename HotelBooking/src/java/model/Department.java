package model;

import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class Department {

    private int deptID;
    private ArrayList<String> url = new ArrayList<>();
    private String typeRoom;
    private int price;
    private boolean status;
    private String deptName;

    public Department() {
    }

    public int getDeptID() {
        for (String string : url) {
            
        }
        return deptID;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public ArrayList<String> getUrl() {
        return url;
    }

    public void setUrl(ArrayList<String> url) {
        this.url = url;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeDept(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}
