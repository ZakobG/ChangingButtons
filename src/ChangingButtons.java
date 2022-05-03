import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class ChangingButtons {
    JFrame f = new JFrame("Changing buttons");
    int last = 0;

    HashMap<Integer, JButton> buttons = new HashMap<Integer, JButton>();
    Color[] colors = {Color.black, Color.cyan, Color.green, Color.white, Color.magenta};

    void init() {
        f.setSize(500, 500);
        f.setLayout(new GridLayout(3, 3));
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void fillMap() {
        for (int i = 0; i < 9; i++) {
            buttons.put(i + 1, new JButton("" + (i + 1)));
        }
    }

    void setObjects() {
        for (JButton btn : buttons.values()) {
            f.add(btn);
            btn.addActionListener(this::actionPerformer);
            f.setVisible(true);
        }
    }

    void actionPerformer(ActionEvent e) {
        scramble(keys(buttons, (JButton) e.getSource()));
    }

    void scramble(Integer n) {
        int x = (int) (Math.random() * colors.length);

        if (n != last) {
            buttons.get(n).setBackground(Color.red);
            for (int i = 1; i <= buttons.size(); i++) {
                if (i != n) {
                    buttons.get(i).setBackground(colors[x]);
                }
            }
        }
    }

    public <K, V> K keys(Map<K, V> map, V value) {
        return map
                .entrySet()
                .stream()
                .filter(entry -> value.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst().get();
    }
}
