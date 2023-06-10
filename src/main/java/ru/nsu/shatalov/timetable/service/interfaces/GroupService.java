package ru.nsu.shatalov.timetable.service.interfaces;

import java.util.List;
import ru.nsu.shatalov.timetable.model.object.Group;

public interface GroupService {

    void addGroup(Group group);

    Group getGroupById(int id);

    Group updateGroup(Group group);

    List<Group> getAllGroups();

    void deleteGroup(Group group);
}
