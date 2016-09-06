package seedu.addressbook.data.person;

public interface Printable {
	public String getPrintableString();
	
	/**
	  * Returns a concatenated version of the printable strings of each object.
	  */
	static String getPrintableString(Printable... printables){
		StringBuilder result = new StringBuilder();
		for(Printable printable : printables) {
			if (result.length() != 0) {
				result.append(' ');
			}
			result.append(printable.getPrintableString());
		}
		return result.toString();
	}
}
