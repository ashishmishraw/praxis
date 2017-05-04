package com.ashu.utils.jvm;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class MemoryLeakDemo {

    public static void main(String[] args) throws InterruptedException {
        Map<Key, String> map = new HashMap<Key, String>(1000);
        int counter = 0;

        while (true) {
            // creates duplicate objects due to bad Key class
            map.put(new Key("dummyKey"), "value");
            counter++;
            if (counter % 1000 == 0) {
                System.out.println("map size: " + map.size());
                TimeUnit.SECONDS.sleep(2);
            }
        }
    }

    // inner class key without hashcode() or equals()  properly implemented with Java 8 "Objects" class
    static class Key {
        private String key;

        public Key(String key) {
            this.key = key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key); // Java 8 Objects class
        }

        /**
         * Important - removing equals implementation causes increase in size of HashMap
         * @param obj
         * @return
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }

            Key other = (Key) obj;

            return Objects.equals(this.key, other.key); // Java 8 Objects class
        }

    }
}