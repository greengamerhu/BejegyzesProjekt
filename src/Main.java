import java.io.*;
import java.util.*;

public class Main {
    public static List<Bejegyzes>  bejegyzesLista = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static Random rnd = new Random();
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
        String fajlnev = "bejegyzesek.csv";

        try {
            fajlbeolvasEshozzaadListahoz(fajlnev);
        }catch (FileNotFoundException e) {
            System.out.println("Nem található az alábbi Fájl: ");
        } catch (IOException e) {
            System.out.println("Ismeretlen hiba történt");
            System.out.println(e.getMessage());
        }


        likeoszto();
        bejegyzesmodosit();

        for (Bejegyzes b : bejegyzesLista) {
            System.out.println(b);
        }
        System.out.printf("A legnépszerübb post:\n%s ",legnepszerubb() );
        if (legnepszerubb().getLikeok() > 35 ) {
            System.out.println("Van olyan bejegyzés ami 35 likenál többet kapott");
        } else {
            System.out.println("Nincs olyan bejegyzés ami 35 likenál többet kapott");

        }

    }

    private static Bejegyzes legnepszerubb() {
        Bejegyzes legtobbLike = bejegyzesLista.get(0);
        for (Bejegyzes b: bejegyzesLista) {
            if (b.getLikeok() > legtobbLike.getLikeok()) {
                legtobbLike = b;
            }
        }
        return legtobbLike;
    }

    private static void bejegyzesmodosit() {
        System.out.println("Kérem adja meg a szöveget");
        bejegyzesLista.get(1).setTartalom(sc.nextLine());
    }

    private static void likeoszto() {
        for (int i = 0; i < bejegyzesLista.size()*20; i++) {
            int index = rnd.nextInt(bejegyzesLista.size());
            bejegyzesLista.get(index).like();
        }
    }


    private static void fajlbeolvasEshozzaadListahoz(String fajlnev) throws IOException {
        FileReader fr = new FileReader(new File(fajlnev));
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while (sor != null && !sor.isEmpty()) {
            String[] adatok = sor.split(";");
            Bejegyzes festmeny = new Bejegyzes(adatok[0], adatok[1]);
            bejegyzesLista.add(festmeny);
            sor = br.readLine();
        }
        br.close();
        fr.close();
    }
}
