package be.thomasmore.cars.model;

public class venue {
    private String name;
    private String brand;
    private int price;
    private int kilometers;
    private String fuel;
    private String year;
    private String color;
    private boolean forSale;
    private boolean radio;
    private boolean gps;
    private boolean airConditioning;
    private boolean automatic;
    private boolean manual;

    public venue(String name, String brand, int price, int kilometers, String fuel, String year, String color, boolean forSale, boolean radio, boolean gps, boolean airConditioning, boolean automatic, boolean manual) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.kilometers = kilometers;
        this.fuel = fuel;
        this.year = year;
        this.color = color;
        this.forSale = forSale;
        this.radio = radio;
        this.gps = gps;
        this.airConditioning = airConditioning;
        this.automatic = automatic;
        this.manual = manual;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isForSale() {
        return forSale;
    }

    public void setForSale(boolean forSale) {
        this.forSale = forSale;
    }

    public boolean isRadio() {
        return radio;
    }

    public void setRadio(boolean radio) {
        this.radio = radio;
    }

    public boolean isGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }
}