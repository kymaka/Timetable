package ru.nsu.shatalov.timetable.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.shatalov.timetable.model.object.constraint.StudentGroup;
import ru.nsu.shatalov.timetable.repository.GroupRepository;
import ru.nsu.shatalov.timetable.service.interfaces.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

  private final GroupRepository repository;

  @Autowired
  public GroupServiceImpl(GroupRepository repository) {
    this.repository = repository;
  }

  @Override
  public StudentGroup save(StudentGroup studentGroup) {
    repository.save(studentGroup);
    return studentGroup;
  }

  @Override
  public StudentGroup getById(Long id) {
    return repository.findById(id).isPresent() ? repository.findById(id).get() : null;
  }

  @Override
  public StudentGroup update(StudentGroup newStudentGroup, Long id) {
    StudentGroup studentGroup = getById(id);
    studentGroup.setNumber(newStudentGroup.getNumber());
    studentGroup.setSubjects(newStudentGroup.getSubjects());
    return repository.save(studentGroup);
  }

  @Override
  public List<StudentGroup> getAll() {
    return repository.findAll();
  }

  @Override
  public void delete(StudentGroup studentGroup) {
    repository.delete(studentGroup);
  }
}
