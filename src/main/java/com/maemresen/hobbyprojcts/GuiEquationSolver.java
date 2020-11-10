package com.maemresen.hobbyprojcts;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.Color;

public class GuiEquationSolver {

    private JFrame frmSolveEquations;
    private JTextField textFieldsa;
    private JTextField textFieldsb;
    private JPanel SimpleEquations;
    private JPanel QuadraticEquations;
    private JTextField textFieldqa;
    private JLabel lblX_2;
    private JLabel lblX_3;
    private JTextField textFieldqb;
    private JTextField textFieldqc;
    private JLabel lblSecondRoot;
    private JLabel lblqer1;
    private JLabel lblqer2;
    private JLabel lblser;
    private JPanel Calculator;
    private JTextField textFieldNum2;
    private JTextField textFieldNum1;
    private JTextField textFieldRes;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GuiEquationSolver window = new GuiEquationSolver();
                    window.frmSolveEquations.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public GuiEquationSolver() {
        initialize();
    }

    private void initialize() {
        frmSolveEquations = new JFrame();
        frmSolveEquations.setTitle("Solve Equations");
        frmSolveEquations.setBounds(100, 100, 406, 223);
        frmSolveEquations.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 11, 339, 161);

        Calculator = new JPanel();
        tabbedPane.addTab("Calculator", null, Calculator, null);
        Calculator.setLayout(null);

        JLabel label = new JLabel("First Number");
        label.setBounds(13, 5, 92, 21);
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        Calculator.add(label);

        JLabel label_1 = new JLabel("Second Number");
        label_1.setBounds(110, 5, 105, 21);
        label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        Calculator.add(label_1);

        textFieldNum2 = new JTextField();
        textFieldNum2.setBounds(120, 33, 86, 20);
        textFieldNum2.setColumns(10);
        Calculator.add(textFieldNum2);

        textFieldNum1 = new JTextField();
        textFieldNum1.setBounds(10, 33, 86, 20);
        textFieldNum1.setColumns(10);
        Calculator.add(textFieldNum1);

