public class BinaryPeerTree {

    private void addPeerApproachTwo(Node root) {
        if (root == null)
            return;
        if (root != null) {
            Node neighbor = null;
            if (root.left != null) {
                if (root.right != null)
                    root.left.peer = root.right;
                else {
                    neighbor = getNeighbor(root);
                    root.left.peer = neighbor;
                }
            }
            if (root.right != null) {
                neighbor = getNeighbor(root);
                root.right.peer = neighbor;
            }
        }
        addPeerApproachTwo(root.left);
        addPeerApproachTwo(root.right);
    }

    private Node getNeighbor(Node node) {
        while (node.peer != null) {
            if (node.peer.left != null) {
                return node.peer.left;
            } else if (node.peer.right != null) {
                return node.peer.right;
            }
            node = node.peer;
        }
        return null;
    }

    public class Node {
        Node left, right, peer;
        public Node(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

}
