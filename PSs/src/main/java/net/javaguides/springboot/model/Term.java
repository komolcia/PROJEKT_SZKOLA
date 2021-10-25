package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "term")
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "hour")
    private int hour;

    @Column(name = "minute")
    private int minute;

    @Column(name = "weeksday")
    private Day weeksDay;

    @Enumerated(EnumType.ORDINAL)
    private AmountOfHours amountOfHours;

    public Long getId() {
        return id;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public Day getWeeksDay() {
        return weeksDay;
    }

    public void setWeeksDay(Day weeksDay) {
        this.weeksDay = weeksDay;
    }

    public AmountOfHours getAmountOfHours() {
        return amountOfHours;
    }

    public void setAmountOfHours(AmountOfHours amountOfHours) {
        this.amountOfHours = amountOfHours;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
