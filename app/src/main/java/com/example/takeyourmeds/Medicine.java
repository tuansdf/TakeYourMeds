package com.example.takeyourmeds;

public class Medicine {
    private String name;
    private String howToUse;
    private String doctorNote;
    private String personalNote;

    public Medicine(String name, String howToUse, String doctorNote, String personalNote) {
        this.name = name;
        this.howToUse = howToUse;
        this.doctorNote = doctorNote;
        this.personalNote = personalNote;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHowToUse() {
        return howToUse;
    }

    public void setHowToUse(String howToUse) {
        this.howToUse = howToUse;
    }

    public String getDoctorNote() {
        return doctorNote;
    }

    public void setDoctorNote(String doctorNote) {
        this.doctorNote = doctorNote;
    }

    public String getPersonalNote() {
        return personalNote;
    }

    public void setPersonalNote(String personalNote) {
        this.personalNote = personalNote;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "name='" + name + '\'' +
                ", howToUse='" + howToUse + '\'' +
                ", doctorNote='" + doctorNote + '\'' +
                ", personalNote='" + personalNote + '\'' +
                '}';
    }
}
