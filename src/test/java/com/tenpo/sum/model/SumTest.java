package com.tenpo.sum.model;

import com.tenpo.sum.dto.Sum;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SumTest {

    @Test
    public void createResult() {
        Sum sum = new Sum(5.0);
        assertThat(sum.getSum()).isEqualTo(5.0);
    }
}
