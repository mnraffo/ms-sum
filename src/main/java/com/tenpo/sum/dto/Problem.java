package com.tenpo.sum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;

/**
 * An RFC-7807 problem
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Problem {
    private URI type;
    private String title;
    private String code;
    private int status;
    private String detail;
    private URI instance;
}
