package com.ps.PS.models;

public class AdminMod {
    private int id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isHasAdminPrivilege() {
        return hasAdminPrivilege;
    }

    public void setHasAdminPrivilege(boolean hasAdminPrivilege) {
        this.hasAdminPrivilege = hasAdminPrivilege;
    }

    private boolean hasAdminPrivilege;
}
