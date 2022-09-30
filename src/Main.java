import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Bejegyzes>  bejegyzesLista = new ArrayList<>();
    public static void main(String[] args) {
        Bejegyzes b1 = new Bejegyzes("Jőzsef", "loooooooooooooooool");
        System.out.println(b1);
        Bejegyzes b2 = new Bejegyzes("Sanyika", "Esik az eső :(((");
        bejegyzesLista.add(b1);
        bejegyzesLista.add(b2);
    }
}
