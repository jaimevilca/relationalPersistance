package urjc.demo.persistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Cargador de la BD y ejemplos de consulta.
 *
 * @author J. Manuel Colmenar
 */
@Controller
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private PlaneRepository repository;
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private CrewMemberRepository crewMemberRepositor;

    @Autowired
    private FlightCrewMemberRepository flightCrewMemberRepository;



    @Override
    public void run(String... args) {

        Plane plane = new Plane("ABC001", "Avianca", "Airbus1001");
        repository.save(plane);


        Airport departureAirport = new Airport("IATA0111", "Barajas", "Madrid", "Spain");
        Airport arriveAirport = new Airport("IATA7133", "Los Angeles International Airport ", "Los Angeles", "USA");

        airportRepository.save(departureAirport);
        airportRepository.save(arriveAirport);

        LocalDateTime departureDate = LocalDateTime.of(2015,
                Month.FEBRUARY, 11, 8, 30, 00);
        int durationSixHours = 10;
        LocalDateTime arriveDate = departureDate.plusHours(durationSixHours);



        CrewMember crewMember1 = new CrewMember("emp001", "Pedro", "Torres", Position.COMMANDER, "AvianceStarAlliance");
        CrewMember crewMember2 = new CrewMember("emp002", "Maria", "Zambrano", Position.COPILOT, "AvianceStarAlliance");
        //crewMemberRepositor.save(crewMember1);
        //crewMemberRepositor.save(crewMember1);
        //flightCrewMemberRepository.save()




        Flight flight1 = new Flight("AVX-001", departureDate, arriveDate, durationSixHours, plane, departureAirport, arriveAirport);



        List<FlightCrewMember> rels = new ArrayList<>();
        FlightCrewMember f1m1 = new FlightCrewMember(flight1,crewMember1);
        FlightCrewMember f1m2 = new FlightCrewMember(flight1,crewMember2);


        flight1.setCrewMembers(rels);


        flightRepository.save(flight1);






    }

}
