import React, { Fragment, useState, useEffect } from 'react';
import Room from "../types/Room";
import RoomService from '../services/RoomService';
import RoomComponent from '../components/RoomComponent';
import { RoomType } from '../enums/RoomType';

function DataPage() {
  const [rooms, setRooms] = useState<Room[]>([]);

  useEffect(() => {
    RoomService.getAll().then((data) => {
      setRooms(data.data);
    })
  })

  return (
    <>
      <h1>Rooms</h1>
      <ul>
        {rooms.map(
          (room) =>
            <li key={room.id}>
              <RoomComponent id={room.id} number={room.number} type={room.type} />
            </li>
        )}
      </ul>
    </>
  )
}

export default DataPage;