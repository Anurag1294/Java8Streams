import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapAndFlatMap {
    public static void main(String[] args) {
        List<Institute> instituteList = new ArrayList<>();

        instituteList.add(new Institute("IIM", Arrays.asList("Bangalore", "Ahmedabad", "Kozhikode", "Lucknow")));
        instituteList.add(new Institute("IIT", Arrays.asList("Delhi", "Mumbai", "Kharagpur")));
        instituteList.add(new Institute("NIFT", Arrays.asList("Hyderabad", "Mumbai", "Patna", "Bangalore")));


        //Suppose we have to extract name of each Institute, that can be done using map() method as shown below.

        final List<String> nameOfInstitutes = instituteList.stream().map(Institute::getName).collect(Collectors.toList());
        System.out.println(nameOfInstitutes);



//    If we suppose to extract unique locations of all institutes, using map() will throw an error.
//    Because, locations are itself wrapped in another List<String> i.e
//    list within a list. Using flatMap() in such scenarios will give correct result.


        final Set<String> collect = instituteList.stream().flatMap(institute -> institute.getLocations().stream()).collect(Collectors.toSet());
        System.out.println(collect);




    }










}
