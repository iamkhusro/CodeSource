package Learnings;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Employee {
    public int id;
    public String name;
    public double salary;
    public String department;
    public String gender;
    public int age;

    Employee () {
    }

    public Employee(int id, String name, double salary, String department, String gender, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Streams {
    public static void main(String[] args) {
        List<Employee> employees = List.of(new Employee(1, "Kunal", 2500.0, "Food", "Male", 25),
                new Employee(3, "Vishal", 5000.0, "Science", "Male", 30),
                        new Employee(2, "Alok", 1500.0, "Food", "Male", 20),
                            new Employee(4, "Jiya", 2500.0, "Political Science", "Female", 32));

        List<Integer> numList = Arrays.asList(10,15,8,49,25,98,32,49,15,49);

        //we will perform various intermediate and terminal operations to create stream pipelines

        System.out.println("Even numbers: ");
        numList.stream().filter(n -> n % 2 ==0).forEach(System.out::println);


        System.out.println("Starting with 1: ");
        numList.stream().map(n -> n + "").filter(n -> n.startsWith("1")).forEach(System.out::println);

        System.out.println("Find duplicates: ");
        Set<Integer> set = new HashSet<>();
        numList.stream().filter(n -> !set.add(n)).forEach(System.out::println);

        System.out.println("First element of list: ");
        System.out.println(numList.stream().findFirst( ).orElse(-1));

        System.out.println("Total number of elements: ");
        System.out.println(numList.stream().count());

        System.out.println("Max element: ");
        System.out.println(numList.stream().max(Integer::compare).orElse(-1));

        System.out.println("Sorted: ");
        numList.stream().sorted().forEach(System.out::println);

        System.out.println("Sorted Reverse 1: ");
        numList.stream().sorted((x,y)->y.compareTo(x)).forEach(System.out::println);

        System.out.println("Sorted Reverse 2: ");
        numList.stream().sorted((x,y) -> y - x).forEach(System.out::println);

        System.out.println("Sorted Strings Reverse: ");
        List<String> strList = List.of("hello", "welcome", "to streams");
        strList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        System.out.println("\nSort employee objects according to ids: ");
        System.out.println(employees.stream().sorted((emp1,emp2) -> emp1.getId() - emp2.getId()).toList());
        //we can use same comparator (e1,e2) -> e1.getId() - e2.getId() for max, min
        //or
        System.out.println(employees.stream().sorted(Comparator.comparingInt(Employee::getId)).toList());



        System.out.println("Distinct: ");
        numList.stream().distinct().forEach(System.out::println);

        System.out.println("First 3 values: ");
        numList.stream().limit(3).forEach(System.out::println);

        System.out.println("Skip first 3 values: ");
        numList.stream().skip(3).forEach(System.out::println);

        System.out.println("Verify if any number is less than 15: ");
        boolean verify = numList.stream().anyMatch(n -> n < 15);
        System.out.println(verify);

        System.out.println("Verify if all numbers are less than 100: ");
        boolean verify2 = numList.stream().allMatch(n -> n < 100);
        System.out.println(verify2);

        System.out.println("Verify if none are more than 100: ");
        boolean verify3 = numList.stream().noneMatch(n -> n > 100);
        System.out.println(verify3);


        System.out.println("Find any number from list: ");
        System.out.println(numList.stream().findAny().orElse(null));

        System.out.println("Find sum() or average() of all numbers from list: ");
        System.out.println(numList.stream().mapToInt(n -> n).average().orElse(-1.0));


        System.out.println("Uses of peek(): ");
        numList.stream().peek(n -> System.out.println("Peek: " + n)).filter(n -> n % 2 == 0).forEach(System.out::println);

        //peek is an intermediate operation and can be used to perform operation or debug
        //and check data one by one in between pipelines without making changes to data and then continue with other operations
        //check outputs to clear



        String str = "Java stream testing";
        System.out.println("Find the first non repeating character in a string: ");
        Character res = str.chars().mapToObj(s -> (char)s).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1).map(entry -> entry.getKey()).findFirst().orElse(null);

        System.out.println(res);


        System.out.println("Find first repeating character");
        String st1 = "New java stream testing";
        Character resChar = st1.chars().mapToObj(n -> Character.toLowerCase((char)n)).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey()).findFirst().orElse(null);
        System.out.println(resChar);


        System.out.println("Return if any element in the int array is repeating or not");
        int[] intArray = {1,5,8,9,5};
        System.out.println("method 1: ");
        List<Integer> intList = Arrays.stream(intArray).boxed().toList();
        Set<Integer> intSet = new HashSet<>(intList);
        System.out.println(intSet.size() != intList.size());

        System.out.println("Method 2: ");
        System.out.println(Arrays.stream(intArray).boxed().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().map(entry -> entry.getValue()).anyMatch(n -> n > 1));


        System.out.println("Find only duplicate elements with count");
        List<Integer> numList1 = List.of(1,6,4,9,0,9,1);
        Map<Integer, Long> intMap = numList1.stream().filter(n -> Collections.frequency(numList1, n) > 1)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(intMap);

        System.out.println("Provide count of each element: ");
        Map<Integer, Long> map = Arrays.stream(intArray).boxed().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        System.out.println(map);


        System.out.println("Concat two streams: ");
        List<String> list1 = List.of("hello", "everyone");
        List<String> list2 = List.of("welcome", "to", "streams");

        Stream<String> stream = Stream.concat(list1.stream(), list2.stream());

        stream.forEach(System.out::println);

        System.out.println("Check if list is empty using Optional, if not null iterate through the list and print the object: ");
        List<Integer> numList2 = List.of(1,6,4,9,0,9,1);
        Optional.of(numList2)
                .orElseGet(Collections::emptyList) // creates empty immutable list: [] in case numList2 is null
                .stream().filter(Objects::nonNull) //loop through each object and consider not null objects
                .forEach(System.out::println);

        System.out.println("\nSkipping null values: ");
        List<Integer> numList3 = Arrays.asList(1,5,8,3,5,12,13,14,null); //cant put null values when using List.of(), so using Arrays.asList()
        numList3.stream().filter(Objects::nonNull).forEach(System.out::println);

        System.out.println("\nSkip null values and print even: ");
        numList3.stream().filter(n -> Objects.nonNull(n) && n % 2 == 0).forEach(System.out::println);


        System.out.println("\nPrint sum of elements using reduce: ");
        System.out.println(numList.stream().reduce(0, (c,e) -> c + e));

        System.out.println("\nGiven a list of integers, write a Java program using Streams to:\n" +
                "\n" +
                "Find all numbers that are divisible by 3 and 5.\n" +
                "Square those numbers.\n" +
                "Find the maximum value among the squared numbers.");

        List<Integer> numberList = Arrays.asList(15, 30, 22, 45, 60, 18, 75);
        System.out.println(numberList.stream().filter(n -> n % 3 == 0 && n % 5 == 0)
                .map(n -> n * n).mapToInt(Integer::intValue).max().orElse(-1));



        int[] arr = new int[]{1,5,34,87};
        System.out.println("From int array: ");
        Arrays.stream(arr).forEach(System.out::println);

        int[] primitiveNumbers = {5, 2, 9, 1, 7};
        Integer[] numbers = Arrays.stream(primitiveNumbers).boxed().toArray(Integer[]::new);
        Arrays.sort(numbers, Collections.reverseOrder());


        System.out.println("Collectors to list: ");
        System.out.println(numList.stream().collect(Collectors.toList()));
        //similarly, we can directly convert to set using toSet() to get unique elements

        System.out.println("Flatten List<List<String>> to a single list: ");
        List<List<String>> listOfList = List.of(List.of("hello" , "there"), List.of("welcome", "to streams"));
        List<String> singleList = listOfList.stream().flatMap(Collection::stream).toList();
        System.out.println(singleList);

        System.out.println("Output the elements Like [hello, there, welcome, to streams]");
        System.out.println(singleList.stream().collect(Collectors.joining(", ", "[", "]")));


        System.out.println("\nFor Employee, create a Map containing id as key and salary as value: ");
        Map<Integer,Double> salMap = employees.stream().collect(Collectors.toMap(Employee::getId, Employee::getSalary));
        System.out.println(salMap);

        System.out.println("\nFor Employee, print average salary department wise: ");
        Map<String, Double> salAvgMap = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(salAvgMap);

        System.out.println("\nFor employee, count gender wise: ");
        Map<String,Long> genderCount = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(genderCount);


        System.out.println("\nFor Employee, find sum of all salaries: ");
        double salarySum = employees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(salarySum);
        //or
        double salarySum2 = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(salarySum2);


        System.out.println("\nFor Employee, summarise salary: ");
        DoubleSummaryStatistics doubleSummaryStatistics = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(doubleSummaryStatistics);

        System.out.println("\nFind employee with max or min age: ");
        System.out.println(employees.stream().max(Comparator.comparingInt(Employee::getAge)).orElse(null));
        //or
        System.out.println(employees.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge))).orElse(null));


        System.out.println("\nGet all employee department names separated by , :");
        String dept = employees.stream().map(Employee::getDepartment).distinct().collect(Collectors.joining(", "));
        System.out.println(dept);

        //Convert a List of objects into a Map by considering duplicated keys and store them in sorted order
