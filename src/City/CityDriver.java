/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author S518750
 */
public class CityDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Cities.txt"));
        while (sc.hasNext()) {
            String line1 = sc.nextLine();
            String line2 = sc.nextLine();
            if (!line1.equals("SENTINEL") && (!line2.equals("dummy data"))) {

                String[] city1Data = line1.split(",");

                String city1name = city1Data[0].trim();
                int city1population = Integer.parseInt(city1Data[1].trim());
                double city1latitude = Double.parseDouble(city1Data[2].trim());
                double city1longitude = Double.parseDouble(city1Data[3].trim());
                double city1homeOwnershipRate = Double.parseDouble(city1Data[4].trim());

                City c1 = new City();
                c1.setname(city1name);
                c1.setpopulation(city1population);
                c1.setlatitude(city1latitude);
                c1.setlongitude(city1longitude);
                c1.sethomeOwnershipRate(city1homeOwnershipRate);

                String[] city2Data = line2.split(",");

                String city2name = city2Data[0].trim();
                int city2population = Integer.parseInt(city2Data[1].trim());
                double city2latitude = Double.parseDouble(city2Data[2].trim());
                double city2longitude = Double.parseDouble(city2Data[3].trim());
                double city2homeOwnershipRate = Double.parseDouble(city2Data[4].trim());

       City c2 = new City(city2name, city2population, city2latitude, city2longitude, city2homeOwnershipRate);
                System.out.println(c1.toString());
                System.out.println(c2.toString());
                System.out.println("The name of the first city is " + c1.getname());
                System.out.println("The population of the first city is " + c1.getpopulation());
                System.out.println("The latitude of the first city is " + c1.getlatitude());
                System.out.println("The longitude of the first city is " + c1.getlongitude());
                System.out.println("The homeownership rate of the first city is " + (c1.gethomeOwnershipRate() * 100) + "%");
                System.out.printf("The distance between %s and %s is %5.2f mi \n",c1.getname(),c2.getname(),c1.calculateDistance(c2));
                if (c1.getpopulation() > c2.getpopulation()) {
                    System.out.println(c2.getname() + "has a smaller population than" + c1.getname());
                } else if (c1.getpopulation() < c2.getpopulation()) {
                    System.out.println(c1.getname() + "has a smaller population than" + c2.getname());

                } else {
                    System.out.println(c1.getname() + " and " + c2.getname() + " have equal populations");
                }
                System.out.println("The number of homeowners in " + c1.getname() + " is " + c1.numHomeOwners());
                System.out.println("The number of homeowners in " + c2.getname() + " is " + c2.numHomeOwners());
                if (c1.numHomeOwners() > c2.numHomeOwners()) {
                    System.out.println(c1.getname() + "has more homeowners than" + c2.getname());
                } else if (c1.numHomeOwners() < c2.numHomeOwners()) {
                    System.out.println(c2 .getname() + "has more homeowners than" + c1.getname());
                } else {
                    System.out.println(c1.getname() + "and" + c2.getname() + "have the same number of homeowners");
                }
                
                determineDirection(c1, c2);

            }

        }
    }

    public static void determineDirection(City c1, City c2) {
        
        if (c1.isNorthOf(c2)) {
            System.out.println(c1.getname() + "is northeast of" + c2.getname());
        } else if (c2.isNorthOf(c1)) {
            System.out.println(c1.getname() + "is southwest of" + c2.getname());
        } else if (c1.isEastOf(c2)) {
            System.out.println(c1.getname() + "is southeast of" + c2.getname());
        } else if (c2.isEastOf(c1)) {
            System.out.println(c1.getname() + "is northwest of" + c2.getname());
        } else if ((c1.isNorthOf(c2)) && (c1.isEastOf(c2))) {
            System.out.println(c1.getname() + "is north of" + c2.getname());
        } else if ((c1.isNorthOf(c2)) && c2.isEastOf(c1)) {
            System.out.println(c1.getname() + "is south of" + c2.getname());
        } else if ((c2.isNorthOf(c1)) && (c1.isEastOf(c2))) {
            System.out.println(c1.getname() + "is east of" + c2.getname());
        } else if ((c2.isNorthOf(c1)) && (c2.isEastOf(c1))) {
            System.out.println(c1.getname() + "is west of" + c2.getname());
        } else {
            System.out.println(c1.getname() + " is in the same location as" + c2.getname());
        }

    }

}
