package com.tomilyk.crudito;

public class PersonaFisica {
    private String name;
    private String lastname;
    private String ine;
    private String rfc;

    public PersonaFisica(String name, String lastname, String ine, String rfc) {
        this.name = name;
        this.lastname = lastname;
        this.ine = ine;
        this.rfc = rfc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @Override
    public String toString() {
        return name + " " + lastname + " " + ine + " " + rfc;
    }
}
