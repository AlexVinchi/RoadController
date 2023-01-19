import core.*;
import core.Camera;

import java.util.Scanner;

public class RoadController {
    private static double passengerCarMaxWeight = 3500.0; // kg
    private static int passengerCarMaxHeight = 2000; // mm
    private static int controllerMaxHeight = 3500; // mm
    private static int passengerCarPrice = 100; // GRN
    private static int cargoCarPrice = 250; // GRN
    private static int vehicleAdditionalPrice = 200; // GRN

    public static void main(String[] args) {
        System.out.println("Сколько автомобилей сгенерировать?");

        Scanner scanner = new Scanner(System.in);
        int carsCount = scanner.nextInt();

        for (int i = 0; i < carsCount; i++) {
            Car car = Camera.getNextCar();
            System.out.println(car);

            //Пропускаем автомобили спецтранспорта бесплатно
            if (car.isSpecial && car.height < controllerMaxHeight) {
                openWay();
                continue;
            } else if (car.isSpecial && car.height >= controllerMaxHeight) {
                blockWay("высота спецтранспорта превышает высоту пропускного пункта!");
                continue;
            }


            //Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
            int price = calculatePrice(car);
            if (price == -1) {
                continue;
            }

            System.out.println("Общая сумма к оплате: " + price + " грн.");
        }
    }

    /**
     * Расчёт стоимости проезда исходя из массы и высоты
     */
    private static int calculatePrice(Car car) {
        int carHeight = car.height;
        int price = 0;
        if (carHeight >= controllerMaxHeight) {
            blockWay("высота вашего ТС превышает высоту пропускного пункта!");
            return -1;
        } else if (car.weight <= passengerCarMaxWeight && car.height <= passengerCarMaxHeight ) {
            //Легковой автомобиль
            price = passengerCarPrice;

            //Проверка есть ли прицеп
            if (car.hasVehicle) {
                price = price + vehicleAdditionalPrice;
            }
        }  else {
            //Грузовой автомобиль
            price = cargoCarPrice;

            //Проверка есть ли прицеп
            if (car.hasVehicle) {
                price = price + vehicleAdditionalPrice;
            }
        }
        /*
        else if (carHeight > passengerCarMaxHeight) {
            double weight = car.weight;
            //Грузовой автомобиль
            if (weight > passengerCarMaxWeight) {
                price = passengerCarPrice;
                if (car.hasVehicle) {
                    price = price + vehicleAdditionalPrice;
                }
            }
            //Легковой автомобиль
            else {
                price = cargoCarPrice;
            }
        } else {
            price = passengerCarPrice;
        }
         */
        return price;
    }

    /**
     * Открытие шлагбаума
     */
    private static void openWay() {
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    /**
     * Сообщение о невозможности проезда
     */
    private static void blockWay(String reason) {
        System.out.println("Проезд невозможен: " + reason);
    }
}