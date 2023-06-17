package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.model.object.constraint.Room;
import ru.nsu.shatalov.timetable.model.object.constraint.StudentGroup;
import ru.nsu.shatalov.timetable.model.object.constraint.Subject;
import ru.nsu.shatalov.timetable.model.object.constraint.Teacher;
import ru.nsu.shatalov.timetable.model.object.constraint.TimeSlot;

public interface TimetableService {

  void generateTimetable();
}
