package ru.nsu.shatalov.timetable.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import ru.nsu.shatalov.timetable.dto.*;
import ru.nsu.shatalov.timetable.generator.TimetableGenerator;
import ru.nsu.shatalov.timetable.model.enums.Day;
import ru.nsu.shatalov.timetable.service.interfaces.*;

@Service
public class TimetableServiceImpl implements TimetableService {

  private final GroupService groupService;
  private final TimetableEntryService timetableEntryService;
  private final SubjectService subjectService;
  private final RoomService roomService;
  private final TimeSlotService timeSlotService;
  private final TeacherService teacherService;

  private final TimetableGenerator generator;

  public TimetableServiceImpl(
      GroupService groupService,
      TimetableEntryService timetableEntryService,
      SubjectService subjectService,
      RoomService roomService,
      TimeSlotService timeSlotService,
      TeacherService teacherService) {
    this.groupService = groupService;
    this.timetableEntryService = timetableEntryService;
    this.subjectService = subjectService;
    this.roomService = roomService;
    this.timeSlotService = timeSlotService;
    this.teacherService = teacherService;

    this.generator = new TimetableGenerator();
  }

  @Override
  public boolean generateTimetable() {
    List<SubjectDTO> subjects = subjectService.getAll();
    List<RoomDTO> rooms = roomService.getAll();
    List<TimeSlotDTO> timeSlots = timeSlotService.getAll();
    List<StudentGroupDTO> studentGroups = groupService.getAll();
    List<TeacherDTO> teachers = teacherService.getAll();
    int[][][] timetable = generator.generate(subjects, rooms, teachers, studentGroups, timeSlots);
    if (timetable != null) {
      Day[] days = {Day.Monday, Day.Tuesday, Day.Wednesday, Day.Thursday, Day.Friday};
      int numberOfCourses = subjects.size();
      int numberOfGroups = studentGroups.size();

      // g - group, i - subject
      // [g][i][0] - room, [g][i][1] - timeslot, [g][i][2] - teacher, [g][i][3] - day of week
      for (int g = 0; g < numberOfGroups; g++) {
        StudentGroupDTO group = studentGroups.get(g);
        if (group.getTimetableEntries() != null) {
          Hibernate.initialize(group.getTimetableEntries());
          List<TimetableEntryDTO> groupEntries = group.getTimetableEntries();
          group.setTimetableEntries(null);
          groupService.update(group, group.getId());
          for (TimetableEntryDTO entry : groupEntries) {
            timetableEntryService.delete(entry.getId());
          }
        }
        List<TimetableEntryDTO> groupTimetable = new LinkedList<>();
        RoomDTO room = null;
        for (int d = 0; d < days.length; d++) {
          for (int i = 0; i < numberOfCourses; i++) {
            if (group.getSubjects().size() > i && timetable[g][i][3] == d) {
              TimetableEntryDTO timetableEntry =
                  new TimetableEntryDTO(
                      rooms.get(timetable[g][i][0]),
                      group.getSubjects().get(i),
                      timeSlots.get(timetable[g][i][1]),
                      teachers.get(timetable[g][i][2]),
                      days[timetable[g][i][3]]);
              groupTimetable.add(timetableEntryService.save(timetableEntry));
              List<TimetableEntryDTO> timetableEntryDTOList = new ArrayList<>();
              timetableEntryDTOList.add(timetableEntry);
              room = rooms.get(timetable[g][i][0]);
              room.setEntries(timetableEntryDTOList);
            }
          }
        }
        group.setTimetableEntries(groupTimetable);

        roomService.update(room, room.getId());

        groupService.update(group, group.getId());

      }
      return true;
    }
    return false;
  }
}
