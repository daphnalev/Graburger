package com.example.graburger;

enum BunType {
    REGULAR(R.drawable.upper_bun_regular, R.drawable.lower_bun_regular,"Regular"),
    GLUTEN_FREE(R.drawable.upper_bun_gluten_free, R.drawable.lower_bun_gluten_free,"Gluten free"),
    BRIOCHE(R.drawable.upper_bun_brioche, R.drawable.lower_bun_brioche, "Brioche");

    private int upperImage;
    private int lowerImage;
    private String title;

    public int getImage(Boolean isUpper ) {
        if (isUpper) { return this.upperImage; }
        else { return this.lowerImage; }
    }

    public String getTitle(){ return this.title; }

    BunType(int upperBunImage, int lowerBunImage, String title){
        this.upperImage = upperBunImage;
        this.lowerImage = lowerBunImage;
        this.title = title;
    }
}

enum CheeseType {
    REGULAR(R.drawable.cheese_regular,"Regular cheese"),
    VEGAN_CHEESE(R.drawable.cheese_vegan,"Vegan cheese"),
    LOW_FAT(R.drawable.cheese_low_fat,"Low fat cheese");

    private int image;
    private String title;

    public int getImage(){ return this.image; }

    public String getTitle(){ return this.title; }

    CheeseType(int image, String title){
        this.image = image;
        this.title = title;
    }
}

enum MeatType {
    REGULAR(R.drawable.meat_regular,"Regular"),
    VEGAN(R.drawable.meat_vegan,"Vegan"),
    HIGH_PROTEIN(R.drawable.meat_high_protein,"High Protein");

    private int image;
    private String title;

    public int getImage(){ return this.image; }

    public String getTitle(){ return this.title; }

    MeatType(int image, String title){
        this.image = image;
        this.title = title;
    }
}

enum TomatoType {
    WITH(R.drawable.tomato_with,"With tomato"),
    WITHOUT(R.drawable.tomato_without,"Without tomato");

    private int image;
    private String title;

    public int getImage(){ return this.image; }

    public String getTitle(){ return this.title; }

    TomatoType(int image, String title){
        this.image = image;
        this.title = title;
    }
}

enum LettuceType {
    WITH(R.drawable.lettuce_with,"With lettuce"),
    WITHOUT(R.drawable.lettuce_without,"Without lettuce");

    private int image;
    private String title;

    public int getImage(){ return this.image; }

    public String getTitle(){ return this.title; }

    LettuceType(int image, String title){
        this.image = image;
        this.title = title;
    }
}

enum SauceType {
    REGULAR(R.drawable.sauce_regular,"Regular"),
    VEGAN(R.drawable.sauce_vegan,"Vegan"),
    LOW_FAT(R.drawable.sauce_low_fat,"Low fat");

    private int image;
    private String title;

    public int getImage(){ return this.image; }

    public String getTitle(){ return this.title; }

    SauceType(int image, String title){
        this.image = image;
        this.title = title;
    }
}

public class BurgerItemModel extends FoodItemModel {

    private BunType bunType;
    private CheeseType cheeseType;
    private MeatType meatType;
    private TomatoType tomatoType;
    private LettuceType lettuceType;
    private SauceType sauceType;

    public BurgerItemModel(BurgerItemModel burger){
        super(burger.getImages(), burger.getDesc());
        this.bunType = burger.bunType;
        this.cheeseType = burger.cheeseType;
        this.meatType = burger.meatType;
        this.tomatoType = burger.tomatoType;
        this.lettuceType = burger.lettuceType;
        this.sauceType = burger.sauceType;

    }

    public BurgerItemModel(){
        super(new int[] {}, "");
        this.bunType = BunType.REGULAR;
        this.cheeseType = CheeseType.REGULAR;
        this.meatType = MeatType.REGULAR;
        this.tomatoType = TomatoType.WITH;
        this.lettuceType = LettuceType.WITH;
        this.sauceType = SauceType.REGULAR;
        updateBurger();
    }

    public void updateImage(){
        super.setImage( new int[] {
                bunType.getImage(true),
                bunType.getImage(false),
                cheeseType.getImage(),
                meatType.getImage(),
                tomatoType.getImage(),
                lettuceType.getImage(),
                sauceType.getImage()});
    }

    public void updateDesc(){
        super.setDesc(bunType.getTitle() + bunType.getTitle() +
                cheeseType.getTitle() + meatType.getTitle() +
                tomatoType.getTitle() + lettuceType.getTitle() +
                sauceType.getTitle());
    }

    private void updateBurger(){
        updateImage();
        updateDesc();
    }

    public void updateBurger(BunType newBun){ this.bunType = newBun; updateBurger();}

    public void updateBurger(CheeseType newCheese){ this.cheeseType = newCheese; updateBurger();}

    public void updateBurger(MeatType newMeat){ this.meatType = newMeat; updateBurger(); }

    public void updateBurger(TomatoType newTomato){ this.tomatoType = newTomato; updateBurger(); }

    public void updateBurger(LettuceType newLettuce){ this.lettuceType = newLettuce; updateBurger(); }

    public void updateBurger(SauceType newSauce){ this.sauceType = newSauce; updateBurger(); }

}