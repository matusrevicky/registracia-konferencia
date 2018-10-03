package sk.upjs.registracia_konferencia;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParticipantTest {
	Workshop cidmWorkshop;
	Workshop slonplWorkshop;

	@BeforeEach
	public void setBefore() {
		cidmWorkshop = new Workshop();
		cidmWorkshop.setPriceFullLate(380);
		cidmWorkshop.setPriceStudentLate(320);
		cidmWorkshop.setPriceFull(355);
		cidmWorkshop.setPriceStudent(295);

		slonplWorkshop = new Workshop();
		slonplWorkshop.setPriceFullLate(265);
		slonplWorkshop.setPriceStudentLate(210);
		slonplWorkshop.setPriceFull(245);
		slonplWorkshop.setPriceStudent(195);
	}

	@Test
	void testFinalPrice1() {
		Participant participant = new Participant();
		participant.setEarly(true);
		participant.setStudent(false);
		participant.setSingleRoom(false);
		participant.setCash(false);
		participant.setWorkshop(cidmWorkshop);

		assertEquals(355.0, participant.finalPrice());
	}

	@Test
	void testFinalPrice2() {
		Participant participant = new Participant();
		participant.setEarly(false);
		participant.setStudent(false);
		participant.setSingleRoom(false);
		participant.setCash(false);
		participant.setWorkshop(cidmWorkshop);

		assertEquals(380.0, participant.finalPrice());
	}

	@Test
	void testFinalPrice3() {
		Participant participant = new Participant();
		participant.setEarly(true);
		participant.setStudent(false);
		participant.setSingleRoom(false);
		participant.setCash(false);
		participant.setWorkshop(slonplWorkshop);

		List<Companion> companions = new ArrayList<>();
		Companion c1 = new Companion();
		c1.setCategory(CompanionCategory.ADULT);
		c1.setStart(LocalDateTime.of(2019, 9, 21, 17, 0));
		c1.setEnd(LocalDateTime.of(2019, 9, 23, 10, 0));
		c1.setTshirt(null);
		companions.add(c1);
		participant.setCompanions(companions);
		

		assertEquals(245+110, participant.finalPrice());
	}

}
