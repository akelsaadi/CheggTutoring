public class NeapolitanPizza extends Pizza{

    public NeapolitanPizza(double radius) { //Same concept as Sicilian Pizza, we finish the class Pizza here as well. Declare Constructor for Neapolitian Pizza radis
        super(); //Call the super which will in invokes the Parent class's constructor(Pizza's constructor)
        this.area = Math.PI * radius * radius; // In the Neapolitian Pizza, the area of iti s pie*r^2, we call Math.PI so  we can get the value for pie
    }

    @Override
    public double getCurrentWeight() {
        return area; //Same concept as the sicilian pizza applies here for the neapolitan pizza.
    }

}