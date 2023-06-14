package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.model.object.StudentGroup;

public interface GroupService {

  StudentGroup save(StudentGroup studentGroup);

  StudentGroup getById(long id);

  StudentGroup update(StudentGroup studentGroup);

  List<StudentGroup> getAll();

  void delete(StudentGroup studentGroup);
}
