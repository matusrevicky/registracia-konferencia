package sk.upjs.registracia_konferencia.persistent;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import sk.upjs.registracia_konferencia.entities.Workshop;

class MysqlWorkshopDaoTest {

	@Test
	void testGetAll() {
		List<Workshop> workshops = DaoFactory.INSTANCE.getWorkshopDao().getAll();
		assertNotNull(workshops);
		assertTrue(workshops.size()>0);
	}

}
