import core.*;
import core.Camera;

import java.util.Scanner;

public class RoadController
{
    private static double passengerCarMaxWeight = 3500.0; // kg  объявляется переменная типа double
    private static int passengerCarMaxHeight = 2000; // mm   объявляется переменная типа int
    private static int controllerMaxHeight = 3500; // mm  объявляется переменная типа int

    private static int passengerCarPrice = 100; // RUB  объявляется переменная типа int
    private static int cargoCarPrice = 250; // RUB  объявляется переменная типа int
    private static int vehicleAdditionalPrice = 200; // RUB  объявляется переменная типа int

    public static void main(String[] args)
    {
        System.out.println("Сколько автомобилей сгенерировать?");

        Scanner scanner = new Scanner(System.in);
        int carsCount = scanner.nextInt(); // объявляется переменная типа int

        for(int i = 0; i < carsCount; i++)
        {
            Car car = Camera.getNextCar();
            System.out.println(car);

            //Пропускаем автомобили спецтранспорта бесплатно
            if (car.isSpecial) {
                openWay();
                continue;
            }

            //Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
            int price = calculatePrice(car); //  объявляется переменная типа int
            if(price == -1) {
                continue;
            }

            System.out.println("Общая сумма к оплате: " + price + " руб.");
        }
    }

    /**
     * Расчёт стоимости проезда исходя из массы и высоты
     */
    private static int calculatePrice(Car car)
    {
        int carHeight = car.height;  // объявляется переменная типа int
        int price = 0;  // объявляется переменная типа int
        if (carHeight > controllerMaxHeight)
        {
            blockWay("высота вашего ТС превышает высоту пропускного пункта!");
            return -1;
        }
        else if (carHeight > passengerCarMaxHeight)
        {
            double weight = car.weight; // объявляется переменная типа double
            //Грузовой автомобиль
            if (weight > passengerCarMaxWeight) // если вес больше максимального веса пассажирского автомобиля
            {
                price = cargoCarPrice; // то и цена должна быть за грузовой автомобиль
                if (car.hasVehicle) {
                    price = price + vehicleAdditionalPrice;
                }
            }
            //Легковой автомобиль
            else {
                price = passengerCarPrice; // иначе цена как за легковой
            }
        }
        else {
            price = passengerCarPrice;
        }
        return price;
    }

    /**
     * Открытие шлагбаума
     */
    private static void openWay()
    {
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    /**
     * Сообщение о невозможности проезда
     */
    private static void blockWay(String reason)
    {
        System.out.println("Проезд невозможен: " + reason);
    }
}