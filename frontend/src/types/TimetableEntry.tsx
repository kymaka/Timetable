import { Day } from "../enums/Day";
import Room from "./Room";
import Subject from "./Subject";
import Teacher from "./Teacher";
import TimeSlot from "./TimeSlot";


interface TimetableEntry {
  id: number;
  room: Room;
  subject: Subject;
  timeSlot: TimeSlot;
  teacher: Teacher;
  day: Day;
}

export default TimetableEntry;