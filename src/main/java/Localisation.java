import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Localisation {
    private String name;
    private String city;

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    private List<Department> departmentList;

    public Localisation(String name, String city) {
        this.name = name;
        this.city = city;
        this.departmentList = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Localisation)) return false;
        Localisation that = (Localisation) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(city, that.city) &&
                Objects.equals(departmentList, that.departmentList);
    }

    @Override
    public String toString() {
        return "Localisation{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", departmentList=" + departmentList +
                '}';
    }
    public void addDepartment(Department newDepartment){
        for(Department i: this.departmentList){
            if(i.getDepartmentType() == newDepartment.getDepartmentType()){
                throw new IllegalArgumentException("Wrong department!");
            }
        }
        this.departmentList.add(newDepartment);

    }
    public void deleteDepartment(Department selectDepartment){
        for(Department i: departmentList){
            if(i.equals(selectDepartment)){
                this.departmentList.remove(selectDepartment);
            }
        }
    }
    public void shiftDepartment(Department departmentToShift, Localisation toShift){
        if(this.departmentList.contains(departmentToShift)){
            toShift.addDepartment(departmentToShift);
            this.departmentList.remove(departmentToShift);
        }
    }
}
