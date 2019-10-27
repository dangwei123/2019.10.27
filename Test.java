import java.util.Arrays;

/**
 * ClassName:Test
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2019/10/27 8:36
 * @Author:DangWei
 */
class MyArrayList {
    public int usedSize;
    public int[] elem;

    public final int CAPACITY = 10;

    public MyArrayList() {
        this.usedSize = 0;
        this.elem = new int[CAPACITY];
    }
    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        //1、pos是否合法
        //2、挪数据
        //3、插入数据
        //4、usedSize++

        if (usedSize == elem.length) {
            this.elem=Arrays.copyOf(elem,2*elem.length);
        }
        if (pos < 0 || pos > this.usedSize) {
            System.out.println("不合法");
            return;
        } else {
            int tmp = usedSize;
            while (tmp != pos) {
                elem[tmp] = elem[tmp - 1];
                tmp--;
            }
            this.elem[pos] = data;
            this.usedSize++;
        }
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for(int i=0;i<usedSize;i++){
            if(elem[i]==toFind){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for(int i=0;i<usedSize;i++){
            if(elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos<0||pos>=usedSize){
            return -1;
        }
        return this.elem[pos];
    }
    // 给 pos 位置的元素设为 value
    // public void setPos(int pos, int value) { }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        if(usedSize==0){
            return;
        }
        int i=0;
        for(i=0;i<usedSize;i++){
            if(elem[i]==toRemove){
                break;
            }
        }
       if(i!=usedSize){
            while(i!=usedSize-1){
                this.elem[i]=elem[i+1];
                i++;
            }
            this.usedSize--;
        }
    }
    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize=0;
    }
    // 打印顺序表
    public void display() {
        for(int i=0;i<usedSize;i++){
            System.out.print(elem[i]+" ");
        }
        System.out.println();
    }
}

public class Test{
    public static void main(String[] args) {
        MyArrayList  myArrayList=new MyArrayList();
        myArrayList.add(0,5);
        myArrayList.add(0,4);
        myArrayList.add(0,3);
        myArrayList.add(0,3);
        myArrayList.add(0,2);
        myArrayList.add(0,1);
        myArrayList.display();
        System.out.println( myArrayList.size());
        myArrayList.remove(3);
        myArrayList.display();
        System.out.println( myArrayList.size());
    }
}

