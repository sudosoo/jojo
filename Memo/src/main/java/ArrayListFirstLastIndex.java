import java.util.ArrayList;
import java.util.List;

public class ArrayListFirstLastIndex {
    public static void main(String[] args) {

        // ArrayList 준비
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);


        // 첫번째, 마지막 index
        int firstIndex = 0;
        int lastIndex = arrayList.size() - 1;

        // 결과 출력
        System.out.println("첫번째 index : " + firstIndex); // 0
        System.out.println("첫번째 index의 값 : " + arrayList.get(firstIndex)); // A

        System.out.println("마지막 index : " + lastIndex); // 4
        System.out.println("마지막 index의 값 : " + arrayList.get(lastIndex)); // E
    }
}