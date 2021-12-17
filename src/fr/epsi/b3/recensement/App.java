package fr.epsi.b3.recensement;

import fr.epsi.b3.recensement.entites.Ville;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

// TODO Récupérer les informations du CSV de manière à stocker dans un tableau et pouvoir boucler dessus ligne par ligne ==> Done
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
        while (sc.hasNext()) {
            codeRegion = sc.next();
            nomRegion = sc.next().replaceAll("\\s+","-");
            codeDepartement = sc.next();
            codeArrondissement = sc.next();
            codeCanton = sc.next();
            codeCommune = sc.next();

            nomCommune = sc.next();
            String nomCommuneTrim = nomCommune.replaceAll("\\s+","");

            populationMunicipale = sc.nextInt();
            populationApart = sc.nextInt();

            populationTotale = sc.next();
            int populationTotaleInt = Integer.parseInt(populationTotale.trim());

            villes.add(new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommuneTrim, populationTotaleInt));

            i++;
        }
        sc.close();

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("");
        System.out.println("      TP Recensement ==> Andreani Quentin && Rondeau Yann      ");
        System.out.println("");
        System.out.println("*****************************************************************");
        System.out.println("******************** Choisissez votre option ********************");
        System.out.println("*****************************************************************");
        System.out.println("1 ==> Population d'une ville donnée");
        System.out.println("2 ==> Population d'un département donnée");
        System.out.println("3 ==> Population d'une région donnée");
        System.out.println("4 ==> Afficher les 10 régions les plus peuplées");
        System.out.println("5 ==> Afficher les 10 départements les plus peuplées");
        System.out.println("6 ==> Afficher les 10 villes les plus peuplées d'un département");
        System.out.println("7 ==> Afficher les 10 villes les plus peuplées d'une région");
        System.out.println("8 ==> Afficher les 10 villes les plus peuplées de France");
        System.out.println("9 ==> Sortir");
        System.out.println("");
        System.out.println("Veuillez entrer un chiffre ici : ");
        int choix = myObj.nextInt();

        switch (choix) {
            case 1:
                Scanner obj1 = new Scanner(System.in);
                System.out.println("Veuillez entrer une ville ici : ");
                String choixVille = obj1.nextLine();

                for (Ville str : villes) {
                    String commune = str.getNomCommune().trim();
                    int population = str.getPopulation();
                    if (commune.equals(choixVille) ) {
                        System.out.println(population);
                    }
                }
                break;
            case 2:
                Scanner obj2 = new Scanner(System.in);
                System.out.println("Veuillez un numéro de département ici : ");
                String choixDep = obj2.nextLine();

                int populationDep = 0;

                for (Ville str : villes) {
                    String codeDep = str.getCodeDepartement();
                    if (codeDep.equals(choixDep)) {
                        int population = str.getPopulation();
                        populationDep += population;
                    }
                }
                System.out.println(populationDep);
                break;
            case 3:
                Scanner obj3 = new Scanner(System.in);
                System.out.println("Les noms seront séparé par des - à la place des espaces ex :");
                System.out.println("Pays-de-la-Loire");
                System.out.println("Veuillez entrer nom région ici : ");
                String choixReg = obj3.nextLine();

                int populationReg = 0;

                for (Ville str : villes) {
                    String nomReg = str.getNomRegion().trim();
                    if (nomReg.equals(choixReg)) {
                        int population = str.getPopulation();
                        populationReg += population;
                    }
                }
                System.out.println(populationReg);
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
        }

//        for (Ville str : villes) {
//            System.out.println(str.getCodeRegion());
//        }
    }
}
