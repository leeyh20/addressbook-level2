package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Represents an adding or deleting of a tag for a specific person that happened during that session
 */
public class Tagging {
    public enum Type {
        ADDED, REMOVED
    }
    private Type type;
    private Person relevantPerson;
    private Tag relevantTag;
    
    public Tagging(Type type, Person relevantPerson, Tag relevantTag) {
        this.type = type;
        this.relevantPerson = relevantPerson;
        this.relevantTag = relevantTag;
    }

    public Type getType() {
        return type;
    }

    public Person getRelevantPerson() {
        return relevantPerson;
    }

    public Tag getRelevantTag() {
        return relevantTag;
    }

    /**
     * Will return a string containing information of the tagging in this format: +/- personName [tagName]
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (this.type.equals(Type.ADDED)) {
            builder.append("+ ");
        } else if (this.type.equals(Type.REMOVED)) {
            builder.append("- ");
        }
        builder.append(this.relevantPerson.getName().fullName + " ");
        builder.append("[" + this.relevantTag.tagName + "]");
        return builder.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Tagging // instanceof handles nulls
                && this.getType().equals(((Tagging) other).getType()) 
                        && this.getRelevantPerson().equals(((Tagging) other).getRelevantPerson())
                        && this.getRelevantTag().equals(((Tagging) other).getRelevantTag())); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
