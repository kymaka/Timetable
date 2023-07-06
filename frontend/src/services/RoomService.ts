import http from '../http-common';
import Room from '../types/Room';

const getAll = () => {
  return http.get<Array<Room>>('/rooms/all');
};

const get = (id: number) => {
  return http.get<Room>('/rooms/${id}');
};

const create = (data: Room) => {
  return http.post<Room>("/rooms", data);
};

const update = (data: Room, id: number) => {
  return http.put<any>('/rooms/${id}', data);
};

const remove = (id: number) => {
  return http.delete<any>('/rooms/${id}');
};

const RoomService = {
  getAll,
  get,
  create,
  update,
  remove,
};

export default RoomService;
