package urjc.demo.persistencia.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date startDate;
    private Date endDate;
    private int hourSpent;

    @ManyToOne
    private Plane plane;

    @ManyToOne
    private Mechanic mechanic;

    private String typeRevision;

    private String description;

    @OneToOne
    private Airport airport;

    public Review() {
    }

    public Review(Date startDate, Date endDate, int hourSpent, Plane plane, Mechanic mechanic, String typeRevision, String description, Airport airport) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.hourSpent = hourSpent;
        this.plane = plane;
        this.mechanic = mechanic;
        this.typeRevision = typeRevision;
        this.description = description;
        this.airport = airport;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getHourSpent() {
        return hourSpent;
    }

    public void setHourSpent(int hourSpent) {
        this.hourSpent = hourSpent;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public String getTypeRevision() {
        return typeRevision;
    }

    public void setTypeRevision(TypeRevision typeRevision) {
        this.typeRevision = typeRevision.name();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}
