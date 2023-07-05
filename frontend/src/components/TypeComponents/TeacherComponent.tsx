import React from "react";
import Teacher from "../../types/Teacher";

const TeacherComponent: React.FC<Teacher> = ({ name, subjects, workingDays }) => {
  return (
    <div>
      <p>Name: {name} </p>
      <p>Subjects: {subjects.map((subject) => <div key = {subject.id}>{subject.name}</div>)}</p>
      <p>Working Days: {workingDays.map((day) => <div key = {day}> {day} </div>)}</p>
    </div>
  );
};

export default TeacherComponent;