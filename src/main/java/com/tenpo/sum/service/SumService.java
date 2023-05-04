package com.tenpo.sum.service;

import com.tenpo.sum.dto.Fee;
import com.tenpo.sum.dto.Sum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SumService {

    @Autowired
    private FeeService feeService;

    public Sum sumAddingFee(double first, double second) {
        Fee fee = feeService.getFee();
        double percentage = Double.sum(1, (fee.getFee() / 100));

        double sum = Double.sum(first, second);
        sum = sum * percentage;

        return new Sum(Math.round(sum));
    }
}
