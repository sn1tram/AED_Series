package series.serie3;

import java.util.ArrayList;
import java.util.List;

public class Node_DNA<String> {
    private List<Node_DNA<String>> children = new ArrayList<Node_DNA<String>>();
    private Node_DNA<String> parent = null;
    private String data = null;
    public boolean isSequenceTerminator = false;

    public Node_DNA(String data) {
        this.data = data;
    }

    public Node_DNA(String data, Node_DNA<String> parent) {
        this.data = data;
        this.parent = parent;
    }

    public List<Node_DNA<String>> getChildren() {
        return children;
    }

    public void addChild(String data) {
        Node_DNA<String> child = new Node_DNA<String>(data);
        this.children.add(child);
    }

    public void addChild(Node_DNA<String> child) {
        this.children.add(child);
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        if (this.children.size() == 0)
            return true;
        else
            return false;
    }

    public void removeParent() {
        this.parent = null;
    }
}
