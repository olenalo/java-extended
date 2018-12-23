package com.alevel.models;

import com.alevel.constants.Menu;

public class DishBuilder {

    public Long id;
    public String menuId;
    public String title;
    public String environment;
    public String ingredients;
    public String technology;
    public String utensil;
    public String design;

    public DishBuilder(Long id) {
        this.id = id;
        this.title = "Dish";
        for (Menu dish : Menu.values()) {
            if (id.equals(dish.getDishDescriptors()[0])) {
                this.title = dish.getDishDescriptors()[1];
            }
        }
    }

    public DishBuilder environment(String environment, Order order, Cook cook) {
        System.out.println(environment);
        order.addResponsibleCook(cook);
        this.environment = environment;
        return this;
    }

    public DishBuilder ingredients(String ingredients, Order order, Cook cook) {
        System.out.println(ingredients);
        order.addResponsibleCook(cook);
        this.ingredients = ingredients;
        return this;
    }

    public DishBuilder technology(String technology, Order order, Cook cook) {
        System.out.println(technology);
        order.addResponsibleCook(cook);
        this.technology = technology;
        return this;
    }

    public DishBuilder utensil(String utensil, Order order, DishWasher dishwasher) {
        System.out.println(utensil);
        order.addResponsibleDishwasher(dishwasher);
        this.utensil = utensil;
        return this;
    }

    public DishBuilder design(String design, Order order, Cook cook) {
        System.out.println(design);
        order.addResponsibleCook(cook);
        this.design = design;
        return this;
    }

    public Dish createDish() {
        return new Dish(this.id,
                this.menuId,
                this.title,
                this.environment,
                this.ingredients,
                this.technology,
                this.utensil,
                this.design);
    }

}
