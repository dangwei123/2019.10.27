/**
 * ClassName:SignalList
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2019/10/27 15:06
 * @Author:DangWei
 */
class ListNode{
    public int date;
    public ListNode next;

    public ListNode(int date){
        this.date=date;
        this.next=null;
    }
}
public class SignalList {
    public ListNode head;

    public SignalList(){
        this.head=null;
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(this.head==null){
            this.head=node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }
    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head==null){
            this.head=node;
        }else {
            ListNode cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    private ListNode findIndex(int index){
        ListNode cur = this.head;
        int tmp=index-1;
        while(tmp!=0){
            cur=cur.next;
            tmp--;
        }
        return cur;
    }
    public boolean addIndex(int index,int data){
            if(index<0||index>getLen()){
                System.out.println("不合法");
                return false;
            }if(index == 0) {
            addFirst(data);
            return true;
        }
        ListNode cur = findIndex(index);
        ListNode node = new ListNode(data);
        node.next=cur.next;
        cur.next=node;
        return true;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        if(this.head==null){
            return false;
        }
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.date==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //得到单链表的长度
    public int getLen(){
        if(this.head==null){
            return 0;
        }
        ListNode cur=this.head;
        int len=0;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        return len;
    }
    //打印
    public void display(){
        ListNode cur=this.head;
        while(cur!=null){
            System.out.print(cur.date+" ");
            cur=cur.next;
        }
        System.out.println();
    }
}


class TestDemo{
    public static void main(String[] args) {
        SignalList signalList=new SignalList();
        signalList.addFirst(5);
        signalList.addFirst(4);
        signalList.addFirst(3);
        signalList.addFirst(2);
        signalList.addFirst(1);
        signalList.display();
        System.out.println(signalList.getLen());
        boolean ret=signalList.contains(3);
        System.out.println(ret);
        signalList.addIndex(2,7);
        signalList.display();
        signalList.addLast(9);
        signalList.addLast(10);
        signalList.display();
    }
}

