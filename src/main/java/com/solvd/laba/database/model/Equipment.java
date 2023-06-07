package com.solvd.laba.database.model;

public class Equipment {
    private int equipmentId;
    private String name;
    private int quantity;

    public Equipment() {}

    public Equipment(int equipmentId, String name, int quantity) {
        this.equipmentId = equipmentId;
        this.name = name;
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "Equipments{" +
                "equipmentId=" + equipmentId +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
