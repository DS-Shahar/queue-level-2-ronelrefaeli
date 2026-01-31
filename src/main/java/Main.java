
    public static int EX12(BinNode<Integer> node) {
        if (node == null)
            return 0;
        int c = (node.getValue() >= 10 && node.getValue() < 100) ? 1 : 0;
        return c + EX12(node.getLeft()) + EX12(node.getRight());
    }

    public static int EX14(BinNode<?> node) {
        if (node == null)
            return 0;
        if (!node.hasLeft() && !node.hasRight())
            return 1;
        return EX14(node.getLeft()) + EX14(node.getRight());
    }

    public static int EX16(BinNode<Integer> node) {
        if (node == null)
            return 0;
        int sum = 0;
        if (node.hasLeft() && node.hasRight())
            sum = node.getValue();
        return sum + EX16(node.getLeft()) + EX16(node.getRight());
    }

    public static int EX17(BinNode<Double> node) {
        if (node == null)
            return 0;
        int c = 0;
        if (node.hasLeft() && node.hasRight() &&
            node.getLeft().getValue() % 1 != 0 &&
            node.getRight().getValue() % 1 != 0)
            c = 1;
        return c + EX17(node.getLeft()) + EX17(node.getRight());
    }
}
