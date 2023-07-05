package ru.nsu.shatalov.timetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.shatalov.timetable.model.object.TimetableEntry;
import ru.nsu.shatalov.timetable.model.object.constraint.StudentGroup;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<StudentGroup, Long> {
  Optional<StudentGroup> findStudentGroupByNumber(String number);
}
