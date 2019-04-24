import java.util.Date;
import java.util.Objects;

public class Person {
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    private String name;
    private String surname;
    private Date birthDate;

    public String getPesel() {
        return pesel;
    }

    private String pesel;

    public Position getPosition() {
        return position;
    }

    private Position position;

    public Person(String name, String surname, Date birthDate, String pesel, Position position) {
        if(!PersonList.getInstance().getPeselList().contains(pesel)){
            PersonList.getInstance().getPeselList().add(pesel);
        if(name.equals("") || surname.equals("")){
            throw new IllegalArgumentException("Something is null!");
        }
        if(2019 - birthDate.getYear() < 18){
            throw new IllegalArgumentException("User age is under 18!");
        }
        PeselValidator peselValidator = new PeselValidator(pesel);
        if(!peselValidator.isValid()){
            throw new IllegalArgumentException("Pesel is to small!");
        }
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.pesel = pesel;
        this.position = position;
        }
        else{
            throw new IllegalArgumentException("This person already exist!");
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(birthDate, person.birthDate) &&
                Objects.equals(pesel, person.pesel) &&
                position == person.position;
    }
}
