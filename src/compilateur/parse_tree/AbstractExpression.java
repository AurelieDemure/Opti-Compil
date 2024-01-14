package compilateur.parse_tree;

import compilateur.abstractTree.*;

public interface AbstractExpression {
    public Component interpret();
    void show();
}
