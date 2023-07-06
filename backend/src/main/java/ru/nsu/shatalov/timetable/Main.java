package ru.nsu.shatalov.timetable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);

    /*    TimetableGenerator generator = new TimetableGenerator();

    Subject[] subjects = {
      new Subject("Math", RoomType.Lecture, SubjectType.Lecture),
      new Subject("Math Seminar", RoomType.General, SubjectType.Seminar),
      new Subject("Computer Science", RoomType.Lecture, SubjectType.Lecture),
      new Subject("Bioinformatics", RoomType.Lecture, SubjectType.Lecture),
      new Subject("System Design", RoomType.Lecture, SubjectType.Lecture)
    };

    Room[] rooms = {
      new Room("1101", RoomType.General),
      new Room("1102t", RoomType.Terminal),
      new Room("1103", RoomType.Lecture),
      new Room("1104", RoomType.General),
      new Room("1105t", RoomType.Terminal),
      new Room("1106", RoomType.Lecture),
    };

    Teacher[] teachers = {
      new Teacher("Alexander", List.of(subjects[0]), List.of(Day.Monday, Day.Tuesday)),
      new Teacher("Anton", List.of(subjects[1]), List.of(Day.Tuesday, Day.Wednesday)),
      new Teacher(
          "Vladimir", List.of(subjects[2], subjects[3]), List.of(Day.Tuesday, Day.Thursday)),
      new Teacher("Maksim", List.of(subjects[4]), List.of(Day.Wednesday, Day.Friday))
    };

    ArrayList<StudentGroup> studentGroups =
        new ArrayList<>(
            List.of(
                new StudentGroup("20213", List.of(subjects)),
                new StudentGroup("20214", List.of(subjects)),
                new StudentGroup("20215", List.of(subjects[0]))));

    ArrayList<TimeSlot> timeSlots =
        new ArrayList<>(List.of(new TimeSlot(900), new TimeSlot(1050), new TimeSlot(1240)));*/
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry
            .addMapping("/**")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("GET", "POST", "PUT", "DELETE");
      }
    };
  }
}
