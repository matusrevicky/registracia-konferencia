package sk.upjs.registracia_konferencia;

import java.util.ArrayList;
import java.util.List;

public class ParticipantDao {
	private List<Participant> participants = new ArrayList<>();
	private long lastID = 0;

	public ParticipantDao() {
		// TODO pre testovacie ucely
		Participant p = new Participant();
		p.setName("Andrej");
		p.setSurname("Kiska");
		p.setEmail("prezident@prezident.sk");
		this.add(p);
	}

	public void add(Participant participant) {
		participant.setId(++lastID);
		participants.add(participant);

	}

	public List<Participant> getAll() {
		return participants;
	}

}
