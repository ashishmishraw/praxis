package com.ashu.utils.puzz;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mishra.ashish@icloud.com
 */
public class LogAnalyzer {

    private static final Scanner scan = new Scanner(System.in);
    private static List<String> logEntries = new ArrayList<>();

    public static void main(String[] args) {
        String filename;
        filename = scan.nextLine();

        readFile(filename + ".txt");

        Map<String, Long> counted = logEntries.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        counted.entrySet().forEach(  e -> System.out.println(e.getKey() + " " + e.getValue() ) );

    }

    private static void readFile(String fileName) {

        try (Stream<String> stream = Files.lines(Paths.get( new File(".").getCanonicalPath() + "/src/main/java/com/ashu/utils/puzz/"+ fileName))) {

            stream.forEach(s -> {
                String[] lineArray = s.split("- -");
                logEntries.add(lineArray[0]);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
