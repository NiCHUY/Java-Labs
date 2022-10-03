public class BinaryTree <T extends Comparable<T>> {
    private Node rootNode;
    public BinaryTree(){
        rootNode = null;
    }

    public class Node {
        private
        T value;
        Node left;
        Node right;

        public Node(T value){
            this.value = value;
        }
        public Node(){}
        public T getValue(){
            return this.value;
        }
        public void setValue(T value){
            this.value = value;
        }
        public Node getLeft(){
            return this.left;
        }
        public Node getRight(){
            return this.right;
        }
        public void setLeft(Node node){
            this.left = node;
        }
        public void setRight(Node node){
            this.right = node;
        }
    }

    public void addNodeByValue(T value){
        Node nodeNew = new Node(value);
        if (rootNode == null){
            rootNode = nodeNew;
        }else {
            Node current = rootNode;
            while (nodeNew != null){
                Node parent = current;
                if (value.compareTo(current.getValue()) == 0){
                    nodeNew = null;
                    return;
                } else if (value.compareTo(current.getValue()) < 0) {
                    current = current.getLeft();
                    if (current == null){
                        parent.setLeft(nodeNew);
                        nodeNew = null;
                        return;
                    }
                }else{
                    current = current.getLeft();
                    if (current == null){
                        parent.setRight(nodeNew);
                        nodeNew = null;
                        return;
                    }
                }

            }
        }
    }

    public Node findNodeByValue(T value){
        Node current = rootNode;
        while (!(current.getValue().compareTo(value) == 0)){
            if (value.compareTo(current.getValue()) < 0){
                System.out.printf("left ");
                current = current.getLeft();
            }else {
                System.out.printf("right ");
                current = current.getRight();
            }
            if (current == null){
                System.out.println("Node not found");
                return null;
            }
        }
        System.out.println("Node found");
        return current;
    }

    public void deleteNodeByValue(T value){
        deleteNodeByValue(rootNode, value);
    }

    private Node deleteNodeByValue(Node node, T value){
        if (node == null) {
            return null;
        }
        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(deleteNodeByValue(node.getLeft(), value));
        } else if (value.compareTo(node.getValue()) > 0) {
            node.setRight(deleteNodeByValue(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getRight();
            } else {
                Node finalWay = node.getLeft();
                while (finalWay.getRight() != null) {
                    finalWay = finalWay.getRight();
                }
                finalWay.setRight(node.getRight());
                return node.getLeft();
            }
        }
        return node;
    }
    public void inorderTreeWalk() {
        inorderTreeWalk(rootNode);
    }

    private void inorderTreeWalk(Node node) {
        if (node != null) {
            inorderTreeWalk(node.getLeft());
            System.out.println(node.getValue().toString());
            inorderTreeWalk(node.getRight());
        }
    }

    public void preorderTreeWalk() {
        preorderTreeWalk(rootNode);
    }

    private void preorderTreeWalk(Node node) {
        if (node != null) {
            System.out.println(node.getValue());
            preorderTreeWalk(node.getLeft());
            preorderTreeWalk(node.getRight());
        }
    }

    public void postorderTreeWalk() {
        postorderTreeWalk(rootNode);
    }

    private void postorderTreeWalk(Node node) {
        if (node != null) {
            postorderTreeWalk(node.getLeft());
            postorderTreeWalk(node.getRight());
            System.out.println(node.getValue());
        }
    }
}
