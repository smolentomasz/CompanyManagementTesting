import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertTrue;

public class DepartmentTest {
    @Test
    public void test1(){
        Department newDepartment = new Department("HR_Department",DepartmentType.HR);
        Person newPerson = new Person("s","z",new Date(9,10,1997),"97100407152", Position.HR_ANALYST);
        newDepartment.addNewPerson(newPerson);

        assertTrue(newDepartment.getPersonList().contains(newPerson));
    }
    @Test(expected = IllegalArgumentException.class)
    public void test2(){
        Department newDepartment = new Department("HR_Department",DepartmentType.HR);
        Person newPerson = new Person("s","z",new Date(9,10,1997),"97100407152", Position.CPP_DEVELOPER);
        newDepartment.addNewPerson(newPerson);

    }
    @Test
    public void test3(){
        Department newDepartment = new Department("HR_Department",DepartmentType.HR);
        Department newDepartment2 = new Department("Marketing_Department",DepartmentType.HR);

        Person newPerson = new Person("s","z",new Date(9,10,1997),"03263091831", Position.HR_ANALYST);

        newDepartment.addNewPerson(newPerson);
        newDepartment.shiftPerson(newPerson, newDepartment2);

        assertTrue(newDepartment2.getPersonList().contains(newPerson));
    }
    @Test(expected = IllegalArgumentException.class)
    public void test4(){
        Department newDepartment = new Department("HR_Department",DepartmentType.HR);
        Department newDepartment2 = new Department("Marketing_Department",DepartmentType.MARKETING);

        Person newPerson = new Person("s","z",new Date(9,10,1997),"gh456478941", Position.HR_ANALYST);

        newDepartment.addNewPerson(newPerson);
        newDepartment.shiftPerson(newPerson, newDepartment2);

    }
}
