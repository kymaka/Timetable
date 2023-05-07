package ru.nsu.shatalov.timetable.generator;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;
import ru.nsu.shatalov.timetable.model.constraint.Room;
import ru.nsu.shatalov.timetable.model.constraint.Subject;

import java.util.List;

import ru.nsu.shatalov.timetable.model.constraint.Teacher;

public class TimetableGenerator {

    public void generate(List<Subject> subjects, List<Room> rooms, List<Teacher> teachers) {
        int numberOfCourses = subjects.size();
        int numberOfRooms = rooms.size();
        int numberOfTimeSlots = 2;

        int[] days = {1, 2, 3};

        int[] courseCapacities = {50, 20, 60, 40};
        int[] courseRoomTypes = {3, 1, 2, 3};
        int[] roomNumbers = new int[numberOfRooms];
        int[] roomCapacities = new int[numberOfRooms];
        int[] roomTypes = new int[numberOfRooms];
        int[] teacherArray = new int[teachers.size()];
        for (int i = 0; i < numberOfRooms; i++) {
            roomNumbers[i] = i;
            roomCapacities[i] = rooms.get(i).getType().getCapacity();
            roomTypes[i] = rooms.get(i).getType().toInt();
        }
        for (int i = 0; i < teachers.size(); i++) {
            teacherArray[i] = i;
        }

        // Model
        Model model = new Model("University Timetable");

        // Variables
        IntVar[][] timetable = new IntVar[numberOfCourses][4]; //i - subject, [i][0] - room, [i][1] - timeslot, [i][2] - Teacher
        for (int i = 0; i < numberOfCourses; i++) {
            timetable[i][0] = model.intVar("Course_" + i + "_Room", roomNumbers);
            timetable[i][1] = model.intVar("Course_" + i + "_TimeSlot", 0, numberOfTimeSlots - 1);
            timetable[i][2] = model.intVar("Course_" + subjects.get(i).getName() + "_Teacher", 0, teachers.size() - 1);
            timetable[i][3] = model.intVar("Course_" + i + "_Day", days);
        }

        // Constraints
        for (int i = 0; i < numberOfCourses; i++) {
            for (int j = i + 1; j < numberOfCourses; j++) {
                //Constraint sameRoom = model.arithm(timetable[i][0], "=", timetable[j][0]);
                /*Constraint sameTimeSlot = */
                model.or(model.arithm(timetable[i][3], "!=", timetable[j][3]),
                        model.arithm(timetable[i][1], "!=", timetable[j][1])).post();
                //Constraint differentRooms = model.arithm(timetable[i][0], "!=", timetable[j][0]);
                //model.ifThen(sameTimeSlot, differentRooms);
                //model.ifThen(sameRoom, differentRooms);
            }
        }

        for (int i = 0; i < numberOfCourses; i++) {
            model.arithm(timetable[i][0], "<", numberOfRooms).post();
            model.arithm(timetable[i][1], "<", numberOfTimeSlots).post();
            model.arithm(timetable[i][2], "<", teachers.size()).post();

            // Checking for correct room type.
            IntVar roomTypeVar = model.intVar(roomTypes);
            model.element(roomTypeVar, roomTypes, timetable[i][0]).post();
            model.arithm(roomTypeVar, "=", courseRoomTypes[i]).post();

            // Checking for right room capacity.
            IntVar roomCapacityVar = model.intVar(roomCapacities);
            model.element(roomCapacityVar, roomCapacities, timetable[i][0]).post();
            model.arithm(roomCapacityVar, ">=", courseCapacities[i]).post();

            // Finding qualified teacher.
            IntVar teacherVar = model.intVar(teacherArray);
            model.element(teacherVar, teacherArray, timetable[i][2]).post();

            for (int t = 0; t < teachers.size(); t++) {
                for (int s = 0; s < teachers.get(t).getSubjects().size(); s++) {
                    if (teachers.get(t).getSubjects().get(s).equals(subjects.get(i))) {
                        model.arithm(teacherVar, "=", t).post();
                    }
                }
            }
        }

        // Solve and display
        if (model.getSolver().solve()) {
            for (int i = 0; i < numberOfCourses; i++) {
                System.out.println
                        (
                                "Subject " + subjects.get(i).getName()
                                        + " -> Room: " + rooms.get(timetable[i][0].getValue()).getNumber()
                                        + ", Time Slot: " + timetable[i][1].getValue()
                                        + ",  Teacher: " + teachers.get(timetable[i][2].getValue()).getName()
                                        + ", Day: " + timetable[i][3].getValue()
                        );
            }
        } else {
            System.out.println("No solution found.");
        }
    }
}
