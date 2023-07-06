import http from '../http-common';
import StudentGroup from '../types/StudentGroup';
import TimetableEntry from '../types/TimetableEntry';

const getAll = () => {
  return http.get<Array<StudentGroup>>('/groups/all');
};

const get = (id: number) => {
  return http.get<StudentGroup>(`/groups/${id}`);
};

const getTimetable = (number: string | undefined) => {
  return http.get<Array<TimetableEntry>>(`/groups/timetable/${number}`);
}

const create = (data: StudentGroup) => {
  return http.post<StudentGroup>("/groups", data);
};

const update = (data: StudentGroup, id: number) => {
  return http.put<any>(`/groups/${id}`, data);
};

const remove = (id: number) => {
  return http.delete<any>(`/groups/${id}`);
};

const StudentGroupService = {
  getAll,
  get,
  getTimetable,
  create,
  update,
  remove,
};

export default StudentGroupService;

