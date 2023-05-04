package com.tenpo.sum.service;

import com.tenpo.sum.client.fee.FeeClient;
import com.tenpo.sum.dto.Fee;
import com.tenpo.sum.dto.Sum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SumService.class, FeeService.class, FeeClient.class })
public class SumServiceTest {

    @Autowired
    private SumService sumService;

    @MockBean
    private FeeClient feeClient;

    @Test
    public void sumAddingFeeTest() {
        given(feeClient.getFee()).willReturn(new Fee(10.00));

        Sum sum = sumService.sumAddingFee(5.0, 5.0);
        assertThat(sum.getSum()).isEqualTo(11.0);
    }
}
