package sample.Classes;

import java.util.ArrayList;
import java.util.Collections;

public class Inventory {

    //MEMBERS

    private ArrayList<Recipe> recipeList; //Contains recipes that user wants to process for grocery list
    private ArrayList<Recipe> inv; //Contains all recipes
    ArrayList<Ingredient> list; //Contains all ingredient from the grocery list


    //INIT

    /**
     * Creates a new inventory
     */
    public Inventory() {
        recipeList = new ArrayList<>();
        list = new ArrayList<>();
        inv = new ArrayList<>();
    }

    //GETTERS & SETTERS
    /**
     * Adds recipe to user inventory
     * @param r: recipe to add
     */
    public void addRecipeToInv(Recipe r){
        inv.add(r);
    }

    /**
     * Gets recipe from inventory
     * @param i: recipe to get
     * @return: the recipe object to get
     */
    public Recipe getRecipe(int i){
        return inv.get(i);
    }

    public ArrayList<Recipe> getAllRecipe(){
        ArrayList<Recipe> result = new ArrayList<>();
        for (Recipe r : inv){
            result.add(r);
        }
        return result;
    }

    //ADDITIONAL METHODs (Process of the grocery list)

    /**
     * Adds a recipe to the list of recipes the user wants to process for the grocery list.
     * The methods allows the user to choose the number of people he wants the recipe to be process  in the list for.
     * the quantities are modified only in the list of recipes to be proessed
     * @param r: recipe to add
     * @param numPpl: number of people that recipe is for for the grocery list
     */
    public void addRecipeToList(Recipe r, int numPpl) {
        for (Ingredient i : r.getIng()){
            i.setQuantity(i.getQuantity() * numPpl / r.getNumPpl());
        }

        recipeList.add(r);
    }

    /**
     * this  methods  fills the  list of  ingredients for  the grocery list.
     * If an ingredient appears twice, it will not appear twice in the list. Quantities are
     * automatically added
     */
    public void fillList() {
        for (Recipe r : recipeList) {
            for (Ingredient i : r.getIngredients()) {
                if(list.contains(i)){
                    for(int j = 0; j < list.size(); j++){
                        if(list.get(j).equals((i))){
                            i.setQuantity((i.getQuantity() + list.get(j).getQuantity()));
                            list.set(j, i);
                        }
                    }
                }
                else{
                    list.add(new Ingredient(i));
                }

            }
        }
    }

    /**
     * Creates a   string containing the grocery list
     * @return: the string containing the  grocery list
     */
    public String getList() {
        String s = "";

        for (Ingredient i : list) {
            s += i.getName() + ": " + i.getQuantity() + " " + i.getUnit() + "\n";
            System.out.println(i.getName() + ": " + i.getQuantity() + " " + i.getUnit());
        }
        return s;
    }

    /**
     * Sorts  the list in alphabetic order
     */
    public void sortList(){
        Collections.sort(list);
    }

}
