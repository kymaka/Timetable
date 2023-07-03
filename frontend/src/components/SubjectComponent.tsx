import React from "react";
import Subject from "../types/Subject";

const SubjectComponent: React.FC<Subject> = ({ name, roomType, subjectType }) => {
  return (
    <div>
      <p>Name: {name}</p>
      <p>Room Type: {roomType}</p>
      <p>Subject Type: {subjectType}</p>
    </div>
  );
};

export default SubjectComponent;