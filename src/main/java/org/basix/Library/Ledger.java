package org.basix.Library;

import org.joda.time.DateTime;

public class Ledger {
    private long id;
    private long book_id;
    private long issued_user_id;
    private boolean book_availability;
    private String issue_date;
    private short issue_duration;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public long getIssued_user_id() {
        return issued_user_id;
    }

    public void setIssued_user_id(long issued_user_id) {
        this.issued_user_id = issued_user_id;
    }

    public boolean isBook_availability() {
        return book_availability;
    }

    public void setBook_availability(boolean book_availability) {
        this.book_availability = book_availability;
    }

    public String getIssue_date() {
        issue_date = DateTime.now().toString("yyyy-MM-dd HH:MM:SS");
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public short getIssue_duration() {
        return issue_duration;
    }

    public void setIssue_duration(short issue_duration) {
        this.issue_duration = issue_duration;
    }
}
