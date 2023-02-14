package urjc.demo.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import urjc.demo.persistencia.dto.FlightHistoryMemberDto;
import urjc.demo.persistencia.dto.MemberTotalFlightsDto;
import urjc.demo.persistencia.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select new urjc.demo.persistencia.dto.FlightHistoryMemberDto(m.name , m.surname, a.city , f.departureDate )" +
            " from Member m join Flight f join Airport a on f.departureAirport = a where m.employeeCode = :code")
    List<FlightHistoryMemberDto> findFlightHistoryByMember(@Param("code") String employeeCode);

    @Query("select new urjc.demo.persistencia.dto.MemberTotalFlightsDto(m.name , m.surname, count(f)  , sum(f.duration) )" +
            " from Member m join Flight f  group by m.name , m.surname ")
    List<MemberTotalFlightsDto> findFlightTotalsByMember();


}
