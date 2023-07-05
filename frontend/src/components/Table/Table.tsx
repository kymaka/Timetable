import axios from "axios"
import { getDataForRoute } from "../../utils/RouteParser"
import { useState, useEffect } from "react"
import { alpha } from "@mui/material/styles";
import Box from "@mui/material/Box";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TablePagination from "@mui/material/TablePagination";
import TableRow from "@mui/material/TableRow";
import TableSortLabel from "@mui/material/TableSortLabel";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Paper from "@mui/material/Paper";
import Checkbox from "@mui/material/Checkbox";
import IconButton from "@mui/material/IconButton";
import Tooltip from "@mui/material/Tooltip";
import FormControlLabel from "@mui/material/FormControlLabel";
import Switch from "@mui/material/Switch";
import DeleteIcon from "@mui/icons-material/Delete";
import FilterListIcon from "@mui/icons-material/FilterList";
import React from "react";
import Room, { isRoom } from "../../types/Room";
import Subject, { isSubject } from "../../types/Subject";
import StudentGroup from "../../types/StudentGroup";
import Teacher, { isTeacher } from "../../types/Teacher";
import TimeSlot, { isTimeSlot } from "../../types/TimeSlot";
import { Day } from "../../enums/Day";
import { useParams } from "react-router-dom";
import TimetableEntry, { isTimetableEntry } from "../../types/TimetableEntry";

function descendingComparator<T>(a: T, b: T, orderBy: keyof T) {
  if (b[orderBy] < a[orderBy]) {
    return -1;
  }
  if (b[orderBy] > a[orderBy]) {
    return 1;
  }
  return 0;
}

type Order = "asc" | "desc";

function getComparator<Key extends keyof any>(
  order: Order,
  orderBy: Key
): (
  a: { [key in Key]: number | string },
  b: { [key in Key]: number | string }
) => number {
  return order === "desc"
    ? (a, b) => descendingComparator(a, b, orderBy)
    : (a, b) => -descendingComparator(a, b, orderBy);
}

function stableSort<T>(
  array: readonly T[],
  comparator: (a: T, b: T) => number
) {
  const stabilizedThis = array.map((el, index) => [el, index] as [T, number]);
  stabilizedThis.sort((a, b) => {
    const order = comparator(a[0], b[0]);
    if (order !== 0) {
      return order;
    }
    return a[1] - b[1];
  });
  return stabilizedThis.map((el) => el[0]);
}
let thisObject: Room | Subject | StudentGroup | Teacher | TimeSlot;
const order: Order = "asc";

export function SuperTable({ type }: any) {
  const { number } = useParams();
  const { data, loading, error } = useFetch(type, number)
  const [rowsData, setRowsData] = React.useState(data);
  const [order, setOrder] = React.useState<Order>("asc");
  const [orderBy, setOrderBy] = React.useState<keyof typeof thisObject | string>("id");
  const [selected, setSelected] = React.useState<readonly string[]>([]);
  const [page, setPage] = React.useState(0);
  const [rowsPerPage, setRowsPerPage] = React.useState(5);


  if (data != null) {
    thisObject = data[0]

    // Keys are the names of the columns.
    const keys = Object.keys(thisObject)

    const handleRequestSort = (
      event: React.MouseEvent<unknown>,
      property: keyof typeof thisObject
    ) => {
      const isAsc = order === "asc";
    };

    const handleClick = (event: React.MouseEvent<unknown>, name: string) => {
      const selectedIndex = selected.indexOf(name);
      let newSelected: readonly string[] = [];

      if (selectedIndex === -1) {
        newSelected = newSelected.concat(selected, name);
      } else if (selectedIndex === 0) {
        newSelected = newSelected.concat(selected.slice(1));
      } else if (selectedIndex === selected.length - 1) {
        newSelected = newSelected.concat(selected.slice(0, -1));
      } else if (selectedIndex > 0) {
        newSelected = newSelected.concat(
          selected.slice(0, selectedIndex),
          selected.slice(selectedIndex + 1)
        );
      }

      setSelected(newSelected);
    };

    const handleChangePage = (event: unknown, newPage: number) => {
      setPage(newPage);
    };

    const handleChangeRowsPerPage = (
      event: React.ChangeEvent<HTMLInputElement>
    ) => {
      setRowsPerPage(parseInt(event.target.value, 10));
      setPage(0);
    };

    const isSelected = (name: string) => selected.indexOf(name) !== -1;

    // Avoid a layout jump when reaching the last page with empty rows.
    const emptyRows =
      page > 0 ? Math.max(0, (1 + page) * rowsPerPage - data.length) : 0;

    /*const visibleRows = React.useMemo(
      () =>
        stableSort(data, getComparator(order, orderBy)).slice(
          page * rowsPerPage,
          page * rowsPerPage + rowsPerPage
        ),
      [order, orderBy, page, rowsPerPage, rowsData]
    );*/

    const handleDelete = (el: typeof thisObject) => {
      setRowsData((oldRows) => {
        if (oldRows) {
          return oldRows.filter((row) => row.id !== el.id);
        }
        return [];
      });
    };

    const handleAdd = (data: typeof thisObject) => {
      console.log(data, "data");

      setRowsData((oldRows) => {
        if (oldRows) {
          const newRows = [...oldRows];
          newRows.push(data);
          return newRows;
        }
        return [data];
      });
    };


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
                      sortDirection={order}
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
              </TableBody>
            </Table>
          </TableContainer>
        </Paper>
      </Box>
    )
  } else {
    return null;
  }
}




function useFetch(type: string, number?: string | undefined) {
  const [data, setData] = useState<null | any[]>(null);
  const [loading, setLoading] = useState<boolean | null | string>(null);
  const [error, setError] = useState<null | string>(null);

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
  }, [type])

  return { data, loading, error }
}

export default useFetch;




/*    return (
      <table>
        <thead>
          <tr>
 
 
 
            {keys.map((key) => (
              <th key={key}>{key}</th>
            ))}
          </tr>
        </thead>
        <tbody>
          {data.map((el) => (
            <tr key={el}>
              {keys.map((key) => (
                <td key={el[key].id}>{el[key]}</td>
              ))}
            </tr>
          ))}
        </tbody>
      </table>
    )
  } else {
    return null;
  }*/
