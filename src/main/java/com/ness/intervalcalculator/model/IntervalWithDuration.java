package com.ness.intervalcalculator.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

/**
 * Model class for intervals with duration and break.
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntervalWithDuration extends Interval {

    private Duration duration;
    @JsonProperty("break")
    private Duration breakDuration;
}
