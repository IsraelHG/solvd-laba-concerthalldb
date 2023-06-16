package com.solvd.laba.database.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Equipment {

    @XmlElement(name="equipmentId")
    @JsonProperty("equipmentId")
    private int equipmentId;

    @XmlElement(name="equipmentName")
    @JsonProperty("equipmentName")
    private String name;

    @XmlElement(name="quantity")
    @JsonProperty("quantity")
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
