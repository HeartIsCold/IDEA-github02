package com.cy.linkedlist;

public class TestDoubleLinkedList {
    public static void main(String[] args) {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        HeroNode heroNode1 = new HeroNode(1,"宋江","及时雨");
        HeroNode heroNode2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode heroNode3 = new HeroNode(3,"吴用","智多星");
        HeroNode heroNode4 = new HeroNode(4,"公孙胜","入云龙");
        HeroNode heroNode5 = new HeroNode(5,"关胜","大刀");

        doubleLinkedList.addByOrder(heroNode1);
        doubleLinkedList.addByOrder(heroNode5);
        doubleLinkedList.addByOrder(heroNode2);
        doubleLinkedList.addByOrder(heroNode4);
        doubleLinkedList.addByOrder(heroNode3);

        doubleLinkedList.addByOrder(heroNode2);

        doubleLinkedList.show();
    }
}
class HeroNode{
    public int id;
    public String name;
    public String nickName;
    public HeroNode pre;
    public HeroNode next;

    public HeroNode(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
class DoubleLinkedList{
    public HeroNode head;

    public DoubleLinkedList() {
        head = new HeroNode(0,"","");
    }

    /**
     * 显示列表数据
     */
    public void show(){
        HeroNode temp = head.next;
        if(temp == null){
            System.out.println("空列表，无数据可展示");
            return;
        }
        while(true){
            System.out.println(temp);
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 添加节点数据
     */
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        if(temp.next == null){
            temp.next = heroNode;
            heroNode.pre = temp;
            return;
        }
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }
    /**
     * 按照编号添加节点数据
     * 情况1：插入第一个节点时，头结点的next为null，直接在头结点后加就可以了
     * 情况2：插入第x个节点时，没有需要改变之前节点的情况，直接遍历到了链表最后一个节点，即最后一个节点的next为null
     * 情况3：需要改变之前节点的顺序，即要插入的节点的id，小于temp所代表的当前节点的id，把插入节点放在目标节点的前面
     * 情况4：插入的节点编号等于链表中已有的某一节点编号，则结束程序
     */
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;

        while(true){
            if(temp.next == null){
                temp.next = heroNode;
                heroNode.pre = temp;
                break;
            }

            if(heroNode.id < temp.next.id){
                heroNode.next = temp.next;
                heroNode.pre = temp;
                temp.next = heroNode;
                temp.next.pre = heroNode;
                break;
            }else if(heroNode.id == temp.next.id){
                System.out.println("已有该编号的hero，无法重复添加");
                break;
            }
            temp = temp.next;
        }
    }

}
