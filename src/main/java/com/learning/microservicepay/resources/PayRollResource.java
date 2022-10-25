package com.learning.microservicepay.resources;

import com.learning.microservicepay.domain.Payroll;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/payments")
public class PayRollResource {

    @GetMapping(value = "/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment){
        Payroll payroll = new Payroll("Vinicius", payment.getDescription(), payment.getHourlyPrice(), 100.0, payment.getHourlyPrice() * payment.getWorkedHours());
        return ResponseEntity.ok().body(payroll);
    }
}
