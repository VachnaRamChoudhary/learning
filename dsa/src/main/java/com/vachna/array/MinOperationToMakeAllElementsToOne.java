package dsa.src.main.java.com.vachna.array;

import java.util.*;

public class MinOperationToMakeAllElementsToOne {

    public MinOperationToMakeAllElementsToOne(){
        int[] nums = {0,1,1,1};
        System.out.println("Min operations: "+ minOperations(nums));
    }
    public int minOperations(int[] nums) {
        int op = 0;
        for(int i = 0; i< nums.length-2; i++){
            System.out.println(Arrays.toString(nums));
            if(nums[i] == 0){
                op+=1;
                nums[i] = flip(nums[i]);
                nums[i+1] = flip(nums[i+1]);
                nums[i+2] = flip(nums[i+2]);
            }
        }
        System.out.println(Arrays.toString(nums));
        if(nums.length < 3 || nums[nums.length-1] == 0 || nums[nums.length-2] == 0){
            return -1;
        } else {
            return op;
        }
    }

    private int flip(int i) {
        return i==1?0:1;
    }


    public static void main(String[] args) {
        new MinOperationToMakeAllElementsToOne();
    }


    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> suppMap = new HashSet<>(Arrays.asList(supplies));
        Map<String, Boolean> recipesMap = new HashMap<>();
        Map<String, List<String>> recipeIngradeMap = new HashMap<>();
        Set<String> inProgress = new HashSet<>(); // To detect cycles

        List<String> ans = new ArrayList<>();
        for(String s : recipes){
            recipesMap.put(s, false);
        }
        for(int i = 0; i < recipes.length; i++){
            recipeIngradeMap.put(recipes[i], ingredients.get(i));
        }

        for (String recipe : recipes) {
            Boolean canMade = canMadeRecipe(recipe, recipeIngradeMap, suppMap, recipesMap, inProgress);
            if (canMade) ans.add(recipe);
        }
        return ans;

    }

    private Boolean canMadeRecipe(String recipe, Map<String, List<String>> recipeIngradeMap,
                                  Set<String> suppMap, Map<String, Boolean> recipesMap,
                                  Set<String> inProgress) {
        if (suppMap.contains(recipe)) return true;  // Already available
        if (recipesMap.get(recipe)) return true;    // Already computed and possible
        if (inProgress.contains(recipe)) return false; // Cycle detected

        inProgress.add(recipe);  // Mark as being processed

        for (String ingredient : recipeIngradeMap.get(recipe)) {
            if (!suppMap.contains(ingredient)) { // If ingredient is not a direct supply
                if (!recipesMap.containsKey(ingredient)) return false; // Ingredient is not a recipe
                if (!canMadeRecipe(ingredient, recipeIngradeMap, suppMap, recipesMap, inProgress)) {
                    return false; // If an ingredient can't be made, this recipe can't be made
                }
            }
        }

        inProgress.remove(recipe);  // Mark as processed
        recipesMap.put(recipe, true); // Mark recipe as possible
        return true;
    }
}
