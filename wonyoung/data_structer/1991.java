package wonyoung.data_structer;

import java.io.*;
import java.util.*;

class Main {

    public static class Child {
        String left;
        String right;

        public Child(String left, String right){
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws Exception {
        // for coding
        System.setIn(new FileInputStream("./input/input_1991.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        HashMap<String, Child> tree = new HashMap<String, Child>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String val = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            tree.put(val, new Child(left, right));
        }

        StringBuilder sb = new StringBuilder();

        preorder(sb, tree, "A");
        sb.append("\n");

        inorder(sb, tree, "A");
        sb.append("\n");

        postorder(sb, tree, "A");
        System.out.println(sb.toString());

    }

    public static void preorder(StringBuilder sb, HashMap<String, Child> tree, String parent){
        if(parent.equals(".")) return;
        sb.append(parent);
        Child c = tree.get(parent);
        preorder(sb, tree, c.left);
        preorder(sb, tree, c.right);
    }

    public static void inorder(StringBuilder sb, HashMap<String, Child> tree, String parent){
        if(parent.equals(".")) return;
        Child c = tree.get(parent);
        inorder(sb, tree, c.left);
        sb.append(parent);
        inorder(sb, tree, c.right);

    }

    private static void postorder(StringBuilder sb, HashMap<String, Child> tree, String parent) {
        if(parent.equals(".")) return;
        Child c = tree.get(parent);
        postorder(sb, tree, c.left);
        postorder(sb, tree, c.right);
        sb.append(parent);
    }

}