import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @ClassName TestMthod
 * @Description TODO
 * @Author lidasi
 * @Date 2022/6/26 15:36
 * @Version 1.0
 **/
public class TestMthod {


    List<Employee> employeeList = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 22, 8888.88),
            new Employee("赵四", 35, 7777.77),
            new Employee("王三", 49, 6666.66),
            new Employee("吴五", 60, 5555.55),
            new Employee("陆六", 27, 2222.22)

    );

    @Test
    public void methodTest() {
        Employee emp = new Employee();
        Supplier<String> str = () -> emp.getName();
        String str1 = str.get();
        System.out.println(str1);
        Supplier<Integer> itje = emp::getAge;
        Integer itje1 = itje.get();
        System.out.println(itje1);
    }

    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> com1 = Integer::compare;
    }

    @Test
    public void test3() {
        String groupArr = "张三,王三,陆六";
        Map<String, Object> map = new HashMap<>();
        for (Employee emp: employeeList) {
            if(Stream.of(groupArr.split(",")).anyMatch(x -> x.equals(emp.getName()))) {
                System.out.println(emp);
            }
        }

    }

}
