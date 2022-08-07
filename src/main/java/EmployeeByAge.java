/**
 * @ClassName EmployeeByAge
 * @Description TODO
 * @Author lidasi
 * @Date 2022/6/25 19:24
 * @Version 1.0
 **/
public class EmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee t) {
        return t.getAge() > 30;
    }
}
