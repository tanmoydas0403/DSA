import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Heaps1<Integer> heaps = new Heaps1<Integer>();
        heaps.insert(34);
        heaps.insert(45);
        heaps.insert(22);
        heaps.insert(89);
        heaps.insert(76);

//        System.out.println(heaps.remove());
//        System.out.println(heaps.remove());
//        System.out.println(heaps.remove());

        ArrayList<Integer> list = heaps.heapSort();
        System.out.println(list);
    }
}
