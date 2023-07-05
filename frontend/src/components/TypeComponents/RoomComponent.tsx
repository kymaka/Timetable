import React from 'react'
import Room from '../../types/Room'

const RoomComponent: React.FC<Room> = ({ number, type }) => {
  return (
    <div>
      <p> Number: {number}</p>
      <p>Room Type: {type}</p>
    </div>
  );
};

export default RoomComponent;
