package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Visit {
    private Integer id;
    private String date;
    private String description;
    //private Pet pet;
    //private Owner owner;
    //private PetType Type;

    public Visit() {
    }

    public Visit(String date, String description, Pet pet, Owner owner, PetType type) {
        this.date = date;
        this.description = description;
        //this.pet = pet;
        //this.owner = owner;
        //Type = type;
    }

    public Visit(Integer id, String date, String description, Pet pet, Owner owner, PetType type) {
        this.id = id;
        this.date = date;
        this.description = description;
        //this.pet = pet;
        //this.owner = owner;
        //Type = type;
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

    /*public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public PetType getType() {
        return Type;
    }

    public void setType(PetType type) {
        Type = type;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visit)) return false;
        Visit visit = (Visit) o;
        return Objects.equals(date, visit.date) && Objects.equals(description, visit.description)
                /*&& Objects.equals(pet, visit.pet) && Objects.equals(owner, visit.owner) && Objects.equals(Type, visit.Type)*/;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, description/*, pet, owner, Type*/);
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                /*", pet=" + pet +
                ", owner=" + owner +
                ", Type=" + Type +*/
                '}';
    }
}
