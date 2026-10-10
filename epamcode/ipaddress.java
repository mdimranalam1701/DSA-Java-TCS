package epamcode;

import java.util.*;

public class ipaddress {
    // Problem 2: Find the most frequent failed IP addresses
    // This is adapted from a reported EPAM technical interview problem involving
    // the \(k\) most frequent failed IP addresses.
    // Question: Given a list of IP addresses and an integer k, return the k most
    // frequent IP addresses.
    // Logic: Count frequencies with a hash map, then use a priority queue to select
    // the top k.

    public static List<String> topKFrequent(
            String[] ips, int k) {

        Map<String, Integer> freq = new HashMap<>();

        for (String ip : ips) {
            freq.put(ip, freq.getOrDefault(ip, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
                (a, b) -> {
                    int compare = Integer.compare(
                            freq.get(a), freq.get(b));

                    if (compare == 0) {
                        return b.compareTo(a);
                    }

                    return compare;
                });

        for (String ip : freq.keySet()) {
            pq.offer(ip);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        String[] ips = {
                "10.0.0.1", "10.0.0.2",
                "10.0.0.1", "10.0.0.3",
                "10.0.0.1", "10.0.0.2"
        };

        System.out.println(topKFrequent(ips, 2));
    }
}
