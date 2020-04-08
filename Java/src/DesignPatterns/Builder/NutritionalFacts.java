package Java.src.DesignPatterns.Builder;

public class NutritionalFacts {

    private final int servingSize;
    private final int servings;

    private final int calories;
    private final int fat;
    private final int protein;
    private final int carbohydrates;

    public static class Builder{
        //Required parameters
        private final int servingSize;
        private final int servings;

        private int calories = 0;
        private int fat = 0;
        private int protein = 0;
        private int carbohydrates = 0;

        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int calories){
            this.calories = calories;
            return this;
        }

        public Builder fat(int fat){
            this.fat = fat;
            return this;
        }
        public Builder protein(int protein){
            this.protein = protein;
            return this;
        }
        public Builder carbohydrates(int carbohydrates){
            this.carbohydrates = carbohydrates;
            return this;
        }

        public NutritionalFacts build(){
            if(servings < 0 || servingSize<0)
                throw new IllegalArgumentException();
            return new NutritionalFacts(this);
        }



    }

    public NutritionalFacts(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        protein = builder.protein;
        carbohydrates = builder.carbohydrates;
    }

    NutritionalFacts cocaCola = new Builder(240,8).calories(300).fat(20).protein(3).carbohydrates(200).build();
}
