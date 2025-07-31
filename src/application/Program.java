package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model_entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter room Number:");
		int roomNumber = sc.nextInt();
		
		System.out.print("Check in date:");
		Date checkin = sdf.parse(sc.next());
		
		System.out.print("Check out date:");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)) {
			System.out.println("Check out date must be after checkin.");
		}else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation);
			
			System.out.println();
			
			System.out.println("Enter data to update reservation");
			
			System.out.print("Check in date:");
			checkin = sdf.parse(sc.next());
			
			System.out.print("Check out date:");
			checkout = sdf.parse(sc.next());
			Date now = new Date();
			
			if (checkin.before(now) || checkout.before(now)) {
				System.out.println("The dates to update must be future dates.");
			}else if(!checkout.after(checkin)) {
				reservation.updateDates(checkin, checkout);
				System.out.println(reservation);
			}
		}
		
		sc.close();

	}

}
