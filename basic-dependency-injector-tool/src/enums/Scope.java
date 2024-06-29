package enums;

public enum Scope {

    SINGLETON("singleton"),
    PROTOTYPE("prototype");

    private final String name;

    Scope(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Scope getScopeName(String scopeName) {
        for (Scope scope : Scope.values()) {
            if (scope.name().equalsIgnoreCase(scopeName)) {
                return scope;
            }
        }
        return null;
    }
}
