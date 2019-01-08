package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {


    private TimeEntryRepository repository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        repository = timeEntryRepository;
    }

    @PostMapping("/time-entry" )
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry createdEntry = repository.create(timeEntryToCreate);
        return new ResponseEntity(createdEntry, HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(long timeEntryId) {
        TimeEntry readEntry = repository.find(timeEntryId);
        if (readEntry == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(readEntry,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity(repository.list(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity update(long timeEntryId, TimeEntry expected) {
        TimeEntry updateTimeEntry = repository.update(timeEntryId,expected);
        if (updateTimeEntry == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(updateTimeEntry, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<TimeEntry> delete(long timeEntryId) {
        repository.delete(timeEntryId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
