package abstractTree;

import java.util.ArrayList;

public class Node implements Component {
    private String value;
    private ArrayList<Component> children;



    public Node(String value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public ArrayList<Component> getChildren() {
        return children;
    }

    public void addChild(Component child) {
        this.children.add(child);
    }

    public void removeChild(Component child) {
        this.children.remove(child);
    }

    @Override
    public void show() {
        System.out.print("" + value);
    }

    public Component getFils(int index){
        return this.children.get(index);
    }
}
