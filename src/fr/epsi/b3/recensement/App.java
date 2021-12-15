package fr.epsi.b3.recensement;

import fr.epsi.b3.recensement.entites.Recensement;
import fr.epsi.b3.recensement.entites.Ville;

import java.io.FileNotFoundException;

public class App {

    public static void main(String[] args) throws FileNotFoundException {

//        File getCSVFiles = new File("recensement2016_sega.csv");
//        Scanner sc = new Scanner(getCSVFiles);
//        sc.useDelimiter(";");
//        int i = 0;
//        while (sc.hasNext() && i < 20) {
//            System.out.print(sc.next() + " | ");
//            i++;
//        }
//        sc.close();

//        List<Villes> ville = new ArrayList<>();
//        ville.add("A");
//        ville.add("B");
//        ville.add("C");
//        System.out.println("ArrayList : " + ville);

        // TODO le but est de stocker les villes dans une List et de jouer avec pour récuperer le resultat voulue !

        Ville vle = new Ville(84, "Auvergne-Rhône-Alpes", 01, 1, "L'Abergement-Clémenciat", 785);
        System.out.println(vle);
    }
}
