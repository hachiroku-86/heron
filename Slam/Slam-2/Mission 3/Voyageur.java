class Voyageur{
    private String nom;
    private int age;
    private String categorie;
    private AdressePostale adresse;
    private Bagage bagage;

    public void setNom(String nom){
        if (nom.length()>= 2){
            this.nom=nom;
        }
    }

    public String getNom(){
        return this.nom;
    }

    public void setAge(int age){
        if (age > 0){
            this.age=age;
            setCategorie();
        }
    }

    public int getAge(){
        return this.age;
    }

    public void setCategorie(){
        if (age<2){
            this.categorie="nourisson";
        }
        else if (age>=2 && age<18){
            this.categorie="enfant";
        }
        else if (age>=18 && age<65){
            this.categorie="adulte";
        }
        else {
            this.categorie="sénior";
        }
    }

    public String getCategorie(){
        return this.categorie;
    }

    public Voyageur(){
        nom = " ";
        age = 0;
        setCategorie();
    }

    public Voyageur(String nom, int age){
        this.nom=nom;
        this.age=age;
        setCategorie();
    }


    public void setAdresse(AdressePostale adresse) {
        this.adresse = adresse;
    }
    public AdressePostale getAdresse(){
        return adresse;
    }

    public void setNumero(Bagage numero) {
        this.bagage = numero;
    }
    public Bagage getNumero(){
        return bagage;
    }

    void afficher () {
        System.out.println ("Nom :("+nom+", "+age+", "+categorie+")");
        if(adresse!=null) {
            this.adresse.afficher();
        }
        if(bagage!=null) {
            this.bagage.afficher();
        }
    }

    void afficher2 () {
        System.out.println ("Nom :("+nom+", "+age+", "+categorie+")");
        this.adresse.afficher();
        System.out.println("Vous n'avez pas de bagage !");
    }



}
