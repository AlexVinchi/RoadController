package core;
/*
Point of automatic check of the car and collection of payment
 */
public class Car {
    public String number;
    public int height;
    public double weight;
    public boolean hasVehicle;
    public boolean isSpecial;

    public void setNumber(String number){ this.number = number;}
    public String getNumber(){ return number; }

    public void setHeight(int height) { this.height = height; }
    public int getHeight(){ return height;}

    public void setWeight(double weight){ this.weight = weight;}
    public double getWeight(){ return weight;}

    public void setHasVehicle(boolean hasVehicle){ this.hasVehicle = hasVehicle;}
    public boolean getHasVehicle(){return hasVehicle;}

    public void setSpecial(boolean isSpecial){this.isSpecial = isSpecial;}
    public boolean getSpecial(){return isSpecial;}

    public String toString() {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ \n=========================================\n " : "";
        String trailer = hasVehicle ? " c прицепом" : "";
        return "\n=========================================\n" +
            special + "Автомобиль" + trailer + ", номерной знак " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}