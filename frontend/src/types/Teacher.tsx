import Subject from "./Subject";
import { Day } from '../enums/Day';

interface Teacher {
  id: number;
  name: string;
  subject: Subject[];
  workingDays: Day[];
}

export default Teacher;