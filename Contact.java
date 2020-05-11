package rubric2;
public class Contact implements Comparable<Contact>{
    private String name;
    private String surname;
    private String phone;

    public Contact(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public String getFormatName() {
        return this.name + "#" + this.surname + "#" + this.phone;
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname + " " + this.phone;
    }

    @Override
    public int compareTo(Contact c) {
        if (this.surname.length() > c.surname.length()) {
            return -1; // metti sopra
        } else return 1; // metti sotto
    }
}