package ru.nsu.shatalov.timetable.model.constraint;

import ru.nsu.shatalov.timetable.model.enums.RoomType;
import ru.nsu.shatalov.timetable.model.enums.SubjectType;

public class Subject {
    private String name;

    private RoomType roomType;

    private SubjectType subjectType;

    public Subject(String name, RoomType roomType, SubjectType subjectType) {
        this.name = name;
        this.roomType = roomType;
        this.subjectType = subjectType;
    }

    public String getName() {
        return this.name;
    }

    public RoomType getRoomType() {
        return this.roomType;
    }

    public SubjectType getSubjectType() {
        return this.subjectType;
    }
}
