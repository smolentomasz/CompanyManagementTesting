import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CompanyTest {
    @Test
    public void test1(){
        Person andrzej = new Person("Andrzej", "Andrzej", new Date(1998,4,3),"98040312977", Position.JAVA_DEVELOPER);
        Person zygmunt = new Person("Zygmunt", "Zygmunt", new Date(1997,10,4),"97100407152", Position.MARKETING_RESEARCH_SPECIALIST);
        Person miroslaw = new Person("Mirosław", "Mirosław", new Date(1998,3,31),"98033110205", Position.JAVA_DEVELOPER);
        Person dominik = new Person("Dominik","Dominik", new Date(1997,7,27), "97072702938", Position.HR_ANALYST);

        Department developmentDepartment = new Department("DEVELOPMENT_department", DepartmentType.DEVELOPMENT);
        developmentDepartment.addNewPerson(andrzej);
        developmentDepartment.addNewPerson(miroslaw);

        Department marketingDepartment = new Department("MARKETING_department",DepartmentType.MARKETING);
        marketingDepartment.addNewPerson(zygmunt);

        Department hrDepartment = new Department("HR_department", DepartmentType.HR);
        hrDepartment.addNewPerson(dominik);

        Department hrDepartment2 = new Department("HR_department", DepartmentType.HR);

        Localisation krakow = new Localisation("Krakow", "Krakow");
        krakow.addDepartment(developmentDepartment);
        krakow.addDepartment(marketingDepartment);

        Localisation warsaw = new Localisation("Warsaw", "Warsaw");
        warsaw.addDepartment(hrDepartment);
        krakow.addDepartment(hrDepartment2);

        Company company1 = new Company(miroslaw,dominik,zygmunt);
        company1.addLocalisation(krakow);
        company1.addLocalisation(warsaw);

        int workersAmount = company1.checkAmount();

        hrDepartment.shiftPerson(zygmunt, hrDepartment2);

        assertEquals(workersAmount,company1.checkAmount());
    }
    @Test
    public void test2(){
        Person maciej = new Person("Maciej", "Maciej", new Date(1998,4,3),"72070212577", Position.JAVA_DEVELOPER);
        Person krzysztof = new Person("Krzysztof", "Krzysztof", new Date(1997,10,4),"93062047333", Position.MARKETING_RESEARCH_SPECIALIST);
        Person benek = new Person("Benek", "Benek", new Date(1998,3,31),"71050838954", Position.JAVA_DEVELOPER);
        Person jan = new Person("Jan","Jan", new Date(1997,7,27), "52101816235", Position.HR_ANALYST);

        Department developmentDepartment = new Department("DEVELOPMENT_department", DepartmentType.DEVELOPMENT);
        developmentDepartment.addNewPerson(maciej);
        developmentDepartment.addNewPerson(benek);

        Department marketingDepartment = new Department("MARKETING_department",DepartmentType.MARKETING);
        marketingDepartment.addNewPerson(krzysztof);

        Department hrDepartment = new Department("HR_department", DepartmentType.HR);
        hrDepartment.addNewPerson(jan);

        Department hrDepartment2 = new Department("HR_department", DepartmentType.HR);

        Localisation lodz = new Localisation("Łódź", "Łódź");
        lodz.addDepartment(developmentDepartment);
        lodz.addDepartment(marketingDepartment);

        Localisation poznan = new Localisation("Poznań", "Poznań");
        poznan.addDepartment(hrDepartment);
        lodz.addDepartment(hrDepartment2);

        Company company2 = new Company(benek,jan,krzysztof);
        company2.addLocalisation(lodz);
        company2.addLocalisation(poznan);

        int workersAmount = company2.checkAmount();

        lodz.shiftDepartment(developmentDepartment, poznan);

        assertEquals(workersAmount,company2.checkAmount());
    }
}
