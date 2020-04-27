import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.lang.*;

public class CountdownTimer {
    JTextField tf,tf2;
    JLabel l1,l2;
    JFrame fr;
    JButton b;
    String n;
    int t;
    public void run()
    {
        buildGUI();
    }
    public void buildGUI()
    {
        fr = new JFrame("Countdown Timer");
        JPanel p = new JPanel();
        l2 = new JLabel("Please Enter the Time:");
        l1 = new JLabel("");
        tf2 = new JTextField(8);
        tf = new JTextField(15);
        tf.setVisible(false);
        tf2.setEnabled(true);
        tf2.setBackground(Color.white);
        p.setBackground(Color.white);
        JButton b=new JButton("Submit");
        b.setEnabled(true);
        b.setVisible(true);
        fr.add(p);
        p.add(l2);
        p.add(tf2);
        p.add(b);
        p.add(l1);
        p.add(tf);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300,100);
        fr.setResizable(false);
        fr.setSize(300,100);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                tf.setEnabled(false);
                b.setVisible(false);
                tf2.setVisible(false);
                l2.setVisible(false);
                tf.setVisible(true);
                Font f = new Font("Verdana", 0, 18);
                tf.setFont(f);
                tf.setBackground(Color.white);
                tf.setVisible(true);
                n = tf2.getText();
                t = Integer.parseInt(n);
                fr.setSize(300,100);
                Thread countThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i = t;i >= 0; i--)
                        {
                            try
                            {
                                String s = Integer.toString(i);
                                tf.setText("        "+ s + " Seconds to go...");
                                Thread.sleep(1000);
                            }
                            catch(Exception e1)
                            {
                                System.out.println(e);
                            }
                        }
                        p.setVisible(false);
                        fr.setVisible(false);
                        JOptionPane.showMessageDialog(fr,"Times up!!!");
                    }
                });
                countThread.start();
            }
        });
    }

    public static void main(String args[])
    {
        CountdownTimer obj = new CountdownTimer();
        obj.buildGUI();
    }
}
