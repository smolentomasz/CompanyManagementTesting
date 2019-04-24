import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private static PersonList ourInstance = new PersonList();

    public static PersonList getInstance() {
        return ourInstance;
    }

    public List<String> getPeselList() {
        return peselList;
    }

    private List<String> peselList = new ArrayList<>();
    private PersonList() {

    }
}
