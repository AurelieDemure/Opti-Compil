package abstractTree;

import java.util.ArrayList;

public class AbstractTree {
    public static void showAsAbstractTree(Component component, String indentation, boolean dernier) {
        System.out.print(indentation);
        if (dernier) {
            System.out.print("|__ ");
        } else {
            System.out.print("|__ ");
        } component.show();


        if (component instanceof Node) {
            ArrayList<Component> children = ((Node) component).getChildren();
            if (children.size() > 0) {
                System.out.println();
            }
            for (int i=0; i<children.size(); i++) {
                String indentationBis = indentation + (dernier? "    " : "|    ");
                showAsAbstractTree(children.get(i), indentationBis, i == (children.size()-1));
            }
        } else {
            System.out.println();
        }
    }
}
