package com.tl.main.other;


import java.util.ArrayList;
import java.util.List;

/**
 * 测试b+树
 * @author lintan
 * @param <K>
 * @param <V>
 */
public class BPlusTree<K extends Comparable<K>,V> {

    /**
     * B+树的阶，即节点最多的子节点数目  默认为3
     */
    private static final int default_branch=3;

    /**
     * B+树的阶
     */
    private int branch;

    /**
     * 根节点
     */
    private Node root;

    //get
    public Node getRoot(){
        return root;
    }

    public BPlusTree(){
        this(default_branch);
    }

    public BPlusTree(int branch){
        if (branch <= 2)
            throw new IllegalArgumentException("Illegal branching factor: "
                    + branch);
        this.branch=branch;
        this.root=new LeafNode();

    }

    /**
     *查询
     * @param key
     * @return
     */
    public V search (K key){
        return this.root.searchValue(key);
    }

    /**
     * 插入
     * @param key
     * @param value
     */
    public void insert(K key,V value){
        this.root.insertValue(key,value);
    }



    /**
     * 抽象节点类，派生中间节点与叶子节点
     */
    private abstract class Node{
        //键
        List<K> keys;

        //父节点
        Node parent;

        abstract  V searchValue (K key);

        abstract  void insertValue(K key,V value);


        /**
         * 是否溢出
         * @return
         */
        public boolean isOverflow(){

            return this.keys.size()>branch;
        }

        /**
         * 是否溢出
         * @return
         */
        public boolean isOverflow(Node node){

            return node.keys.size()>branch;
        }

    }

    /**
     * 非叶节点
//     * @param <K>
     *
     */
    private class BPlusNode extends  Node{
        //子节点  非叶节点只存储key,不存储value
        List<Node> branch;

        public BPlusNode(){
            this.branch =new ArrayList<Node>();
            this.keys=new ArrayList<K>();
        }

        /**
         * 非叶节点查找value
         * @param key
         * @return
         */
        @Override
        V searchValue(K key) {

//            int index=this.keys.size()-1;
//
//            while(index>0&&this.keys.get(index).compareTo(key)<0)
//                index--;
            int index=0;
            int size=this.keys.size()-1;
            while(index<=size&&this.keys.get(index).compareTo(key)<0)
                index++;
            /*Node leafNode=this.branch.get(index);

            //LeafNode类中包含泛型，因此无法用instanceOf
            while (!leafNode.getClass().equals(LeafNode.class)) {

            }*/
            index=index==this.keys.size()?--index:index;

            return this.branch.get(index).searchValue(key);

        }

        /**
         * 非叶节点插入
         * @param key
         * @param value
         */
        @Override
        void insertValue(K key, V value) {


            int index=0;
            int size=this.keys.size()-1;
            while(index<=size&&this.keys.get(index).compareTo(key)<0)
                index++;

//            int index=0;
//            while(index<this.keys.size()&&key.compareTo(this.keys.get(index))>0){
//                index++;
//            }

            //如果要插入的节点大于当前节点的所有元素，则与节点中最大的元素替换
             if(this.keys.size()==index){
                 //保证非叶节点元素大于指向的节点的所有元素
                 this.keys.remove(--index);
                 this.keys.add(key);
                this.branch.get(index).insertValue(key,value);
            }
            else
            this.branch.get(index).insertValue(key,value);
        }

    }

    /**
     * 叶子节点
     */
    private class LeafNode extends Node{

        //叶子节点即存储K 也存储 V,非叶子节点只存储 K
        List<V> values;

        //下一个叶子节点
        LeafNode nextNode;

        LeafNode left;

        public LeafNode(){
            this.values=new ArrayList<V>();
            this.keys=new ArrayList<K>();
        }

        /**
         * 二分法查找叶子节点
         * @param key
         * @return
         */
        @Override
        V searchValue(K key) {
           int index=search(key);
           if(index!=-1)
               return this.values.get(index);

            return  null;
        }

        /**
         * 若匹配返回key的下标，否则返回最接近key的下标
         * @param keys
         * @return
         */
        public  int search (K keys){

            int low=0;
            int high=this.keys.size()-1;

            while(low<=high){
                int mid = (low + high) >>>1;
                K midValue=this.keys.get(mid);
                if(midValue.compareTo(keys)<0)
                    low=mid+1;
                else if (midValue.compareTo(keys)>0)
                    high=mid-1;
                else
                    return mid;
            }

            return -1;
        }


