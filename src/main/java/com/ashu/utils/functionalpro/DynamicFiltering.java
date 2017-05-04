package com.ashu.utils.functionalpro;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

/**
 * http://stackoverflow.com/questions/22845574/how-to-dynamically-do-filtering-in-java-8
 *
 * Examples of how to construct stream pipelines dynamically using predicates
 * and context-sensitive filtering criteria. Instances of functional interfaces
 * are stored in data structures and are composed using reduce() and are then
 * applied to the stream. This allows an arbitrary number of predicates or
 * filtering criteria to be applied in one pipeline stage.
 *
 * @author smarks
 */
public class DynamicFiltering {


    public static void main(String[] args) {

        DynamicFiltering df = new DynamicFiltering();
        df.composeCriteria();
        df.composePredicates();
    }

    /**
     * Composes several predicates into a single predicate, and then
     * applies the composite predicate to a stream.
     */
    void composePredicates() {
        System.out.println();
        System.out.println("Composed predicates:");
        System.out.println();

        List<Predicate<Widget>> allPredicates = Arrays.asList(
                w -> w.length() >= 10,
                w -> w.weight() > 40.0,
                w -> w.name().compareTo("c") > 0
        );

        Predicate<Widget> compositePredicate =
                allPredicates.stream()
                        .reduce(w -> true, Predicate::and);

        widgetList.stream()
                .filter(compositePredicate)
                .forEach(System.out::println);
    }

    /**
     * Composes several criteria into a single criterion, and then
     * applies the composite criterion to a stream.
     */
    void composeCriteria() {

        System.out.println();
        System.out.println("Composed criteria:");
        System.out.println();

        List<Criterion> allCriteria = Arrays.asList(
                fromPredicate(w -> w.length() > 10),
                topN(comparing(Widget::length).reversed(), 4L),
                topPercent(comparing(Widget::weight), 0.50)
        );

        Criterion compositeCriteria =
                allCriteria.stream()
                        .reduce(c -> c, (c1, c2) -> (s -> c2.apply(c1.apply(s))));

        compositeCriteria.apply(widgetList.stream())
                .forEach(System.out::println);
    }

    /**
     * Creates a Criterion from a Predicate.
     */
    Criterion fromPredicate(Predicate<Widget> pred) {
        return stream -> stream.filter(pred);
    }

    /**
     * Creates a Criterion that sorts the stream using a Comparator {@code cmp}
     * and then returns a stream of the first {@code n} elements of the result.
     */
    Criterion topN(Comparator<Widget> cmp, long n) {
        return stream -> stream.sorted(cmp).limit(n);
    }

    /**
     * Creates a Criterion that sorts the stream using a Comparator {@code cmp}
     * and then returns a stream of the first {@code pct} portion of the
     * elements. The {@code pct} value should be between 0.0 and 1.0.
     */
    Criterion topPercent(Comparator<Widget> cmp, double pct) {
        return stream -> {
            List<Widget> temp =
                    stream.sorted(cmp).collect(toList());
            return temp.stream()
                    .limit((long)(temp.size() * pct));
        };
    }

    /**
     * Creates a Criterion that sorts the stream using a Comparator {@code cmp}
     * and then returns a stream of the percentile range from {@code from} to
     * {@code to} expressed as fractions between 0.0 and 1.0.
     *
     * See this followup question:
     * http://stackoverflow.com/questions/22917270/how-to-get-a-range-of-items-from-stream-using-java-8-lambda
     */
    Criterion topPercentFromRange(Comparator<Widget> cmp, double from, double to) {
        return stream -> {
            List<Widget> temp =
                    stream.sorted(cmp).collect(toList());
            return temp.stream()
                    .skip((long)(temp.size() * from))
                    .limit((long)(temp.size() * (to - from)));
        };
    }

    List<Widget> widgetList;

    /**
     * Populates widgetList with some sample data.
     */
    DynamicFiltering() {
        widgetList = Arrays.asList(
                new Widget("a", 20, 22.5),
                new Widget("b", 10, 15.2),
                new Widget("c", 30, 95.7),
                new Widget("d", 25,  7.5),
                new Widget("e", 17, 62.7),
                new Widget("f", 28, 44.1),
                new Widget("g",  9, 13.2),
                new Widget("h", 13, 33.5),
                new Widget("i", 42, 14.0),
                new Widget("j", 37, 59.3)
        );
    }
}

/**
 * A function that takes a Stream<Widget> and returns a Stream<Widget>.
 * This is essentially a UnaryOperator<Stream<Widget>> but it's defined using
 * specific types so that there are fewer generics. Simple intermediate
 * operations like filter() take a Stream<T> and return Stream<T>, so chaining
 * Criterion objects together is like adding a variable number of intermediate
 * operations to a pipeline. A Criterion may be "context-sensitive" in that
 * it may use information about the size of the stream. In order to compute
 * this, the stream elements must first be collected into a list, so that the
 * number of elements can be determined before filtering a subset of the
 * elements based on their number.
 */
@FunctionalInterface
interface Criterion {
    Stream<Widget> apply(Stream<Widget> s);
}

/**
 * A POJO that has name, length, and weight attributes.
 */
class Widget {
    final String name;
    final int length;
    final double weight;

    public Widget(String name, int length, double weight) {
        this.name = name;
        this.length = length;
        this.weight = weight;
    }

    public String name() { return name; }
    public int length() { return length; }
    public double weight() { return weight; }

    @Override
    public String toString() {
        return String.format("[%s, %2d, %4.1f]", name, length, weight);
    }
}