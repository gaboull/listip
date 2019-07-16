package com.example;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        IIpAddressRetriever ipar = new IpAddressRetriever();
        IClient c = new Client(ipar);
        c.printAllIpAddresses(System.out);
    }
}
