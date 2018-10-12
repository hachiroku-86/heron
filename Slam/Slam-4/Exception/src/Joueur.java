import java.util.Date;

public class Joueur {
        String Nom;
        String Prenom;
        String Poste;
        int Numero;
        int Id;
        String Club;
        Date DateN;


        public void setNom(String Nom){
            this.Nom=Nom;
        }

        public String getNom(){
            return this.Nom;
        }

        public void setPrenom(String Prenom){
            this.Prenom=Prenom;
        }

        public String getPrenom(){
            return this.Prenom;
        }

        public void setPoste(String Poste){
            this.Poste=Poste;
        }

        public String getPoste(){
            return this.Poste;
        }

        public void setNumero(int Numero){
            this.Numero=Numero;
        }

        public int getNumero(){
            return this.Numero;
        }

        public void setId(int Id) { this.Id=Id; }

        public int getId(){
            return this.Id;
        }

        public void setClub(String Club){
            this.Club=Club;
        }

        public String getClub(){
            return this.Club;
        }

        public void setDateN(Date DateN){
            this.DateN=DateN;
        }

        public Date getDateN(){
            return this.DateN;
        }

        @Override

        public String toString() {
            return (this.Nom + this.Prenom +this.Poste + this.Numero + this.Id + this.DateN + this.Club);
    }

}
