package com.sample.test.demo.constants;


public enum PizzaToppings {
    DICEDMANGO("Diced Mango"),
    OLIVES("Olives"),
    MUSHROOMS("Mushrooms"),
    CARAMELIZEDONIONS("Caramelized onions"),
    ITALIANHAM("Italian Ham"),
    CLASSICPEPPERONI("Classic Pepperoni"),
    SALAMI("Salami"),
    PROVOLONECHEESE("Provolone cheese"),
    EXTRACHEESE("Extra cheese"),
    MOZZARELLACHEESE("Mozzarella cheese"),
    PARMASANCHEESE("Parmesan cheese")
    //ONIONS("Caramelized onions"),
    //ITALIANHAM("Italian Ham"),
    //PEPPERONI("Classic Pepperoni"),
    //SALAMI("Salami"),
    //PROVOLNE("Provolone cheese"),
    
    ;

    private String displayName;

    private PizzaToppings(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
