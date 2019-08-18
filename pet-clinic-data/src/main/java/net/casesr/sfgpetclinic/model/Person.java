package net.casesr.sfgpetclinic.model;

public class Person extends BaseEntity {
    private String firstName;
    private String lastNme;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNme() {
        return lastNme;
    }

    public void setLastNme(String lastNme) {
        this.lastNme = lastNme;
    }
}
