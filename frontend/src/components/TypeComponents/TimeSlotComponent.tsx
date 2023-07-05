import React from "react";
import TimeSlot from "../../types/TimeSlot";

const TimeSlotComponent: React.FC<TimeSlot> = ({ time }) => {
  return (
    <div>
      <p>Time: {time}</p>
    </div>
  );
};

export default TimeSlotComponent;