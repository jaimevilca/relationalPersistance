package urjc.demo.persistencia;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CrewMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String employeeCode;
    private String name;
    private String surname;
    private String position;
    private String company;

    @OneToMany(mappedBy = "crewMember", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FlightCrewMember> flights = new ArrayList<>();

    public CrewMember() {
    }

    public CrewMember(String employeeCode, String name, String surname, Position position, String company) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.surname = surname;
        this.position = position.name();
        this.company = company;
        this.flights = flights;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public void setEmployeeCode(String codeIATA) {
        this.employeeCode = codeIATA;
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

    public void setSurname(String city) {
        this.surname = city;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position.name();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<FlightCrewMember> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightCrewMember> flights) {
        this.flights = flights;
    }
}
