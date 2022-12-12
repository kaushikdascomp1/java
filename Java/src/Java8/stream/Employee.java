package Java8.stream;

public class Employee {

    public int empCode;
    public String name;
    public String department;
    public int sal;

    public Employee(int empCode, String name, String dept, int sal){
        this.empCode = empCode;
        this.name = name;
        this.department = dept;
        this.sal = sal;
    }

    public int getEmpCode() {
        return empCode;
    }

    public void setEmpCode(int empCode) {
        this.empCode = empCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empCode=" + empCode +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", sal=" + sal +
                '}';
    }
}
