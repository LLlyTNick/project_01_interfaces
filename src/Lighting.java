import Interfaces.InterLight;


public class Lighting implements InterLight{
    private int countLight;



    public Lighting(int countLight){
        this.countLight=countLight;
    }

    @Override
    public int getLight(){
        return countLight;
    }


    @Override
    public String getName() {

        return "";
    }

    @Override
    public void describe() {

    }
}
