package com.ness.intervalcalculator.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ness.intervalcalculator.model.Interval;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Response class for API calls.
 */
@Data
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

    private boolean success;
    private List<Interval> intervals;
    private String errorMessage;
}
