package de.lubowiecki.firstfaces.listener;

import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.faces.event.ValueChangeListener;

public class CategoryChangeListener implements ValueChangeListener {

    @Override
    public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
        System.out.println("geändert von " + event.getOldValue() + " auf " + event.getNewValue());
    }
}
