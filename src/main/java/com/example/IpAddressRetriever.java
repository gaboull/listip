package com.example;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class IpAddressRetriever implements IIpAddressRetriever {

    @Override
    public List<InetAddress> retrieve(NetworkInterface nif) {
        List<InetAddress> result = new ArrayList<>();
        for (Enumeration<InetAddress> en = nif.getInetAddresses(); en.hasMoreElements();) {
            result.add(en.nextElement());
        }

        return result;
    }

    @Override
    public List<InetAddress> retrieveAll() throws IOException {
        List<InetAddress> result = new ArrayList<>();
        for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
            result.addAll(retrieve(en.nextElement()));
        }

        return result;
    }

}
