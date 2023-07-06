import Subject from './Subject';
import TimetableEntry from './TimetableEntry';

interface StudentGroup {
  id: number;
  number: string;
  subjects: Subject[];
  timetableEntries: TimetableEntry[];
}

export default StudentGroup;