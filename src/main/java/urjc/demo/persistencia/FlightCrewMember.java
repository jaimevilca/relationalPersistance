package urjc.demo.persistencia;

import jakarta.persistence.*;

@Entity
public class FlightCrewMember {
    @EmbeddedId
    private FlightCrewMemberId id;
    @ManyToOne
    @MapsId("flightId")
    private Flight flight;

    @ManyToOne
    @MapsId("crewMemberId")
    private CrewMember crewMember;

    public FlightCrewMember() {}

    public FlightCrewMember(Flight flight, CrewMember crewMemberId) {
        this.flight = flight;
        this.crewMember = crewMemberId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public CrewMember getCrewMember() {
        return crewMember;
    }

    public void setCrewMember(CrewMember crewMember) {
        this.crewMember = crewMember;
    }
}
