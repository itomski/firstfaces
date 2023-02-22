package de.lubowiecki.firstfaces;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;

import java.io.Serializable;

@ManagedBean
@SessionScoped
public class MoinBean implements Serializable {

    private int count;

    public String getGreeting() {
        return "Moin Moin " + ++count;
    }
}
