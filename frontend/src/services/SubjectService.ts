import http from '../http-common';
import Subject from '../types/Subject';

const getAll = () => {
  return http.get<Array<Subject>>('/subjects/all');
};

const get = (id: number) => {
  return http.get<Subject>(`/subjects/${id}`);
};

const create = (data: Subject) => {
  return http.post<Subject>("/subjects", data);
};

const update = (data: Subject, id: number) => {
  return http.put<any>(`/subjects/${id}`, data);
};

const remove = (id: number) => {
  return http.delete<any>(`/subjects/${id}`);
};

const SubjectService = {
  getAll,
  get,
  create,
  update,
  remove,
};

export default SubjectService;
