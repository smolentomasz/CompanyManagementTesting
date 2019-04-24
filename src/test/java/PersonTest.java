import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class PersonTest {
    @Test(expected = IllegalArgumentException.class)
    public void test(){
        Person nowaOsoba = new Person("","a",new Date(9,10,1997),"97100407152", Position.CPP_DEVELOPER);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test2(){
        Person nowaOsoba = new Person("a","",new Date(9,10,1997),"97100407152", Position.CPP_DEVELOPER);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test3(){
        Person nowaOsoba = new Person("a","a",new Date(9,10,1997),"456", Position.CPP_DEVELOPER);
    }
    @Test
    public void test4(){
        Person nowaOsoba = new Person("s","z",new Date(9,10,1997),"03263091831", Position.CPP_DEVELOPER);
        assertNotNull(nowaOsoba);

        assertEquals(nowaOsoba.getPesel(), "03263091831");
        assertEquals(nowaOsoba.getName(), "s");
        assertEquals(nowaOsoba.getSurname(), "z");
        assertEquals(nowaOsoba.getBirthDate(), new Date(9,10,1997));

    }
}
