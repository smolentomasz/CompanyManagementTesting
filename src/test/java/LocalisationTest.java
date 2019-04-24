import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class LocalisationTest {
    @Test
    public void test1(){
        Localisation localisation1 = new Localisation("First","NY");
        Localisation localisation2 = new Localisation("Second", "LA");

        Department newDepartment = new Department("Mark_department",DepartmentType.MARKETING);
        localisation1.addDepartment(newDepartment);
        localisation1.shiftDepartment(newDepartment, localisation2);
        assertTrue(localisation2.getDepartmentList().contains(newDepartment));
    }
    @Test(expected = IllegalArgumentException.class)
    public void test2(){
        Localisation localisation1 = new Localisation("Second", "LA");

        Department newDepartment = new Department("Mark_department",DepartmentType.MARKETING);
        Department newDepartment2 = new Department("Mark_department",DepartmentType.MARKETING);

        localisation1.addDepartment(newDepartment);
        localisation1.addDepartment(newDepartment2);

    }
}
