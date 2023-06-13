package ru.nsu.shatalov.timetable;

import java.util.ArrayList;
import java.util.List;
import ru.nsu.shatalov.timetable.generator.TimetableGenerator;
import ru.nsu.shatalov.timetable.model.object.Group;
import ru.nsu.shatalov.timetable.model.object.TimeSlot;
import ru.nsu.shatalov.timetable.model.object.constraint.Room;
import ru.nsu.shatalov.timetable.model.object.constraint.Subject;
import ru.nsu.shatalov.timetable.model.object.constraint.Teacher;
import ru.nsu.shatalov.timetable.model.enums.Day;
import ru.nsu.shatalov.timetable.model.enums.RoomType;
import ru.nsu.shatalov.timetable.model.enums.SubjectType;
import ru.nsu.shatalov.timetable.repository.GroupRepository;
import ru.nsu.shatalov.timetable.repository.RoomRepository;
import ru.nsu.shatalov.timetable.repository.SubjectRepository;
import ru.nsu.shatalov.timetable.repository.TeacherRepository;
import ru.nsu.shatalov.timetable.repository.TimeSlotRepository;
import ru.nsu.shatalov.timetable.service.impl.GroupServiceImpl;
import ru.nsu.shatalov.timetable.service.impl.RoomServiceImpl;
import ru.nsu.shatalov.timetable.service.impl.SubjectServiceImpl;
import ru.nsu.shatalov.timetable.service.impl.TeacherServiceImpl;
import ru.nsu.shatalov.timetable.service.impl.TimeSlotServiceImpl;
import ru.nsu.shatalov.timetable.store.DataStore;

public class Main {

  public static void main(String[] args) {
    DataStore dataStore = new DataStore();
    SubjectRepository subjectRepository = new SubjectRepository(dataStore);
    SubjectServiceImpl subjectService = new SubjectServiceImpl(subjectRepository);

    RoomRepository roomRepository = new RoomRepository(dataStore);
    RoomServiceImpl roomService = new RoomServiceImpl(roomRepository);

    TeacherRepository teacherRepository = new TeacherRepository(dataStore);
    TeacherServiceImpl teacherService = new TeacherServiceImpl(teacherRepository);

    GroupRepository groupRepository = new GroupRepository(dataStore);
    GroupServiceImpl groupService = new GroupServiceImpl(groupRepository);

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

    ArrayList<Group> groups =
        new ArrayList<>(
            List.of(
                new Group("20213", List.of(subjects)),
                new Group("20214", List.of(subjects)),
                new Group("20215", List.of(subjects[0]))));

    // TODO: Add data storage for timeslots.
    ArrayList<TimeSlot> timeSlots =
        new ArrayList<>(List.of(new TimeSlot(900), new TimeSlot(1050), new TimeSlot(1240)));

    for (TimeSlot timeSlot : timeSlots) {
      timeSlotService.addTimeSlot(timeSlot);
    }

    for (Group group : groups) {
      groupService.addGroup(group);
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
        groupService.getAllGroups(),
        timeSlotService.getAllTimeSlots());
  }
}
