import Room from "../types/Room";
import TimeSlot from "../types/TimeSlot";

export interface Column {
  id: keyof any;
  numeric: boolean;
  disablePadding: boolean;
  label: string;
}

const roomColumns: Column[] = [
  {
    id: "id",
    numeric: false,
    disablePadding: true,
    label: "ID"
  },
  {
    id: "number",
    numeric: false,
    disablePadding: false,
    label: "Number"
  },
  {
    id: "type",
    numeric: false,
    disablePadding: false,
    label: "Type"
  }
];

const timeSlotColumns: Column[] = [
  {
    id: "id",
    numeric: false,
    disablePadding: true,
    label: "ID"
  },
  {
    id: "time",
    numeric: true,
    disablePadding: false,
    label: "Time"
  }
];
