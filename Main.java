package rubric2;

public class Main {
    public static void main(String args[]) {
        Rubric r1 = new Rubric("/Users/carloleonardi/Documents/workspace/JavaProjects/TestVSCode/rubric2/rubric1.txt");
        System.out.println(r1.getLength());
        // r1.addContact("Caio", "Aiello", "+39346789087");
        // r1.removeContact(2);
        // sull'aggiunta
        // sull'eliminazione
        // sulla modifica di un singolo contatto.
        System.out.println(r1);
    }
}