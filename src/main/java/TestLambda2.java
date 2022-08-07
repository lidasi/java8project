import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @ClassName TestLambda2
 * @Description Lambda 表达式的基础语法：java8中引入了一个新的操作符 “->” 该操作符称为箭头操作符 或Lambda操作符
 * 左侧：Lambda 表达式的参数列表
 * 右侧: Lambda 表达式中所需要执行的功能，即Lambda体
 * 语法格式一：无参数，无返回值
 *          () -> System.out.println("Hello Lambda!")
 * 语法格式二: 有一个参数，并且无返回值
 *          (x) -> System.out.println(x)
 * 语法格式三: 若只有一个参数，小括号可以不写
 *          x -> System.out.println(x)
 * 语法格式四: 若有两个以上的参数，并且Lambda体中有多条语句
 *             Comparator<Integer> com = (x, y) -> {
 *             System.out.println("函数式接口");
 *             return Integer.compare(x, y);
 *         };
 * 语法格式五:若Lambda 体中只有一条语句，return 和大括号都可以省略不写
 * 语法格式六: Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
 * @Author lidasi
 * @Date 2022/6/25 19:51
 * @Version 1.0
 **/
public class TestLambda2 {
    @Test
    public void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        };
        r.run();
        System.out.println("----------------------");
        Runnable r1 = () -> System.out.println("Hello Lambda!");
        r1.run();
    }
    @Test
    public void test2(){
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("学习快乐");
    }

    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }
}
