package model;

/**
 *
 * @author Tom
 */
public class Department {
    private String deptID;
    private String url;
    private int typeDept;
    private int price;
    private boolean status;

    public Department() {
    }

    public String getDeptID() {
        return deptID;
    }

    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTypeDept() {
        return typeDept;
    }

    public void setTypeDept(int typeDept) {
        this.typeDept = typeDept;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
}
