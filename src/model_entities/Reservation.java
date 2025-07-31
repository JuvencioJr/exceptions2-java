package model_entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model_exceptions.DomainExceptions;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainExceptions {
	
		if(!checkout.after(checkin)) {
			throw new DomainExceptions("Check out date must be after checkin.");
		}
		
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}


	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		
		long diff = checkout.getTime() - checkin.getTime();
		
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}

	public void updateDates(Date checkin, Date checkout) throws DomainExceptions {
		
		Date now = new Date();
		
		if (checkin.before(now) || checkout.before(now)) {
			throw new DomainExceptions("The dates to update must be future dates.");
		}
		
		if(!checkout.after(checkin)) {
			throw new DomainExceptions("Check out date must be after checkin.");
		}
		
		this.checkin = checkin;
		this.checkout = checkout;
		
	}
	
	@Override
	public String toString() {
		return "Reservation " +
				" room: " +
				roomNumber +
				
				" checkin: " +
				sdf.format(checkin) +
				" checkout: " +
				sdf.format(checkout) +
				" ," +
				duration() +
				" days";
				
	}
	
	
	
	
}
