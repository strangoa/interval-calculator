package com.ness.intervalcalculator.service;

import com.ness.intervalcalculator.model.Interval;
import com.ness.intervalcalculator.repository.IntervalRepository;
import com.ness.intervalcalculator.util.IntervalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class to operations for intervals.
 */
@Service
public class IntervalService {

    private final IntervalRepository intervalRepository;

    /**
     * Constructor.
     *
     * @param intervalRepository
     */
    @Autowired
    public IntervalService(IntervalRepository intervalRepository) {
        this.intervalRepository = intervalRepository;
    }

    /**
     * Returns all intervals.
     *
     * @return
     */
    public List<Interval> findAll() {
        return intervalRepository.findAll();
    }

    /**
     * Returns an interval by id.
     *
     * @param id
     * @return
     */
    public Interval findById(Long id) {
        return intervalRepository.findById(id);
    }

    /**
     * Creates an interval.
     *
     * @param interval
     * @return
     */
    public Long create(Interval interval) {
        return intervalRepository.create(interval);
    }

    /**
     * Removes an interval.
     *
     * @param id
     */
    public void deleteById(Long id) {
        intervalRepository.deleteById(id);
    }

    /**
     * Returns intervals from the parameter with duration and break.
     *
     * @param intervals
     * @return
     */
    public List<Interval> getDurationForIntervals(List<Interval> intervals) {
        intervals.forEach(intervalRepository::create);
        return IntervalUtils.extendIntervalsWithDuration(intervals);
    }

    /**
     * Returns all the intervals with duration and break.
     *
     * @return
     */
    public List<Interval> findAllWithDuration() {
        List<Interval> intervals = intervalRepository.findAll();
        return IntervalUtils.extendIntervalsWithDuration(intervals);
    }
}
