enum RoomType {
  Terminal = 'Terminal',
  Lecture = 'Lecture',
  General = 'General',
}

// Additional properties and methods can be represented using utility objects
const RoomTypeInfo = {
  Terminal: { label: 'Terminal', capacity: 20, integer: 0 },
  Lecture: { label: 'Lecture', capacity: 200, integer: 1 },
  General: { label: 'General', capacity: 50, integer: 2 },
};

const getRoomTypeInfo = (roomType: RoomType) => {
  return RoomTypeInfo[roomType];
};

export { RoomType, RoomTypeInfo, getRoomTypeInfo };
