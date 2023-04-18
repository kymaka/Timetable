package ru.nsu.shatalov.timetable.generator;

import java.util.List;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;
import ru.nsu.shatalov.timetable.model.constraint.Subject;

public class TimetableGenerator {

    public void generate(List<Subject> subjects) {
        int numberOfCourses = subjects.size();
        int numberOfRooms = 3;
        int numberOfTimeSlots = 5;
        int[] courseCapacities = {50, 20, 60, 40};
        int[] roomNumbers = {0, 1, 2};
        int[] roomCapacities = {30, 40, 60};

        // Model
        Model model = new Model("University Timetable");

        // Variables
        IntVar[][] timetable = new IntVar[numberOfCourses][2]; //i - subject, [i][0] - room, [i][1] - timeslot
        for (int i = 0; i < numberOfCourses; i++) {
            timetable[i][0] = model.intVar("Course_" + i + "_Room", roomNumbers);
            timetable[i][1] = model.intVar("Course_" + i + "_TimeSlot", 0, numberOfTimeSlots - 1);
        }

        // Constraints
        for (int i = 0; i < numberOfCourses; i++) {
            for (int j = i + 1; j < numberOfCourses; j++) {
                //Constraint sameRoom = model.arithm(timetable[i][0], "=", timetable[j][0]);
                /*Constraint sameTimeSlot = */
                model.arithm(timetable[i][1], "!=", timetable[j][1]).post();
                //Constraint differentRooms = model.arithm(timetable[i][0], "!=", timetable[j][0]);
                //model.ifThen(sameTimeSlot, differentRooms);
                //model.ifThen(sameRoom, differentRooms);
            }
        }

        for (int i = 0; i < numberOfCourses; i++) {
            model.arithm(timetable[i][0], "<", numberOfRooms).post();
            model.arithm(timetable[i][1], "<", numberOfTimeSlots).post();

            IntVar roomCapacityVar = model.intVar(roomCapacities);
            model.element(roomCapacityVar, roomCapacities, timetable[i][0]).post();
            model.arithm(roomCapacityVar, ">=", courseCapacities[i]).post();
        }

        // Solve and display
        if (model.getSolver().solve()) {
            for (int i = 0; i < numberOfCourses; i++) {
                System.out.println("Subject " + subjects.get(i).getName() + " -> Room: "
                        + timetable[i][0].getValue() + ", Time Slot: "
                        + timetable[i][1].getValue());
            }
        } else {
            System.out.println("No solution found.");
        }
    }
}
