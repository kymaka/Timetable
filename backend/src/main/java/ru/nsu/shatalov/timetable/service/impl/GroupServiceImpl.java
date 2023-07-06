package ru.nsu.shatalov.timetable.service.impl;

import java.util.LinkedList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.shatalov.timetable.dto.StudentGroupDTO;
import ru.nsu.shatalov.timetable.dto.TimetableEntryDTO;
import ru.nsu.shatalov.timetable.model.object.TimetableEntry;
import ru.nsu.shatalov.timetable.model.object.constraint.StudentGroup;
import ru.nsu.shatalov.timetable.repository.GroupRepository;
import ru.nsu.shatalov.timetable.service.interfaces.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

  private final GroupRepository repository;

  private final ModelMapper modelMapper;

  @Autowired
  public GroupServiceImpl(GroupRepository repository) {
    this.repository = repository;
    this.modelMapper = new ModelMapper();
  }

  @Override
  public StudentGroupDTO save(StudentGroupDTO studentGroupDTO) {
    StudentGroup studentGroup = modelMapper.map(studentGroupDTO, StudentGroup.class);
    repository.save(studentGroup);
    return modelMapper.map(studentGroup, StudentGroupDTO.class);
  }

  @Override
  public StudentGroupDTO getById(Long id) {
    StudentGroup studentGroup =
        repository.findById(id).isPresent() ? repository.findById(id).get() : null;
    if (studentGroup != null) {
      return modelMapper.map(studentGroup, StudentGroupDTO.class);
    }
    return null;
  }

  @Override
  public StudentGroupDTO getByNumber(String number) {
    StudentGroup studentGroup =
        repository.findStudentGroupByNumber(number).isPresent()
            ? repository.findStudentGroupByNumber(number).get()
            : null;
    if (studentGroup != null) {
      return modelMapper.map(studentGroup, StudentGroupDTO.class);
    }
    return null;
  }

  @Override
  public List<TimetableEntryDTO> getTimetable(String number) {
    StudentGroupDTO studentGroupDTO = getByNumber(number);
    return studentGroupDTO.getTimetableEntries();
  }

  @Override
  public StudentGroupDTO update(StudentGroupDTO newStudentGroupDTO, Long id) {
    StudentGroup studentGroup =
        repository.findById(id).isPresent() ? repository.findById(id).get() : null;
    if (studentGroup != null) {
      StudentGroup newStudentGroup = modelMapper.map(newStudentGroupDTO, StudentGroup.class);
      studentGroup.setNumber(newStudentGroup.getNumber());
      studentGroup.setSubjects(newStudentGroup.getSubjects());
      studentGroup.setTimetableEntries(newStudentGroup.getTimetableEntries());
      repository.save(studentGroup);
      return modelMapper.map(studentGroup, StudentGroupDTO.class);
    }
    return null;
  }

  @Override
  public List<StudentGroupDTO> getAll() {
    List<StudentGroup> studentGroups = repository.findAll();
    List<StudentGroupDTO> studentGroupDTOS = new LinkedList<>();
    for (StudentGroup group : studentGroups) {
      studentGroupDTOS.add(modelMapper.map(group, StudentGroupDTO.class));
    }
    return studentGroupDTOS;
  }

  @Override
  public void delete(StudentGroupDTO studentGroupDTO) {
    StudentGroup studentGroup = modelMapper.map(studentGroupDTO, StudentGroup.class);
    repository.delete(studentGroup);
  }
}
