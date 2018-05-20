public class AdressePostale {
    private String adresse;
    private String ville;
    private String codePostal;

    public AdressePostale (String adresse, String ville, String codePostal) {
        this.adresse=adresse;
        this.ville=ville;
        this.codePostal=codePostal;
    }

    public void setAdresse(String adresse){
        this.adresse=adresse;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setVille(String ville){
        this.ville=ville;
    }

    public String getVille() {
        return this.ville;
    }

    public void setcodePostal(String codePostal){
        this.codePostal=codePostal;
    }

    public String getcodePostal() {
        return this.codePostal;
    }

    @Override
    public String toString(){
        if(this.adresse!=null){
            return" Votre adresse est " + adresse +" "+ ville +" "+ codePostal;
        }else{
            return "Pas d'adresse";
        }
    }
}
