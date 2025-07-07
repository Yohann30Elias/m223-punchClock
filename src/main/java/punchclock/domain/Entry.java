package punchclock.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Entry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime checkIn;

	@Column(nullable = false)
	private LocalDateTime checkOut;

	private String comment;

	@ManyToOne
	private Category category;

	@ManyToMany
	private List<Tag> tags;

	public Entry() {
	}

	public Entry(LocalDateTime checkIn, LocalDateTime checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	/**
	 * Falls du EntryCategory noch in PunchclockApplication nutzt:
	 * Speichere den Enum-Typ als Text im Comment.
	 */
	public Entry(LocalDateTime checkIn, LocalDateTime checkOut, EntryCategory entryCategory) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.comment = entryCategory != null ? entryCategory.name() : null;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
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
