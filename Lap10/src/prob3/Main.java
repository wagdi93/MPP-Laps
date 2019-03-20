package prob3;

import java.util.*;
import java.util.function.*;


public class Main {
    //could return list.contains(s), but this does not generalize


    public static void test1() {
        List<String> list = Arrays.asList("Bob", "Joe", "Tom");
        boolean result = Main.contains(list, "Tom", (string1, string2) -> string1.equals(string2));
        System.out.println(result);
    }

    public static void test2() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1003, "Tom", 60000));
        list.add(new Employee(1002, "Harry", 70000));
        list.add(new Employee(1001, "Joe", 50000));
        Employee e = new Employee(1001, "Joe", 50000);
        boolean foundIt = Main.contains(list, e, (e1, e2) -> e1.getId() == e2.getId());
        System.out.println(foundIt);
    }

    public static void test3() {
        List<Manager> list = new ArrayList<>();
        list.add(new Manager(1003, "Tom", 60000, 700));
        list.add(new Manager(1002, "Harry", 70000, 400));
        list.add(new Manager(1001, "Joe", 50000, 500));

        Manager m = new Manager(1001, "Joe", 50000, 500);
        boolean foundIt = Main.contains(list, m,
                (Employee e1, Employee e2) -> e1.getId() == e2.getId());
        System.out.println(foundIt);
    }

    public static void test4() {
        List<Manager> list = new ArrayList<>();
        list.add(new Manager(1003, "Tom", 60000, 700));
        list.add(new Manager(1002, "Harry", 70000, 400));
        list.add(new Manager(1001, "Joe", 50000, 500));

        Manager m = new Manager(1001, "Joe", 50000, 500);
        boolean foundIt = Main.contains(list, m,
                (Employee e, Person p) -> e.getName().equals(p.getName()));
        System.out.println(foundIt);
    }

    public static <T> boolean contains(List<? extends T> list, T element, BiPredicate<? super T, ? super T> biPredicate) {
        for (T t : list) {
            if (biPredicate.test(t, element)) {
                return true;
            }
        }
        return false;

    }

    public static void test5() {
        List<CheckingAccount> list = new ArrayList<>();
        list.add(new CheckingAccount(1001, 25.00));
        list.add(new CheckingAccount(1002, 35.00));
        list.add(new CheckingAccount(1003, 125.00));

        Account a = new CheckingAccount(1002, 35.00);
        boolean foundIt = Main.contains(list, a,
                (Account a1, Account a2) -> a1.getAcctId() == a2.getAcctId());
        System.out.println(foundIt);
    }


    public static void main(String[] args) {
        test1();
    }


}
