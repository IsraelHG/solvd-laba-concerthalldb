package com.solvd.laba.database.model;

import java.util.ArrayList;

public class Equipment {
    private int equipmentId;
    private String name;
    private int quantity;
    private ArrayList<Event> events;

    public Equipment(int equipmentId, String name, int quantity) {
        this.equipmentId = equipmentId;
        this.name = name;
        this.quantity = quantity;
        this.events = new ArrayList<>();
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Equipments{" +
                "equipmentId=" + equipmentId +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", events=" + events +
                '}';
    }
}
