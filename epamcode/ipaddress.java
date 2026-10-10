package epamcode;

public class ipaddress {
    // Problem 2: Find the most frequent failed IP addresses
    // This is adapted from a reported EPAM technical interview problem involving
    // the \(k\) most frequent failed IP addresses.
    // Question: Given a list of IP addresses and an integer k, return the k most
    // frequent IP addresses.
    // Logic: Count frequencies with a hash map, then use a priority queue to select
    // the top k.

    public static boolean validIp(String s) {
        String[] arr = s.split(".");

        if (arr.length != 4) {
            return false;
        }

        for (String num : arr) {

        }

    }

    public static void main(String[] args) {

    }
}