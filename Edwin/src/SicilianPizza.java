

public class SicilianPizza extends Pizza{ //This is an extension to the Class Pizza(Since we made the class pizza abstract, it means it must have other classes to finish it up.
    public SicilianPizza(double length,double  width) { //Declaring the Constructor for Sicilian(Not default), with parameters length and width
        super(); //Since it's extending the class Pizza, the super() keyword basically invokes the Parent's constructor which in our case is the Pizza. Therefor it will invoke Pizza's constructor
        this.area = length * width; //Since we never finished setting the area in the parent class Pizza and we declared area as protected, therefor we can use it here and we can finish it here.
                                    //In our case here, Sicilian Pizza's area is Length*width, so this is what we set it to
    }

    @Override
    public double getCurrentWeight() {
        return area * 2; // If you look at the class Pizza, we also declared getCurrentWeight abstract because the two types of pizzas have two different weight measurements. 
        //Therefor, we finish the getCurrentWeight Method here, in the Sicilian Pizza, the weight is area*2. 
    }


}