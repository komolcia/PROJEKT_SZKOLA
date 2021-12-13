package net.javaguides.springboot.model.domain;

public enum AmountOfHours {
    WEEKLY(30), BIWEEKLY(60);

    AmountOfHours(int amount) {
        this.amount = amount;
    }

    public final int amount;
}
