package ru.nsu.shatalov.timetable.service.impl;

import java.util.LinkedList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.nsu.shatalov.timetable.dto.SubjectDTO;
import ru.nsu.shatalov.timetable.model.object.constraint.Subject;
import ru.nsu.shatalov.timetable.repository.SubjectRepository;
import ru.nsu.shatalov.timetable.service.interfaces.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

  private final SubjectRepository repository;

  private final ModelMapper modelMapper;

  public SubjectServiceImpl(SubjectRepository repository) {
    this.repository = repository;
    this.modelMapper = new ModelMapper();
  }

  @Override
  public SubjectDTO save(SubjectDTO subjectDTO) {
    Subject subject = modelMapper.map(subjectDTO, Subject.class);
    repository.save(subject);
    return modelMapper.map(subject, SubjectDTO.class);
  }

  @Override
  public SubjectDTO getById(Long id) {
    Subject subject = repository.findById(id).isPresent() ? repository.findById(id).get() : null;
    if (subject != null) {
      return modelMapper.map(subject, SubjectDTO.class);
    }
    return null;
  }

  @Override
  public SubjectDTO update(SubjectDTO subject, Long id) {
    return null;
  }

  @Override
  public List<SubjectDTO> getAll() {
    List<Subject> subjects = repository.findAll();
    List<SubjectDTO> subjectDTOS = new LinkedList<>();
    for (Subject subject : subjects) {
      subjectDTOS.add(modelMapper.map(subject, SubjectDTO.class));
    }
    return subjectDTOS;
  }

  @Override
  public void delete(Long id) {
    Subject subject = repository.findById(id).isPresent() ? repository.findById(id).get() : null;
    if (subject != null) {
      repository.delete(subject);
    }
  }
}
