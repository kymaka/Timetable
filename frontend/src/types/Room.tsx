import { RoomType } from "../enums/RoomType";

interface Room {
  id: number;
  number: string;
  type: RoomType;
}

export default Room;