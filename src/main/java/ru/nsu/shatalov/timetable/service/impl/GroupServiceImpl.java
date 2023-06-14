package ru.nsu.shatalov.timetable.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.shatalov.timetable.model.object.StudentGroup;
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
  public StudentGroup getById(long id) {
    return repository.findById(id).isPresent() ? repository.findById(id).get() : null;
  }

  @Override
  public StudentGroup update(StudentGroup studentGroup) {
    return null;
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
