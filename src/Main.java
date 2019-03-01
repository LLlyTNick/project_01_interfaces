import  Exception.WrongIlluminaceException;
import Exception.WrongSpaceException;


public class Main {
    public static void main(String[] args) {
        Building building=new Building("Здание");
        try {
            building.addRoom("Комната 1",200,3);
            building.addRoom("Комната 2",10,2);
            building.getRoom("Комната 1").add(new Lighting(300));
            building.getRoom("Комната 1").add(new Lighting(200));
            building.getRoom("Комната 1").add(new Furniture("Стол письменный",30));
            building.getRoom("Комната 1").add(new Chair("Кресло мягкое и пушистое",1,2));
            building.describe();
            //
        }
        catch(WrongSpaceException ex){
            System.out.println(ex.getMessage());
        }
        catch(WrongIlluminaceException ex){
            System.out.println(ex.getMessage());
        }


    }
}
