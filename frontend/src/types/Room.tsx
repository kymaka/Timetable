import { RoomType } from "../enums/RoomType";

interface Room {
  id: number;
  number: string;
  type: RoomType;
}

export function isRoom(obj: any): obj is Room {
  let res;
  try {
    res = 'id' in obj && 'number' in obj && 'type' in obj;
  } catch (error) {
    res = false
  }
  return res
}

export default Room;