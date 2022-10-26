package com.learning.microservicepay.services;

import com.learning.microservicepay.domain.Payroll;
import com.learning.microservicepay.feignClients.UserFeign;
import com.learning.microservicepay.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Slf4j//disponibiliza um log
@Service
public class PayrollService {

    private final Environment env;
    private final UserFeign feign;

    public Payroll getPayment(Long workedId, Payroll payroll){
        log.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty("local.server.port") + "port");
        try {
            var user = feign.findById(workedId).getBody();
            if(Objects.nonNull(user)) {
                return new Payroll(user.getName(), payroll.getDescription(), user.getHourlyPrice(), payroll.getWorkedHours(), payroll.getWorkedHours() * user.getHourlyPrice());
            }
        }catch (FeignException.NotFound ex){
            throw new ObjectNotFoundException();
        }catch (Exception ex){
            throw new IllegalArgumentException("Illegal argument execption");
        }
        return null;
    }
}
