package urjc.demo.persistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import urjc.demo.persistencia.dto.FlightHistoryMemberDto;
import urjc.demo.persistencia.dto.IPlaneMechanicReviewDto;
import urjc.demo.persistencia.dto.MemberTotalFlightsDto;
import urjc.demo.persistencia.entity.*;
import urjc.demo.persistencia.repository.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;
import java.util.List;

/**
 * Cargador de la BD y ejemplos de consulta.
 *
 * @author J. Manuel Colmenar
 */
@Controller
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private PlaneRepository planeRepository;
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MechanicRepository mechanicRepository;


    @Override
    public void run(String... args) {

        Plane plane = new Plane("ABC001", "Avianca", "Airbus1001", 15);
        planeRepository.save(plane);


        Airport departureAirport = new Airport("IATA0111", "Barajas", "Madrid", "Spain");
        Airport arriveAirport = new Airport("IATA7133", "Los Angeles International Airport ", "Los Angeles", "USA");

        airportRepository.save(departureAirport);
        airportRepository.save(arriveAirport);

        LocalDateTime departureDate = LocalDateTime.of(2015,
                Month.FEBRUARY, 11, 8, 30, 00);
        int durationSixHours = 10;
        LocalDateTime arriveDate = departureDate.plusHours(durationSixHours);
        int durationSixHours2 = 6;
        LocalDateTime arriveDate2 = departureDate.plusHours(durationSixHours);


        Member member1 = new Member("emp001", "Pedro", "Torres", Position.COMMANDER, "AvianceStarAlliance");
        Member member2 = new Member("emp002", "Maria", "Zambrano", Position.COPILOT, "AvianceStarAlliance");
        memberRepository.save(member1);
        memberRepository.save(member2);

        Mechanic mechanic1 = new Mechanic("MECHANIC001", "Jordy", "Piedra López", "Airlin", 3, "grado");
        Mechanic mechanic2 = new Mechanic("MECHANIC002", "Jaime", "Vilca Huera", "NextSpace", 5, "superior");
        mechanicRepository.save(mechanic1);
        mechanicRepository.save(mechanic2);

        Flight flight1 = new Flight("AVX-001", "Company1", departureDate, arriveDate, durationSixHours, plane, departureAirport, arriveAirport);
        Flight flight2 = new Flight("AVX-002", "Company2", departureDate, arriveDate2, durationSixHours2, plane, departureAirport, arriveAirport);
        flightRepository.save(flight1);
        flightRepository.save(flight2);

        Review review = new Review(new Date(), new Date(), 4, plane, mechanic1, "periodic", "Description 1 ", departureAirport);
        reviewRepository.save(review);


        System.out.println(" Para cada avión, mostrar el nombre y apellidos de los mecánicos responsables de sus revisiones");
        System.out.println("------------------------------------------");
        List<IPlaneMechanicReviewDto> planesMechanics = planeRepository.findPlaneByMechanicReview();
        planesMechanics.forEach(p -> System.out.println("Airplane : " + p.getRegistration() + " Mechanic name: " + p.getName() + " Mechanic surname: " + p.getSurnames()));

        System.out.println("------------------------------------------");

        System.out.println(" Dado el nombre de una ciudad y una fecha, listado de los vuelos que han\n" +
                "despegado (origen) en los aeropuertos de esa ciudad en esa fecha, ordenados por\n" +
                "hora.");
        System.out.println("------------------------------------------");
        List<Flight> flights = flightRepository.findFlightByCityAndDepartureDate("Madrid", departureDate);
        flights.forEach(System.out::println);


        System.out.println("------------------------------------------");

        System.out.println(" Dado el código de empleado de un tripulante, mostrar su nombre y apellidos y\n" +
                "las ciudades desde las que ha despegado junto con la fecha en que despegó.");
        System.out.println("------------------------------------------");
        List<FlightHistoryMemberDto> members = memberRepository.findFlightHistoryByMember("emp001");
        members.forEach(System.out::println);

        System.out.println("------------------------------------------");

        System.out.println(" Para cada tripulante, mostrar su nombre y apellidos junto con su número total\n" +
                "de vuelos y la suma de horas de estos.");
        System.out.println("------------------------------------------");
        List<MemberTotalFlightsDto> countFlightsByMember = memberRepository.findFlightTotalsByMember();
        countFlightsByMember.forEach(System.out::println);


    }

}
