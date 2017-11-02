
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;

public class SubjectsMenu extends JMenu {

    private JRadioButtonMenuItem Chinese, English, Math;
    private ButtonGroup subjectsGroup;

    public SubjectsMenu(String name) {
        super(name);
        subjectsGroup = new ButtonGroup();
        Chinese = new JRadioButtonMenuItem("國語     Alt+C");
        Chinese.setMnemonic('c');
        English = new JRadioButtonMenuItem("英文     Alt+E");
        English.setMnemonic('e');
        Math = new JRadioButtonMenuItem("數學     Alt+M");
        Math.setMnemonic('m');
        subjectsGroup.add(Chinese);
        subjectsGroup.add(English);
        subjectsGroup.add(Math);
        add(Chinese);
        add(English);
        add(Math);
    }

    public boolean getAnyRatioButtonIsSelected() {
        return Chinese.isSelected() || English.isSelected() || Math.isSelected();
    }

    public void setEnabled(boolean bool) {
        English.setEnabled(bool);
        Chinese.setEnabled(bool);
        Math.setEnabled(bool);
    }

    public SubjectOptions getMenuItemOption() {
        if (Chinese.isSelected()) {
            return SubjectOptions.CHINESE;
        } else if (English.isSelected()) {
            return SubjectOptions.ENGLISH;
        } else {
            return SubjectOptions.MATH;
        }
    }

    public void setAllMenuItemListener(ActionListener actionListener) {
        Chinese.addActionListener(actionListener);
        English.addActionListener(actionListener);
        Math.addActionListener(actionListener);
    }
}
