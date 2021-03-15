import java.util.ArrayList;

public class Grup extends Pasageri{
	
	final public String type = "Grup";
	
	public Grup(String id, ArrayList<Pasageri> array) {
		total_priority = 0;
		for(Pasageri p: array) {
			total_priority += p.getPrioritate();
		}
		total_priority += this.calculatePoints();
		this.id = id;
	}	

	@Override
	public int calculatePoints() {
		// TODO Auto-generated method stub
		return 5;
	}
}
