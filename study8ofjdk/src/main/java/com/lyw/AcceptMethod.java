package com.lyw;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Lenovo on 2018/12/4.
 */
public class AcceptMethod {

    public static void main(String[] args ){
        String[] lettersArray = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        List<String> lettersList = Arrays.asList(lettersArray);

        System.out.println("地址为："+System.identityHashCode(lettersList));

        List<String> output1 = lettersList.stream().map(String::toUpperCase).collect(Collectors.toList());
        List<String> output2 = lettersList.stream().map(x->x).collect(Collectors.toList());


        Stream<List<Integer>> inputStream = Stream.of(Arrays.asList(1), Arrays.asList(3,3), Arrays.asList(4,5,6));
        Stream<Integer> newInput = inputStream.flatMap(x->x.stream());
        List<Integer> listOfInt = newInput.collect(Collectors.toList());
        listOfInt.forEach(x->System.out.println(x));

        Consumer<String> printlnStr = x ->{
            System.out.println("输出当前字母:"+x);
        };
        output1.stream().forEach(x->printlnStr.accept(x));



        Predicate<String> deleteR = x -> {
            return !x.equals("r");
        };

        List<String> listOfAfterFilter = lettersList.stream().filter(x-> deleteR.test(x)).collect(Collectors.toList());
        String str = lettersList.stream().filter(x-> deleteR.test(x)).collect(Collectors.joining()).toString();
        System.out.println(str);
        listOfAfterFilter.stream().forEach(x -> printlnStr.accept(x));

        print(null);
        print("");
        print("发生大幅");
        getLength(null);
        getLength("");
        getLength("abcccc");
    }

    /**
     * optional用例
     */
    public static void print(String text) {
        Optional.ofNullable(text).ifPresent(System.out::println);
    }

    public static int getLength(String text) {
        return Optional.ofNullable(text).map(String::length).orElse(-1);
    }



}
