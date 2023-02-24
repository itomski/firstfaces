package de.lubowiecki.firstfaces.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.context.FacesContext;

import java.io.Serializable;
import java.util.Locale;

@ManagedBean
@SessionScoped
public class LangBean implements Serializable {

    private Locale lang;

    public LangBean() {
        this.lang = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    }

    public Locale getLang() {
        return lang;
    }

    public void setLang(String code) {

        Locale lang = new Locale(code);
        switch(code.toUpperCase()) {
            case "DE":
            case "EN":
                FacesContext.getCurrentInstance().getViewRoot().setLocale(lang);
                this.lang = lang;
        }
    }
}
