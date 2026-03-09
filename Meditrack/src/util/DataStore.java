package util;
import java.util.ArrayList;
import java.util.List;

public class DataStore<T> {

    private List<T> data = new ArrayList<>();

    public void add(T obj) {
        data.add(obj);
    }

    public List<T> getAll() {
        return data;
    }
}
