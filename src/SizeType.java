public enum SizeType {
    PETIT("petit"),
    MOYEN("moyen"),
    GRAND("grand");

    private final String value;

    SizeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
