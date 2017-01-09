package series.serie3;


public class DNACollection {

    private Node_DNA<String> root;

    public DNACollection() {

        root = new Node_DNA<>("root");
    }

    public void add2(String fragment) {

        char[] splitedString = fragment.toCharArray();
        Node_DNA<String> currNode = root;
        for (int i = 0; i <= splitedString.length - 1; i++) {
            int childCount = 0;
            boolean found = false;
            switch (splitedString[i]) {
                case 'A':
                    if (currNode.getChildren().isEmpty()) {
                        Node_DNA<String> child = new Node_DNA<String>("A");
                        currNode.addChild(child);
                        currNode = child;
                    } else {
                        for (Node_DNA<String> children : currNode.getChildren()) {
                            childCount++;
                            if (children.getData().equals("A")) {
                                currNode = children;
                                found = true;
                                break;
                            } else if (childCount == 4) {
                                break;
                            }
                        }
                        if (!found) {
                            currNode.addChild(new Node_DNA<String>("A"));
                        }
                    }
                    break;

                case 'C':
                    if (currNode.getChildren().isEmpty()) {
                        Node_DNA<String> child = new Node_DNA<String>("C");
                        currNode.addChild(child);
                        currNode = child;
                    } else {
                        for (Node_DNA<String> children : currNode.getChildren()) {
                            childCount++;
                            if (children.getData().equals("C")) {
                                currNode = children;
                                break;
                            } else if (childCount == 4) {
                                break;
                            }
                        }
                        if (childCount < 4) {
                            currNode.addChild(new Node_DNA<String>("C"));
                        }
                    }
                    break;

                case 'T':
                    if (currNode.getChildren().isEmpty()) {
                        Node_DNA<String> child = new Node_DNA<String>("T");
                        currNode.addChild(child);
                        currNode = child;
                    } else {
                        for (Node_DNA<String> children : currNode.getChildren()) {
                            childCount++;
                            if (children.getData().equals("T")) {
                                currNode = children;
                                break;
                            } else if (childCount == 4) {
                                break;
                            }
                        }
                        if (childCount < 4) {
                            currNode.addChild(new Node_DNA<String>("T"));
                        }
                    }
                    break;
            }

        }

    }


    public void add(String fragment) {

        char[] splitedString = fragment.toCharArray();
        Node_DNA<String> currNode = root;
        for (int i = 0; i <= splitedString.length - 1; i++) {
            currNode = getStringDNANode(splitedString[i], currNode);
        }

    }

    private Node_DNA<String> getStringDNANode(char c, Node_DNA<String> currNode) {
        int childCount = 0;
        boolean found = false;
        if (currNode.getChildren().isEmpty()) {
            Node_DNA<String> child = new Node_DNA<>(String.valueOf(c));
            currNode.addChild(child);
            currNode = child;
        } else {
            for (Node_DNA<String> children : currNode.getChildren()) {
                childCount++;
                if (children.getData().equals(String.valueOf(c))) {
                    currNode = children;
                    found = true;
                    break;
                } else if (childCount == 4) {
                    break;
                }
            }
            if (!found) {
                currNode.addChild(new Node_DNA<>(String.valueOf(c)));
            }
        }
        return currNode;
    }

}
