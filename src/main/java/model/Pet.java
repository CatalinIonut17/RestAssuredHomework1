package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pet {
    private Integer id;
    private String name;
    private String brithDate;
    private Owner owner;
    private PetType type;
    private Visit visit;

    public Pet() {
    }

    public Pet(String name, String brithDate, Owner owner, PetType type, Visit visit) {
        this.name = name;
        this.brithDate = brithDate;
        this.owner = owner;
        this.type = type;
        this.visit = visit;
    }

    public Pet(Integer id, String name, String brithDate, Owner owner, PetType type, Visit visit) {
        this.id = id;
        this.name = name;
        this.brithDate = brithDate;
        this.owner = owner;
        this.type = type;
        this.visit = visit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(String brithDate) {
        this.brithDate = brithDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return Objects.equals(name, pet.name) && Objects.equals(brithDate, pet.brithDate) && Objects.equals(owner, pet.owner) && Objects.equals(type, pet.type) && Objects.equals(visit, pet.visit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, brithDate, owner, type, visit);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brithDate='" + brithDate + '\'' +
                ", owner=" + owner +
                ", type=" + type +
                ", visit=" + visit +
                '}';
    }
}
