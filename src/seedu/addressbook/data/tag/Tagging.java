package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

public class Tagging {
	private final Tag tag;
	private final Person person;
	private final Action action;
	
	public Tagging(Action action, Person person, Tag tag) {
		this.action = action;
		this.person = person;
		this.tag = tag;
	}
	
	public enum Action {
		ADD("+"),
		REMOVE("-");
		
		private String value;
		
		Action(String action) {
			value = action;
		}
		
		@Override
	    public String toString() {
			return value;
	    }
	}
	
	@Override
    public String toString() {
		return action.toString() + " " + person.getName().toString() + " " + tag.toString();
    }
}
