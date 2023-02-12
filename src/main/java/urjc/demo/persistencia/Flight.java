package urjc.demo.persistencia;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String code;
    private LocalDateTime departureDate;
    private LocalDateTime arriveDate;
    private int duration;

    @OneToOne
    private Plane plane;

    @OneToOne
    private Airport departureAirport;

    @OneToOne
    private Airport arriveAirport;


    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FlightCrewMember> crewMembers = new ArrayList<>();

    public Flight(String code, LocalDateTime departureDate, LocalDateTime arriveDate, int duration, Plane plane, Airport departureAirport, Airport arriveAirport) {
        this.code = code;
        this.departureDate = departureDate;
        this.arriveDate = arriveDate;
        this.duration = duration;
        this.plane = plane;
        this.departureAirport = departureAirport;
        this.arriveAirport = arriveAirport;
    }

    public Flight() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(LocalDateTime arriveDate) {
        this.arriveDate = arriveDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArriveAirport() {
        return arriveAirport;
    }

    public void setArriveAirport(Airport arriveAirport) {
        this.arriveAirport = arriveAirport;
    }

    public List<FlightCrewMember> getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(List<FlightCrewMember> crewMembers) {
        this.crewMembers = crewMembers;
    }
}
