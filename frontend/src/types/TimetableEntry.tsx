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

export function isTimetableEntry(obj: any): obj is TimetableEntry {
  let res;
  try {
    res = 'id' in obj && 'room' in obj && 'subject' in obj && 'timeSlot' in obj
      && 'teacher' in obj && 'day' in obj;
  } catch (error) {
    res = false
  }
  return res
}

export default TimetableEntry;