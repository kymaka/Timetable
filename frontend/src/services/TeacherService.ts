import http from '../http-common';
import Teacher from '../types/Teacher';

const getAll = () => {
  return http.get<Array<Teacher>>('/teachers');
};

const get = (id: number) => {
  return http.get<Teacher>('/teachers/${id}');
};

const create = (data: Teacher) => {
  return http.post<Teacher>("/teachers", data);
};

const update = (data: Teacher, id: number) => {
  return http.put<any>('/teachers/${id}', data);
};

const remove = (id: number) => {
  return http.delete<any>('/teachers/${id}');
};

const TeacherService = {
  getAll,
  get,
  create,
  update,
  remove,
};

export default TeacherService;
