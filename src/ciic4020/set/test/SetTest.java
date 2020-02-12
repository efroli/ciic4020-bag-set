package ciic4020.set.test;

import java.util.Scanner;

import ciic4020.set.Set;
import ciic4020.set.StaticSet;
import ciic4020.set.DynamicSet;

public class SetTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("This program supports static (S) and dynamic (D) sets!");
		System.out.println("What type of set do you wish to use (S/D): ");
		String input = in.nextLine();
		Set<String> theSet;
		
		if (input.equals("S")) {
			theSet = new StaticSet<String>(7);
		} else if (input.equals("D")) {
			theSet = new DynamicSet<String>(7);
		} else {
			in.close();
			throw new IllegalArgumentException("Option not recognized");
		}
		
		theSet.add("Bob");
		theSet.add("Jil");
		theSet.add("Ned");
		theSet.add("Apu");
		theSet.add("Ned");
		theSet.add("Amy");
		printSet(theSet);

		System.out.println("Is Bob member of the bag?: " + theSet.isMember("Bob"));
		System.out.println("Is Li member of the bag?: " + theSet.isMember("Li"));
		theSet.remove("Ned");
		System.out.println("Is the Bag empty: " + theSet.isEmpty());
		printSet(theSet);
		theSet.clear();
		System.out.println("Is the Bag empty: " + theSet.isEmpty());
		System.out.println("Elements:");
		printSet(theSet);

		// redo the Set
		theSet.add("Bob");
		theSet.add("Jil");
		theSet.add("Ned");
		theSet.add("Apu");
		theSet.add("Ned");
		theSet.add("Amy");

		Set<String> S2 = input.equals("S") ? new StaticSet<String>(10) : new DynamicSet<String>(10);
		S2.add("Amy");
		S2.add("Jil");
		S2.add("Moe");
		S2.add("Ned");
		System.out.println("Union: ");
		printSet(theSet.union(S2));

		System.out.println("difference theSet - S2: ");
		printSet(theSet.difference(S2));

		System.out.println("difference S2 - theSet: ");
		printSet(S2.difference(theSet));
		
		System.out.println("Intersection: ");
		printSet(S2.intersection(theSet));
		
		System.out.println("S2.isSubSet(theSet): " + S2.isSubSet(theSet));
		S2.remove("Moe");
		System.out.println("S2.isSubSet(theSet): " + S2.isSubSet(theSet));
		
		//Exercise 2
		Set<String> S3 = input.equals("S") ? new StaticSet<String>(10) : new DynamicSet<String>(10);
		S3.add("Amy");
		S3.add("Jil");
		S3.add("Moe");
		S3.add("Ned");
		
		Set<String> S4 = input.equals("S") ? new StaticSet<String>(10) : new DynamicSet<String>(10);
		S4.add("Amy");
		S4.add("Jil");
		S4.add("Moe");
		S4.add("Ned");
		System.out.println("S3.equals(S4): " + S3.equals(S4));
		
		S3.remove("Jil");
		System.out.println("S4.equals(S3): " + S4.equals(S3));
		//END Exercise 2
		
		//Exercise 3
		checkDisjoint(theSet);
		//END Exercise 3
		
		System.out.println("Done!");
		in.close();
	}

	//Exercise 3
	public static boolean checkDisjoint(Object[] sets)
	{
		//returns true if the intersection of the array is empty. 
		//false otherwise. 
		
		return false; //dummy
	}
	//END Exercise 3
	
	private static void printSet(Set theSet) {
		for (Object obj : theSet)
			System.out.println(obj);
		System.out.println("Set size: " + theSet.size());
	}
}
