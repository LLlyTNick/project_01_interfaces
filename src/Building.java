import Exception.WrongIlluminaceException;

import java.util.ArrayList;
import java.util.List;


    public class Building {
        private String name;
        private List<Room> rooms;

        /* публичный конструктор  */
        public Building(String name) {
            this.name = name;
            rooms = new ArrayList<Room>();
        }


        public void addRoom(String nameRoom, int square, int WindowNumber) throws WrongIlluminaceException {
            if (!((WindowNumber *700>4000)||(WindowNumber *700<300))) {
                rooms.add(new Room(nameRoom, square, WindowNumber));
            }
            else{
                throw new WrongIlluminaceException("В "+nameRoom+" значение параметра sumLight находиться вне диапозона 400..4000\n " +
                        "sumLight=WindowNumber*700\n"+
                        "Перепроверьте значение countWindow(countWindow="+ WindowNumber +")");
            }

        }


        public Room getRoom(String nameRoom) {
            Room rm = new Room("", 0, 0);

            for (Room curr : rooms) {
                if (curr.getName().equals(nameRoom)) {
                    return curr;
                }
            }
            if (rm.getName().equals(nameRoom)) {
                return rm;
            } else {
                return null;
            }
        }

        public void describe(){
            System.out.println(name);
            for(Room room:rooms) {
                System.out.println(" " + room.getName());
                room.describe();

            }
        }
    }

