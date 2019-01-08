package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository  implements TimeEntryRepository {
    private Map<Long, TimeEntry> map = new HashMap<>();
    private Long counter = 0L;

    public TimeEntry create(TimeEntry timeEntry) {
        counter = counter + 1;
        timeEntry.setId(counter);
        map.put(counter, timeEntry);
        return timeEntry;
    }

    public List<TimeEntry> list() {
        return new ArrayList<>(map.values());
    }

    public TimeEntry find(long timeEntryId) {
        return map.get(timeEntryId);
    }

    @Override
    public TimeEntry update(long id, TimeEntry entry) {
        if (map.containsKey(id)) {
            entry.setId(id);
            map.put(id, entry);
            return entry;
        }
        return null;
    }

    public TimeEntry update(Object id, TimeEntry timeEntry) {
        return null;
    }

    public void delete(long id) {
        if (map.containsKey(id)) {
            map.remove(id);
        }
    }

}
