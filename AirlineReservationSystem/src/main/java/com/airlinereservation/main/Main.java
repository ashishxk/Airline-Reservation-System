package com.airlinereservation.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.airlinereservation.model.Flight;
import com.airlinereservation.model.User;
import com.airlinereservation.service.AirlineServiceImpl;
import com.airlinereservation.service.IAirlineService;
import com.airlinereservation.service.IUserService;
import com.airlinereservation.service.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------WELCOME TO HAWKINS AIRLINE RESERVATION---------------");

		LocalDateTime localTime;
		LocalDate localDate;
		
		int ch = 0;
		do {
			System.out.println("\nPLEASE SELECT:-");
			System.out.println("\n1. ADMIN");
			System.out.println("2. USER");

			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.println("\nINPUT YOUR CHOICE:-\n");
				System.out.println("1. ADD PLANE");
				System.out.println("2. DELETE PLANE");
				System.out.println("3. UPDATE PLANE");
				System.out.println("4. GET FLIGHT INFO");
				System.out.println("\n");

				int choice1 = sc.nextInt();
				IAirlineService flightServiceRef = new AirlineServiceImpl();

				if (choice1 == 1) {
					System.out.println("ENTER FLIGHT ID:");
					int flightNumber = sc.nextInt();
					sc.nextLine();
					
					System.out.println("ENTER FLIGHT NAME:");
					String flightName = sc.nextLine();
					
					System.out.println("ENTER FLIGHT SOURCE:");
					String source = sc.nextLine();
					
					System.out.println("ENTER FLIGHT DESTINATION:");
					String destination = sc.nextLine();
					
					System.out.println("SELECT SERVICE TYPE:");
					String serviceType = sc.nextLine();
					
					System.out.println("ENTER CLASS TYPE:");
					String classType = sc.nextLine();
					
					System.out.println("ENTER DATE IN FORMAT YYYY-MM-DD:");
					String date = sc.nextLine();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					localDate = LocalDate.parse(date, formatter);
					
					System.out.println("ENTER TIME IN FORMAT YYYY-MM-DD HH:MM:");
					String time = sc.nextLine();
					DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
					localTime = LocalDateTime.parse(time, format);
					
					System.out.println("ENTER TOTAL PASSENGER SEATS:");
					int seat = sc.nextInt();
					sc.nextLine();
					
					System.out.println("ENTER FLIGHT FARE:");
					double fare = sc.nextDouble();
					sc.nextLine();
					
					
					Flight flight = new Flight(flightNumber, flightName, source, destination, serviceType, classType,
							localDate, localTime, seat, fare);
					
					flightServiceRef.addPlane(flight);
					break;

				} else if (choice1 == 2) {
					System.out.println("ENTER FLIGHT NUMBER/ID");
					int flightNumber = sc.nextInt();
					sc.nextLine();
					flightServiceRef.deletePlane(flightNumber);
					break;
					
				} else if (choice1 == 3) {
					System.out.println("ENTER FLIGHT NUMBER/ID");
					int flightNumber = sc.nextInt();
					System.out.println("ENTER FLIGHT FARE");
					double fare = sc.nextDouble();
					flightServiceRef.updatePlane(flightNumber, fare);
					break;
					
				} else if (choice1 == 4) {
					System.out.println(flightServiceRef.getFlightInfo());
					break;
				}

				else
					System.out.println("**************INVALID INPUT**************");

				break;

			case 2:
				System.out.println("\nINPUT YOUR CHOICE:-\n");
				System.out.println("REGISTER");
				System.out.println("LOGIN");
				IUserService userService = new UserServiceImpl();
				int choice2 = sc.nextInt();
				sc.nextLine();
				
				if(choice2==1) {
					User user = new User();
					System.out.println("ENTER NAME:");
					String name = sc.nextLine();
					user.setName(name);
					
					System.out.println("ENTER MOBILE:");
					int mobile = sc.nextInt();
					user.setMobile(mobile);
					
					System.out.println("ENTER E-MAIL:");
					String mail = sc.nextLine();
					user.setEmail(mail);
					
					System.out.println("ENTER USERNAME:");
					String userName = sc.nextLine();
					user.setUsername(userName);
					
					System.out.println("CHOOSE YOUR PASSWORD:");
					System.out.println("1. AUTO PASSWORD");
					System.out.println("2. MANUAL PASSWORD");
					
					int choice3 = sc.nextInt();
					sc.nextLine();
					
					switch(choice3) {
					case 1:
						break;
						
					case 2:
						System.out.println("ENTER YOUR PASSWORD:");
						String password = sc.nextLine();
						user.setPassword(password);
						
						default:
							System.out.println("INVALID CHOICE");
							break;
					}
					
					if(user.getPassword()!=null) {
						System.out.println("Successfully Registered");
					}
					
					
				}
				
				/*
				 * System.out.println("1. BOOK FLIGHT"); System.out.println("2. CANCEL FLIGHT");
				 * System.out.println("3. SEARCH FLIGHT");
				 * 
				 * int ch2 = sc.nextInt(); sc.nextLine();
				 * 
				 * if (ch2 == 1) { System.out.println("ENTER DEPARTURE:"); String departure =
				 * sc.nextLine(); System.out.println("ENTER ARRIVAL:"); String arrival =
				 * sc.nextLine(); } else if (ch2 == 2) {
				 * System.out.println("ENTER PNR NUMBER:"); int pnrNumber = sc.nextInt(); } else
				 * if (ch2 == 3) { System.out.println("ENTER DATE:"); String date =
				 * sc.nextLine(); DateTimeFormatter formatter =
				 * DateTimeFormatter.ofPattern("yyyy-MM-dd"); localDate = LocalDate.parse(date,
				 * formatter); System.out.println("ENTER TIME:"); String time = sc.nextLine();
				 * DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				 * localTime = LocalDateTime.parse(time, format); } else
				 * System.out.println("**************INVALID INPUT**************"); break;
				 */

			default:
				System.out.println("**************INVALID INPUT**************");
			}
			
			System.out.println("PRESS 1: CONTINUE");
			System.out.println("PRESS 2: EXIT");
			ch=sc.nextInt();
		} while (ch == 1);
		System.out.println("------------------THANK YOU!!------------------");
		sc.close();
	}

}
