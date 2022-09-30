import java.util.*;

public class Main {
    public static List<Bejegyzes>  bejegyzesLista = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Bejegyzes b1 = new Bejegyzes("Jőzsef", "loooooooooooooooool");
        System.out.println(b1);
        Bejegyzes b2 = new Bejegyzes("Sanyika", "Esik az eső :(((");
        bejegyzesLista.add(b1);
        bejegyzesLista.add(b2);
        System.out.print("Kérem adja meg hány bejegyzést szeretne felvenni: ");

        int db;
        try {
            db = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            throw new Error("nem természetes számot adott meg");
        }

        for (int i = 0; i < db; i++) {
            System.out.print("Adja meg a szezőt ");
            String szerzo = sc.nextLine();
            System.out.print("Adja meg a Tartalmat ");
            String tartalom = sc.nextLine();
            bejegyzesLista.add( new Bejegyzes(szerzo, tartalom));
        }
    }
}
