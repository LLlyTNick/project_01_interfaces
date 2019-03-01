import Exception.WrongIlluminaceException;
import Exception.WrongSpaceException;
import Interfaces.InterAdd;
import Interfaces.InterFurniture;
import Interfaces.InterLight;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private int square;
    private int summMinSquare;
    private int summMaxSquare;
    private int summLight;
    private int minLight;
    private int maxLight;
    private int WindowNumber;
    private List<InterFurniture> furniture;
    private List<InterLight> lights;



    public Room(String name, int square, int WindowNumber) {
        this.name = name;
        this.square = square;
        summMinSquare = 0;
        summMaxSquare=0;
        this.WindowNumber = WindowNumber;
        minLight = 300;
        maxLight = 4000;
        summLight = WindowNumber * 700;
        furniture = new ArrayList<InterFurniture>();
        lights=new ArrayList<InterLight>();
    }




    public void add(InterAdd added) throws WrongSpaceException, WrongIlluminaceException {
        if(added instanceof InterFurniture) {
            if (((square * 0.7) >= (summMinSquare + ((InterFurniture)added).getMinSquare())) && ((square * 0.7) 
                    >= (summMaxSquare + ((InterFurniture)added).getMaxSquare()))) {
                furniture.add((InterFurniture)added);
                summMinSquare += ((InterFurniture)added).getMinSquare();
                summMaxSquare += ((InterFurniture)added).getMaxSquare();
            }
            else {
                throw new WrongSpaceException("Площадь " + this.name + " будет занята более чем 70%, если добавить " 
                        + added.getName()+"(square="+((InterFurniture) added).getMinSquare()+")");
            }
        }
        else if(added instanceof InterLight){
            if((summLight+((InterLight)added).getLight()>=minLight)&&(summLight+((InterLight)added).getLight()<=maxLight)){
                lights.add(((InterLight)added));
                summLight+=((InterLight)added).getLight();
            }
            else{
                throw new WrongIlluminaceException("Освещенность "+this.name+" будет находиться вне границ 300..4000, " +
                        "если добавить лампочку со значением countLight="+((InterLight)added).getLight()+
                        "\n(summLight="+summLight+")");
            }
        }
    }



    public void describe() {
        System.out.print("    Освещенность=" + getSummLight() + " ( " + getWindowNumber() + " окна по 700лк");

        if (lights.size() != 0) {
            System.out.print("" + "      лампочки ");
        }

        for (InterLight added : lights) {
            System.out.print(added.getLight() + "лк ");
        }
        System.out.println(")");
        System.out.print("    Площадь=" + getSquare());
        if (getSummMaxSquare() != 0) {
            System.out.print("  м^2( занято ");
            if (getSummMaxSquare() == getSummMinSquare()) {
                System.out.print(getSummMaxSquare());
            } else {
                System.out.println(getSummMinSquare() + "-" + getSummMaxSquare() + "м^2, гарантировано свободно " +
                        (getSquare() - getSummMaxSquare()) + "м^2 или " + (100 * getSummMaxSquare() / getSquare())
                        + "% площади)");
            }
        } else {
            System.out.println(" (свободно 100%)");
        }

        if (furniture.size() != 0) {
            System.out.println("    Мебель:");
            for (InterFurniture added : furniture) {
                added.describe();
            }
        }
        else {
            System.out.println("    Мебели нет");
        }
    }


    public String getName() {
        return name;
    }
    private int getSquare (){
        return square;
    }
    private int getWindowNumber(){
        return WindowNumber;
    }
    private int getSummLight(){
        return summLight;
    }
    private int getSummMaxSquare(){
        return summMaxSquare;
    }
    private int getSummMinSquare(){
        return summMinSquare;
    }
}
