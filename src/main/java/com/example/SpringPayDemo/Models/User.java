package com.example.SpringPayDemo.Models;

public class User {
    private String _phoneNumber;
    private String _name;
    private String _password;

    public User(String userContact, String userName, String userPassword) {
        this._phoneNumber = userContact;
        this._name = userName;
        this._password = userPassword;
    }

    public String get_phoneNumber() {
        return _phoneNumber;
    }

    public void set_phoneNumber(String _phoneNumber) {
        this._phoneNumber = _phoneNumber;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }
}
