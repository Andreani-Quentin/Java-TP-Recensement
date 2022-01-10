package fr.epsi.b3.recensement;

import fr.epsi.b3.recensement.entites.Departement;
import fr.epsi.b3.recensement.entites.Region;
import fr.epsi.b3.recensement.entites.Ville;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

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
                ArrayList<Region> region = new ArrayList<>();
                region.add(new Region("", "", 0));

                String nomRegVille = null;
                String codeRegVille = null;
                int popVille = 0;

                for (Ville vil : villes) {
                    boolean check = false;
                    for(Region reg : region) {
                        String nomReg = vil.getNomRegion().trim();
                        if (nomReg.equals(reg.getNomRegion().trim())){
                            var pop = vil.getPopulation() + reg.getPopulation();
                            reg.setPopulation(pop);
                            check = true;
                        }
                    }
                    if (!check) {
                        nomRegVille = vil.getNomRegion();
                        codeRegVille = vil.getCodeRegion();
                        popVille = vil.getPopulation();

                        region.add(new Region(nomRegVille, codeRegVille, popVille));
                    }
                }

                ArrayList<Integer> regPopList = new ArrayList<Integer>();
                for (Region reg : region) {
                    regPopList.add(reg.getPopulation());
                }
                Collections.sort(regPopList);
                Collections.reverse(regPopList);

                System.out.println("");
                System.out.println("**** Voici les 10 Région les plus peuplées de France ****");
                System.out.println("");

                var x = 0;
                for (Integer pop : regPopList) {
                    for (Region reg : region) {
                        if (reg.getPopulation() == pop) {
                            if (x < 10) {
                                System.out.println(reg.getNomRegion());
                                System.out.println("======> " + pop);
                                System.out.println("");

                            }
                        }
                    }
                    x++;
                }

                break;
            case 5:
                ArrayList<Departement> departement = new ArrayList<>();
                departement.add(new Departement("", 0));

                String codeDepVille = null;
                popVille = 0;

                for (Ville vil : villes) {
                    boolean check = false;
                    for(Departement dep : departement) {
                        String codeDep = vil.getCodeDepartement().trim();
                        if (codeDep.equals(dep.getCodeDepartement().trim())){
                            var pop = vil.getPopulation() + dep.getPopulation();
                            dep.setPopulation(pop);
                            check = true;
                        }
                    }

                    if (!check) {
                        codeDepVille = vil.getCodeDepartement();
                        popVille = vil.getPopulation();

                        departement.add(new Departement(codeDepVille, popVille));
                    }
                }

                ArrayList<Integer> depPopList = new ArrayList<Integer>();
                for (Departement dep : departement) {
                    depPopList.add(dep.getPopulation());
                }
                Collections.sort(depPopList);
                Collections.reverse(depPopList);

                System.out.println("");
                System.out.println("**** Voici les 10 départements les plus peuplées de France ****");
                System.out.println("");

                x = 0;
                for (Integer pop : depPopList) {
                    for (Departement dep : departement) {
                        if (dep.getPopulation() == pop) {
                            if (x < 10) {
                                System.out.println(dep.getCodeDepartement());
                                System.out.println("======> " + pop);
                                System.out.println("");

                            }
                        }
                    }
                    x++;
                }
                break;
            case 6:
                Scanner obj6 = new Scanner(System.in);
                System.out.println("Veuillez entrer un numéro de département ici : ");
                String choixDep2 = obj6.nextLine();
//                HashMap<String, Integer> dep10 = new HashMap<String, Integer>();
                ArrayList<Integer> vilPopList = new ArrayList<Integer>();

                for (Ville str : villes) {
                    String codeDep = str.getCodeDepartement();
                    if (codeDep.equals(choixDep2)) {
                        int population = str.getPopulation();
                        vilPopList.add(population);
                    }
                }
                Collections.sort(vilPopList);
                Collections.reverse(vilPopList);

                System.out.println("");
                System.out.println("**** Voici les 10 villes les plus peuplées de ce département ****");
                System.out.println("");

                x = 0;
                for (Integer pop : vilPopList) {
                    for (Ville vil : villes) {
                        if (vil.getPopulation() == pop) {
                            if (x < 10) {
                                System.out.println(vil.getNomCommune());
                                System.out.println("======> " + pop);
                                System.out.println("");

                            }
                        }
                    }
                    x++;
                }

//                for (Ville str : villes) {
//                    String codeDep = str.getCodeDepartement();
//                    if (codeDep.equals(choixDep2)) {
//                        int population = str.getPopulation();
//                        String commune = str.getNomCommune().trim();
//                        dep10.put(commune, population);
//                    }
//                  var maxValue = Collections.max(dep10.values());
//                  System.out.println(maxValue);
//                  System.out.println(dep10.keySet());
//                }
                break;
            case 7:
                Scanner obj7 = new Scanner(System.in);
                System.out.println("Les noms seront séparé par des - à la place des espaces ex :");
                System.out.println("Pays-de-la-Loire");
                System.out.println("Veuillez entrer nom région ici : ");
                String choixReg2 = obj7.nextLine();
                ArrayList<Integer> vilPopRegList = new ArrayList<Integer>();

                for (Ville str : villes) {
                    String nomReg = str.getNomRegion().trim();
                    if (nomReg.equals(choixReg2)) {
                        int population = str.getPopulation();
                        vilPopRegList.add(population);
                    }
                }

                Collections.sort(vilPopRegList);
                Collections.reverse(vilPopRegList);

                System.out.println("");
                System.out.println("**** Voici les 10 villes les plus peuplées de cette Région ****");
                System.out.println("");

                x = 0;
                for (Integer pop : vilPopRegList) {
                    for (Ville vil : villes) {
                        if (vil.getPopulation() == pop) {
                            if (x < 10) {
                                System.out.println(vil.getNomCommune());
                                System.out.println("======> " + pop);
                                System.out.println("");

                            }
                        }
                    }
                    x++;
                }
                break;
            case 8:
                ArrayList<Integer> villePopList = new ArrayList<Integer>();

                for (Ville vil : villes) {
                    villePopList.add(vil.getPopulation());
                }

                Collections.sort(villePopList);
                Collections.reverse(villePopList);

                System.out.println("");
                System.out.println("**** Voici les 10 villes les plus peuplées de France ****");
                System.out.println("");

                x = 0;
                for (Integer pop : villePopList) {
                    for (Ville vil : villes) {
                        if (vil.getPopulation() == pop) {
                            if (x < 10) {
                                System.out.println(vil.getNomCommune());
                                System.out.println("======> " + pop);
                                System.out.println("");
                            }
                        }
                    }
                    x++;
                }
                break;
            case 9:
                break;
        }
    }
}
