import Subject from "./Subject";
import { Day } from '../enums/Day';

interface Teacher {
  id: number;
  name: string;
  subjects: Subject[];
  workingDays: Day[];
}

export function isTeacher(obj: any): obj is Teacher {
  let res;
  try {
    res = 'id' in obj && 'name' in obj && 'subjects' in obj && 'workingDays' in obj;
  } catch (error) {
    res = false
  }
  return res
}


export default Teacher;