import java.util.*;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        /// No of males and femailes in organisation
        //No of Males
        System.out.println("No of Males :");
        System.out.println(employeeList.stream().filter(employee -> (employee.gender.equals("Male"))).count());

        //No of Females
        System.out.println("No of Males :");
        System.out.println(employeeList.stream().filter(employee -> (employee.gender.equals("Female"))).count());

        //Grouping method

        Map<String,Long> maleFemaleMap = employeeList.stream().collect(Collectors.groupingBy(employee -> employee.gender,Collectors.counting()));
        System.out.println(maleFemaleMap);


        //print name of all departments in organisation

        System.out.println("All Departments Name :");
        System.out.println(employeeList.stream().map(employee -> employee.getDepartment()).distinct().collect(Collectors.toList()));



        //average age of male and female members

        System.out.println("Average age of Male and female members");
        Map<Object, Double> ageMap =
                employeeList.stream()
                        .collect(Collectors.groupingBy(employee -> employee.getGender(),Collectors.averagingInt(Employee::getAge)));
        System.out.println(ageMap);

        //Highest paid employee in organisation
        System.out.println("Highest paid Employee in Org");
        final Optional<Double> highestSalary = employeeList.stream().map(Employee::getSalary).max((o1, o2) -> (int) (o1-o2));
        System.out.println(highestSalary.get());

        final Optional<Employee> employeeOptional
                = employeeList.stream().collect(Collectors.maxBy((o1,o2) ->  (int) (o1.getSalary()-o2.getSalary())));
        System.out.println(employeeOptional.get());


        //Highest paid employee in organisation
        System.out.println("Lowest paid Employee in Org");
        final Optional<Double> lowestSalary = employeeList.stream().map(Employee::getSalary).max((o1, o2) -> (int) (o2-o1));
        System.out.println(lowestSalary.get());
        System.out.println(employeeList.stream().collect(Collectors.maxBy((o1, o2) -> (int) (o2.getSalary()-o1.getSalary()))));

        //Get Name of all employee who joined after 2015
        System.out.println("Employee who joined after 2015");
        final List<String> employees = employeeList.stream().filter(employee -> employee.yearOfJoining > 2015).map(Employee::getName).collect(Collectors.toList());
        System.out.println(employees);


        //Count no of employee in each department
        System.out.println("No of employee in each department");
        final Map<String, Long> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(collect);


        //Average salary of each department
        System.out.println("Average salary in each department");
        final Map<String, Double> collect1 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(value -> value.getSalary())));
        System.out.println(collect1);


        //details of the youngest male employee in the product development department
        System.out.println("Details of youngest male employee in the product development department");
        System.out.println(employeeList.stream().
                filter(employee -> employee.getDepartment().equals("Product Development") && employee.getGender().equals("Male"))
                .min(Comparator.comparingInt(Employee::getAge)));


        //Most Experiencing candidate in org
        System.out.println( "most working experience in the organization");
        System.out.println(employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst());

        //male and female employees are there in the sales and marketing team?
        System.out.println("male and female employees are there in the sales and marketing team");
        final Map<String, Long> sales_and_marketing = employeeList.stream().filter(employee -> employee.getDepartment().equals("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(sales_and_marketing);

        // average salary of male and female employees
        System.out.println(" average salary of male and female employees");
        final Map<String, Double> collect2 = employeeList.stream().
                collect(Collectors.
                        groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect2);

        //List down the names of all employees in each department
        System.out.println("Names of all employees in each department");
        final Map<String, List<Employee>> collect3 = employeeList.stream().collect(Collectors.groupingBy(
                Employee::getDepartment));
        System.out.println(collect3);


        //Average salary and Total Salary of org
        System.out.println("Average salary :");
        final DoubleSummaryStatistics doubleSummaryStatistics
                = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(doubleSummaryStatistics.getAverage());
        System.out.println("Total salary :");
        System.out.println(doubleSummaryStatistics.getSum());
        System.out.println("Count of Salary");
        System.out.println(doubleSummaryStatistics.getCount());


        //Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.

        final Map<Boolean, List<Employee>> partitionEmployees =
                employeeList.stream().collect(Collectors.partitioningBy(employee -> employee.getAge() > 25));
        for (Boolean flag:partitionEmployees.keySet()){

            System.out.println("----------------------------");
            if (flag){
                System.out.println("Younger than 25");
            } else {
                System.out.println("Older than 25");
            }
            System.out.println("----------------------------");
            partitionEmployees.get(flag).forEach(System.out::println);
        }


        // oldest employee in the organization? What is his age and which department he belongs to

        System.out.println("oldest employee in the organization? What is his age and which department he belongs to");
        final Optional<Employee> optionalEmployee =
                employeeList.stream().collect(Collectors.maxBy((o1, o2) -> o1.getAge() - o2.getAge()));
        System.out.println(optionalEmployee.get().age);
        System.out.println(optionalEmployee.get().name);
        System.out.println(optionalEmployee.get().department);



    }
}
