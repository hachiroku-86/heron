public class Bagage {

    private int numero;
    private String couleur;
    private double poids;

    public Bagage (int numero, String couleur, double poids) {
        this.numero=numero;
        this.couleur=couleur;
        this.poids=poids;
    }

    public void setNumero(int numero){
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

    public void setPoids(double poids){
        this.poids=poids;
    }

    public double getPoids() {
        return this.poids;
    }

    @Override
    public String toString (){
        if(this.numero!=0) {
            return " Votre bagage est " + numero + " " + couleur + " " + poids;
        }else{
            return "Pas de bagage";
        }
    }
}
