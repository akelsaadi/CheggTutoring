


public class Main {
    public static void main(String[] args) { //Main is declared here, we are testing everything we created.
        Pizza neapolitan = new NeapolitanPizza(2); // We are creating an object Pizza, name it neapolitan, and it's of type NeapolitanPizza, if you remember, Neapolitan Pizza had one parameter in it's cosntructor and it was radius, here we are setting that radius to 2.
        Pizza sicilian = new SicilianPizza(2, 3); //Same thing here, creating object Pizza, name "sicilian" of type SicilianPizza, our constructor in SicilianPizza had parameters length and width, here we are setting length to 2 and width to 3.
        neapolitan.addTopping(new Topping("mushrooms")); // now we are calling the object neapolitan, calling the method addTopping, addTopping method's had a parameter of type Topping, so here we are creating a new object Topping and  in turn that invokes the constructor in our Topping class, which has one parameter of type string, so we give that string a name "mushrooms" 
        neapolitan.addTopping(new Topping("pepperoni"));//same concept as above
        sicilian.addTopping(new Topping("anchovies,"));//same concept as above, except here we are calling the object sicilian
        sicilian.addTopping(new Topping("pepperoni"));//same ^
//Now neapolitan has two toppings added to it, mushrooms and pepperoni. Like wise for sicilian, it has anchovies and pepperoni
        System.out.println(neapolitan.checkTopping(new Topping("mushrooms")));//like above, except this time the checktopping method is invoked, it also has a parameter of type Topping, create new object Topping which invokes the constructor from the class Topping, set the string to mushrooms. so now it's checking for mushrooms
        System.out.println(sicilian.checkTopping(new Topping("mushrooms"))); // same concept

        System.out.println(neapolitan.getCurrentArea()); //Here it's printing out the area, use the object neapolitan to call the method getCurrentArea (Which is in the Class Pizza, but we have to call it using the classes that extends pizza because in the class pizza, if you remember, it's not done. we finished it in the later classes.
        System.out.println(sicilian.getCurrentArea()); //Same concept. 

        System.out.println(neapolitan.getCurrentWeight()); // same concept, except this is called from the class neapolitan. It doesn't matter though, the children classes can call the parent's classes methods and their own methods
        System.out.println(sicilian.getCurrentWeight()); // same concept as above.

        System.out.println(neapolitan.eatSlice()); // calling eatSlice which is in the parent class.  
        System.out.println(sicilian.eatSlice()); // calling the method eatSlice as well, in the parent class.

    }
}