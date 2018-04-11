package com.thoughtworks.step.bootcamp.parking;

import java.util.ArrayList;

class Listeners {
    private ArrayList<Listener> listeners;

    Listeners() {
        this.listeners = new ArrayList<>();
    }

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void sayNoSpace(){
        for (Listener listener: listeners) {
            listener.noSpace(); }
    }

    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    public boolean hasItem(Listener listener) {
        return listeners.contains(listener);
    }
}
