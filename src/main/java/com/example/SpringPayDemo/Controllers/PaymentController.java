package com.example.SpringPayDemo.Controllers;

import com.example.SpringPayDemo.Models.Payment;
import com.example.SpringPayDemo.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService _paymentService;

    @GetMapping("/pay")
    public String showPaymentPage(){
        return "pay";
    }

    @PostMapping("/pay")
    public String initiatePayment(@RequestParam String phoneNumber, @RequestParam double amountProcess, Model model) {
        String trans_ID = "TRANS" + System.currentTimeMillis();
        Payment payment = new Payment(trans_ID, phoneNumber, amountProcess, true);
        _paymentService.AddPayment(payment);

        model.addAttribute("TransactionID", trans_ID);
        return "redirect:/payment-success?transactionId=" + trans_ID;
    }

    @GetMapping("payment-success")
    public String showPaymentSuccessPage(@RequestParam String transactionID, Model model) {
        Payment paymentHistory = _paymentService.GetPayments(transactionID);
        model.addAttribute("Payment", paymentHistory);
        return "payment-success";
    }
}
