package ru.nsu.shatalov.timetable.repository;

import java.util.List;
import ru.nsu.shatalov.timetable.model.object.TimeSlot;
import ru.nsu.shatalov.timetable.store.DataStore;

public class TimeSlotRepository {

  private final DataStore dataStore;

  public TimeSlotRepository(DataStore dataStore) {
    this.dataStore = dataStore;
  }

  public void save(TimeSlot timeSlot) {
    dataStore.addTimeSlot(timeSlot);
  }

  public List<TimeSlot> getAll() {
    return dataStore.getAllTimeSlots();
  }
}
