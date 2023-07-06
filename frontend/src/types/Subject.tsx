import { RoomType } from '../enums/RoomType';
import { SubjectType } from '../enums/SubjectType';

interface Subject {
  id: number;
  name: string;
  roomType: RoomType;
  subjectType: SubjectType;
}

export function isSubject(obj: any): obj is Subject {
  let res;
  try {
    res = 'id' in obj && 'name' in obj && 'roomType' in obj && 'subjectType' in obj;
  } catch (error) {
    res = false
  }
  return res
}


export default Subject;