        /**
         * 叶子节点添加元素
         * @param key
         * @param value
         */
        @Override
        void insertValue(K key, V value) {
            //在叶子节点中找到合适的位置插入元素
            int index=0;
            while(index<this.keys.size()&&this.keys.get(index).compareTo(key)<0){
                index++;
            }

            if(index<this.keys.size()&&this.keys.get(index).compareTo(key)==0)
                this.values.set(index,value);
            else{
                this.keys.add(index,key);
                this.values.add(index,value);
            }
            //是否超过B+树节点最大元素数量

            if(isOverflow()){
                //拆分子节点
                int size=this.keys.size();
                int split=size>>>1;

                //生成叶子节点
                LeafNode leafNode=new LeafNode();
                leafNode.keys.addAll(this.keys.subList(0,split));
                leafNode.values.addAll(this.values.subList(0,split));
                leafNode.nextNode=this;

                this.keys.subList(0,split).clear();
                this.values.subList(0,split).clear();
                //设置左边叶子节点
                this.left=leafNode;

                if(this.parent==null){
                    BPlusNode node =new BPlusNode();
                    node.keys.add(leafNode.keys.get(split-1));
                    node.keys.add(this.keys.get(this.keys.size()-1));

                    node.branch.add(leafNode);
                    node.branch.add(this);

                    root=node;
                    leafNode.parent=node;
                    this.parent=node;
                }
                else{
                    //设置新生成的叶子节点的父节点
                    leafNode.parent=this.parent;
                    //将刚拆分的两个叶子节点中的两个最大的元素提到parent节点中
                    int parent_size=parent.keys.size();
                    this.parent.keys.subList(parent_size-1,parent_size).clear();

                    this.parent.keys.add(leafNode.keys.get(leafNode.keys.size()-1));
                    this.parent.keys.add(this.keys.get(this.keys.size()-1));

                    BPlusNode parent_node=(BPlusNode) this.parent;

//                    parent_node.branch.remove(parent_node.branch.size()-1);
                    parent_node.branch.add(parent_node.branch.size()-1,leafNode);
//                    parent_node.branch.add(this);

                    //循环判断下层节点溢出拆分后有没有导致parent 节点也发生溢出
                    while(parent_node!=null){

                        if(isOverflow(parent_node)){
                            int parent_mid=parent_node.keys.size()>>>1;

                            BPlusNode new_node=new BPlusNode();
                            new_node.keys.addAll(parent_node.keys.subList(0,parent_mid));

//                            new_node.parent=parent_node.parent;
                            new_node.branch.addAll(parent_node.branch.subList(0,parent_mid));
                            parent_node.keys.subList(0,parent_mid).clear();
                            parent_node.branch.subList(0,parent_mid).clear();


                            //将两个节点中最大的元素分别提到parent节点中
                            if(parent_node.parent!=null){
                                parent_node.parent.keys.remove(parent_node.parent.keys.size()-1);
                                parent_node.parent.keys.add(new_node.keys.get(parent_mid-1));
                                parent_node.parent.keys.add(parent_node.keys.get(parent_node.keys.size()-1));

                                //继续循环判断
                                parent_node=(BPlusNode) parent_node.parent;

                                parent_node.branch.add(parent_node.branch.size()-1,new_node);

                                continue;
                            }
                            //parent==null
                            else{
                                BPlusNode plusNode =new BPlusNode();
                                plusNode.keys.add(new_node.keys.get(parent_mid-1));
                                plusNode.keys.add(parent_node.keys.get(parent_node.keys.size()-1));
                                plusNode.branch.add(new_node);
                                plusNode.branch.add(parent_node);


                                //设置父节点
                                new_node.parent=plusNode;
                                parent_node.parent=plusNode;
                                //设置根节点
                                root=plusNode;
                                break;
                            }
                        }
                        break;
                    }

                }



            }
            /*//没有溢出，需要保持非叶节点中相应的元素为叶节点中的最大值
            else {
                K leafNodeMaxValue=this.keys.get(this.keys.size()-1);



            }*/
        }
    }
}





