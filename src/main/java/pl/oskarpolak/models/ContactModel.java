package pl.oskarpolak.models;

public class ContactModel {
    private String number;
    private String name;
    private String lastname;

    public ContactModel(String number, String name, String lastname) {
        this.number = number;
        this.name = name;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "ContactModel{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
