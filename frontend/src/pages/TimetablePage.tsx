import { useParams } from "react-router-dom";
import { SuperTable } from "../components/Table/Table";


export function TimetablePage() {
  const { number } = useParams();

  return (
    <>
      <h1>Group: {number} </h1>
      <SuperTable type={'timetable'} number={number} />
    </>
  );
}