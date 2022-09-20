public class SearchTree<T> {

    Nodes<T> root;

    SearchTree() {

    }

    SearchTree(T value) {
        root = new Nodes(value);
    }

    public boolean add(T value) {

        if (root == null) {
            root = new Nodes<>(value);
            return true;
        } else
            return addNode(root, value);
    }

    private boolean addNode(Nodes<T> root, T value) {
        if (root.value == value) return false;
        if ((int) root.value < (int) value) {
            if (root.right != null)
                return addNode(root.right, value);
            else {
                root.right = new Nodes<>(value);
                return true;
            }
        }
        if ((int) root.value > (int) value) {
            if (root.left != null)
                return addNode(root.left, value);
            else {
                root.left = new Nodes<>(value);
                return true;
            }
        }
        return true;
    }

    public boolean find(T value) {
        if (root == null) return false;
        return findNodes(root, value);
    }

    public boolean findNodes(Nodes<T> root, T value) {
        if (root == null) return false;
        if ((int) root.value == (int) value) return true;
        return (int) root.value > (int) value ? findNodes(root.left, value) : findNodes(root.right, value);
    }

    private Nodes<T> findNodesLocationParent(Nodes<T> root, T value, Nodes<T> parent) {
        if (root == null) return null;
        if ((int) root.value == (int) value) return parent;
        return (int) root.value > (int) value ? findNodesLocationParent(root.left, value, root) : findNodesLocationParent(root.right, value, root);
    }

    public boolean remove(T value) {
        if (root == null) return false;
        Nodes<T> parent = findNodesLocationParent(root, value, root);
        Nodes<T> temp;
        if (parent == null) return false;
        if (parent.left != null && parent.left.value == value) temp = parent.left;
        else temp = parent.right;

        if (temp.right == null) {
            if (parent.left == temp) parent.left = parent.left.left;
            else parent.right = parent.right.left;
        } else if (temp.right.left == null) {
            temp.value = temp.right.value;
            temp.right = null;
        } else {
            Nodes<T> smallest = getMostLeft(temp.right);
            temp.value = smallest.left.value;
            if (smallest.left.right != null) {
                smallest = smallest.left.right;
            } else
                smallest.left = null;
        }
        return true;
    }

    private Nodes<T> getMostLeft(Nodes<T> root) {
        if (root.left.left == null) return root;
        return getMostLeft(root.left);
    }


    public T findMAX() {
        if (root == null) return null;
        Nodes<T> temp = root;
        while (temp.right != null)
            temp = temp.right;
        return temp.value;
    }

    void delete(T value) {
        root = deleteRec(root, value);
    }

    Nodes<T> deleteRec(Nodes<T> root, T value) {
        if (root == null)
            return root;

        if ((int)value < (int)root.value)
            root.left = deleteRec(root.left, value);
        else if ((int)value > (int)root.value)
            root.right = deleteRec(root.right, value);

        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.value = minValue(root.right);
            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    T minValue(Nodes<T> root) {
        T minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }
}
