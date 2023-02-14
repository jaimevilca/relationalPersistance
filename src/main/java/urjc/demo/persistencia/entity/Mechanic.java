package urjc.demo.persistencia.entity;

import jakarta.persistence.*;

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
    private List<Review> reviews;

    public Mechanic() {
    }

    public Mechanic(String employeeCode, String name, String surnames, String companyName, int yearIncorporation, String education) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.surnames = surnames;
        this.companyName = companyName;
        this.yearIncorporation = yearIncorporation;
        this.education = education;
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

    public List<Review> getOverhauls() {
        return reviews;
    }

    public void setOverhauls(List<Review> reviews) {
        this.reviews = reviews;
    }
}
