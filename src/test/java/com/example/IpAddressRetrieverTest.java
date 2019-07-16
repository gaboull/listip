package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IpAddressRetrieverTest {

    @InjectMocks
    private IpAddressRetriever sut;

    @Test
    public void testRetrieve() throws IOException {
        InetAddress ip1Mock = mock(InetAddress.class);
        InetAddress ip2Mock = mock(InetAddress.class);
        NetworkInterface nifMock = mock(NetworkInterface.class);
        when(nifMock.getInetAddresses()).thenReturn(Collections.enumeration(Arrays.asList(ip1Mock, ip2Mock)));

        List<InetAddress> actual = sut.retrieve(nifMock);

        verifyZeroInteractions(ip1Mock);
        verifyZeroInteractions(ip2Mock);
        verify(nifMock).getInetAddresses();
        verifyNoMoreInteractions(nifMock);
        assertNotNull(actual);
        assertTrue(actual.size() == 2);
        assertEquals(ip1Mock, actual.get(0));
        assertEquals(ip2Mock, actual.get(1));
    }
}
