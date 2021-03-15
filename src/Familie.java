import java.util.ArrayList;

public class Familie extends Pasageri{
	
	final public String type = "Familie";	
	
	public Familie(String id, ArrayList<Pasageri> array) {
		total_priority = 0;
		for(Pasageri p: array) {
			total_priority += p.getPrioritate();
		}
		total_priority += calculatePoints();
		this.id = id;
	}	

	@Override
	public int calculatePoints() {
		// TODO Auto-generated method stub
		return 10;
	}
}
