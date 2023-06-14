package ru.nsu.shatalov.timetable;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.nsu.shatalov.timetable.generator.TimetableGenerator;
import ru.nsu.shatalov.timetable.model.object.StudentGroup;
import ru.nsu.shatalov.timetable.model.object.TimeSlot;
import ru.nsu.shatalov.timetable.model.object.constraint.Room;
import ru.nsu.shatalov.timetable.model.object.constraint.Subject;
import ru.nsu.shatalov.timetable.model.object.constraint.Teacher;
import ru.nsu.shatalov.timetable.model.enums.Day;
import ru.nsu.shatalov.timetable.model.enums.RoomType;
import ru.nsu.shatalov.timetable.model.enums.SubjectType;
import ru.nsu.shatalov.timetable.repository.RoomRepository;
import ru.nsu.shatalov.timetable.repository.SubjectRepository;
import ru.nsu.shatalov.timetable.repository.TeacherRepository;
import ru.nsu.shatalov.timetable.repository.TimeSlotRepository;
import ru.nsu.shatalov.timetable.service.impl.RoomServiceImpl;
import ru.nsu.shatalov.timetable.service.impl.SubjectServiceImpl;
import ru.nsu.shatalov.timetable.service.impl.TeacherServiceImpl;
import ru.nsu.shatalov.timetable.service.impl.TimeSlotServiceImpl;
import ru.nsu.shatalov.timetable.store.DataStore;

@SpringBootApplication
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
    DataStore dataStore = new DataStore();
    SubjectRepository subjectRepository = new SubjectRepository(dataStore);
    SubjectServiceImpl subjectService = new SubjectServiceImpl(subjectRepository);

    RoomRepository roomRepository = new RoomRepository(dataStore);
    RoomServiceImpl roomService = new RoomServiceImpl(roomRepository);

    TeacherRepository teacherRepository = new TeacherRepository(dataStore);
    TeacherServiceImpl teacherService = new TeacherServiceImpl(teacherRepository);

    TimeSlotRepository timeSlotRepository = new TimeSlotRepository(dataStore);
    TimeSlotServiceImpl timeSlotService = new TimeSlotServiceImpl(timeSlotRepository);

    TimetableGenerator generator = new TimetableGenerator();

    Subject[] subjects = {
      new Subject("Math", RoomType.Lecture, SubjectType.Lecture),
      new Subject("Math Seminar", RoomType.General, SubjectType.Seminar),
      new Subject("Computer Science", RoomType.Lecture, SubjectType.Lecture),
      new Subject("Bioinformatics", RoomType.Lecture, SubjectType.Lecture),
      new Subject("System Design", RoomType.Lecture, SubjectType.Lecture)
    };

    Room[] rooms = {
      new Room("1101", RoomType.General),
      new Room("1102t", RoomType.Terminal),
      new Room("1103", RoomType.Lecture),
      new Room("1104", RoomType.General),
      new Room("1105t", RoomType.Terminal),
      new Room("1106", RoomType.Lecture),
    };

    Teacher[] teachers = {
      new Teacher("Alexander", List.of(subjects[0]), List.of(Day.Monday, Day.Tuesday)),
      new Teacher("Anton", List.of(subjects[1]), List.of(Day.Tuesday, Day.Wednesday)),
      new Teacher(
          "Vladimir", List.of(subjects[2], subjects[3]), List.of(Day.Tuesday, Day.Thursday)),
      new Teacher("Maksim", List.of(subjects[4]), List.of(Day.Wednesday, Day.Friday))
    };

    ArrayList<StudentGroup> studentGroups =
        new ArrayList<>(
            List.of(
                new StudentGroup("20213", List.of(subjects)),
                new StudentGroup("20214", List.of(subjects)),
                new StudentGroup("20215", List.of(subjects[0]))));

    ArrayList<TimeSlot> timeSlots =
        new ArrayList<>(List.of(new TimeSlot(900), new TimeSlot(1050), new TimeSlot(1240)));

    for (TimeSlot timeSlot : timeSlots) {
      timeSlotService.addTimeSlot(timeSlot);
    }

    for (Subject subject : subjects) {
      subjectService.addSubject(subject);
    }

    for (Room room : rooms) {
      roomService.addRoom(room);
    }

    for (Teacher teacher : teachers) {
      teacherService.addTeacher(teacher);
    }

    generator.generate(
        subjectService.getAllSubjects(),
        roomService.getAllRooms(),
        teacherService.getAllTeachers(),
        studentGroups,
        timeSlotService.getAllTimeSlots());
  }
}
