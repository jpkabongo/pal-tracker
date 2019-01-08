package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    void delete(long timeEntryId);

    List<TimeEntry> list();

    TimeEntry create(TimeEntry any);

    TimeEntry find(long timeEntryId);

    TimeEntry update(long eq, TimeEntry any);
}
