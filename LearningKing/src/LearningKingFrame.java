import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JDialog;

public class LearningKingFrame extends JFrame {
    private GameOptions gameOption;
    private SubjectOptions subjectOption;
    private MenuBar menuBar;
    private boolean isStart = false;
    public LearningKingFrame() {
        super("學習知識王");
        
        JDialog.setDefaultLookAndFeelDecorated(true);
        menuBar = new MenuBar();
        setJMenuBar(menuBar);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(getContentPane(), "是否確定關閉程式",
                            "遊戲訊息", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE)) {
                        System.exit(0);
                    }
                }
            }
        });
        menuBar.getGameMenu().setAllMenuItemListener(new GameMenuHandler());
        menuBar.getSubjectsMenu().setAllMenuItemListener(new SubjectsMenuHandler());
        
    }

    private class GameMenuHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            gameOption=menuBar.getGameMenu().getMenuItemOption(event.getSource());
            System.out.println(gameOption.getValue());
            switch (gameOption) {
                case UPDATE_QUESTIONS:
                    break;
                case GAME_START:
                    if (!menuBar.getSubjectsMenu().getAnyRatioButtonIsSelected()) {
                        JOptionPane.showMessageDialog(LearningKingFrame.this, "錯誤操作! ! 請選擇科目後再進行遊戲",
                                "遊戲訊息", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    isStart = !isStart;
                    menuBar.getSubjectsMenu().setEnabled(!isStart);
                    menuBar.getGameMenu().setEnabled(isStart);
                    break;
                case GAME_PAUSE:
                    break;
                    
                case GAME_END:
                    isStart = !isStart;
                    menuBar.getSubjectsMenu().setEnabled(!isStart);
                    menuBar.getGameMenu().setEnabled(isStart);
                    break;
                case GAME_CLOSE:
                    System.exit(0);
                    break;
                default:
                    break;

            }
        }
    }
    private class SubjectsMenuHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            subjectOption=menuBar.getSubjectsMenu().getMenuItemOption();
            System.out.println("Radio: "+subjectOption.getValue());
        }
    }
}
