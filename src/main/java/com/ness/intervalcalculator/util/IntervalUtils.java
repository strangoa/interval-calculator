package com.ness.intervalcalculator.util;

import com.ness.intervalcalculator.model.Interval;
import com.ness.intervalcalculator.model.IntervalWithDuration;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Utility class for processing intervals.
 */
public class IntervalUtils {

    /**
     * Extends an interval with duration and break.
     *
     * @param intervals
     * @return
     */
    public static List<Interval> extendIntervalsWithDuration(List<Interval> intervals) {
        List<Interval> intervalsWithDuration = new ArrayList<>();
        AtomicReference<LocalDateTime> endOfLastInterval = new AtomicReference<>();
        intervals.forEach(interval -> {
            IntervalWithDuration intervalWithDuration = new IntervalWithDuration();
            intervalWithDuration.setId(interval.getId());
            intervalWithDuration.setStart(interval.getStart());
            intervalWithDuration.setEnd(interval.getEnd());
            intervalWithDuration.setDuration(Duration.between(interval.getStart(), interval.getEnd()));
            if (endOfLastInterval.get() != null) {
                intervalWithDuration.setBreakDuration(Duration.between(endOfLastInterval.get(), interval.getStart()));
            }
            intervalsWithDuration.add(intervalWithDuration);
            endOfLastInterval.set(interval.getEnd());
        });
        return intervalsWithDuration;
    }

    private IntervalUtils() {
    }
}
