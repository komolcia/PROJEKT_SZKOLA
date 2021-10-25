package net.javaguides.springboot.model;

public enum AmountOfHours {
    HALF(30), FULL(60);

    AmountOfHours(int amount) {
        this.amount = amount;
    }

    public final int amount;
}
