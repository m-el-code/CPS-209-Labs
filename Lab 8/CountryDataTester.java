/**
 * This program reads in country data from a file into an ArrayList, then can be
 * used to find the largest country by area, by density, or the smallest by density.
 * You are to complete the following:
 *
 *   - Complete the readCountries method which reads in the country data to an ArrayList of Country objects
 *   - Make a Comparator that compares according to area
 *   - Make a Comparator that compares according to density
 *   - Use those comparators to find the max area country, max density country, and min density country
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CountryDataTester
{

    public static ArrayList<Country> readCountries(String filename)
    {
        ArrayList<Country> countries = new ArrayList<>();

        //-----------Start below here. To do: approximate lines of code = 13
        // Inside a try-catch block, create a scanner to iterate through
        // the lines in the file, extract each country, and add it to the above
        // ArrayList of countries
       try {
        
            // Create a scanner for the given filename
            // Skip the first line which just has column information
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			scanner.nextLine();

            // Iterate through the lines
            // Use a second scanner to pull out necessary information to construct a Country object
            // Remember to set the delimiter correct for this data file
			while (scanner.hasNextLine()){
				Scanner line = new Scanner(scanner.nextLine());
				line.useDelimiter(",");
				String name = line.next();
				int population = line.nextInt();
				int area = line.nextInt();
				countries.add(new Country(name, population, area));
			}
	   }
				
        // Catch the IOException and print out "filename: File not found" where filename is the filename
        // Should return an empty array list in this case
		catch (IOException exception){
			System.out.println(filename + ": File not found");
		}
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
        return countries;
    }

    //-----------Start below here. To do: approximate lines of code = 3
    // Create a Comparator that compares Country objects by area
    public static Comparator<Country> areaComparator = new Comparator<Country>(){
		@Override
		public int compare(Country one, Country two){
			return one.getArea() - two.getArea();
		}
	};
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    //-----------Start below here. To do: approximate lines of code = 9
    // Create a Comparator that compares Country objects by density. Before you
    // do the division, remember to cast the values to doubles
    
	public static Comparator<Country> densityComparator = new Comparator<Country>(){
		@Override
		public int compare(Country one, Country two){
			double densityOne = (double) one.getPopulation()/one.getArea();
			double densityTwo = (double) two.getPopulation()/two.getArea();
			
			return Double.compare(densityOne, densityTwo);
		}
	};
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    public static void main(String[] args)
    {
        System.out.println("--- TEST 1: Checks on file with data");
        String filename = "countrydata.txt";
        ArrayList<Country> countries = readCountries(filename);

        System.out.println("OUTPUT:   num countries is " + countries.size());
        System.out.println("EXPECTED: num countries is " + 238);

        System.out.println("\n--- TEST 2: Country with max area");
        Country maxArea = null;

        //-----------Start below here. To do: approximate lines of code = 1
        // Set maxArea as the Country with the maximum area. Use
        // Collections.max and your AreaComparator
        maxArea = Collections.max(countries, areaComparator);
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
        System.out.println("OUTPUT:   " + maxArea);
        System.out.println("EXPECTED: (Russia, Pop:140702094, Area:17075200)");

        System.out.println("\n--- TEST 3: Country with max density");
        Country maxDensity = null;

        //-----------Start below here. To do: approximate lines of code = 1
        // Set maxDensity as the Country with the maximum density. Use
        // Collections.max and your DensityComparator
		maxDensity = Collections.max(countries, densityComparator);
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
        System.out.println("OUTPUT:   " + maxDensity);
        System.out.println("EXPECTED: (Macau, Pop:460823, Area:28)");

        System.out.println("\n--- TEST 4: Country with min density");
        Country minDensity = null;

        //-----------Start below here. To do: approximate lines of code = 1
        // Set minDensity as the Country with the minimum density. Use
        // Collections.min and your DensityComparator
        minDensity = Collections.min(countries, densityComparator);
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
        System.out.println("OUTPUT:   " + minDensity);
        System.out.println("EXPECTED: (Greenland, Pop:56326, Area:2166086)");

        System.out.println("\n\n--- TEST 5: Checks on a missing file");
        System.out.print("OUTPUT:   ");
        ArrayList<Country> missing_countries = readCountries("missing_countrydata.txt");
        System.out.println("EXPECTED: missing_countrydata.txt: File not found");

        System.out.println("\ncheck array list is empty");
        System.out.println("OUTPUT:   Array list size of " + missing_countries.size());
        System.out.println("EXPECTED: Array list size of 0");



    }
}
