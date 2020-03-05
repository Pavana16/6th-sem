package customer;

public class item {
	String name,id;
	double cost;
	item(String i,String n,double c){
		id=i;
		name=n;
		cost=c;
	}
	public String toString() {
		return id+" "+name+" "+cost;
	}
}
