import axios from "axios"
import { deleteDataForRoute, getDataForRoute } from "../../utils/RouteParser"
import { useState, useEffect } from "react"
import Box from "@mui/material/Box";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import React from "react";
import Room, { isRoom } from "../../types/Room";
import Subject, { isSubject } from "../../types/Subject";
import StudentGroup from "../../types/StudentGroup";
import Teacher, { isTeacher } from "../../types/Teacher";
import TimeSlot, { isTimeSlot } from "../../types/TimeSlot";
import { Day } from "../../enums/Day";
import { useParams } from "react-router-dom";
import TimetableEntry, { isTimetableEntry } from "../../types/TimetableEntry";
import { Button } from "@mui/material";
import BasicModal from "../Modal/Popup";


let thisObject: Room | Subject | StudentGroup | Teacher | TimeSlot | TimetableEntry;

export function SuperTable({ type }: any) {
  const { number } = useParams();
  const { data, loading, error, refetch } = useFetch(type, number)
  const [rowsData, setRowsData] = React.useState(data);

  const handleAdd = (type: string) => {
    console.log(data, "data");
  };
  if (data != null) {
    if (data[0] != null) {
      thisObject = data[0]

      // Keys are the names of the columns.
      const keys = Object.keys(thisObject)

      const handleDelete = (
        type: string, thisThingy: Room | Subject | StudentGroup | Teacher | TimeSlot | TimetableEntry) => {
        deleteDataForRoute(type, thisThingy.id).then(() => {
          refetch();
        });
      }


      return (
        <Box sx={{ width: "100%" }}>
          <Paper sx={{ width: "100%", mb: 2 }}>
            <TableContainer>
              <Table
                sx={{ minWidth: 750 }}
                aria-labelledby="tableTitle"
                size={"medium"}
              >
                <TableHead>
                  <TableRow>
                    {keys.map((key) => (
                      <TableCell
                        key={key}
                        align={"left"}
                        padding={"normal"}
                      >
                        {key}
                      </TableCell>
                    ))}
                    <TableCell align={"right"}></TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {data.map((row, index) => (
                    <TableRow
                      hover
                      role="checkbox"
                      tabIndex={-1}
                      key={row}
                      sx={{ cursor: "pointer" }}
                    >
                      {keys.map((key) => {
                        let cellContent;
                        if (isTimetableEntry(thisObject)) {
                          if (isSubject((row[key])) || (isTeacher(row[key]))) {
                            cellContent = (`|${row[key].name}|`) + ('');
                          } else if (isRoom(row[key])) {
                            cellContent = (`|${row[key].number}|`) + ('');
                          } else if (isTimeSlot(row[key])) {
                            cellContent = (`|${row[key].time}|`) + ('');
                          } else {
                            cellContent = (`|${row[key]}|`) + ' ';
                          }
                        } else if (Array.isArray(row[key])) {
                          // Array of Subjects or Teachers
                          if (isSubject((row[key][0])) || (isTeacher(row[key][0]))) {
                            cellContent = row[key].map((val: Subject | Teacher) => `|${val.name}|`).join('');
                          } else if (isTimetableEntry(row[key][0])) {
                            cellContent = row[key].map((val: TimetableEntry) => `|${val.day
                              + ' '
                              + val.room.number
                              + ' '
                              + val.subject.name
                              + ' '
                              + val.teacher.name
                              + ' '
                              + val.timeSlot.time
                              }|`).join('');
                          } else if ((row[key][0] as Day)) {
                            // Array of Days
                            cellContent = row[key].map((val: Day) => `|${val}|`).join('');
                          }
                        } else {
                          // Regular value
                          cellContent = row[key];
                        }

                        return (
                          <TableCell key={row[key].id} align="left">
                            {cellContent}
                          </TableCell>
                        );
                      })}

                      <Button className="delete" onClick={() => handleDelete(type, row)}>
                        Delete
                      </Button>
                    </TableRow>
                  ))}
                  {(
                    <TableRow
                      style={{
                        height: 53 * 5
                      }}
                    >
                      <TableCell colSpan={6} />
                    </TableRow>
                  )}
                  <Button className="add">
                    <BasicModal />
                  </Button>
                </TableBody>
              </Table>
            </TableContainer>
          </Paper>
        </Box>
      )
    } else {
      return <>No timetable for this group yet</>;
    }
  } else {
    return (
      <>
        No Data
        <Button className="add" onClick={() => handleAdd(type)}>
          Add
          <BasicModal />
        </Button>
      </>);
  }
}




function useFetch(type: string, number?: string | undefined) {
  const [data, setData] = useState<null | any[]>(null);
  const [fetchTrigger, setFetchTrigger] = useState(0)
  const [loading, setLoading] = useState<boolean | null | string>(null);
  const [error, setError] = useState<null | string>(null);
  // Нужна какая-то возможность обновить данные. Создадим функцию рефетч. Она будет просто 
  // изменять триггер, который мы добавим в зависимости useEffect и тем самым при его изменении
  // юзэффект сработает ещё раз. костыль какой-то, но нет времени придумывать лучше. Вроде должно работать.
  const refetch = () => {
    setFetchTrigger(fetchTrigger + 1)
  }


  useEffect(() => {
    setLoading('loading...')
    setData(null);
    setError(null);
    const source = axios.CancelToken.source();
    getDataForRoute(type, number)
      .then(res => {
        setLoading(false);
        //checking for multiple responses for more flexibility
        //with the url we send in.
        setData(res.data);
      })
      .catch(err => {
        setLoading(false)
        setError('An error occurred. Awkward..')
      })
    return () => {
      source.cancel();
    }
  }, [type, fetchTrigger])

  return { data, loading, error, refetch }
}

export default useFetch;
