import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @ClassName TestLambda3
 * @Description Lambda 四大核心接口
 * java内置4大核心接口
 *
 * Consumer(T) : 消费型接口
 * 		 void accept(T t);
 * 		 传入泛型T,无返回值
 *
 * Supplier<T> : 供给型接口
 *		 T get();
 *		 无传入参数，返回泛型T
 *
 * Function<T, R> : 函数型接口
 *		 R apply(T t);
 *		 传入泛型T，返回R类型返回值
 *
 * Predicate<T> : 断言型接口
 *		 boolean test(T t);
 *		 传入泛型T，返回boolean类型
 * @Author lidasi
 * @Date 2022/6/26 14:18
 * @Version 1.0
 **/
public class TestLambda3 {
    List<Employee> employeeList = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 22, 8888.88),
            new Employee("赵四", 35, 7777.77),
            new Employee("王三", 49, 6666.66),
            new Employee("吴五", 60, 5555.55),
            new Employee("陆六", 27, 2222.22)

    );
    @Test
    public void predicatePl() {
        List<String> testStr = Arrays.asList("附近的开始啦","f硅胶壳","防静电啦","ggelalsj");
        List<String> preList = predicateTest(testStr, (x) -> x.length()>5);
        preList.forEach(System.out::println);
    }

    @Test
    public List<String> predicateTest(List<String> strList, Predicate<String> pre) {
        List<String> list = new ArrayList<>();
        for (String s : strList)
        {
            if(pre.test(s))
            {
                list.add(s);
            }
        }
        return list;
    }

    //function 函数型接口
    @Test
    public void functionPl() {
        String str = functionTest("  今天我在学java8    ", (x) -> x.trim());
        System.out.println(str);
        String str1 = functionTest("  今天我在学java8    ", (x) -> x.substring(5,8));
        System.out.println(str1);
    }

    @Test
    public String functionTest(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    //Supplier 供给型接口
    @Test
    public List<Integer> supplierTest(Integer sum, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < sum; i++) {
            int num = sup.get();
            list.add(num);
        }
        return list;
    }

    @Test
    public void supplierPl() {
        List<Integer> rdm = supplierTest(1, () -> (int)(Math.random() * 3-1)+1);
        rdm.forEach(System.out::println);
    }
    //consumer 消费型接口
    @Test
    public void consumerTest(double money, Consumer<Double> con) {
        con.accept(money);
    }
    @Test
    public void consumerPl() {
        consumerTest(10000, (x) -> System.out.println("消费了" + x +"元"));
    }


}