//        Map<String, Long> notesRecords = noteLst.stream()
//                .sorted(Comparator
//                        .comparingLong(Notes::getTagId)
//                        .reversed()) // sorting is based on TagId 55,44,33,22,11
//                .collect(Collectors.toMap
//                        (Notes::getTagName, Notes::getTagId,
//                                (oldValue, newValue) -> oldValue,LinkedHashMap::new));


        System.out.println("Find the second most repeated element: ");
        List<Integer> integerList = List.of(1,6,7,1,2,7,8,2,4,2,2,7);
        Map<Integer, Long> countMap = integerList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Long> counts = countMap.values().stream().sorted(Collections.reverseOrder()).toList();

        Long secondMaxCount;
        if (counts.size() > 1) {
            secondMaxCount = counts.get(1);
            System.out.println(countMap.entrySet().stream().filter(entry -> entry.getValue().equals(secondMaxCount)).map(entry -> entry.getKey()).findFirst().orElse(null));
        }

        //in one stream
        long secondMostRepeated = integerList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted((e1,e2) -> (int)(e2.getValue() - e1.getValue())).skip(1).mapToLong(e -> e.getKey()).findFirst().orElse(-1);

        System.out.println(secondMostRepeated);


        System.out.println("Partition a list into two having even and odd numbers: ");
        List<Integer> partInt = List.of(1,6,4,3,77,51,6,1);
        Map<Boolean, List<Integer>> partIntMap = partInt.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println(partIntMap);


        System.out.println("Get summary of the list of Integers: ");
        IntSummaryStatistics intSummaryStatistics = partInt.stream().collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println(intSummaryStatistics);
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getMax());

        System.out.println("Use collectors mapping: ");
        System.out.println(partInt.stream().collect(Collectors.mapping(n -> n * 2, Collectors.toList())));
        //we can directly use stream().map(n -> n * 2).toList();


        System.out.println("Get the lengths of each string in a list: ");
        List<String> strList1 = List.of("heya", "buddy", "nice", "to", "meet", "you");
        Map<String, Integer> lengthMap = strList1.stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(lengthMap);

        System.out.println("Use collectors filtering: ");
        System.out.println(strList1.stream().collect(Collectors.filtering(n -> n.length() > 3, Collectors.toList())));


        System.out.println("Use of collectingAndThen: ");
        int size = partInt.stream().collect(Collectors.collectingAndThen(Collectors.toSet(), Set::size));
        System.out.println(size);


        System.out.println("\nFind the longest string in a list of strings: ");
        System.out.println(strList1.stream().max((x,y) -> x.length() - y.length()).orElse(""));
        //or
        System.out.println(strList1.stream().max(Comparator.comparing(String::length)).orElse(""));
        //or
        System.out.println(strList1.stream().max(Comparator.comparingInt(String::length)).orElse(""));



        System.out.println("\nCalculate the average age of a list of Employee objects: ");
        System.out.println(employees.stream().mapToInt(Employee::getAge).average().orElse(0));


        System.out.println("\nMerge two sorted lists into a single sorted list: ");
        List<Integer> l1 = List.of(1,4,8,10,22);
        List<Integer> l2 = List.of(15,33,80,102,220);
        System.out.println(Stream.concat(l1.stream(), l2.stream()).sorted().toList());


        System.out.println("\nFind the intersection of two lists: ");
        List<Integer> l3 = List.of(1,4,15,8,10,22,44);
        List<Integer> l4 = List.of(15,33,44,80,102,220);
        System.out.println(l3.stream().filter(l4::contains).toList());

        System.out.println("\nFind the kth smallest element: ");
        List<Integer> l5 = List.of(100,140,1,4,15,8,10,22,44);
        int k = 5;
        System.out.println(l5.stream().sorted().skip(k - 1).findFirst().orElse(-1));

        System.out.println("\nGiven a list of strings, find the frequency of each word: ");
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
        Map<String, Long> freqMap = words.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        //use LinkedHashMap to maintain order, else don't pass anything
        System.out.println(freqMap);



        System.out.println("\nUsing Collectors.teeing() to calculate Average and Sum: ");
        List<Integer> nums = IntStream.rangeClosed(1, 10).boxed().toList();

        String result = nums.stream().collect(
                Collectors.teeing(
                        Collectors.averagingInt(Integer::intValue),
                        Collectors.summingInt(Integer::intValue),
                        (average, sum) -> String.format("Average: %.2f, Sum: %d", average, sum)
                )
        );

        System.out.println(result);


        System.out.println("\nUsing Collectors.teeing() to Filter and Count: ");
        HashMap<String, Object> resultMap = employees.stream().collect(
                Collectors.teeing(
                        Collectors.filtering(e -> e.getSalary() > 200, Collectors.toList()),
                        Collectors.filtering(e -> e.getSalary() > 200, Collectors.counting()),
                        (list, count) -> {
                            HashMap<String, Object> newMap = new HashMap();
                            newMap.put("list", list);
                            newMap.put("count", count);
                            return newMap;
                        }
                ));

        System.out.println(resultMap);


        System.out.println("\nGiven a list of strings, group them by their length using a Map<Integer, List<String>>: ");
        List<String> stringList = List.of("cat", "dog", "elephant", "bat", "lion");
        Map<Integer, List<String>> groupList = stringList.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(groupList);


        System.out.println("\nGiven a list of strings, return a sorted list of all distinct characters present in all the strings: ");
        List<String> list3 = List.of("apple", "banana", "cherry");
        List<Character> charList = list3.stream().reduce((a,b) -> a + b).orElse("").chars().mapToObj(n -> (char)n).distinct().sorted().toList();
        System.out.println(charList);


        System.out.println("\nGiven a list of strings, count how many strings start with a specific prefix: ");
        List<String> list4 = List.of("apple", "apricot", "banana", "cherry", "ape");
        String prefix = "ap";
        System.out.println(list4.stream().filter(s -> s.startsWith(prefix)).count());


        System.out.println("\nFind the maximum and minimum value from a list of integers using teeing(): ");
        List<Integer> list5 = List.of(5, 10, 20, 1, 8);
        String ans = list5.stream().collect(Collectors.teeing(
                Collectors.maxBy(Integer::compareTo),
                Collectors.minBy(Integer::compareTo),
                (max,min) -> "Max: " + max.orElse(-1) + ", Min: " + min.orElse(-1)
        ));
        System.out.println(ans);


        System.out.println("\nGiven multiple lists of integers, find the common elements that are present in all lists: ");
        List<Integer> commList1 = List.of(7,3,1,8,32,51);
        List<Integer> commList2 = List.of(9,1,4,8,51);
        List<Integer> commList3 = List.of(3,10,1,8,51,100,34);

        System.out.println(commList1.stream().filter(commList2::contains).filter(commList3::contains).toList());


        System.out.println("\nFind Strings with Only Digits: ");
        List<String> numStrList = List.of("123", "abc", "45", "hello", "6789");
        System.out.println(numStrList.stream().filter(s -> s.matches("\\d+")).toList());


        System.out.println("\nGiven two lists of equal size, combine them into a map where one list provides keys and the other provides values: ");
        List<String> keys = List.of("name", "age", "city");
        List<String> values = List.of("Alice", "30", "New York");

        Map<String,String> kV = IntStream.range(0, keys.size()).boxed().collect(Collectors.toMap(keys::get, values::get));
        System.out.println(kV);

        //Explanation:
        //IntStream.range(0, keys.size()): Creates a stream of indices from 0 to keys.size() - 1.
        //.boxed(): Converts the IntStream to a Stream<Integer> for easier collection.
        //.collect(Collectors.toMap(keys::get, values::get)):
        //Maps each index to its corresponding element in keys (key) and values (value) using keys::get and values::get.


        System.out.println("\nGiven a List<Integer>, write a stream-based solution to find the second largest unique number. If the list does not have at least two unique numbers, return Optional.empty(): ");
        List<Integer> intNumbers = Arrays.asList(5, 3, 9, 1, 3, 9, 7);
        Optional<Integer> optional = intNumbers.stream().filter(n -> Collections.frequency(intNumbers, n) == 1)
                .sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(optional.isPresent() ? optional.get() : optional);


        System.out.println("Check whether a string is Pangram or not. (A word or a sentence is called a pangram if it contains all the English alphabet letters.): ");
        String pangram = "TheQuickBrownFoxJumpsOverTheLazyDog";
        Set<Character> allChars = pangram.toLowerCase().chars()
                .mapToObj(n -> (char)n).collect(Collectors.toSet());
        System.out.println(allChars.size() == 26);

        System.out.println("Show employees department wise with highest salary: ");
        Map<String, Optional<Employee>> empMap = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        for (String dep : empMap.keySet()) {
            System.out.println("Department: " + dep + ", Name: " + empMap.get(dep).orElse(new Employee()).getName());
        }
    }

}
