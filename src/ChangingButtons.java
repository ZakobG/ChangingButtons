import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ChangingButtons implements ActionListener {
    JFrame f = new JFrame("Changing buttons");
    JButton bttn;

    HashMap<Integer, JButton> buttons = new HashMap<Integer, JButton>();

    void init() {
        f.setSize(300, 300);
        f.setLayout(new GridLayout(3, 3));
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void fillMap() {
        for (int i = 0; i < 9; i++) {
            buttons.put(i + 1, bttn = new JButton("" + (i + 1)));
        }
    }

    void setObjects() {
        for (JButton btn : buttons.values()) {
            f.add(btn);
            btn.addActionListener(this);
            f.setVisible(true);
        }
    }


    public void actionPerformed(ActionEvent e) {
        int x = (int) (Math.random() * 9);

        switch (x) {
            case 0 -> bttn.setBackground(Color.black);
            case 1 -> bttn.setBackground(Color.blue);
            case 2 -> bttn.setBackground(Color.cyan);
            case 3 -> bttn.setBackground(Color.gray);
            case 4 -> bttn.setBackground(Color.green);
            case 5 -> bttn.setBackground(Color.magenta);
            case 6 -> bttn.setBackground(Color.orange);
            case 7 -> bttn.setBackground(Color.pink);
            case 8 -> bttn.setBackground(Color.red);
        }

        if (e.getSource() == buttons.get(1) && x == 0 || x == 1 || x == 2 || x == 3 || x == 4 || x == 5 || x == 6 || x == 7 || x == 8) {
            System.out.println(x);
        }
    }
}
