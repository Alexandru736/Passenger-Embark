
public abstract class Pasageri {
	
	//metadata
	protected String id;
	private int prioritate;
	private String nume;
	
	//priority of the group
	protected int total_priority;
	
	//children of the Pasageri node
//	protected Pasageri pas_left; 
//	protected Pasageri pas_right;
//	protected Pasageri parent;
//	protected int node_level;
	
	//constructor used for data initialization 
	public Pasageri(String id, String nume, int varsta, Ticket ticket, 
			boolean imbarcare_prioritara, boolean nevoi_speciale) {
		this.id = id;
		this.setPrioritate(this.getPrioritate(varsta, ticket, imbarcare_prioritara, nevoi_speciale));
		this.setNume(nume);
		
//		this.pas_left = null;
//		this.pas_right = null;
//		this.parent = null;
//		this.node_level = 0;
	}
	
	public Pasageri() {}

	//abstract method for calculating the point difference 
	//of a Pasageri group(could be 5p, 10p or 0p)
	protected abstract int calculatePoints(); 
	
	//calculates the priority of a person
	public static int getPrioritate(int varsta, Ticket ticket, 
			boolean imbarcare_prioritara, boolean nevoi_speciale) {
		int total_priority = 0;
		
		if(varsta < 2)
			total_priority += 20;
		else if(varsta < 5)
			total_priority += 10;
		else if(varsta < 10)
			total_priority += 5;
		else if(varsta >= 60)
			total_priority += 15;
		
		if(ticket.getTicket_type().equals("p"))
			total_priority += 20;
		else if(ticket.getTicket_type().equals("b"))
			total_priority += 35;
		
		if(imbarcare_prioritara == true)
			total_priority += 30;
		
		if(nevoi_speciale == true)
			total_priority += 100;
		
		return total_priority;
	}
	
	//de continuat swap
	public static void swap(Pasageri p1, Pasageri p2) {
		int tmp_prioritate = p1.getTotal_priority();
		p1.setTotal_priority(p2.getTotal_priority());
		p2.setTotal_priority(tmp_prioritate);
		
		String tmp_id = p1.id;
		p1.id = p2.id;
		p2.id = tmp_id;
		
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getPrioritate() {
		return prioritate;
	}

	public void setPrioritate(int prioritate) {
		this.prioritate = prioritate;
	}
	
	public void setTotal_priority(int total_priority) {
		this.total_priority = total_priority;
	}
	
	public int getTotal_priority() {
		return total_priority;
	}
}
