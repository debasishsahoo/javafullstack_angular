package DefensiveCopying;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Event {
	private Date eventDate;
	private List<String> attendees;

	// Defensive copy in getter - returns a copy, not the original
	public Date getEventDate() {
		return new Date(eventDate.getTime());
	}

	// Defensive copy in setter - stores a copy, not the original reference
	public void setEventDate(Date eventDate) {
		this.eventDate = new Date(eventDate.getTime());
	}

	// For collections, return unmodifiable view or deep copy
	public List<String> getAttendees() {
		return new ArrayList<>(attendees); // Return a copy
	}

	public void setAttendees(List<String> attendees) {
		this.attendees = new ArrayList<>(attendees); // Store a copy
	}

}
