package com.ness.intervalcalculator.controller;

import com.ness.intervalcalculator.dto.ApiResponse;
import com.ness.intervalcalculator.model.Interval;
import com.ness.intervalcalculator.service.IntervalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * Default implementation for the Intervals API.
 */
@RestController
class IntervalController implements IntervalOperations {

    private final IntervalService intervalService;

    @Autowired
    public IntervalController(IntervalService intervalService) {
        this.intervalService = intervalService;
    }

    @Override
    public ResponseEntity<ApiResponse> findAll() {
        List<Interval> intervals = intervalService.findAll();
        ApiResponse response = ApiResponse.builder()
                .success(true)
                .intervals(intervals)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> findById(Long id) {
        Interval interval = intervalService.findById(id);
        ApiResponse response = ApiResponse.builder()
                .success(true)
                .intervals(Collections.singletonList(interval))
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> create(Interval interval) {
        intervalService.create(interval);
        ApiResponse response = ApiResponse.builder()
                .success(true)
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ApiResponse> delete(Long id) {
        intervalService.deleteById(id);
        ApiResponse response = ApiResponse.builder()
                .success(true)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> getDurationForIntervals(List<Interval> intervals) {
        List<Interval> intervalsWithDuration = intervalService.getDurationForIntervals(intervals);
        ApiResponse response = ApiResponse.builder()
                .success(true)
                .intervals(intervalsWithDuration)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> findAllWithDuration() {
        List<Interval> intervalsWithDuration = intervalService.findAllWithDuration();
        ApiResponse response = ApiResponse.builder()
                .success(true)
                .intervals(intervalsWithDuration)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
