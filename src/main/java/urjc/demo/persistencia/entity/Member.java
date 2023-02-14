package urjc.demo.persistencia.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String employeeCode;
    private String name;
    private String surname;
    private String position;
    private String company;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Flight> flights = new ArrayList<>();

    public Member() {
    }

    public Member(String employeeCode, String name, String surname, Position position, String company) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.surname = surname;
        this.position = position.name();
        this.company = company;
        this.flights = flights;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
