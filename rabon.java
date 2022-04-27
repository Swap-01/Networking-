import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ravan implements ActionListener {
    JFrame jf;
    JTextField t3;
    JButton b1, b2;
    int a, b, c;

    ravan() {
        jf = new JFrame();
        t3 = new JTextField(25);
        b1 = new JButton("YES");
        b2 = new JButton("NO");

        jf.setSize(300, 300);
        jf.setVisible(true);
        jf.setLayout(null);

        jf.add(b2);
        jf.add(b1);
        jf.add(t3);

        b1.setBounds(10, 40, 100, 30);
        b2.setBounds(10, 90, 100, 30);
        t3.setBounds(30, 180,180, 40);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("YES"))
            t3.setText("You pressed OK");
        else if (e.getActionCommand().equals("NO"))
            t3.setText("You pressed NOT OK");
    }
}

class rabon {
    public static void main(String args[]) {
        ravan ob = new ravan();
    }
}