package model;

import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class BookingDetail {

    private int BookingID;
    private OrderWait orderWait;
    private ArrayList<Department> departments = new ArrayList<>();
    private boolean status;

    public int getBookingID() {
        return BookingID;
    }

    public void setBookingID(int BookingID) {
        this.BookingID = BookingID;
    }

    public OrderWait getOrderWait() {
        return orderWait;
    }

    public void setOrderWait(OrderWait orderWait) {
        this.orderWait = orderWait;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
