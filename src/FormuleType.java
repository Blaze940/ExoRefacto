public enum FormuleType {
    ASSIETTE("assiette"),
    SANDWICH("sandwich");

    private final String value;

    FormuleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
