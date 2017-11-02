
public enum SubjectOptions {
    CHINESE(0),
    ENGLISH(1),
    MATH(2);
    private int value;
    private SubjectOptions(int value) {
        this.value=value;
    }
    public int getValue(){
        return this.value;
    }
}
