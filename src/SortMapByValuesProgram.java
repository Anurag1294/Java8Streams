import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class SortMapByValuesProgram {
    public static void main(String[] args) {
        //Define one HashMap called idNameMap

        Map<Integer, String> idNameMap = new HashMap<>();

        //Insert Id-Name pairs into idNameMap

        idNameMap.put(111, "Lisa");
        idNameMap.put(222, "Narayan");
        idNameMap.put(333, "Xiangh");
        idNameMap.put(444, "Arunkumar");
        idNameMap.put(555, "Jyous");
        idNameMap.put(666, "Klusener");

        //Java 8
        final LinkedList<Map.Entry<Integer, String>> entryLinkedList = new LinkedList<>(idNameMap.entrySet());

        Collections.sort(entryLinkedList,Comparator.comparing(Map.Entry::getKey));
        //Now use LinkedHashMap to store order of data
        //Insert all elements of listOfEntry into new LinkedHashMap which maintains insertion order

        Map<Integer, String> sortedIdNameMap = new LinkedHashMap<>();

        for (Map.Entry<Integer, String> entry : entryLinkedList)
        {
            sortedIdNameMap.put(entry.getKey(), entry.getValue());
        }
        System.out.println(sortedIdNameMap);

        //ComparingKey

        final Map<Integer, String> sortedMap = idNameMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (s, s2) -> s, LinkedHashMap::new));
        System.out.println(sortedMap);
        final Map<Integer, String> sortedMap1 = idNameMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (s, s2) -> s2, LinkedHashMap::new));
        System.out.println(sortedMap1);

        final Map<Integer, String> sortedMap2 = idNameMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (s, s2) -> s2, LinkedHashMap::new));
        System.out.println(sortedMap2);

        final Map<Integer, String> sortedMap3 = idNameMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (s, s2) -> s, LinkedHashMap::new));
        System.out.println(sortedMap3);



    }
}
