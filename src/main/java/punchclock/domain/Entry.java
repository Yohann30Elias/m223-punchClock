package punchclock.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Entry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime checkIn;

	@Column(nullable = false)
	private LocalDateTime checkOut;

	@Enumerated(EnumType.STRING)
	private EntryCategory category;

	private String comment;

	public Entry() {
	}

	public Entry(Long id, LocalDateTime checkIn, LocalDateTime checkOut) {
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Entry(LocalDateTime checkIn, LocalDateTime checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Entry(LocalDateTime checkIn, LocalDateTime checkOut, EntryCategory category) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDateTime checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDateTime getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDateTime checkOut) {
		this.checkOut = checkOut;
	}

	public EntryCategory getCategory() {
		return category;
	}

	public void setCategory(EntryCategory category) {
		this.category = category;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy / HH:mm:ss");
		return "Entry [id=" + id +
				", checkIn=" + checkIn.format(formatter) +
				", checkOut=" + checkOut.format(formatter) + "]";
	}
}
