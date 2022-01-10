package fr.epsi.b3.recensement.entites;

public class Region {
    private String nomRegion;
    private String codeRegion;
    private int population;

    public Region(String nomRegion, String codeRegion, int population) {
        this.nomRegion = nomRegion;
        this.codeRegion = codeRegion;
        this.population = population;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public String getCodeRegion() {
        return codeRegion;
    }

    public void setCodeRegion(String codeRegion) {
        this.codeRegion = codeRegion;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
