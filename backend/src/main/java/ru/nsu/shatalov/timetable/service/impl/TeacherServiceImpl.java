package ru.nsu.shatalov.timetable.service.impl;

import java.util.LinkedList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.nsu.shatalov.timetable.dto.TeacherDTO;
import ru.nsu.shatalov.timetable.model.object.constraint.Teacher;
import ru.nsu.shatalov.timetable.repository.TeacherRepository;
import ru.nsu.shatalov.timetable.service.interfaces.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

  private final TeacherRepository repository;

  private final ModelMapper modelMapper;

  public TeacherServiceImpl(TeacherRepository repository) {
    this.repository = repository;
    this.modelMapper = new ModelMapper();
  }

  @Override
  public TeacherDTO save(TeacherDTO teacherDTO) {
    Teacher teacher = modelMapper.map(teacherDTO, Teacher.class);
    return modelMapper.map(repository.save(teacher), TeacherDTO.class);
  }

  @Override
  public List<TeacherDTO> getAll() {
    List<Teacher> teachers = repository.findAll();
    List<TeacherDTO> teacherDTOS = new LinkedList<>();
    for (Teacher teacher : teachers) {
      teacherDTOS.add(modelMapper.map(teacher, TeacherDTO.class));
    }
    return teacherDTOS;
  }

  @Override
  public TeacherDTO getById(Long id) {
    Teacher teacher = repository.findById(id).isPresent() ? repository.findById(id).get() : null;
    if (teacher != null) {
      return modelMapper.map(teacher, TeacherDTO.class);
    }
    return null;
  }
}
