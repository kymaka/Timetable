package ru.nsu.shatalov.timetable;

import ru.nsu.shatalov.timetable.generator.TimetableGenerator;
import ru.nsu.shatalov.timetable.model.constraint.Room;
import ru.nsu.shatalov.timetable.model.constraint.Subject;
import ru.nsu.shatalov.timetable.model.enums.RoomType;
import ru.nsu.shatalov.timetable.model.enums.SubjectType;
import ru.nsu.shatalov.timetable.repository.RoomRepository;
import ru.nsu.shatalov.timetable.repository.SubjectRepository;
import ru.nsu.shatalov.timetable.service.impl.RoomServiceImpl;
import ru.nsu.shatalov.timetable.service.impl.SubjectServiceImpl;
import ru.nsu.shatalov.timetable.store.DataStore;

public class Main {

    public static void main(String[] args) {
        DataStore dataStore = new DataStore();
        SubjectRepository subjectRepository = new SubjectRepository(dataStore);
        SubjectServiceImpl subjectService = new SubjectServiceImpl(subjectRepository);

        RoomRepository roomRepository = new RoomRepository(dataStore);
        RoomServiceImpl roomService = new RoomServiceImpl(roomRepository);

        TimetableGenerator generator = new TimetableGenerator();

        Subject[] subjects = {
                new Subject("Math", RoomType.Lecture, SubjectType.Lecture),
                new Subject("Math", RoomType.General, SubjectType.Seminar),
                new Subject("Computer Science", RoomType.Lecture, SubjectType.Lecture),
                new Subject("Bioinformatics", RoomType.Lecture, SubjectType.Lecture),
        };

        Room[] rooms = {
                new Room("1101", RoomType.General),
                new Room("1102t", RoomType.Terminal),
                new Room("1103", RoomType.Lecture),
        };

        for (Subject subject : subjects) {
            subjectService.addSubject(subject);
        }

        for (Room room : rooms) {
            roomService.addRoom(room);
        }

        generator.generate(subjectService.getAllSubjects(), roomService.getAllRooms());
    }
}
