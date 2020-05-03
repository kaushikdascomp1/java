package Java.src.Java8.stream;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class EmployeeStream {

    public static void main(String[] args) {
        Employee emp1 = new Employee(1001,"Kaushik","ECE",1000);
        Employee emp2 = new Employee(2003,"Monojeet","CIV",3400);
        Employee emp3 = new Employee(4544,"Mrinal","ECE",1300);
        Employee emp4 = new Employee(1056,"Varun","ECE",700);
        Employee emp5 = new Employee(6766,"Abhinesh","ME",1300);
        Employee emp6 = new Employee(7656,"Debaprotim","ME",1200);
        Employee emp7 = new Employee(6562,"Rupam","CIV",2300);

        List<Employee> employeeList = Arrays.asList(emp1,emp2,emp3,emp4,emp5,emp6,emp7);

        //To Find the highest sal by department
        Map<String, Optional<Employee>> highestEmplBySal = employeeList.stream().collect(groupingBy(Employee::getDepartment, maxBy(Comparator.comparingInt(Employee::getSal))));
        for(Map.Entry<String, Optional<Employee>> emp: highestEmplBySal.entrySet()){
            Optional<Employee> empl1 = emp.getValue();
            System.out.println(empl1.get().getDepartment() +"    "+ empl1.get().getSal());
        }

        //Sort all employees by salary and if salary is same sort by depy
        List<Employee> sortEmployeesBySalAndDept = employeeList.stream().sorted(Comparator.comparingInt(Employee::getSal).reversed().thenComparing(Employee::getDepartment)).collect(Collectors.toList());
        sortEmployeesBySalAndDept.forEach(System.out::println);

        //To find the total salary in each dept
        //To find other operation apart from summingInt and maxBy
        Map<String, Integer> totalSalaryByEachDept = employeeList.stream().collect(groupingBy(Employee::getDepartment, summingInt(Employee::getSal)));
        System.out.println(totalSalaryByEachDept);

        //Map sorting by value
        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put("F",emp1);
        employeeMap.put("B",emp2);
        employeeMap.put("C",emp3);
        employeeMap.put("D",emp4);
        employeeMap.put("E",emp5);
        employeeMap.put("A",emp6);
        employeeMap.put("G",emp7);

        LinkedHashMap<String, Employee> sortedByValue = employeeMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getSal).reversed().thenComparing(Employee::getDepartment))).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        sortedByValue.entrySet().stream().forEach(System.out::println);
        Comparator<Employee> sortingBySal = (e1,e2)->e2.getSal()-e1.getSal();
        Comparator<Employee> sortingByDept = (e1,e2)->e2.getDepartment().compareTo(e1.getDepartment());
        Comparator<Employee> sortingBySalDept = sortingBySal.thenComparing(sortingByDept);
        employeeMap.entrySet().stream().map(e1 -> e1.getValue()).sorted(sortingBySalDept).collect(toList());

        System.out.println("-------------------------------------------------------");
        LinkedHashMap<String, Employee> collectByKey = employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        collectByKey.entrySet().stream().forEach(System.out::println);

        Map<Employee, String> employeeKeyMap = new HashMap<>();

        employeeKeyMap.put(emp1,"F");
        employeeKeyMap.put(emp2,"B");
        employeeKeyMap.put(emp3,"C");
        employeeKeyMap.put(emp4,"D");
        employeeKeyMap.put(emp5,"E");
        employeeKeyMap.put(emp6,"A");
        employeeKeyMap.put(emp7,"G");

        LinkedHashMap<Employee, String> sortedMapEmployeeKey = employeeKeyMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSal).reversed().thenComparing(Employee::getDepartment))).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        sortedMapEmployeeKey.entrySet().stream().forEach(System.out::println);

        questionsFromShivam();

    }

    public static void questionsFromShivam(){
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee(1,"Aparna",  "HR",30000 ));
        list.add(new Employee(2, "Babua", "IT",30000 ));
        list.add(new Employee(3, "Celina", "ACCOUNTS", 40000 ));
        list.add(new Employee(4, "Dion", "HR", 40000 ));
        list.add(new Employee(5, "Ezekiel", "IT", 60000 ));


        // Maximum and Average
        Optional<Integer> maxSal = list.stream().map(x -> x.getSal()).max(Integer::compareTo);
        Double averageSal = list.stream().collect(averagingInt(Employee::getSal));

        //count of employee names tarting with a
       // print(findCountOfEmpWithnameStartingFrom(list, "A"));
       Predicate<Employee> namePredicate = namestarting("A").or(namestarting("a"));
        long countEmployeeNamesStartingWithA = list.stream().filter(namePredicate).count();

        //Groupby Dept with employee ID
        //// ["HR" -> "1,2,3"]
        Map<String, List<Integer>> groupingByDeptAndListofEmployeeId = list.stream().collect(groupingBy(Employee::getDepartment, mapping(Employee::getEmpCode, toList())));

        //grouping by department
        Map<String, List<Employee>> groupEmployeeByDept = list.stream().collect(groupingBy(Employee::getDepartment));

        //grouping by number of employees in department
        Map<String, Integer> groupEmployeesByDeptWithCount = list.stream().collect(groupingBy(Employee::getDepartment, summingInt(e -> 1)));

        //AverageSalByDept
        Map<String, Double> avgSalByDept = list.stream().collect(groupingBy(Employee::getDepartment, averagingInt(Employee::getSal)));

        //partitioning by IT and Non IT
        Map<Boolean, List<Employee>> partitioningByITAndNonIT = list.stream().collect(partitioningBy(x -> x.getDepartment().equals("IT")));

        //return names of all employees before C
        Predicate<Employee> namesStartingWithC = namestarting("C").or(namestarting("c"));
       String allEmployeesNamesBeforeC = list.stream().takeWhile(namesStartingWithC.negate()).map(x->x.getName()).collect(joining(","));

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println(allEmployeesNamesBeforeC);
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Partitioning By Test");
        partitioningByITAndNonIT.entrySet().stream().forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Group By Mapping  Test");
        groupingByDeptAndListofEmployeeId.entrySet().stream().forEach(System.out::println);
    }

    public static Predicate<Employee> namestarting(String string){
       return employee->employee.getName().startsWith(string);
    }


    public void sortEmployeeList(List<Employee> empList, Comparator<Employee> sortingStrategy){

    }

}
