import java.util.ArrayList;
import java.util.List;

class Repository<T> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public T get(int index) {
        return items.get(index);
    }

    public List<T> getAll() {
        return items;
    }
}

public class RepositoryDemo {
    public static void main(String[] args) {
        Repository<String> users = new Repository<>();
        users.add("Debasish");
        users.add("Sahoo");

        Repository<Integer> scores = new Repository<>();
        scores.add(100);
        scores.add(95);

        System.out.println(users.getAll());
        System.out.println(scores.getAll());
    }
}

