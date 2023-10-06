import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<10; i++) {
            list.add((int) (Math.random()*1000+1));
        }
        System.out.println("정렬전: "+list);
        System.out.println("정렬후: "+mergeSort(list));
    }
    public static List<Integer> mergeSort(List<Integer> list) {
        if (list.size() <= 1) return list;

        //끝까지 쪼갠후
        int mid = list.size()/2;
        List<Integer> left = mergeSort(list.subList(0, mid));
        List<Integer> right = mergeSort(list.subList(mid, list.size()));

        //합치면서 정렬
        List<Integer> result = new ArrayList<>();
        int leftPointer = 0;
        int rightPointer = 0;
        while(leftPointer < left.size() || rightPointer < right.size()) {
            //left, right 포인터가 모두 살아있을떄
            if (leftPointer < left.size() && rightPointer < right.size()) {
                //둘중 작은것부터 채운다
                if (left.get(leftPointer) < right.get(rightPointer)) {
                    result.add(left.get(leftPointer));
                    leftPointer++;
                } else {
                    result.add(right.get(rightPointer));
                    rightPointer++;
                }
            }
            //left 만 살아있을때
            else if (leftPointer < left.size()) {
                result.add(left.get(leftPointer));
                leftPointer++;
            }
            //right 만 살아있을때
            else {
                result.add(right.get(rightPointer));
                rightPointer++;
            }
        }
        return result;
    }
}
