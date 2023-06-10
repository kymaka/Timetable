package ru.nsu.shatalov.timetable.model.object;

public class TimeSlot {

    private final int time;

    public TimeSlot(int time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TimeSlot other = (TimeSlot) obj;
        return time == other.time;
    }
}
