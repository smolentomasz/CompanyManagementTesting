import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {
    private String name;

    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    private DepartmentType departmentType;

    public List<Person> getPersonList() {
        return personList;
    }

    private List<Person> personList;

    public Department(String name, DepartmentType departmentType) {
        this.name = name;
        this.departmentType = departmentType;
        this.personList = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) &&
                departmentType == that.departmentType &&
                Objects.equals(personList, that.personList);
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", departmentType=" + departmentType +
                ", personList=" + personList +
                '}';
    }

    public void addNewPerson(Person newPerson){

            if(departmentType == DepartmentType.HR && (newPerson.getPosition() == Position.HR_ANALYST || newPerson.getPosition() == Position.TRAINING_MANAGER)){
                this.personList.add(newPerson);
            }
            else if(departmentType == DepartmentType.MARKETING && (newPerson.getPosition() == Position.MARKETING_CONSULTANT || newPerson.getPosition() == Position.MARKETING_RESEARCH_SPECIALIST)){
                this.personList.add(newPerson);
            }
            else if(departmentType == DepartmentType.DEVELOPMENT && (newPerson.getPosition() == Position.JAVA_DEVELOPER || newPerson.getPosition() == Position.CPP_DEVELOPER)){
                this.personList.add(newPerson);
            }
            else
                throw new IllegalArgumentException("Wrong type of department!");
    }
    public void removePerson(Person selectPerson){
        for(Person i: personList){
            if(i.equals(selectPerson)){
                this.personList.remove(selectPerson);
            }
        }
    }
    public void shiftPerson(Person personToShift, Department toShift){
        if(this.personList.contains(personToShift)){
            toShift.addNewPerson(personToShift);
            this.personList.remove(personToShift);
        }
    }
}
