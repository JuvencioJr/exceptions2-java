package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model_entities.Reservation;
import model_exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			System.out.print("Enter room Number:");
			int roomNumber = sc.nextInt();
			
			System.out.print("Check in date:");
			Date checkin = sdf.parse(sc.next());
			
			System.out.print("Check out date:");
			Date checkout = sdf.parse(sc.next());
			
				Reservation reservation = new Reservation(roomNumber, checkin, checkout);
				System.out.println(reservation);
				
				System.out.println();
				
				System.out.println("Enter data to update reservation");
				
				System.out.print("Check in date:");
				checkin = sdf.parse(sc.next());
				
				System.out.print("Check out date:");
				
				reservation.updateDates(checkin, checkout);
				System.out.println(reservation);
			
		}catch (ParseException e) {
			System.out.println(e.getMessage());
		}catch (DomainExceptions e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}catch (RuntimeException e) {
			System.out.println("Unexpected exception.");
		}
		
			
			sc.close();

		}

	}

