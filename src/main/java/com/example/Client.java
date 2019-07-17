package com.example;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;

public class Client implements IClient {

    private IIpAddressRetriever ipar;

    public Client(IIpAddressRetriever ipar) {
        this.ipar = ipar;
    }

    @Override
    public void printAllIpAddresses(PrintStream out) {
        try {
            for (InetAddress adr : ipar.retrieveAll()) {
                if (adr.isSiteLocalAddress()) {
                    out.println(adr.getHostAddress());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
