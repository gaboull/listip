package com.example;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.List;

public interface IIpAddressRetriever {
    List<InetAddress> retrieve(NetworkInterface nif);

    List<InetAddress> retrieveAll() throws IOException;
}
