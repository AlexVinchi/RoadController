package core;

public class Camera {
    public static Car getNextCar() {
        //String randomNumber = Double.toString(Math.random()).substring(2, 5);
        String randomNumber = Double.toString(Math.random()).substring(2, 6);
        String[] randomRegion = {"AI", "AA", "AM", "AO", "BT", "OA", "TA", "BI", "EA", "EC", "BK", "MA", "BK", "CA", "XM", "TE"};
        int numberRegion = (int)Math.floor(Math.random() * randomRegion.length);
        int prefixRegion = (int)Math.floor(Math.random() * randomRegion.length);
        int randomHeight = (int) (1000 + 3500. * Math.random());
        double randomWeight = Math.round(600 + 10000 * Math.random());

        Car car = new Car();
        car.number = randomRegion[numberRegion]+randomNumber+randomRegion[prefixRegion];
        car.height = randomHeight;
        car.weight = randomWeight;
        car.hasVehicle = Math.random() > 0.5;
        car.isSpecial = Math.random() < 0.15;

        return car;
    }
}