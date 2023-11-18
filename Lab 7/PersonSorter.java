import java.util.Arrays;
import java.util.Comparator;
/**
   Below, you will test how to sort an array in multiple ways using a comparator.
   You are to complete the following tasks:

     - Create a Comparator for Person objects that can be used to sort according
       to name, and use it to sort the array
     - Create a Comparator for Person objects that can be used to sort according
       to age in ascending order, and use it to sort the array
     - Create a Comparator for Person objects that can be used to sort according
       to age in ascending order, and use it to sort the array
 */
public class PersonSorter
{
	public static void main(String[] args) 
	{
		Person[] persons = {
				new Person("Elvis", "Goodyear", 56),
				new Person("Stanley", "Clark", 8),
				new Person("Jane", "Graff", 16),
				new Person("Nancy", "Goodyear", 69),
				new Person("Alice", "Goodyear", 100)
		} ;
		System.out.println("Initial Order: " + Arrays.toString(persons));

		System.out.println("\n--- TEST 1: Sort the array alphabetically");
		//-----------Start below here. To do: approximate lines of code = 6
		// Todo create a simple (inner) class that implements the Comparator interface
		// to sort two person objects by name 
		// compare last name alphabetically. If they are equal then compare first names
		// Hint: make use of the class String compareTo() method to compare name strings
		class nameComparator implements Comparator<Person>{
			public int compare(Person one, Person two){
				if (one.getLastName().compareTo(two.getLastName()) == 0){
					return one.getFirstName().compareTo(two.getFirstName());
				}
				return one.getLastName().compareTo(two.getLastName());
			}
		}
		// call Array.sort with two parameters - one passing in the array of persons
		// and one passing in an object of the inner class
		Arrays.sort(persons, new nameComparator());
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		System.out.println("OUTPUT:   " + Arrays.toString(persons));
		System.out.println("EXPECTED: [(Clark, Stanley. Age: 8), (Goodyear, Alice. Age: 100), (Goodyear, Elvis. Age: 56), (Goodyear, Nancy. Age: 69), (Graff, Jane. Age: 16)]");

		System.out.println();
		System.out.println("Sorted by age (youngest to oldest):");

		System.out.println("\n--- TEST 2: Sort the array by age");
		//-----------Start below here. To do: approximate lines of code = 4
		// ToDo create a simple (inner) class that implements the Comparator interface
		// to sort two person objects by age (youngest to oldest)
		
		class ageAscComparator implements Comparator<Person>{
			public int compare(Person one, Person two){
				return Integer.compare(one.getAge(), two.getAge());
			}
		}

		// call Array.sort with two parameters - one passing in the array of persons
		// and one passing in an object of the inner class
		Arrays.sort(persons, new ageAscComparator());
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		System.out.println("OUTPUT:   " + Arrays.toString(persons));
		System.out.println("EXPECTED: [(Clark, Stanley. Age: 8), (Graff, Jane. Age: 16), (Goodyear, Elvis. Age: 56), (Goodyear, Nancy. Age: 69), (Goodyear, Alice. Age: 100)]");

		System.out.println("\n--- TEST 3: Sort the array by age in descending order");
		//-----------Start below here. To do: approximate lines of code = 4
		// ToDo create a simple (inner) class that implements the Comparator interface
		// to sort two person objects by age (oldest to youngest)
		
		class ageDescComparator implements Comparator<Person>{
			public int compare(Person one, Person two){
				return Integer.compare(two.getAge(), one.getAge());
			}
		}
		
		// call Array.sort with two parameters - one passing in the array of persons
		// and one passing in an object of the inner class
		Arrays.sort(persons, new ageDescComparator());
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		System.out.println("OUTPUT:   " + Arrays.toString(persons));
		System.out.println("EXPECTED: [(Goodyear, Alice. Age: 100), (Goodyear, Nancy. Age: 69), (Goodyear, Elvis. Age: 56), (Graff, Jane. Age: 16), (Clark, Stanley. Age: 8)]");
	}
}
