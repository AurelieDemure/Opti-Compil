package parse_tree;

import abstractTree.*;
public interface AbstractExpression {
    public Component interpret();
    void show();
}
