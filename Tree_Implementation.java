import java.util.*;

public class Tree_Implementation {
    static class Node {
        String data;
        List<Node> children;

        public Node(String data) {
            this.data = data;
            this.children = new ArrayList<>();
        }

        public void addChild(Node child) {
            this.children.add(child);
        }
    }

    static class Tree {
        Node root;

        public Tree(String rootData) {
            this.root = new Node(rootData);
        }

        public void printTree(Node node, String indent) {
            if (node == null)
                return;
            System.out.println(indent + "- " + node.data);
            for (Node child : node.children) {
                printTree(child, indent + "  ");
            }
        }

        public void printTree() {
            printTree(root, "");
        }

        public Node search(Node node, String target) {
            if (node == null)
                return null;
            if (node.data.equals(target))
                return node;

            for (Node child : node.children) {
                Node found = search(child, target);
                if (found != null)
                    return found;
            }

            return null;
        }

        public Node search(String target) {
            return search(root, target);
        }

        public boolean addChild(String parentData, String childData) {
            Node parentNode = search(parentData);
            if (parentNode == null)
                return false;
            parentNode.addChild(new Node(childData));
            return true;
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree("Root");

        tree.addChild("Root", "Child1");
        tree.addChild("Root", "Child2");
        tree.addChild("Child1", "Child1.1");
        tree.addChild("Child1", "Child1.2");
        tree.addChild("Child2", "Child2.1");

        System.out.println("Tree structure:");
        tree.printTree();

        String searchValue = "Child1.2";
        Node foundNode = tree.search(searchValue);
        if (foundNode != null) {
            System.out.println("\nNode '" + searchValue + "' found in the tree.");
        } else {
            System.out.println("\nNode '" + searchValue + "' not found.");
        }
    }
}
