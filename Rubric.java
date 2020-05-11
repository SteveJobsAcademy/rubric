package rubric2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Rubric {
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    private String path;

    public Rubric(String path) {
        this.path = path;
        this.loadContactsByFile();
        Collections.sort(this.contacts);
        this.remap(); 
    }

    public Contact getByIndex(int index) {
        return contacts.get(index);
    }

    public void removeContact(int indexToRemove) {
        this.contacts.remove(indexToRemove);
        this.remap();
    }

    public void addContact(String name, String surname, String phone) {
        Contact c = new Contact(name, surname, phone);
        this.contacts.add(c);
        try {
            FileWriter writer = new FileWriter(this.path, true);
            writer.write("\n");
            writer.write(c.getFormatName());
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int getLength() {
        return contacts.size();
    }

    public void loadContactsByFile() {
        try {
            FileReader reader = new FileReader(this.path);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            do {
                line = bufferedReader.readLine();
                if (line != null) {
                    String[] s = line.split("#");
                    if (s.length == 3) {
                        Contact c = new Contact(s[0], s[1], s[2]);
                        contacts.add(c);
                    }
                }
            } while (line != null);
            reader.close();
        } catch (final FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } 

    private void remap() {
        try {
            FileWriter writer = new FileWriter(this.path, false);
            for (int i = 0; i< this.contacts.size(); i++) {
                if (i != 0) {
                    writer.write("\n");
                }
                Contact c = this.contacts.get(i);
                writer.write(c.getFormatName());
            }
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String result = "[";
        for (Contact c: this.contacts) {
            result += "\n" + c.toString();
        }
        result += "\n]";
        return result;
    }
}