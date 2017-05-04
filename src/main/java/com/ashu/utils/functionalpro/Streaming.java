package com.ashu.utils.functionalpro;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by ashishmishraw@github.com on 30/12/16.
 *
 * Practise Streaming, filtering, mapping, slicing & collecting
 */
public class Streaming {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1. All txns happened in 2011 and sort them ASC by value
        List<Transaction> txn2011 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        txn2011.stream().forEach(System.out::println);

        //2. What are all the unique cities where the traders work?
        List<Trader> traders = Arrays.asList( raoul, mario, alan, brian);

        List<String> citiesTradersWork = traders.stream()
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        citiesTradersWork.stream().forEach(System.out::println);

        //3. Find all traders from Cambridge and sort them by name.
        List<Trader> tradersFromCambridge = traders.stream()
                .filter(t->t.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        tradersFromCambridge.stream().forEach(System.out::println);

        //4. Return a string of all traders’ names sorted alphabetically.
        List<String> traderNames = traders.stream()
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.toList());
        traderNames.stream().forEach(System.out::println);

        //Okay? how about a single string having all names
        String traderNamesStr = traders.stream()
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.joining());
        System.out.println(traderNamesStr);

        //5. Are any traders based in Milan?
        System.out.println("Are any traders based in Milan? "  +
            traders.stream().anyMatch(t-> t.getCity().equals("Milan")));

        //6. Print all transactions’ values from the traders living in Cambridge.
        List<Integer> txnValueOfTradersInCambridge =  transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());

        txnValueOfTradersInCambridge.forEach(System.out::println);

        //7. What’s the highest value of all the transactions?
       Optional maxTxnVal =
                transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(Integer::max);

        System.out.println("highest txn value is: " + maxTxnVal.toString());

        //8. Find the transaction with the smallest value
        Optional minTxnVal =
                transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(Integer::min);

        System.out.println("Lowest txn value is: " + minTxnVal.toString());
    }


    public static class Trader{
        private final String name;
        private final String city;
        public Trader(String n, String c){
            this.name = n;
            this.city = c;
        }
        public String getName(){
            return this.name;
        }
        public String getCity(){
            return this.city;
        }
        public String toString(){
            return "Trader:"+this.name + " in " + this.city;
        }
    }


    public static class Transaction{
        private final Trader trader;
        private final int year;
        private final int value;
        public Transaction(Trader trader, int year, int value){
            this.trader = trader;
            this.year = year;
            this.value = value;
        }
        public Trader getTrader(){
            return this.trader;
        }
        public int getYear(){
            return this.year;
        }
        public int getValue(){
            return this.value;
        }
        public String toString(){
            return "{" + this.trader + ", " +
                    "year: "+this.year+", " +
                    "value:" + this.value +"}";
        }
    }
}
