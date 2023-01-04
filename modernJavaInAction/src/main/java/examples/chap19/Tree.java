package examples.chap19;

public class Tree {
    private String key;
    private int value;
    private Tree left, right;

    public Tree(String key, int value, Tree left, Tree right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }
}
