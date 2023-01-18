package model;

public class Subscriber {
    private final String name;
    private Integer money;
    private final String type;

    public Subscriber(String name, Integer money, String type) {
        this.name = name;
        this.money = money;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }
}
