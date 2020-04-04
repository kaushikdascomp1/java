package Java.src.Java8.stream;

import java.util.*;
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



    }
}
