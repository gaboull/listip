package com.example;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClientTest {

    @InjectMocks
    private Client sut;

    @Mock
    private IIpAddressRetriever iparMock;

    @Test
    public void testPrintAllIpAddresses() throws IOException {
        InetAddress ip1Mock = mock(InetAddress.class);
        when(ip1Mock.isSiteLocalAddress()).thenReturn(false);
        InetAddress ip2Mock = mock(InetAddress.class);
        when(ip2Mock.getHostAddress()).thenReturn("ip2");
        when(ip2Mock.isSiteLocalAddress()).thenReturn(true);
        when(iparMock.retrieveAll()).thenReturn(Arrays.asList(ip1Mock, ip2Mock));
        PrintStream outMock = mock(PrintStream.class);

        sut.printAllIpAddresses(outMock);

        verify(ip1Mock).isSiteLocalAddress();
        verifyNoMoreInteractions(ip1Mock);
        verify(ip2Mock).isSiteLocalAddress();
        verify(ip2Mock).getHostAddress();
        verifyNoMoreInteractions(ip2Mock);
        verify(iparMock).retrieveAll();
        verifyNoMoreInteractions(iparMock);
        verify(outMock).println("ip2");
        verifyNoMoreInteractions(outMock);
    }
}
