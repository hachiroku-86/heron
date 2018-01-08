public class Bagage {
    private int numero;
    private String couleur;
    private int poids;

    public Bagage (int numero, String couleur, int poids) {
        this.numero=numero;
        this.couleur=couleur;
        this.poids=poids;
    }

    public void setNumero(String adresse){
        this.numero=numero;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setCouleur(String couleur){
        this.couleur=couleur;
    }

    public String getCouleur() {
        return this.couleur;
    }

    public void setPoids(int poids){
        this.poids=poids;
    }

    public int getPoids() {
        return this.poids;
    }

    void afficher(){
        System.out.println(" Votre bagage est " + numero +" "+ couleur +" "+ poids);
    }
}
