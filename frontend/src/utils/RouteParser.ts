import { useParams } from "react-router-dom";
import RoomService from "../services/RoomService";
import StudentGroupService from "../services/StudentGroupService";
import SubjectService from "../services/SubjectService";
import TeacherService from "../services/TeacherService";
import TimeSlotService from "../services/TimeSlotService";

export function getDataForRoute(type: string, number?: string | undefined) {
  if (type === 'room') {
    return RoomService.getAll();
  } else if (type === 'timeslot') {
    return TimeSlotService.getAll();
  } else if (type === 'subject') {
    return SubjectService.getAll();
  } else if (type === 'group') {
    return StudentGroupService.getAll();
  } else if (type === 'timetable') {
    return StudentGroupService.getTimetable(number);;
  } else {
    return TeacherService.getAll();
  }
}