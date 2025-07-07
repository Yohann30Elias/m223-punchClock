package punchclock.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Entry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
//	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(nullable = false)
	private LocalDateTime checkIn;

//	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
//	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(nullable = false)
	private LocalDateTime checkOut;

	private EntryCategory category;

	private String comment;


	public Entry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entry(LocalDateTime checkIn, LocalDateTime checkOut) {
		super();
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Entry(LocalDateTime checkIn, LocalDateTime checkOut, EntryCategory cat) {
		super();
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.category = cat;
	}


	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	public EntryCategory getCategory() {
		return category;
	}

	public void setCategory(EntryCategory category) {
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

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy / HH:mm:ss");
		return "Entry [id=" + id + ", checkIn=" + checkIn.format(formatter) + ", checkOut=" + checkOut.format(formatter) + "]";
	}

}
