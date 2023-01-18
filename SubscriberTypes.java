package model;

public enum SubscriberTypes {
    NORMAL("Normal"),
    LAZY("Lazy");

    SubscriberTypes(String name) {
        this.name = name;
    }

    private final String name;
}
