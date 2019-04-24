import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Company {
    private Person CEO;
    private Person CTO;
    private Person CFO;
    private List<Localisation> localisationList;


    public Company(Person CEO, Person CTO, Person CFO) {
        this.CEO = CEO;
        this.CTO = CTO;
        this.CFO = CFO;
        this.localisationList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Company{" +
                "CEO=" + CEO.toString() +
                ", CTO=" + CTO.toString() +
                ", CFO=" + CFO.toString() +
                ", localisationList=" + localisationList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return Objects.equals(CEO, company.CEO) &&
                Objects.equals(CTO, company.CTO) &&
                Objects.equals(CFO, company.CFO) &&
                Objects.equals(localisationList, company.localisationList);
    }
    public void addLocalisation (Localisation newLocalisation){
        this.localisationList.add(newLocalisation);
    }
    public void deleteLocalisation(Localisation selectLocalisation){
        for(Localisation i: localisationList){
            if(i.equals(selectLocalisation)){
                this.localisationList.remove(selectLocalisation);
            }
        }
    }
    public int checkAmount(){
        int amount = 0;
        for(Localisation i: this.localisationList){
            for(Department j: i.getDepartmentList()){
                amount += j.getPersonList().size();
            }
        }
        return amount;
    }
}
