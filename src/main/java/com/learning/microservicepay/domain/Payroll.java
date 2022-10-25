package com.learning.microservicepay.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Payroll {

    private String workedName;
    private String description;
    private Double hourlyPrice;
    private Double workedHours;
    private Double totalPayment;
}
