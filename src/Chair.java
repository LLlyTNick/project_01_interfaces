import Interfaces.InterFurniture;


public class Chair implements InterFurniture {
    private String name;
    private int minSquare;
    private int maxSquare;


    public Chair(String name, int minSquare, int maxSquare){
        this.name=name;
        this.minSquare=minSquare;
        this.maxSquare=maxSquare;
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


    public void describe(){
        System.out.print("     " + getName());
        System.out.println(" (площадь от " + getMinSquare() + " м^2 до " + getMaxSquare() + " м^2)");
    }

}
