package urjc.demo.persistencia.entity;

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

    private String companyName;

    @ManyToOne
    private Plane plane;

    @OneToOne
    private Airport departureAirport;

    @OneToOne
    private Airport arriveAirport;

    private LocalDateTime departureDate;
    private LocalDateTime arriveDate;
    private float duration;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Member> members = new ArrayList<>();

    public Flight(String code, String companyName,LocalDateTime departureDate, LocalDateTime arriveDate, int duration, Plane plane, Airport departureAirport, Airport arriveAirport) {
        this.code = code;
        this.departureDate = departureDate;
        this.arriveDate = arriveDate;
        this.duration = duration;
        this.plane = plane;
        this.departureAirport = departureAirport;
        this.arriveAirport = arriveAirport;
        this.companyName = companyName;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public List<Member> getCrewMembers() {
        return members;
    }

    public void setCrewMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", arriveDate='" + arriveDate + '\'' +
                ", duration='" + duration + '\'' +

               // ", departureAirport='" + departureAirport.toString() + '\'' +
               // ", arriveAirport='" + arriveAirport.toString() + '\'' +
                ", companyName='" + companyName + '\'' +

                '}';
    }
}
