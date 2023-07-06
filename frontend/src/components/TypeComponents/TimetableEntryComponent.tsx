import React from "react";
import TimetableEntry from "../../types/TimetableEntry";

const TimetableEntryComponent: React.FC<TimetableEntry> = ({ room, subject, timeSlot, teacher, day }) => {
  return (
    <div>
      <p>Room: {room.number}</p>
      <p>Subject: {subject.name}</p>
      <p>Time: {timeSlot.time}</p>
      <p>Teacher: {teacher.name}</p>
      <p>Day: {day}</p>
    </div>
  );
};

export default TimetableEntryComponent;
