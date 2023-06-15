package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.model.object.constraint.StudentGroup;

public interface GroupService {

  StudentGroup save(StudentGroup studentGroup);

  StudentGroup getById(Long id);

  StudentGroup update(StudentGroup studentGroup, Long id);

  List<StudentGroup> getAll();

  void delete(StudentGroup studentGroup);
}
