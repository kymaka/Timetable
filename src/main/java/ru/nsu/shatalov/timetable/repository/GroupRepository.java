package ru.nsu.shatalov.timetable.repository;

import java.util.List;
import ru.nsu.shatalov.timetable.model.object.Group;
import ru.nsu.shatalov.timetable.store.DataStore;

public class GroupRepository {

    private final DataStore dataStore;

    public GroupRepository(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public void save(Group group) {
        dataStore.addGroup(group);
    }

    public List<Group> getAll() {
        return this.dataStore.getAllGroups();
    }
}
