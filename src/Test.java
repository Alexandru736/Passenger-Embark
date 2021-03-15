import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class Test {
	public static void main(String args[]) throws IOException {
		Scanner input = new Scanner(new File("queue.in"));
		int number_of_people = input.nextInt();
		
		String id = "";
		String nume = "";
		int varsta = 0;
		Ticket ticket;
		boolean nevoi = false;
		boolean imbarcare_prioritara = false;
		
		HashMap<String, ArrayList<Pasageri>> hashmap = new HashMap<String, ArrayList<Pasageri>>();
		MaxHeap maxheap = new MaxHeap(100);
		
		int i = 1; // counter
		while(i <= number_of_people){
			id = input.next();
			nume = input.next();
			varsta = input.nextInt();
			ticket = new Ticket(input.next());
			imbarcare_prioritara = input.nextBoolean();
			nevoi = input.nextBoolean();
			
			Pasageri pasager = new Pasageri(id, nume, varsta, ticket, imbarcare_prioritara, nevoi) {

				@Override
				public int calculatePoints() {
					// TODO Auto-generated method stub
					return 0;
				}
			};
						
			hashmap.putIfAbsent(id, new ArrayList<Pasageri>());
			hashmap.get(id).add(pasager);
			
			i++;
		}
		
		while(input.hasNext() != false) {
			String command = input.next();
			//System.out.println(command);
			if(command.equals("insert")) {
				String id_input = input.next();
				//System.out.println("id_input: " + id_input);
				if(id_input.charAt(0) == 'f') {
					Familie family = new Familie(id_input, hashmap.get(id_input));
					maxheap.insert(family, family.getTotal_priority());
					//System.out.println("Prioritate familie: " + family.getTotal_priority());
				}
				if(id_input.charAt(0) == 'g') {
					Grup group = new Grup(id_input, hashmap.get(id_input));
					maxheap.insert(group, group.getTotal_priority());
					//System.out.println("Prioritate grup: " + group.getTotal_priority());
				}
				if(id_input.charAt(0) == 's') {
					Singur alone = new Singur(id_input, hashmap.get(id_input));
					maxheap.insert(alone, alone.getTotal_priority());
					//System.out.println("Prioritate singur: " + alone.getTotal_priority());
				}
				//maxheap.list();
			}
			else if(command.equals("list")) {
				maxheap.list();
			}
			else if(command.equals("embark")) {
				maxheap.embark();
				//maxheap.list();
			}
		}
		maxheap.writer.close();
		//Display the hashmap
		/*
		for (Entry<String, ArrayList<Pasageri>> ee : hashmap.entrySet()) {
		    String key = ee.getKey();
		    System.out.print(key + ": ");
		    List<Pasageri> values = ee.getValue();
		    for(Pasageri p : values) {
		    	if(p.equals(values.get(values.size() - 1)))
		    		System.out.print(p.getNume() + " " + p.getPrioritate());
		    	else 
		    		System.out.print(p.getNume() + " " + p.getPrioritate() + ", ");
		    }
		    System.out.print("\n");
		}
		*/
	}
}
