public enum GameOptions{
    UPDATE_QUESTIONS(0),
    GAME_START(1),
    GAME_PAUSE(2),
    GAME_END(3),
    GAME_CLOSE(4);
    private int value;
    private GameOptions(int value){
        this.value=value;
    }
    public int getValue(){
        return this.value;
    }
}
