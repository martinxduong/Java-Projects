public class carMain {
    public static void main(String[] args) {
        car Rav4=new car("Toyota","Rav4",2021,28,8000,14.5,8); //make model
        year mpg milesDriven fuelCapacity fuelRemaining
        Rav4.drive(56);
        Rav4.fillTank(5);
        System.out.println(Rav4.getFuelRemaining());
        System.out.println(Rav4);
        car Altima=new car("Nissan","Altima",2008,23,150000,20.0,15); //make
        model year mpg milesDriven fuelCapacity fuelRemaining
        Altima.drive(56);
        Altima.fillTank(5);
        Altima.drive(30);
        System.out.println(Altima.getFuelRemaining());
        System.out.println(Altima);
    }
}


