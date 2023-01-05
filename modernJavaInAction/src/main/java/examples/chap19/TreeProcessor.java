package examples.chap19;

public class TreeProcessor {
    public static int lookup(String key, int defaultValue, Tree tree) {
        if (tree == null) {
            return defaultValue;
        }

        if (key.equals(tree.getKey())) {
            return tree.getValue();
        }

        return lookup(key, defaultValue, key.compareTo(tree.getKey()) < 0 ? tree.getLeft() : tree.getRight());
    }

    public static void update(String key, int newValue, Tree tree) {
        if (tree == null) {
            // new add Node
            return;
        }

        if (key.equals(tree.getKey())) {
            tree.setValue(newValue);
            return;
        }

        update(key, newValue, key.compareTo(tree.getKey()) > 0 ? tree.getLeft() : tree.getRight());
    }

    /**
     * update 와 update2 메소드 모두 기존 트리를 변경 한다, 즉 트리에 저장된 맵의 모든 사용자가 변경에 영향을 받는다.
     * 이러한 결과를 파괴적인 갱신이라고 한다.
     * */
    public static Tree update2(String key, int newValue, Tree tree) {
        if (tree == null) {
            tree = new Tree(key, newValue, null, null);
        } else if (key.equals(tree.getKey())) {
            tree.setValue(newValue);
        } else if (key.compareTo(tree.getKey()) < 0) {
            tree.setLeft(update2(key, newValue, tree.getLeft()));
        } else {
            tree.setRight(update2(key, newValue, tree.getRight()));
        }

        return tree;
    }

    public static Tree functionalUdate(String key, int newValue, Tree tree) {
        if (tree == null) {
            return new Tree(key, newValue, null, null);
        }

        if (key.equals(tree.getKey())) {
            return new Tree(key, newValue, tree.getLeft(), tree.getRight());
        }

        if (key.compareTo(tree.getKey()) < 0) {
            return new Tree(
                    tree.getKey(),
                    tree.getValue(),
                    functionalUdate(key, newValue, tree.getLeft()),
                    tree.getRight()
            );
        }

        return new Tree(tree.getKey(), tree.getValue(), tree.getLeft(), functionalUdate(key, newValue, tree.getRight()));
    }
}
