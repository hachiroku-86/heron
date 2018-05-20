public class VoyageurHandicape extends Voyageur {
    private String handicap;

    public VoyageurHandicape (){

    }

    public VoyageurHandicape (String nom, int age, String handicap){
        super(nom,age);
        this.handicap = handicap;
    }

    public void setHandicap (String handicap){
        this.handicap = handicap;
    }

    public String getHandicap() {
        return this.handicap;
    }

    @Override
    public String toString(){
        return super.toString()+"Son handicap est : " + this.handicap;
    }
}
