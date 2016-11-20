import java.util.ArrayList;

public abstract class Pizza implements Comparable{ // The class is abstract because it's not complete, it will be complete when we have our two types of pizzas done
     protected double area; //This is protected because, both of our pizzas that we will be in their seperate classes, have their own areas. so we declare it here and finish it later
     private ArrayList<Topping> topping; // we will make an arrayList for the toppings using our Topping class

    public abstract double getCurrentWeight(); // Same thing for the getCurrentWeight, both pizza classes (Sicilian and Neapolitian will be finishing this later)

    public Pizza() {
        this.topping = new ArrayList<Topping>(); // this is a default constructor, it will create and array list of toppings everytime it's called.
    }

    @Override
    public int compareTo(Object o) { //This is a comparing method, it will compare areas
        Pizza tmp = (Pizza)o; //Creating a an object Pizza called tmp
        if(this.area < tmp.area) { // now we will compare this pizza's area to our temporary pizza's area
            return -1; // if this pizza's area is less than our temp pizza, then it will return -1
        }
        else if(this.area > tmp.area) {
            return 1; // else if it's greater then it will return 1 (True)
        }
        return 0; //otherwise return 0 (False)
    }

    public boolean checkTopping(Topping t){
        for (int i = 0; i < this.topping.size(); i++) { //this for loop is going through all of our array list
            if (this.topping.get(i).getTopping() == t.getTopping()) // this right here is comparing the topping we have in our parameters to our array list, if we found a matching name.                
                return true; // we will return true.
        }
        return false; // if we didn't find any matching toppings, we will return False.
    };

    public Double getCurrentArea() {

        return area; // this is a getter for the area.
    }

    public double eatSlice(){
        return area / 9; //this should be self explanatory, every slice we eat is our area/9
    };

    public void addTopping(Topping topping) { //we add toppings using this, what this will do is create "topping" of type Topping.
        this.topping.add(topping); //and the topping we created will be added to the arrayList Topping we created above, we add using the keyword "add"
    }

}