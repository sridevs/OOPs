package com.thoughtworks.step.bootcamp.parking;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class listenersTest {
    private Listeners listeners;
    private Listener listener;

    @Before
    public void setUp() {
        listeners = new Listeners();
        listener = mock(Listener.class);
        doNothing().when(listener).noSpace();
        doNothing().when(listener).hasSpace();
        listeners.addListener(listener);
    }

    @Test
    public void shouldAddGivenListener() {
    }

    @Test
    public void shouldCallNoSpaceOfAllListeners() {
        listeners.sayNoSpace();
        verify(listener).noSpace();
    }

    @Test
    public void removeListener() {
        listeners.removeListener(listener);
//        verify(listeners).removeListener(listener);
    }
}
