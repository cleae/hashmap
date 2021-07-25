package com.tl.main.other;

public class BPlusTreeTest {





    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        BPlusTree tree=new BPlusTree<Integer,String>(4);

        tree.insert(1,"刘一");

        tree.insert(2,"陈二");

        tree.insert(3,"张三");

        tree.insert(4,"李四");

        tree.insert(5,"王五");
//
        tree.insert(6,"赵六");
//
        tree.insert(7,"孙七");
//
        tree.insert(8,"周八");
//
        tree.insert(9,"吴九");
//
        tree.insert(10,"郑十");
        //允许覆盖
        tree.insert(10,"郑十一");
//
//
        tree.insert(11,"zhangsan");
//
        tree.insert(12,"lisi");


        System.out.println(tree.getRoot());

        System.out.println(tree.search(1));
        System.out.println(tree.search(2));
        System.out.println(tree.search(3));
        System.out.println(tree.search(4));
        System.out.println(tree.search(5));


        System.out.println(tree.search(6));







        System.out.println(tree.search(7));


        System.out.println(tree.search(8));

        System.out.println(tree.search(9));

        System.out.println(tree.search(10));

        System.out.println(tree.search(11));

        System.out.println(tree.search(12));



        BPlusTree tree2=new BPlusTree<Integer,String>(4);

        for (int i = 1; i < 50; i++) {
            tree2.insert(i,"value"+i);
        }



        System.out.println("-----------");
        for (int i = 1; i < 50; i++) {
            System.out.println(tree2.search(i));
        }



    }
}
