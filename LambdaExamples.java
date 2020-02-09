package com.java.demo.lambda;

import java.util.List;



/**
 * Lambda has been introduced to ease coding, reduce bulk code such as building anonymous
 * inner class. Instead of that we can use lambda. Anonymous inner class creates its own class file Example
 * 
 * @author satyajitdas
 *
 */
public class LambdaExamples {

	public static void main(String[] args) {
		 List<Person> lists=List.of(new Person(20, "Amir"), new Person(22, "Bob"), new Person(32, "Gorge"),
					new Person(55, "Hermine"), new Person(40, "India"), new Person(55, "Jack"), new Person(57, "India"),
					new Person(59, "Lui"), new Person(25, "Catherine"), new Person(27, "Donald"), new Person(30, "Egor"),
					new Person(32, "Fany"), new Person(25, "Giros"), new Person(27, "Hermine"), new Person(37, "Iliena"),
					new Person(57, "Fany"));
		
		 
		 //a simple example of internal for loop, the iterating logic is encapsulated
		 lists.forEach((Person p)->System.out.println(p));
		 //a less verbose way
		 lists.forEach(p->System.out.println(p));
		 //way using method reference
		 lists.forEach(System.out::println);
		 
		 List<Integer> integers=List.of(1,2,3,4,5,6,7,8);
		 //method reference with 2 params:
		 System.out.println(integers.stream().reduce(0,(total,i)->Integer.sum(total,i)));
		//here method reference can be used with 2 params:
		 System.out.println(integers.stream().reduce(0,Integer::sum));
		 
		 //Example of filter, map and reduce
		 System.out.println(integers.
				 stream().
				 filter(e->e%2==0).map(e->e*2).
				 reduce(0,(total,e)->total+e));
		 //shorter way
		 
		 System.out.println(integers.
				 stream().
				 filter(e->e%2==0).
				 map(e->e*2).
				 reduce(0,Integer::sum));
		 //another way
		 System.out.println(integers.
				 stream().
				 filter(e->e%2==0).
				 mapToInt(e->e*2).
				 sum());
		 
		 

	}

}

class Person {
	int age;

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	String name;

	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}

}

