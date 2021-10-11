/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Tom
 */
public class Feedback {
    private int feedID;
    private Customer customer;
    private String feedbackConten;

    public Feedback() {
    }

    public int getFeedID() {
        return feedID;
    }

    public void setFeedID(int feedID) {
        this.feedID = feedID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getFeedbackConten() {
        return feedbackConten;
    }

    public void setFeedbackConten(String feedbackConten) {
        this.feedbackConten = feedbackConten;
    }
    
    
}
