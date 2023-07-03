import React from 'react'
import StudentGroup from '../types/StudentGroup'

const StudentGroupComponent: React.FC<StudentGroup> =({ number, subjects, timetableEntries }) => {
  return (
    <div>
      <p>Number: {number}</p>
      <p>Subjects: {subjects.map((subject) => <div key = {subject.id}>{subject.name}</div>)}</p>
    </div>
  );
};

export default StudentGroupComponent;