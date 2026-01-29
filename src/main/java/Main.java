public class Main 
{

    public static void main(String[] args) 
    {

        BinNode<Integer> n1 = new BinNode<>(1);
        BinNode<Integer> n3 = new BinNode<>(3);
        BinNode<Integer> n5 = new BinNode<>(5);
        BinNode<Integer> n7 = new BinNode<>(7);

        BinNode<Integer> n2 = new BinNode<>(n1, 2, n3);
        BinNode<Integer> n6 = new BinNode<>(n5, 6, n7);

        BinNode<Integer> root = new BinNode<>(n2, 4, n6);

        System.out.println("Leaves count: " + countLeaves(root));
    }

    public static <T> int countLeaves(BinNode<T> node) 
    {
        if (node == null)
            return 0;
        if (!node.hasLeft() && !node.hasRight())
            return 1;
        return countLeaves(node.getLeft()) + countLeaves(node.getRight());
    }
}
public static <T> boolean allRightHaveLeft(BinNode<T> root) 
{
    if (root == null)
        return true;

    if (root.getRight() != null && root.getLeft() == null)
        return false;

    return allRightHaveLeft(root.getLeft()) && allRightHaveLeft(root.getRight());
}

