public static int tree12(BinNode<Integer> t){
    if(t==null)
        return 0;
    if(t.getValue()==10 || t.getValue()<100)
        return 1 + tree12(t.getLeft()) + tree12(t.getRight());
    return tree12(t.getLeft()) + tree12(t.getRight());
}

public static int tree14(BinNode<Integer> t){
    if(t==null)
        return 0;
    if(t.getLeft()==null && t.getRight()==null)
        return 1;
    return tree14(t.getLeft()) + tree14(t.getRight());
}

public static int tree16(BinNode<Integer> t){
    if(t==null)
        return 0;
    if(t.getLeft()!=null && t.getRight()!=null)
        return t.getValue() + tree16(t.getLeft()) + tree16(t.getRight());
    return tree16(t.getLeft()) + tree16(t.getRight());
}

public static int tree17(BinNode<Integer> t){
    if(t==null)
        return 0;
    if(t.getLeft()!=null && t.getRight()!=null &&!(t.getLeft().getLeft()==null && t.getLeft().getRight()==null) &&!(t.getRight().getLeft()==null && t.getRight().getRight()==null))
        return 1 + tree17(t.getLeft()) + tree17(t.getRight());
    return tree17(t.getLeft()) + tree17(t.getRight());
}

public static boolean tree18(BinNode<Integer> t1, BinNode<Integer> t2){
    return sumTree(t1) > sumTree(t2);
}

public static int sumTree(BinNode<Integer> t){
    if(t==null)
        return 0;
    return t.getValue() + sumTree(t.getLeft()) + sumTree(t.getRight());
}

public static boolean tree20(BinNode<Integer> t, int n){
    boolean[] arr = new boolean[n+1];
    if(!checkTree(t, arr))
        return false;
    for(int i=1;i<=n;i++){
        if(!arr[i])
            return false;
    }
    return true;
}

public static boolean checkTree(BinNode<Integer> t, boolean[] arr){
    if(t==null)
        return true;
    int x = t.getValue();
    if(x<1 || x>=arr.length || arr[x])
        return false;
    arr[x]=true;
    return checkTree(t.getLeft(),arr) && checkTree(t.getRight(),arr);
}
