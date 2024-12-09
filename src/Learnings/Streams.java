package Learnings;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
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
        strList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

        //for objects
        //employees.stream().sorted((e1,e2) -> e1.getId() - e2.getId()))
        //we can use same comparator (e1,e2) -> e1.getId() - e2.getId() for max, min



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

        //peek is an intermediate operation and can be used to perform operation or check data one by one in between pipelines without making changes to data and then continue with other operations.
        //check outputs to clear



        String str = "Java stream testing";
        System.out.println("Find the first non repeating character in a string: ");
        String res = str.chars().mapToObj(s -> Character.toString((char)s).toLowerCase()).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1).map(entry -> entry.getKey()).findFirst().orElse(null);

        System.out.println(res);


        System.out.println("Find first repeating character");
        String st1 = "New java stream testing";
        Character resChar = st1.chars().mapToObj(n -> Character.toLowerCase((char)n)).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey()).findFirst().orElse(null);
        System.out.println(resChar);


        System.out.println("Return if any element in the in array is repeating or not");
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
        Map<Integer, Long> intMap = numList1.stream().filter(n -> Collections.frequency(numList1, n) > 1).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(intMap);

        System.out.println("Provide count of each element: ");
        Map<Integer, Long> map = Arrays.stream(intArray).boxed().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        System.out.println(map);


        System.out.println("Concat two streams: ");
        List<String> list1 = List.of("hello", "everyone");
        List<String> list2 = List.of("welcome", "to", "streams");

        Stream<String> stream = Stream.concat(list1.stream(), list2.stream());

        stream.forEach(System.out::println);

        System.out.println("Check if list is empty in using Optional, if not null iterate through the list and print the object: ");
        List<Integer> numList2 = List.of(1,6,4,9,0,9,1);
        Optional.of(numList2)
                .orElseGet(Collections::emptyList) // creates empty immutable list: [] in case noteLst is null
                .stream().filter(Objects::nonNull) //loop through each object and consider not null objects
                .forEach(System.out::println);

        System.out.println("Print sum of elements using reduce: ");
        System.out.println(numList.stream().reduce(0, (c,e) -> c + e));



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


        //suppose for an object Employee, we want to create a Map containing id as key and salary as value
        //Map<Integer,Double> map = employees.stream().collect(Collectors.toMap(Employee::getId, Employee::getSalary));

        //average salary department wise
        //Map<String,Double> map = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary));

        //count gender wise
        //Map<String,Double> map = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting());


        //sum of all salary
        //double salarySum = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));


        //summarising on salary
        //double salarySum = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

        //employee with max or min age
        //Employee emp = employees.stream().collect(Collectors.maxBy((emp1, emp2) -> exp1.getSalary() - emp2.getSalary())).orElse(null);
        //Alternate, Employee emp = employees.stream().max((emp1, emp2) -> emp1.getSalary() - emp2.getSalary()).orELse(null);


        //get all department names separated by ,
        //String departments = employees.stream().map(Employee::getDepartment).collect(Collectors.joining(", "));

        //Convert a List of objects into a Map by considering duplicated keys and store them in sorted order
//        Map<String, Long> notesRecords = noteLst.stream()
//                .sorted(Comparator
//                        .comparingLong(Notes::getTagId)
//                        .reversed()) // sorting is based on TagId 55,44,33,22,11
//                .collect(Collectors.toMap
//                        (Notes::getTagName, Notes::getTagId,
//                                (oldValue, newValue) -> oldValue,LinkedHashMap::new));


        System.out.println("Find the second most repeated element: ");
        List<Integer> integerList = List.of(1,6,7,1,2,8,2,4,2);
        Map<Integer, Long> countMap = integerList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Long> counts = countMap.values().stream().sorted(Collections.reverseOrder()).toList();

        Long secondMaxCount;
        if (counts.size() > 1) {
            secondMaxCount = counts.get(1);
            System.out.println(countMap.entrySet().stream().filter(entry -> entry.getValue().equals(secondMaxCount)).map(entry -> entry.getKey()).findFirst().orElse(null));
        }


        System.out.println("Partition a list into two having even and odd numbers: ");
        List<Integer> partInt = List.of(1,6,4,3,77,51);
        Map<Boolean, List<Integer>> partIntMap = partInt.stream().collect(Collectors.partitioningBy(n -> n % 2== 0));

        System.out.println(partIntMap);


        System.out.println("Get summary of the list of Integers: ");
        IntSummaryStatistics intSummaryStatistics = partInt.stream().collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println(intSummaryStatistics.toString());
        System.out.println(intSummaryStatistics.getAverage());

        System.out.println("Use collectors mapping: ");
        System.out.println(partInt.stream().collect(Collectors.mapping(n -> n * 2, Collectors.toList())));
        //old way, now we can directly use stream().map(n -> n * 2).toList();
    }
}
