package model;

import java.util.Objects;

public class Visit {
    private Integer id;
    private String date;
    private String description;
    private Owner owner;
    private Pet pet;
    private Type type;

    public Visit() {
    }

    public Visit(String date, String description, Owner owner, Pet pet, Type type) {
        this.date = date;
        this.description = description;
        this.owner = owner;
        this.pet = pet;
        this.type = type;
    }

    public Visit(Integer id, String date, String description, Owner owner, Pet pet, Type type) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.owner = owner;
        this.pet = pet;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visit)) return false;
        Visit visit = (Visit) o;
        return Objects.equals(date, visit.date) && Objects.equals(description, visit.description) && Objects.equals(owner, visit.owner) && Objects.equals(pet, visit.pet) && Objects.equals(type, visit.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, description, owner, pet, type);
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", descrption='" + description + '\'' +
                ", owner=" + owner +
                ", pet=" + pet +
                ", type=" + type +
                '}';
    }
}
