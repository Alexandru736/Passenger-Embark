import java.util.ArrayList;

public class Singur extends Pasageri{
	
	public final String type = "Singur";
	
	public Singur(String id, ArrayList<Pasageri> array) {
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
		return 0;
	}
}
