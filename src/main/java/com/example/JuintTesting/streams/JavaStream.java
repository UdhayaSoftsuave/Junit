package com.example.JuintTesting.streams;

import org.springframework.util.ConcurrentReferenceHashMap;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStream {
    public static List<String> stringList = List.of("a","b","c","a","e","d", "b");
    public static List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    public static List<Integer> intLists = List.of(11,12,33,24,15,66,17,58,29,10);
    private static String string = "Java articles are Awesome";

    private static List<Student> studentlist = List.of(
            new Student(1,"udhaya",12,67),
            new Student(1,"kumar",14,98),
            new Student(1,"Zen",13,78),
            new Student(1,"Ani",16,71),
            new Student(1,"prabu",11,63)
    );
    private static List<Student> studentListWithDuplicateName = List.of(
            new Student(1,"Udhaya",12,67),
            new Student(1,"Kumar",14,98),
            new Student(1,"Zen",13,78),
            new Student(1,"Ani",16,71),
            new Student(1,"Ani",18,81),
            new Student(1,"Udhaya",9,88),
            new Student(1,"Udhaya",9,100),
            new Student(1,"Prabu",11,63)
    );
    private static List<Integer> randamInteger = Arrays.asList(4,5,6,7,1,2,3);

    private static int nums[] = {1,2,3,1};

    public static void main(String[] args) {
        Comparator<Integer> comparing = Comparator.comparing(Integer::intValue);
        // MIN
        Optional<Integer> min = intList.stream().collect(Collectors.minBy(comparing));
        Optional<Integer> min1 = intList.stream().min(comparing);
        System.out.println("Minvalue by collect() : "+ min + " and min() :" +min1);

        //MAX
        Optional<Integer> max = intList.stream().collect(Collectors.maxBy(comparing));
        Optional<Integer> max1 = intList.stream().max(comparing);
        System.out.println("Maxvalue by collect() : "+ max + " and min() :" +max1);

        // toCollection()
        // we can convert anything under the collection.
        LinkedList<String> toCollection = stringList.stream().collect(Collectors.toCollection(LinkedList::new));
        System.out.println(toCollection instanceof LinkedList);

        //toList & toUnmodifiedList
        List<String> list = stringList.stream().collect(Collectors.toList());
        List<String> unmodifiableList = stringList.stream().collect(Collectors.toUnmodifiableList());
        System.out.println("List : " + list + " & UnModifiedLied : " +unmodifiableList);

        //toSet & toUnmodifiedList
        Set<String> set = stringList.stream().collect(Collectors.toSet());
        Set<String> unmodifiableSet = stringList.stream().collect(Collectors.toUnmodifiableSet());
        System.out.println("Set : " + set + " & UnModifiedLied : " +unmodifiableSet);

        //joining
        String joining = stringList.stream().collect(Collectors.joining());
        System.out.println("Joining String : " + joining);
        String joiningUsingDelimiter = stringList.stream().collect(Collectors.joining("*"));
        System.out.println("Joining String using delimiter '*' : " + joiningUsingDelimiter);
        String joiningPrefixSuffix = stringList.stream().collect(Collectors.joining(",", "Letter are '", "' "));
        System.out.println("Joining String using prefix & suffix: " + joiningPrefixSuffix);


        //counting
        Long count = intList.stream().collect(Collectors.counting());
        System.out.println("Total count : "+ count);

        //summing
        Integer summingInt = intList.stream().collect(Collectors.summingInt(Integer::intValue));
        Long summingLong = intList.stream().collect(Collectors.summingLong(Integer::intValue));
        Double summingDouble = intList.stream().collect(Collectors.summingDouble(Integer::intValue));

        System.out.println("summingInt " + summingInt);
        System.out.println("summingLong " + summingLong);
        System.out.println("summingDouble " + summingDouble);

        //Average
        Double averagingInt = intList.stream().collect(Collectors.averagingInt(Integer::intValue));
        Double averagingLong = intList.stream().collect(Collectors.averagingLong(Integer::intValue));
        Double averagingDouble = intList.stream().collect(Collectors.averagingDouble(Integer::intValue));

        System.out.println("AveragingInt " + averagingInt);
        System.out.println("AveragingLong " + averagingLong);
        System.out.println("AveragingDouble " + averagingDouble);

        //summarizing
        IntSummaryStatistics summarizingInt = intList.stream().collect(Collectors.summarizingInt(Integer::intValue));
        LongSummaryStatistics summarizingLong = intList.stream().collect(Collectors.summarizingLong(Integer::intValue));
        DoubleSummaryStatistics summarizingDouble = intList.stream().collect(Collectors.summarizingDouble(Integer::intValue));

        System.out.println("SummarizingInt " + summarizingInt);
        System.out.println("SummarizingLong " + summarizingLong);
        System.out.println("SummarizingDouble " + summarizingDouble);

        //map
        Map<String, Student> studentMap = studentlist.stream().collect(Collectors.toMap(Student::getName, Function.identity()));
        Map<String, Student> unmodifiableStudentMap = studentlist.stream().collect(Collectors.toUnmodifiableMap(Student::getName, Function.identity()));
        Map<String, Student> ConcurrentStudentMap = studentlist.stream().collect(Collectors.toConcurrentMap(Student::getName, Function.identity()));
//        for(Map.Entry<String, Student> student : ConcurrentStudentMap.entrySet())
//            System.out.println(student.getKey() + " --> "+ student.getValue());

        Map<String, Student> studentMapByMerging = studentListWithDuplicateName.stream().collect(Collectors.toMap(Student::getName, Function.identity(), (a, b) -> b));
        Map<String, Student> unmodifiableStudentMapByMerging = studentListWithDuplicateName.stream().collect(Collectors.toUnmodifiableMap(Student::getName, Function.identity(), (a, b) -> b));
        Map<String, Student> ConcurrentStudentMapByMerging = studentlist.stream().collect(Collectors.toConcurrentMap(Student::getName, Function.identity(), (a, b) -> b));
//        for(Map.Entry<String, Student> student : ConcurrentStudentMapByMerging.entrySet())
//            System.out.println(student.getKey() + " --> "+ student.getValue());

        TreeMap<String, Student> studentMapWithSorted = studentListWithDuplicateName.stream().collect(Collectors.toMap(Student::getName, Function.identity(), (a, b) -> b, TreeMap::new));
        Map<String, Student> ConcurrentStudentMapWithSorted = studentlist.stream().collect(Collectors.toConcurrentMap(Student::getName, Function.identity(), (a, b) -> b, ConcurrentSkipListMap::new));
//        for(Map.Entry<String, Student> student : ConcurrentStudentMapWithSorted.entrySet())
//            System.out.println(student.getKey() + " --> "+ student.getValue());

        //groupBy
        Map<String, List<Student>> groupByName = studentListWithDuplicateName.stream().collect(Collectors.groupingBy(Student::getName));
        Map<String, List<Student>> concurrentGroupByName = studentListWithDuplicateName.stream().collect(Collectors.groupingByConcurrent(Student::getName));
//        for(Map.Entry<String, List<Student>> student : concurrentGroupByName.entrySet())
//            System.out.println(student.getKey() + " --> "+ student.getValue());

        Map<String, Integer> sumMarkByGroupByName = studentListWithDuplicateName.stream().collect(Collectors.groupingBy(Student::getName, Collectors.summingInt(Student::getMark)));
        Map<String, Integer> concurrentSumMarkByGroupByName = studentListWithDuplicateName.stream().collect(Collectors.groupingByConcurrent(Student::getName, Collectors.summingInt(Student::getMark)));
//        for(Map.Entry<String, Integer> student : concurrentSumMarkByGroupByName.entrySet())
//            System.out.println(student.getKey() + " --> "+ student.getValue());

        Map<String, Integer> sumMarkByGroupByNameWithOrdered = studentListWithDuplicateName.stream().collect(Collectors.groupingBy(Student::getName, TreeMap::new, Collectors.summingInt(Student::getMark)));
        Map<String, Integer> concurrentSumMarkByGroupByNameWithOrdered = studentListWithDuplicateName.stream().collect(Collectors.groupingByConcurrent(Student::getName, ConcurrentReferenceHashMap::new, Collectors.summingInt(Student::getMark)));
//        for(Map.Entry<String, Integer> student : sumMarkByGroupByNameWithOrdered.entrySet())
//            System.out.println(student.getKey() + " --> "+ student.getValue());

        //partitionBy
        Map<Boolean, List<Student>> partitionBy = studentlist.stream().collect(Collectors.partitioningBy(Student::isPassed));
//        for(Map.Entry<Boolean, List<Student>> student : partitionBy.entrySet())
//            System.out.println(student.getKey() + " --> "+ student.getValue());


        //print even Numbers from the list
        List<Integer> evenNumbers = intList.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers);

        //StartWith1
        List<Integer> startWith1 = intLists.stream().map(a -> a + "").filter(a -> a.startsWith("1")).map(a -> Integer.valueOf(a)).collect(Collectors.toList());
        System.out.println(startWith1);


        //Distinct values
        List<String> distinct = stringList.stream().distinct().collect(Collectors.toList());
        System.out.println(distinct);


        //Find Duplicates
        Map<String, Long> countList = stringList.stream().collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
        List<String> collect = countList.entrySet().stream().filter(a -> a.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(collect);

        Optional<Integer> first = intLists.stream().findFirst();
        System.out.println(first);

        Optional<Integer> firstAny = intLists.stream().findAny();
        System.out.println(firstAny);

        //firstNonRepeatedCharacterInString
        LinkedList<String> collect1 = string.chars().mapToObj(a -> String.valueOf((char)a).toLowerCase()).collect(Collectors.toCollection(LinkedList::new));
        LinkedHashMap<String, Long> collect2 = collect1.stream().collect(Collectors.groupingBy(String::valueOf, LinkedHashMap::new, Collectors.counting()));
        Map.Entry<String, Long> stringLongEntry = collect2.entrySet().stream().filter(e -> e.getValue() == 1L).findFirst().get();
        System.out.println(stringLongEntry.getKey());

        //firstRepeatedCharacterInString
        LinkedList<String> collect3 = string.chars().mapToObj(a -> String.valueOf((char)a).toLowerCase()).collect(Collectors.toCollection(LinkedList::new));
        LinkedHashMap<String, Long> collect4 = collect1.stream().collect(Collectors.groupingBy(String::valueOf, LinkedHashMap::new, Collectors.counting()));
        Map.Entry<String, Long> stringLongEntry1 = collect2.entrySet().stream().filter(e -> e.getValue() > 1L).findFirst().get();
        System.out.println(stringLongEntry1.getKey());

        //printListInReverseOrder
        List<Integer> collect5 = intList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(collect5);

        // Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
        Set<Integer> collect6 = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        System.out.println(collect6.size() != nums.length);

        //concatenate two Streams
        Stream<Integer> concatStream = Stream.concat(intList.stream(), intLists.stream());
        List<Integer> collect7 = concatStream.collect(Collectors.toList());
        System.out.println(collect7);

        //perform cube on list elements and filter numbers greater than 50.
        List<Integer> collect8 = randamInteger.stream().map(i -> i * i * i).filter(i -> i > 50).collect(Collectors.toList());
        System.out.println(collect8);

        //sort an array and then convert the sorted array into Stream
        Stream<Integer> sorted = Arrays.stream(nums).boxed().sorted();
        System.out.println(sorted);

        // List of objects into a Map by considering duplicated keys and store them in sorted order
        Map<String, List<Student>> collect9 = studentListWithDuplicateName.stream().collect(Collectors.groupingBy(Student::getName));
        for(Map.Entry<String, List<Student>>  student : collect9.entrySet())
            System.out.println(student.getKey() + " --> "+ student.getValue());

        //How to count each element/word from the String ArrayList in Java8
        Map<String, Long> collect10 = stringList.stream().collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
        System.out.println(collect10);


        //How to find only duplicate elements with its count from the String ArrayList in Java8
        List<Map.Entry<String, Long>> collect11 = stringList.stream().collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet().stream().filter(a -> a.getValue() > 1).collect(Collectors.toList());
        System.out.println(collect11);

        //How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order
        Map<String, Set<Student>> collect12 = studentListWithDuplicateName.stream().collect(Collectors.groupingBy(Student::getName,Collectors.toCollection(TreeSet::new)));
        System.out.println(collect12);
    }
}
