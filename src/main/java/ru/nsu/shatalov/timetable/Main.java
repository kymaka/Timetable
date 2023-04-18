package ru.nsu.shatalov.timetable;

import ru.nsu.shatalov.timetable.generator.TimetableGenerator;
import ru.nsu.shatalov.timetable.model.constraint.Subject;
import ru.nsu.shatalov.timetable.model.enums.RoomType;
import ru.nsu.shatalov.timetable.model.enums.SubjectType;
import ru.nsu.shatalov.timetable.repository.SubjectRepository;
import ru.nsu.shatalov.timetable.service.impl.SubjectServiceImpl;
import ru.nsu.shatalov.timetable.store.DataStore;

public class Main {

    public static void main(String[] args) {
        DataStore dataStore = new DataStore();
        SubjectRepository subjectRepository = new SubjectRepository(dataStore);
        SubjectServiceImpl subjectService = new SubjectServiceImpl(subjectRepository);
        TimetableGenerator generator = new TimetableGenerator();

        Subject[] subjects = {
                new Subject("Math", RoomType.Lecture, SubjectType.Lecture),
                new Subject("Math", RoomType.General, SubjectType.Seminar),
                new Subject("Computer Science", RoomType.Lecture, SubjectType.Lecture),
                new Subject("Bioinformatics", RoomType.Lecture, SubjectType.Lecture),
        };

        for (Subject subject : subjects) {
            subjectService.addSubject(subject);
        }

        generator.generate(subjectService.getAllSubjects());
    }
}
