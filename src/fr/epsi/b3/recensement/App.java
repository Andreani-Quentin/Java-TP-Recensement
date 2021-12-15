package fr.epsi.b3.recensement;

import fr.epsi.b3.recensement.entites.Ville;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

// TODO Récupérer les informations du CSV de manière à stocker dans un tableau et pouvoir boucler dessus ligne par ligne
// TODO Écrire un menu de cas particulier (Interactif dans le terminal)
// TODO Créer un switch ou des fonctions pour chaque cas particularité demandé


public class App {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Ville> villes = new ArrayList<>();

        String codeRegion;
        String nomRegion;
        String codeDepartement;
        String codeArrondissement;
        String codeCanton;
        String codeCommune;
        String nomCommune;
        int populationMunicipale;
        int populationApart;
        String populationTotale;

        File getCSVFiles = new File("recensement_2016.csv");
        Scanner sc = new Scanner(getCSVFiles);
        sc.useDelimiter("[;\n]");

        int i = 0;
        while (sc.hasNext() && i < 1) {
            codeRegion = sc.next();
            System.out.println(codeRegion);

            nomRegion = sc.next();
            System.out.println(nomRegion);

            codeDepartement = sc.next();
            System.out.println(codeDepartement);

            codeArrondissement = sc.next();
            System.out.println(codeArrondissement);

            codeCanton = sc.next();
            System.out.println(codeCanton);

            codeCommune = sc.next();
            System.out.println(codeCommune);

            nomCommune = sc.next();
            System.out.println(nomCommune);

            populationMunicipale = sc.nextInt();
            System.out.println(populationMunicipale);

            populationApart = sc.nextInt();
            System.out.println(populationApart);

            populationTotale = sc.next();
            int populationTotaleInt = Integer.parseInt(populationTotale.trim());
            System.out.println(populationTotaleInt);

            villes.add(new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, populationTotaleInt));

            i++;
        }

        System.out.println(villes);
        sc.close();
    }
}
