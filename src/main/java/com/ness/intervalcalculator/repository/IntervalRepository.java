package com.ness.intervalcalculator.repository;

import com.ness.intervalcalculator.exception.IntervalException;
import com.ness.intervalcalculator.model.Interval;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Repository class to persistence operations for intervals.
 */
@Repository
@Slf4j
public class IntervalRepository {

    private static final List<Interval> intervals = new ArrayList<>();

    /**
     * Finds all intervals.
     *
     * @return
     */
    public List<Interval> findAll() {
        return intervals;
    }

    /**
     * Finds an interval by id.
     *
     * @param id
     * @return
     */
    public Interval findById(Long id) {
        Optional<Interval> optionalInterval = intervals.stream().filter(interval -> Objects.equals(interval.getId(), id)).findFirst();
        if (optionalInterval.isPresent()) {
            log.debug("Interval was found for the ID {}", id);
            return optionalInterval.get();
        } else {
            log.error("No interval was found for the ID {}", id);
            throw new IntervalException("No interval was found for the ID " + id);
        }
    }

    /**
     * Creates an interval.
     *
     * @param interval
     * @return
     */
    public Long create(Interval interval) {
        // get the biggest ID
        OptionalLong optionalMaxId = intervals.stream().mapToLong(Interval::getId).reduce(Long::max);
        optionalMaxId.ifPresent(maxId -> {
            interval.setId(++maxId);
        });
        intervals.add(interval);
        log.debug("Interval was added with ID {}", interval.getId());
        return interval.getId();
    }

    /**
     * Removes an interval by its id.
     *
     * @param id
     */
    public void deleteById(final Long id) {
        if (intervals.stream().anyMatch(ivl -> Objects.equals(ivl.getId(), id))) {
            intervals.removeIf(ivl -> Objects.equals(ivl.getId(), id));
            log.debug("Interval was deleted with ID {}", id);
        } else {
            log.error("No interval was found with ID {}", id);
            throw new IntervalException("No interval was found for the ID " + id);
        }
    }
}