        JButton button = new JButton("+");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double n1, n2, res;
                try {
                    n1 = Double.parseDouble(textFieldNum1.getText());
                    n2 = Double.parseDouble(textFieldNum2.getText());
                    res = n1 + n2;
                    textFieldRes.setText(Double.toString(res));
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");

                }
            }
        });
        button.setBounds(13, 66, 41, 29);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Dialog", Font.BOLD, 15));
        button.setBackground(Color.RED);
        Calculator.add(button);

        JButton button_1 = new JButton("-");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double n1, n2, res;
                try {
                    n1 = Double.parseDouble(textFieldNum1.getText());
                    n2 = Double.parseDouble(textFieldNum2.getText());
                    res = n1 - n2;
                    textFieldRes.setText(Double.toString(res));
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");

                }
            }
        });
        button_1.setBounds(64, 65, 41, 29);
        button_1.setForeground(Color.BLACK);
        button_1.setFont(new Font("Dialog", Font.BOLD, 18));
        button_1.setBackground(Color.ORANGE);
        Calculator.add(button_1);

        JButton button_2 = new JButton("x");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double n1, n2, res;
                try {
                    n1 = Double.parseDouble(textFieldNum1.getText());
                    n2 = Double.parseDouble(textFieldNum2.getText());
                    res = n1 * n2;
                    textFieldRes.setText(Double.toString(res));
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");

                }
            }
        });
        button_2.setBounds(115, 66, 41, 29);
        button_2.setForeground(Color.BLACK);
        button_2.setFont(new Font("Dialog", Font.BOLD, 17));
        button_2.setBackground(Color.GREEN);
        Calculator.add(button_2);

        JButton button_3 = new JButton("/");
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double n1, n2, res;
                try {
                    n1 = Double.parseDouble(textFieldNum1.getText());
                    n2 = Double.parseDouble(textFieldNum2.getText());
                    res = n1 / n2;
                    textFieldRes.setText(Double.toString(res));
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");

                }
            }
        });
        button_3.setBounds(166, 66, 41, 29);
        button_3.setFont(new Font("Dialog", Font.BOLD, 18));
        button_3.setBackground(Color.MAGENTA);
        Calculator.add(button_3);

        textFieldRes = new JTextField();
        textFieldRes.setBounds(110, 107, 86, 20);
        textFieldRes.setColumns(10);
        Calculator.add(textFieldRes);

        JLabel label_2 = new JLabel("Result =");
        label_2.setBounds(32, 106, 64, 19);
        label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        Calculator.add(label_2);

        SimpleEquations = new JPanel();
        tabbedPane.addTab("Simple Equations", null, SimpleEquations, null);
        SimpleEquations.setLayout(null);

        JButton btnSolveSimpleEquation = new JButton("Solve");
        btnSolveSimpleEquation.setBounds(135, 40, 80, 23);
        SimpleEquations.add(btnSolveSimpleEquation);

        JLabel lblX_1 = new JLabel("x+");
        lblX_1.setBounds(106, 8, 36, 21);
        SimpleEquations.add(lblX_1);
        lblX_1.setFont(new Font("Tahoma", Font.BOLD, 15));

        textFieldsa = new JTextField();
        textFieldsa.setBounds(10, 10, 86, 20);
        SimpleEquations.add(textFieldsa);
        textFieldsa.setColumns(10);

        JLabel lblX = new JLabel("x  =");
        lblX.setBounds(10, 39, 36, 21);
        SimpleEquations.add(lblX);
        lblX.setFont(new Font("Tahoma", Font.BOLD, 15));

        textFieldsb = new JTextField();
        textFieldsb.setBounds(131, 10, 86, 20);
        SimpleEquations.add(textFieldsb);
        textFieldsb.setColumns(10);

        lblser = new JLabel("?");
        lblser.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblser.setBounds(46, 39, 36, 21);
        SimpleEquations.add(lblser);
        btnSolveSimpleEquation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    String a = textFieldsa.getText();
                    String b = textFieldsb.getText();

                    double a1 = Double.parseDouble(a);
                    double b1 = Double.parseDouble(b);
                    lblser.setText(Double.toString((-b1) / a1));
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");

                }
            }
        });

        QuadraticEquations = new JPanel();
        tabbedPane.addTab("QuadraticEquations", null, QuadraticEquations, null);
        QuadraticEquations.setLayout(null);

        textFieldqa = new JTextField();
        textFieldqa.setBounds(10, 12, 86, 20);
        QuadraticEquations.add(textFieldqa);
        textFieldqa.setColumns(10);

        lblX_2 = new JLabel("x\u00B2+");
        lblX_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
        lblX_2.setBounds(100, 14, 21, 14);
        QuadraticEquations.add(lblX_2);

        lblX_3 = new JLabel("x+");
        lblX_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
        lblX_3.setBounds(209, 14, 39, 18);
        QuadraticEquations.add(lblX_3);

        textFieldqb = new JTextField();
        textFieldqb.setColumns(10);
        textFieldqb.setBounds(120, 12, 86, 20);
        QuadraticEquations.add(textFieldqb);

        textFieldqc = new JTextField();
        textFieldqc.setColumns(10);
        textFieldqc.setBounds(233, 12, 86, 20);
        QuadraticEquations.add(textFieldqc);

        JLabel lblYourDeltaIs = new JLabel("Your Delta is =");
        lblYourDeltaIs.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
        lblYourDeltaIs.setBounds(10, 43, 111, 14);
        QuadraticEquations.add(lblYourDeltaIs);

        final JLabel lbldelta = new JLabel("\u25B2");
        lbldelta.setBounds(110, 44, 46, 14);
        QuadraticEquations.add(lbldelta);

        JButton btnSolveQuadraticEquation = new JButton("Solve");
        btnSolveQuadraticEquation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    String a = textFieldqa.getText();
                    String b = textFieldqb.getText();
                    String c = textFieldqc.getText();
                    double a1 = Double.parseDouble(a);
                    double b1 = Double.parseDouble(b);
                    double c1 = Double.parseDouble(c);
                    double delta = (b1 * b1) - 4 * (a1 * c1);
                    if (delta < 0) {
                        lbldelta.setText(Double.toString(delta));
                        lblqer1.setText("No Root");
                        lblqer2.setText("No Root");
                        JOptionPane.showMessageDialog(null, "Your delta is smaller than zero so you have no roots");
                    } else {
                        lbldelta.setText(Double.toString(delta));
                        lblqer1.setText(Double.toString(((-b1) + Math.sqrt(delta)) / 2 * a1));
                        lblqer2.setText(Double.toString(((-b1) - Math.sqrt(delta)) / 2 * a1));
                    }
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");

                }
            }
        });
        btnSolveQuadraticEquation.setBounds(200, 93, 80, 23);
        QuadraticEquations.add(btnSolveQuadraticEquation);

        JLabel lblFirstRoot = new JLabel("First Root =");
        lblFirstRoot.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
        lblFirstRoot.setBounds(10, 68, 111, 14);
        QuadraticEquations.add(lblFirstRoot);

        lblSecondRoot = new JLabel("Second Root =");
        lblSecondRoot.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
        lblSecondRoot.setBounds(10, 93, 111, 14);
        QuadraticEquations.add(lblSecondRoot);

        lblqer1 = new JLabel("x1");
        lblqer1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblqer1.setBounds(90, 69, 66, 14);
        QuadraticEquations.add(lblqer1);

        lblqer2 = new JLabel("x2");
        lblqer2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblqer2.setBounds(111, 93, 66, 14);
        QuadraticEquations.add(lblqer2);
        frmSolveEquations.getContentPane().setLayout(null);
        frmSolveEquations.getContentPane().add(tabbedPane);
    }
}
