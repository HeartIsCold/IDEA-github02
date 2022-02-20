package com.cy.linkedlist;

public class TestJosephu {
    public static void main(String[] args) {

        CircleSingleLinkedList c = new CircleSingleLinkedList();
        StudentNode s1 = new StudentNode(1,"赵一");
        StudentNode s2 = new StudentNode(2,"钱二");
        StudentNode s3 = new StudentNode(3,"孙三");
        StudentNode s4 = new StudentNode(4,"李四");

        c.show();
        System.out.println("*****************");

        c.add(s1);
        c.add(s2);
        c.show();
        System.out.println("*****************");

        c.add(s3);
        c.show();

    }
}
class StudentNode{
    public int id;
    public String name;
    StudentNode next;

    public StudentNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
class CircleSingleLinkedList{
    public StudentNode head = new StudentNode(0,"");

    //添加元素时使用，first表示第一个节点元素，current指向最新添加的元素
    StudentNode first;
    StudentNode current;

    //遍历元素时使用
    StudentNode temp = head;

    public CircleSingleLinkedList() {

    }

    public void add(StudentNode studentNode){
        /**
         * 情况1：列表中除了头结点还没有其他节点,这段代码只执行一次
         */
        if(head.next == null){
            head.next = studentNode;
            studentNode.next = studentNode;
            current = studentNode;
            first = studentNode;
            return;
        }
        /**
         * 情况2：列表中除了头结点之外，已经有了至少一个节点
         */
        else {
            current.next = studentNode;
            current = studentNode;
            studentNode.next = first;
        }
    }

    public void show(){
        /**
         * 情况1：列表中除了头结点外，没有其他节点，则不展示，退出
         */
        if(first == null){
            System.out.println("链表为空，无法展示");
            return;
        }
        /**
         * 情况2：有其他节点
         */
        else {
            while(true){
                temp = temp.next;
                System.out.println(temp);
                if(temp.next ==first){
                    break;
                }
            }
        }
    }
}