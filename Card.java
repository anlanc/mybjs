
/**
 * @author chenanlan
 *
 */
public class Card {
	/**
	 * 
	 */
	String Name;
	/**
	 * 
	 */
	int Value;
	
	/**
	 * @param n
	 * @param vl
	 */
	public Card(String n, int vl) {
		Name = n;
		Value = vl;
		
	}
	
	/**
	 * @param myName
	 */
	public void setName(String myName) {
		 Name = myName;

	}
	
	
	/**
	 * @param myValue
	 */
	public void setValue(int myValue) {
		Value = myValue;
		
	}
	
	/**
	 * @return
	 */
	public String getName() {
		return Name;
		
	}
	
	/**
	 * @return
	 */
	public int getValue() {
		return Value;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public  String toString() {
		return Name;
		
		
	}

}
