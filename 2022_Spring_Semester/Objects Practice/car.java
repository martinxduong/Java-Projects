public class car {
    private String make;
    private String model;
    private int year;
    private double mpg;
    private double milesDriven;
    private double fuelCapacity;
    private double fuelRemaining;

<<<<<<< HEAD
    public car(String makeTemp, String modelTemp, int yearTemp, double mpgTemp, double milesDrivenTemp, double fuelCapcityTemp, double fuelRemainingTemp) {
        make=makeTemp;
        model=modelTemp;
        year=yearTemp;
        mpg=mpgTemp;
        milesDriven=milesDrivenTemp;
        fuelCapacity=fuelCapcityTemp;
        fuelRemaining=fuelRemainingTemp;
    }

    public double fillTank(double g) {
        if(fuelRemaining+g <= fuelCapacity) {
            fuelRemaining+=g;
        }else if(fuelRemaining+g > fuelCapacity) {
            fuelRemaining=fuelCapacity;
        }
        return fuelRemaining;
    }

    public void drive(double m) {
        if(fuelRemaining >= (m/mpg)) {
            milesDriven+=m;
            fuelRemaining=fuelRemaining-(m/mpg);
        }
        else {
            milesDriven=milesDriven+(fuelRemaining*mpg);
            fuelRemaining=0;
        }
    }

    public String toString() {
        return make+" , "+model+" , "+year+" , "+mpg+" , "+milesDriven+" ,"+fuelCapacity+" , "+fuelRemaining;
    }

    public double getFuelRemaining() {
        return fuelRemaining;
    }
}
...................................
=======
    public car(String makeTemp, String modelTemp, int yearTemp, double mpgTemp, double milesDrivenTemp, double fuelCapcityTemp, double fuelRemainingTemp) {
        make=makeTemp;
        model=modelTemp;
        year=yearTemp;
        mpg=mpgTemp;
        milesDriven=milesDrivenTemp;
        fuelCapacity=fuelCapcityTemp;
        fuelRemaining=fuelRemainingTemp;
    }

    public double fillTank(double g) {
        if(fuelRemaining+g <= fuelCapacity) {
            fuelRemaining+=g;
        }else if(fuelRemaining+g > fuelCapacity) {
            fuelRemaining=fuelCapacity;
        }
        return fuelRemaining;
    }

    public void drive(double m) {
        if(fuelRemaining >= (m/mpg)) {
            milesDriven+=m;
            fuelRemaining=fuelRemaining-(m/mpg);
        }
        else {
            milesDriven=milesDriven+(fuelRemaining*mpg);
            fuelRemaining=0;
        }
    }

    public String toString() {
        return make+" , "+model+" , "+year+" , "+mpg+" , "+milesDriven+" ,"+fuelCapacity+" , "+fuelRemaining;
    }

    public double getFuelRemaining() {
        return fuelRemaining;
    }
}

>>>>>>> 7f4a5b72829e4066e4d833a8f1e4bd66c56e1787