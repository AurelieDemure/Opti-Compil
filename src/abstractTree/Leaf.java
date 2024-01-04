package abstractTree;

public class Leaf implements Component {
    private String value;

    public Leaf(String value) {
        this.value = value;
    }

    @Override
    public void show() {
        System.out.print("" + value);
    }
}
