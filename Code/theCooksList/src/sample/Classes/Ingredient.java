package sample.Classes;

import java.util.Locale;

public class Ingredient implements Comparable{

    //MEMBERS

    private String name;
    private double quantity;
    private String unit;

    //INIT

    /**
     * Creates a new Ingredient object with an empty name, 0 of quantity
     * and an empty unit
     */
    public Ingredient(){
        name = "";
        quantity = 0;
        unit = "";
    }

    /**
     * Creates an Ingerdient object setting its name, quantity and unit
     * @param name: the name of the ingredient
     * @param quantity: the quantity of the ingredient in the recipe
     * @param unit: the unit of the recipe
     */
    public Ingredient(String name, double  quantity, String unit){
        this.name = name;
        this.quantity = quantity;
        this.unit = unit.toLowerCase(Locale.ROOT);
    }

    /**
     * Creates Ingredient object from copy of another Ingredient object
     * @param copy: the Ingredient object to copy
     */
    public Ingredient(Ingredient copy){
        this.name = copy.getName();
        this.quantity = copy.getQuantity();
        this.unit = copy.getUnit();
    }

    //GETTERS & SETTERS

    public String getName() {
        return name;
    }
    //Never used but might be usefull in further versions
    public void setName (String name) throws Exception {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }
    //Never used but might be usefull in further versions
    public void setUnit(String unit) {
        this.unit = unit;
    }

    //COMPARABLE OVERRIDES

    @Override
    public boolean equals(Object o){
        /*Two Ingredients are equal if they have the same name
        the unit and the quantity does not matter*/
        if(!(o instanceof Ingredient)){
            return false;
        }
        Ingredient other = (Ingredient) o;

        if(other.getName().equals(this.getName())){
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        Ingredient other = (Ingredient) o;
        return this.getName().compareTo(other.getName());
    }
}
