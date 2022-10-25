package com.learning.microservicepay.resources;

import com.learning.microservicepay.domain.Payroll;
import com.learning.microservicepay.domain.User;
import com.learning.microservicepay.feignClients.UserFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/payments")
public class PayRollResource {

    private final UserFeign userFeign;

    @GetMapping(value = "/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment){
        User user = userFeign.findById(workerId).getBody();

        Payroll payroll = new Payroll(user.getName(), payment.getDescription(), user.getHourlyPrice(), payment.getWorkedHours(), user.getHourlyPrice() * payment.getWorkedHours());
        return ResponseEntity.ok().body(payroll);
    }
}
