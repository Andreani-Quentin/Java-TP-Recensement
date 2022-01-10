package fr.epsi.b3.recensement.entites;

public class Departement {
    private String codeDepartement;
    private int population;

    public Departement(String codeDepartement, int population) {
        this.codeDepartement = codeDepartement;
        this.population = population;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
