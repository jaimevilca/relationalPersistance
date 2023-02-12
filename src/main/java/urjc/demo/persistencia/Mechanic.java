package urjc.demo.persistencia;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Mechanic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String employeeCode;
    private String name;
    private String surnames;
    private String companyName;
    private int yearIncorporation;
    private String education;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="mechanic")
    private List<Overhaul> overhauls;

    public Mechanic() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getYearIncorporation() {
        return yearIncorporation;
    }

    public void setYearIncorporation(int yearIncorporation) {
        this.yearIncorporation = yearIncorporation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education.name();
    }

    public List<Overhaul> getOverhauls() {
        return overhauls;
    }

    public void setOverhauls(List<Overhaul> overhauls) {
        this.overhauls = overhauls;
    }
}
