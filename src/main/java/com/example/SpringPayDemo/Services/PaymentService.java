package com.example.SpringPayDemo.Services;

import com.example.SpringPayDemo.Models.Payment;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {
    private Map<String, Payment> paymentsMap = new HashMap<>();

    public void AddPayment(Payment payment) {
        paymentsMap.put(payment.get_transactionId(), payment);
    }

    public Payment GetPayments(String transactionID) {
        return paymentsMap.get(transactionID);
    }
}
