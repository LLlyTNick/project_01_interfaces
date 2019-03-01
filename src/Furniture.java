import Interfaces.InterFurniture;


public class Furniture implements InterFurniture {
    private String name;
    private int maxSquare;
    private int minSquare;


    public Furniture(String name,int square){
        this.name=name;
        this.maxSquare=square;
        this.minSquare=square;
    }


    public int getMaxSquare(){
        return maxSquare;
    }


    public int getMinSquare() {
        return minSquare;
    }


    public String getName(){
        return name;
    }


    @Override
    public void describe() {
        System.out.print("     " + getName());
        System.out.println(" (площадь " + getMinSquare() + " м^2)");
    }
    

}
