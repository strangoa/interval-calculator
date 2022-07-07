package com.ness.intervalcalculator.controller;

import com.ness.intervalcalculator.dto.ApiResponse;
import com.ness.intervalcalculator.model.Interval;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Base interface for the Intervals API.
 */
@RequestMapping("/api/intervals")
public interface IntervalOperations {

    @GetMapping
    ResponseEntity<ApiResponse> findAll();

    @GetMapping(value = "/{id}")
    ResponseEntity<ApiResponse> findById(@PathVariable("id") Long id);

    @PostMapping
    ResponseEntity<ApiResponse> create(@RequestBody Interval interval);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<ApiResponse> delete(@PathVariable("id") Long id);

    @PostMapping(value = "/durations")
    ResponseEntity<ApiResponse> getDurationForIntervals(@RequestBody List<Interval> intervals);

    @GetMapping(value = "/durations")
    ResponseEntity<ApiResponse> findAllWithDuration();
}
