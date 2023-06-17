package ru.nsu.shatalov.timetable.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import ru.nsu.shatalov.timetable.generator.TimetableGenerator;
import ru.nsu.shatalov.timetable.model.enums.Day;
import ru.nsu.shatalov.timetable.model.object.TimetableEntry;
import ru.nsu.shatalov.timetable.model.object.constraint.Room;
import ru.nsu.shatalov.timetable.model.object.constraint.StudentGroup;
import ru.nsu.shatalov.timetable.model.object.constraint.Subject;
import ru.nsu.shatalov.timetable.model.object.constraint.Teacher;
import ru.nsu.shatalov.timetable.model.object.constraint.TimeSlot;
import ru.nsu.shatalov.timetable.repository.GroupRepository;
import ru.nsu.shatalov.timetable.repository.RoomRepository;
import ru.nsu.shatalov.timetable.repository.SubjectRepository;
import ru.nsu.shatalov.timetable.repository.TeacherRepository;
import ru.nsu.shatalov.timetable.repository.TimeSlotRepository;
import ru.nsu.shatalov.timetable.repository.TimetableEntryRepository;
import ru.nsu.shatalov.timetable.service.interfaces.TimetableService;

@Service
public class TimetableServiceImpl implements TimetableService {

  private final GroupRepository groupRepository;
  private final TimetableEntryRepository timetableEntryRepository;
  private final SubjectRepository subjectRepository;
  private final RoomRepository roomRepository;
  private final TimeSlotRepository timeSlotRepository;
  private final TeacherRepository teacherRepository;

  private final TimetableGenerator generator;

  public TimetableServiceImpl(
      GroupRepository groupRepository,
      TimetableEntryRepository timetableEntryRepository,
      SubjectRepository subjectRepository,
      RoomRepository roomRepository,
      TimeSlotRepository timeSlotRepository,
      TeacherRepository teacherRepository) {
    this.groupRepository = groupRepository;
    this.timetableEntryRepository = timetableEntryRepository;
    this.subjectRepository = subjectRepository;
    this.roomRepository = roomRepository;
    this.timeSlotRepository = timeSlotRepository;
    this.teacherRepository = teacherRepository;
    this.generator = new TimetableGenerator();
  }

  @Override
  public void generateTimetable() {
    List<Subject> subjects = subjectRepository.findAll();
    List<Room> rooms = roomRepository.findAll();
    List<TimeSlot> timeSlots = timeSlotRepository.findAll();
    List<StudentGroup> studentGroups = groupRepository.findAll();
    List<Teacher> teachers = teacherRepository.findAll();
    int[][][] timetable = generator.generate(subjects, rooms, teachers, studentGroups, timeSlots);
    Day[] days = {Day.Monday, Day.Tuesday, Day.Wednesday, Day.Thursday, Day.Friday};
    int numberOfCourses = subjects.size();
    int numberOfGroups = studentGroups.size();

    // g - group, i - subject
    // [g][i][0] - room, [g][i][1] - timeslot, [g][i][2] - teacher, [g][i][3] - day of week
    for (int g = 0; g < numberOfGroups; g++) {
      StudentGroup group = studentGroups.get(g);
      if (group.getTimetableEntries() != null) {
        Hibernate.initialize(group.getTimetableEntries());
        List<TimetableEntry> groupEntries = group.getTimetableEntries();
        group.setTimetableEntries(null);
        groupRepository.save(studentGroups.get(g));
        for (TimetableEntry entry : groupEntries) {
          timetableEntryRepository.deleteById(entry.getId());
        }
      }
      List<TimetableEntry> groupTimetable = new ArrayList<>();
      for (int d = 0; d < days.length; d++) {
        for (int i = 0; i < numberOfCourses; i++) {
          if (studentGroups.get(g).getSubjects().size() > i && timetable[g][i][3] == d) {
            TimetableEntry timetableEntry =
                new TimetableEntry(
                    rooms.get(timetable[g][i][0]),
                    studentGroups.get(g).getSubjects().get(i),
                    timeSlots.get(timetable[g][i][1]),
                    teachers.get(timetable[g][i][2]),
                    days[timetable[g][i][3]]);
            groupTimetable.add(timetableEntry);
            timetableEntryRepository.save(timetableEntry);
          }
        }
      }
      StudentGroup studentGroup = studentGroups.get(g);
      studentGroup.setTimetableEntries(groupTimetable);
      groupRepository.save(studentGroup);
    }
  }
}
