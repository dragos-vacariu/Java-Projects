/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project44;

import java.util.ArrayList;

/**
 *
 * @author Black2
 */
public class CarLot {
    private ArrayList <Car> CarList;
    public CarLot()
    {
        CarList = new ArrayList();
    }
    public ArrayList <Car> getAllCars()
    {
        CarList.add(new Car("Ford Mustang GT", 300.0f, 1.2f, "cars\\ford mustang gt.j", 40000));
        CarList.add(new Car("Mitsubishi Lancer Evolution IX", 320f, 1.1f, "cars\\mitsubishi lancer evolution ix.j", 33000));
        CarList.add(new Car("Aston Martin DB9", 255f, 1.15f, "cars\\aston martin db9.j", 12000));
        CarList.add(new Car("Audi TT", 270f, 1.25f, "cars\\audi tt.j", 14000));
        CarList.add(new Car("BMW 650i", 230f, 1.05f, "cars\\bmw 650i.j", 6000));
        CarList.add(new Car("BMW M3", 290f, 1.25f, "cars\\bmw m3.j", 16000));
        CarList.add(new Car("Chevrolet Camaro Concept", 285f, 1.25f, "cars\\chevrolet camaro concept.j", 15000));
        CarList.add(new Car("Chevrolet Camaro", 255f, 1.2f, "cars\\chevrolet camaro.j", 8500));
        CarList.add(new Car("Chevrolet Corvette Z06", 345f, 1.3f, "cars\\chevrolet corvette.j", 60000));
        CarList.add(new Car("Chrysler 300C SRT-8", 240f, 1.1f, "cars\\chrysler.j", 6500));
        CarList.add(new Car("Dodge Viper GTS", 345f, 1.24f, "cars\\dodge viper.j", 58000));
        CarList.add(new Car("Ferrari 458", 290f, 1.19f, "cars\\ferrari 458.j", 24000));
        CarList.add(new Car("Ford Flex", 220f, 1.13f, "cars\\ford flex.j", 3000));
        CarList.add(new Car("Lamborghini Aventador", 344f, 1.26f, "cars\\lamborghini aventador.j", 64000));
        CarList.add(new Car("Lamborghini Gallardo", 320f, 1.2f, "cars\\lamborghini gallardo.j",43000));
        CarList.add(new Car("Mazda RX-8", 260f, 1.18f, "cars\\mazda rx8.j", 14500));
        CarList.add(new Car("Mitsubishi Eclipse", 245f, 1.24f, "cars\\mitsubishi eclipse.j", 9000));
        CarList.add(new Car("Nissan 350z Coupe", 280f, 1.15f, "cars\\nissan 350z coupe.j", 11500));
        CarList.add(new Car("Nissan Skyline GT-R", 290f, 1.23f, "cars\\nissan skyline gtr.j", 30500));
        CarList.add(new Car("Porche 911 Turbo S", 290f, 1.2f, "cars\\porche 911 turbo s.j", 28000));
        CarList.add(new Car("Porche Cayman S", 270f, 1.18f, "cars\\porche cayman s.j", 19000));
        CarList.add(new Car("Renault Clio RS", 235f, 1.21f, "cars\\renault clio rs.j", 10500));
        CarList.add(new Car("Renault Megane", 260f, 1.16f, "cars\\renault megane.j", 8500));
        CarList.add(new Car("Subaru Impreza WRX STI", 285f, 1.215f, "cars\\subaru impreza wrx sti.j", 27000));
        CarList.add(new Car("Subaru Legacy Concept", 290f, 1.3f, "cars\\subaru legacy concept.j", 36000));
        CarList.add(new Car("Toyota Corolla", 224f, 1.13f, "cars\\toyota corolla.j", 4500));
        CarList.add(new Car("Toyota Supra", 255f, 1.14f, "cars\\toyota supra.j", 7500));
        CarList.add(new Car("Voltzwagen Golf GTI", 230f, 1.07f, "cars\\vw golf.j", 3000));
        CarList.add(new Car("BMW Z4", 265f, 1.09f, "cars\\bmw z4.j", 13000));
        CarList.add(new Car("Mitsubishi Outlander", 245f, 1.11f, "cars\\mitsubishi outlander.j", 9000));
        CarList.add(new Car("BMW X1", 235f, 1.14f, "cars\\bmw x1.j", 10000));
        CarList.add(new Car("Lamborghini Haracan", 330f, 1.22f, "cars\\lamborghini haracan.j", 45000));
        CarList.add(new Car("Lamborghini Spyder", 310f, 1.18f, "cars\\lamborghini spyder.j", 41000));
        CarList.add(new Car("Ferrari 575 GTC", 315f, 1.22f, "cars\\ferrari 575 gtc.j", 44000));
        CarList.add(new Car("BMW X6M", 250f, 1.15f, "cars\\bmw x6m.j", 14000));
        CarList.add(new Car("Voltzwagen Jetta", 270f, 1.12f, "cars\\vw jetta.j", 11000));
        CarList.add(new Car("Toyota Yaris", 240f, 1.155f, "cars\\toyota yaris.j", 10000));
        CarList.add(new Car("Audi A5", 245f, 1.11f, "cars\\audi a5.j", 8000));
        CarList.add(new Car("Audi A7", 280f, 1.15f, "cars\\audi a7.j", 18000));
        CarList.add(new Car("Dodge Challenger", 285f, 1.25f, "cars\\dodge challenger.j", 29000));
        CarList.add(new Car("Honda Civic", 260f, 1.08f, "cars\\toyota yaris.j", 9000));
        CarList.add(new Car("Lexus LS 460", 270f, 1.11f, "cars\\lexus ls460.j", 12000));
        
        return CarList;
    }
    public Car getCarFromLot(int index)
    {
        return CarList.get(index);
    }
    public Car getCarFromLot(String carName)
    {
        CarLot car = new CarLot();
        ArrayList<Car> carList = car.getAllCars();
        for(Car k : carList)
        {
            if(k.getCarName().compareTo(carName)==0)
            {
                return k;
            }
        }
        //this should never be reached.
        return null;
    }
}