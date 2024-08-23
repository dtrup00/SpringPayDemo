package com.example.SpringPayDemo.Models;

import org.springframework.web.bind.annotation.ModelAttribute;

public class Payment {
    private String _transactionId;
    private String _userPhoneNumber;
    private double _amount;
    private boolean _paymentSuccess;

    public Payment(String transId, String phone, double amount, boolean success) {
        this._transactionId = transId;
        this._userPhoneNumber = phone;
        this._amount = amount;
        this._paymentSuccess = success;
    }

    public String get_transactionId() {
        return _transactionId;
    }

    public void set_transactionId(String _transactionId) {
        this._transactionId = _transactionId;
    }

    public String get_userPhoneNumber() {
        return _userPhoneNumber;
    }

    public void set_userPhoneNumber(String _userPhoneNumber) {
        this._userPhoneNumber = _userPhoneNumber;
    }

    public double get_amount() {
        return _amount;
    }

    public void set_amount(double _amount) {
        this._amount = _amount;
    }

    public boolean is_paymentSuccess() {
        return _paymentSuccess;
    }

    public void set_paymentSuccess(boolean _paymentSuccess) {
        this._paymentSuccess = _paymentSuccess;
    }
}
