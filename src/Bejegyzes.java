import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bejegyzes {
    String szerzo;
    String tartalom;
    int likeok;
    LocalDateTime letrejott;
    LocalDateTime szerkesztve;
    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.letrejott = LocalDateTime.now();
        this.szerkesztve = LocalDateTime.now();
    }

    public String getSzerzo() {
        return szerzo;
    }

    public String getTartalom() {
        return tartalom;
    }

    public int getLikeok() {
        return likeok;
    }

    public LocalDateTime getLetrejott() {
        return letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        this.szerkesztve = LocalDateTime.now();
        return szerkesztve;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
    }
    public void like() {
        this.likeok++;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formazottLetrejott = this.letrejott.format(formatter);
        String formazottSzerkesztve = this.szerkesztve.format(formatter);
        if (this.letrejott.equals(this.szerkesztve)) {
        return String.format( "%s - %d - %s \n" +
                "Szerkesztve: %s \n" +
                "%s \n",
                this.szerzo,
                this.likeok,
                formazottLetrejott,
                formazottSzerkesztve,
                this.tartalom
                );
        } else {
            return String.format( "%s - %d - %s \n %s \n",
                    this.szerzo,
                    this.likeok,
                    formazottLetrejott,
                     this.tartalom
            );
        }


    }
}
