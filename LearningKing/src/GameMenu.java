
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;

public class GameMenu extends JMenu {

    private JMenuItem updateQuestions, gameStart, gamePause, gameEnd, gameClose;

    public GameMenu(String name) {
        super(name);
        updateQuestions = new JMenuItem("更新題庫     Alt+U");
        updateQuestions.setMnemonic('u');
        gameStart = new JMenuItem("遊戲開始     Alt+S");
        gameStart.setMnemonic('s');
        gamePause = new JMenuItem("遊戲暫停     Alt+P");
        gamePause.setMnemonic('p');
        gameEnd = new JMenuItem("遊戲結束     Alt+F");
        gameEnd.setMnemonic('f');
        gameClose = new JMenuItem("關閉程式     ESC");
        add(updateQuestions);
        addSeparator();
        add(gameStart);
        add(gamePause);
        add(gameEnd);
        addSeparator();
        add(gameClose);
        updateQuestions.setEnabled(false);
        setEnabled(false);
    }

    public void setEnabled(boolean bool) {
        gameStart.setEnabled(!bool);
        gamePause.setEnabled(bool);
        gameEnd.setEnabled(bool);
    }

    public void setAllMenuItemListener(ActionListener actionListener) {
        updateQuestions.addActionListener(actionListener);
        gameStart.addActionListener(actionListener);
        gamePause.addActionListener(actionListener);
        gameEnd.addActionListener(actionListener);
        gameClose.addActionListener(actionListener);
    }

    public GameOptions getMenuItemOption(Object menuItem) {
        if (menuItem == updateQuestions) {
            return GameOptions.UPDATE_QUESTIONS;
        } else if (menuItem == gameStart) {
            return GameOptions.GAME_START;
        } else if (menuItem == gamePause) {
            return GameOptions.GAME_PAUSE;
        } else if (menuItem == gameEnd) {
            return GameOptions.GAME_END;
        } else if (menuItem == gameClose) {
            return GameOptions.GAME_CLOSE;
        }
        return null;
    }
}
