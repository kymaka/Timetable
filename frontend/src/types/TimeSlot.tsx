interface TimeSlot {
  id: number;
  time: string;
}

export function isTimeSlot(obj: any): obj is TimeSlot {
  let res;
  try {
    res = 'id' in obj && 'time' in obj;
  } catch (error) {
    res = false
  }
  return res
}

export default TimeSlot;