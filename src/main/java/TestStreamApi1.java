import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName Stream1
 * @Description TODO
 * @Author lidasi
 * @Date 2022/8/8 1:15
 * @Version 1.0
 * 一、Stream 的三个操作步骤
 * 1、创建Stream
 * 2、中间操作
 * 3、终止操作（终端操作）
 **/
public class TestStreamApi1 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 22, 8888.88),
            new Employee("赵四", 35, 7777.77),
            new Employee("王三", 49, 6666.66),
            new Employee("吴五", 60, 5555.55),
            new Employee("吴五", 60, 5555.55),
            new Employee("吴五", 60, 5555.55),
            new Employee("陆六", 27, 2222.22)

    );

    //中间操作
    /**
     * 映射
     * map——接收Lambda,将元素转换成其他形式或提取信息，接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
      **/
    /**
      *筛选与切片
     * filter——接收Lambda,从流中排除某些元素
     * limit——截断流，使其元素不超过给定数量
     * skip(n) ——跳过元素，返回一个扔掉前n个元素的流。若流中元素不足n个，则返回一个空流，与limit(n)互补
     * distinct——筛选,通过流所生成元素的hashCode()和equals()去除重复元素
     **/
    @Test
    public void test5(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
        list.stream()
                .map((e) -> e.toUpperCase())
                .forEach(System.out::println);

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
    //public static Stream<Character> stream
    @Test
    public void test4(){
        employees.stream()
                .filter((e) -> e.getSalary() > 5000)
                .skip(2)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void test3(){
        employees.stream()
                .filter((e) -> e.getSalary() > 5000)
                .limit(2)
                .forEach(System.out::println);
    }
    //内部迭代: 迭代操作由Stream API 完成
    @Test
    public void test1(){
        //中间操作: 不会执行任何操作
        Stream<Employee> stream = employees.stream()
                .filter(e ->
                        {
                            System.out.println("Stream API 的中间操作");
                            return e.getAge()>35;
                        });
        //终止操作: 一次性执行全部内容，即“惰性求值”
        stream.forEach(System.out::println);
    }

    //外部迭代
    @Test
    public void test2() {
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
