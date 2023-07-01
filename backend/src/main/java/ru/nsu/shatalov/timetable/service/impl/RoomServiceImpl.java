package ru.nsu.shatalov.timetable.service.impl;

import java.util.LinkedList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.nsu.shatalov.timetable.dto.RoomDTO;
import ru.nsu.shatalov.timetable.model.object.constraint.Room;
import ru.nsu.shatalov.timetable.repository.RoomRepository;
import ru.nsu.shatalov.timetable.service.interfaces.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

  private final RoomRepository repository;

  private final ModelMapper modelMapper;

  public RoomServiceImpl(RoomRepository repository) {
    this.repository = repository;
    this.modelMapper = new ModelMapper();
  }

  @Override
  public RoomDTO save(RoomDTO roomDTO) {
    Room room = modelMapper.map(roomDTO, Room.class);
    return modelMapper.map(repository.save(room), RoomDTO.class);
  }

  @Override
  public RoomDTO getById(Long id) {
    Room room = repository.findById(id).isPresent() ? repository.findById(id).get() : null;
    if (room != null) {
      return modelMapper.map(room, RoomDTO.class);
    }
    return null;
  }

  @Override
  public RoomDTO update(RoomDTO room, Long id) {
    return null;
  }

  @Override
  public List<RoomDTO> getAll() {
    List<Room> rooms = repository.findAll();
    List<RoomDTO> roomDTOS = new LinkedList<>();
    for (Room room : rooms) {
      roomDTOS.add(modelMapper.map(room, RoomDTO.class));
    }
    return roomDTOS;
  }

  @Override
  public void delete(Long id) {
    Room room = repository.findById(id).isPresent() ? repository.findById(id).get() : null;
    if (room != null) {
      repository.delete(room);
    }
  }
}
