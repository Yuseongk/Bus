//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int number = 0;
        double revenue = 0;
        int passengerMoved = 0;
        int preventedBoardings = 0;
        int discountedRider = 0;
        int peakRide = 0;
        int offPeakRide = 0;
        int currentLoad = 0;

        while (number != 3) {


            System.out.println("1) New Trip Segment   2) Sell/Validate Ticket   3) Close Day");
            Scanner input0 = new Scanner(System.in);
            int num = input0.nextInt();
            number = num;


            if (num == 1) {
                System.out.println("Route?  [R10/R21] > ");
                Scanner input3 = new Scanner(System.in);
                String route = input3.nextLine();
                System.out.println("Hour? > ");
                Scanner input4 = new Scanner(System.in);
                int hour = input4.nextInt();
                System.out.println("Boarding? > ");
                Scanner input5 = new Scanner(System.in);
                int boarding = input5.nextInt();
                System.out.println("alighting? > ");
                Scanner input6 = new Scanner(System.in);
                int alighting = input6.nextInt();
                currentLoad = boarding - alighting;
                System.out.println("Current load" + route + ": " + currentLoad + "/40");


            }


            if (num == 2) {
                if (currentLoad >= 40) {
                    System.out.println("full board");
                    preventedBoardings++;
                } else {


                    passengerMoved++;
                    double price = 0.0;
                    System.out.println("0V Haarlemmermeer Bus");
                    System.out.println("Name? > ");
                    Scanner input = new Scanner(System.in);
                    String name = input.nextLine();
                    System.out.println("age? > ");
                    Scanner input2 = new Scanner(System.in);
                    int age = input2.nextInt();
                    boolean senior = false;
                    boolean youth = false;
                    if (age >= 65) {
                        senior = true;
                        youth = false;
                        discountedRider++;
                    }
                    if (age < 18) {
                        youth = true;
                        senior = false;
                        discountedRider++;
                    }

                    System.out.println("Ticket type [single/day]? > ");
                    Scanner input1 = new Scanner(System.in);
                    String ticketType = input1.nextLine();

                    if (ticketType.equals("single")) {
                        if (senior) {
                            price = 2.1;
                        } else if (youth) {
                            price = 3;
                            price = price * 0.5;
                        } else {
                            price = 3;
                        }
                    } else if (ticketType.equals("day")) {
                        price = 7;
                    } else
                        System.out.println("error");

                    System.out.println("Hour (0-23) ? > ");
                    int hour = input.nextInt();
                    if (youth) {
                        System.out.println("Price: " + price);
                        if (hour <= 9 && hour >= 7) {
                            peakRide++;
                        }
                        if (hour <= 18 && hour >= 16) {
                            peakRide++;
                        }
                        else
                        {
                            offPeakRide++;
                        }
                    } else {
                        if (hour <= 9 && hour >= 7) {
                            price = price + 0.5;
                            peakRide = peakRide + 1;
                        }
                        if (hour <= 18 && hour >= 16) {
                            price = price + 0.5;
                            peakRide = peakRide + 1;
                        }
                        else {
                            offPeakRide = offPeakRide + 1;
                        }
                        System.out.println("Price: " + price);

                    }
                    revenue = revenue + price;
                }
            }


            if (num == 3) {
                System.out.println("---OPERATIONS REPORT ---");
                System.out.println("REVENUE: " + revenue);
                System.out.println("PASSENGER MOVED :" + passengerMoved);
                System.out.println("PREVENTED BOARDINGS:" + preventedBoardings);
                System.out.println("DISCOUNTED RIDERS:" + discountedRider);
                System.out.println("PEAK RIDES:" + peakRide + "  |  " + "OFF-PEAK RIDES:" + offPeakRide);


            }
        }




    }
}