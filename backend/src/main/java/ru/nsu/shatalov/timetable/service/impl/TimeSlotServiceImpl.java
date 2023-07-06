package ru.nsu.shatalov.timetable.service.impl;

import java.util.LinkedList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.nsu.shatalov.timetable.dto.TimeSlotDTO;
import ru.nsu.shatalov.timetable.model.object.constraint.TimeSlot;
import ru.nsu.shatalov.timetable.repository.TimeSlotRepository;
import ru.nsu.shatalov.timetable.service.interfaces.TimeSlotService;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {

  private final TimeSlotRepository repository;

  private final ModelMapper modelMapper;

  public TimeSlotServiceImpl(TimeSlotRepository repository) {
    this.repository = repository;
    this.modelMapper = new ModelMapper();
  }

  @Override
  public TimeSlotDTO save(TimeSlotDTO timeSlotDTO) {
    TimeSlot timeSlot = modelMapper.map(timeSlotDTO, TimeSlot.class);
    return modelMapper.map(repository.save(timeSlot), TimeSlotDTO.class);
  }

  @Override
  public List<TimeSlotDTO> getAll() {
    List<TimeSlot> timeSlots = repository.findAll();
    List<TimeSlotDTO> timeSlotDTOS = new LinkedList<>();
    for (TimeSlot timeSlot : timeSlots) {
      timeSlotDTOS.add(modelMapper.map(timeSlot, TimeSlotDTO.class));
    }
    return timeSlotDTOS;
  }

  @Override
  public TimeSlotDTO getById(Long id) {
    TimeSlot timeSlot = repository.findById(id).isPresent() ? repository.findById(id).get() : null;
    if (timeSlot != null) {
      return modelMapper.map(timeSlot, TimeSlotDTO.class);
    }
    return null;
  }

  @Override
  public void delete(Long id) {
    TimeSlot timeSlot = repository.findById(id).isPresent() ? repository.findById(id).get() : null;
    if (timeSlot != null) {
      repository.delete(timeSlot);
    }
  }
}
