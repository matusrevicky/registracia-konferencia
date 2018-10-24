package sk.upjs.registracia_konferencia.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Participant {
	public static final double SINGLE_ROOM_FEE = 75.0;

	private Long id;
	private String name;
	private String surname;
	private String email;
	private String organization;
	private String address;
	private Long ico;
	private String dic;
	private boolean early;
	private Tshirt tshirt;
	private boolean student;
	private boolean singleRoom;
	private LocalDateTime start;
	private LocalDateTime end;
	private List<Companion> companions;
	private Workshop workshop;
	private boolean cash;

	public double finalPrice() {
		double price = 0;

		if (isStudent() == false && isEarly() == false) {
			price = workshop.getPriceFullLate();
		}
		if (isStudent() == false && isEarly() == true) {
			price = workshop.getPriceFull();
		}
		if (isStudent() == true && isEarly() == false) {
			price = workshop.getPriceFullLate();
		}
		if (isStudent() == true && isEarly() == true) {
			price = workshop.getPriceFull();
		}

		if (isSingleRoom() && !isStudent()) {
			price = price + SINGLE_ROOM_FEE;
		}

		if (companions != null) {
			for (Companion comp : companions) {
				price = price + comp.getPrice();
			}
		}

		return price;
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getIco() {
		return ico;
	}

	public void setIco(Long ico) {
		this.ico = ico;
	}

	public String getDic() {
		return dic;
	}

	public void setDic(String dic) {
		this.dic = dic;
	}

	public boolean isEarly() {
		return early;
	}

	public void setEarly(boolean skory) {
		this.early = skory;
	}

	public Tshirt getTshirt() {
		return tshirt;
	}

	public void setTshirt(Tshirt tshirt) {
		this.tshirt = tshirt;
	}

	public boolean isStudent() {
		return student;
	}

	public void setStudent(boolean student) {
		this.student = student;
	}

	public boolean isSingleRoom() {
		return singleRoom;
	}

	public void setSingleRoom(boolean singleRoom) {
		this.singleRoom = singleRoom;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	public List<Companion> getCompanions() {
		return companions;
	}

	public void setCompanions(List<Companion> companions) {
		this.companions = companions;
	}

	public Workshop getWorkshop() {
		return workshop;
	}

	public void setWorkshop(Workshop workshop) {
		this.workshop = workshop;
	}

	public boolean isCash() {
		return cash;
	}

	public void setCash(boolean cash) {
		this.cash = cash;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
