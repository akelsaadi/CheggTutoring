public class Topping { //Declaring Class named Topping
    private String topping; //Declaring String named Topping

    public Topping(String topping) { // This is a constructor, a constructor will usually have the same name of the class, If it does not have any parameters then it will be a default constructor.
        this.topping = topping; //This has a parameter, named topping. and we are saying that the topping we declared is set to the toping we have in the parameter of our constructor
    }

    public String getTopping() {
        return topping; //This is a getter, when we call it it will return the topping 
    }

    public void setTopping(String topping) {
        this.topping = topping; //this is a setter, we need a setter for us to be able to call the getter. 
    }
}
// Now let's move on to Class pizza.