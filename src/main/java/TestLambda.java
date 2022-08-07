import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName TestLambda
 * @Description 一、Lambda 表达式的基础语法：java8中引入了一个新的操作符 “->” 该操作符称为箭头操作符或Lambda操作符
 *      左侧：Lambda 表达式的参数列表
 *      右侧: Lambda 表达式中所需执行的功能，即Lambda体
 * @Author lidasi
 * @Date 2022/6/25 17:28
 * @Version 1.0
 **/
public class TestLambda {
    //原来的匿名内部类
    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);
    }
    //Lambda 表达式
    @Test
    public void Test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    List<Employee> employeeList = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 22, 8888.88),
            new Employee("赵四", 35, 7777.77),
            new Employee("王三", 49, 6666.66),
            new Employee("吴五", 60, 5555.55),
            new Employee("陆六", 27, 2222.22)

    );


    //获取大于35的
    public List<Employee> dayu35(List<Employee> list){
        List<Employee> employees = new ArrayList<>();
        for (Employee e: list)
        {
            if(e.getAge() >30) {
                employees.add(e);
            }
        }
        return employees;
    }


    //策略设计模式
    @Test
    public void test4() {
        List<Employee> list = fileterEmployee(employeeList, new EmployeeByAge());
        for
        (Employee employee: list)
        {
            System.out.println(employee);
        }
    }

    @Test
    public void dayu35Test() {
        System.out.println(dayu35(employeeList));
        List<Employee> list1 = employeeList.stream().filter(a -> a.getAge() > 40).collect(Collectors.toList());
        System.out.println(list1);

    }

    @Test
    public List<Employee> fileterEmployee(List<Employee> employees, MyPredicate<Employee> t) {
        List<Employee> list = new ArrayList<>();
        for (Employee emp: employees) {
            if (t.test(emp))
            {
                list.add(emp);
            };
        }
        return list;
    }
    //匿名内部内
    @Test
    public void test5() {
        List<Employee> list = fileterEmployee(employeeList, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() > 6000;
            }
        });
        for
        (Employee employee: list)
        {
            System.out.println(employee);
        }
    }

    //Lambda 优化方式
    @Test
    public void test6() {
        List<Employee> employees = fileterEmployee(employeeList, (e) -> e.getSalary() > 6000);
        employees.forEach(System.out::println);
    }
    //stream 优化方式
    @Test
    public void test7() {
        employeeList.stream()
                .filter((e) -> e.getSalary() > 6000)
                .limit(2)
                .forEach(System.out::println);
        System.out.println("--------------------------------");
        employeeList.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}
