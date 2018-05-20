public class VoyageurPrivilège extends Voyageur{

    private int code;
    public VoyageurPrivilège(){

    }
    public VoyageurPrivilège(String nom, int age, int code){
        super(nom, age); //ref classe mere
        this.code=code;
    }

    public void setCode(int code) {
        this.code=code;
    }

    public int getCode() {
        return this.code;
    }

    public String toString(){
        return super.toString() + "code : " + this.code;
    }
}
