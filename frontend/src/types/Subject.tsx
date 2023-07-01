import { RoomType } from '../enums/RoomType';
import { SubjectType } from '../enums/SubjectType';

interface Subject {
  id: number;
  name: string;
  roomType: RoomType;
  subjectType: SubjectType;
}

export default Subject;
