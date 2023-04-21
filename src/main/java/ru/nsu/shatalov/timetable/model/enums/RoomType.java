package ru.nsu.shatalov.timetable.model.enums;

public enum RoomType {
    Terminal("Terminal", 20),
    Lecture("Lecture", 200),
    General("General", 50);

    RoomType(String label, int capacity) {
        this.label = label;
        this.capacity = capacity;
    }
    private final String label;

    private final int capacity;

    public String getLabel() {
        return label;
    }

    public int getCapacity() {
        return capacity;
    }
}
