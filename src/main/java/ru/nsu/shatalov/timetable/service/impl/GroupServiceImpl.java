package ru.nsu.shatalov.timetable.service.impl;

import java.util.List;
import ru.nsu.shatalov.timetable.model.object.Group;
import ru.nsu.shatalov.timetable.repository.GroupRepository;
import ru.nsu.shatalov.timetable.service.interfaces.GroupService;

public class GroupServiceImpl implements GroupService {

  private final GroupRepository repository;

  public GroupServiceImpl(GroupRepository repository) {
    this.repository = repository;
  }

  @Override
  public void addGroup(Group group) {
    repository.save(group);
  }

  @Override
  public Group getGroupById(int id) {
    return null;
  }

  @Override
  public Group updateGroup(Group group) {
    return null;
  }

  @Override
  public List<Group> getAllGroups() {
    return repository.getAll();
  }

  @Override
  public void deleteGroup(Group group) {}
}
