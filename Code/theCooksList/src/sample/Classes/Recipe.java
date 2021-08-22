package sample.Classes;

import java.util.ArrayList;
import java.util.Locale;

public class Recipe {

    //MEMBERS

    private String name;
    private ArrayList<Ingredient> recipe;
    private int numPpl;

    //INIT

    /**
     * Creates an empty  recipe object
     */
    public Recipe(){
        name = "";
        recipe = new ArrayList<>();
        numPpl = 0;
    }

    /**
     * Creates a Recipe object with a name and a number of people
     * @param name
     * @param numPpl
     */
    public Recipe(String name, int numPpl){
        this.name = name.toLowerCase(Locale.ROOT);
        recipe = new ArrayList<>();
        this.numPpl = numPpl;
    }

    /**
     * Creates a  recipe from a copy of another recipe
     * @param r: the recipe to copy
     */
    public Recipe(Recipe r){
        this.name = r.name;
        recipe = new ArrayList<>();
        for (Ingredient i : r.getIngredients()){
            recipe.add(new Ingredient(i));
        }
        this.numPpl = r.numPpl;
    }


    //GETTERS & SETTERS

    public int getNumPpl() {
        return numPpl;
    }
    //Never used but might be usefull in further versions
    public void setNumPpl(int numPpl) {
        this.numPpl = numPpl;
    }

    public String getName() {
        return name;
    }
    //Never used but might be usefull in further versions
    public void setName(String name) {
        this.name = name;
    }

    //OTHER METHODS

    /**
     * Adds ingredient to the recipe
     * @param i
     */
    public void addIngredient(Ingredient i){
        recipe.add(new Ingredient (i));
    }

    /**
     * Fetch a specific ingredient  from the recipe
     * @return: the ingredient  object
     */
    public ArrayList<Ingredient> getIngredients(){
        ArrayList<Ingredient > ing = new ArrayList<>();
        for (Ingredient i : recipe){
            ing.add(new Ingredient(i));
        }
        return ing;
    }

    /**
     * Fetchs an ingredient from the  recipe
     * @return
     */
    public ArrayList<Ingredient> getIng(){
        return recipe;
    }

    /**
     * Returns the string with content of the recipe
     * @return
     */
    public String toString(){
        String list = "";
        for (Ingredient i : recipe){
            list = list + "\n" +  i.getName();
        }
        return list;
    }


}
