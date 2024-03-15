import java.util.HashSet;
import java.util.Set;

public class ex67 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(); //중복 허용 안됨
        set.add("홍길동");
        set.add("변사또");
        set.add("춘향이");

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        setA.add(10);
        setA.add(20);
        setA.add(30);
        setB.add(30);
        setB.add(40);
        setB.add(50);

        //교집합 - 원본이 회손됨. 주의!
//        setA.retainAll(setB);
//        System.out.println(setA);

        //합집합 - 원본이 회손됨. 주의!
//        setA.addAll(setB);
//        System.out.println(setA);

        //합집합 - 원본이 회손됨. 주의!
        setA.removeAll(setB);
        System.out.println(setA);
    }
}
