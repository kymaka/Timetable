import http from '../http-common';
import TimeSlot from '../types/TimeSlot';

const getAll = () => {
  return http.get<Array<TimeSlot>>('/timeslots/all');
};

const get = (id: number) => {
  return http.get<TimeSlot>('/timeslots/${id}');
};

const create = (data: TimeSlot) => {
  return http.post<TimeSlot>("/timeslots", data);
};

const update = (data: TimeSlot, id: number) => {
  return http.put<any>('/timeslots/${id}', data);
};

const remove = (id: number) => {
  return http.delete<any>('/timeslots/${id}');
};

const TimeSlotService = {
  getAll,
  get,
  create,
  update,
  remove,
};

export default TimeSlotService;
