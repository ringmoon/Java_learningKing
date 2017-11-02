
import javax.swing.JMenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {

    private GameMenu gameMenu;
    private SubjectsMenu subjectsMenu;

    public MenuBar() {
        gameMenu = new GameMenu("遊戲(G)");
        gameMenu.setMnemonic('g');
        add(gameMenu);
        subjectsMenu = new SubjectsMenu("科目(J)");
        subjectsMenu.setMnemonic('j');
        add(subjectsMenu);
    }

    public GameMenu getGameMenu() {
        return gameMenu;
    }

    public SubjectsMenu getSubjectsMenu(){
        return subjectsMenu;
    }
    
}
