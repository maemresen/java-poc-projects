package com.maemresen.hobbyprojcts;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GuiCalculator {

	private JFrame frmS;
	private JTextField textFieldNum1;
	private JTextField textFieldNum2;
	private JTextField textFieldRes;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiCalculator window = new GuiCalculator();
					window.frmS.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public GuiCalculator() {
		initialize();
	}

	private void initialize() {
		frmS = new JFrame();
		frmS.setTitle("Calculator");
		frmS.getContentPane().setBackground(new Color(0, 255, 255));
		frmS.getContentPane().setFont(new Font("Dialog", Font.BOLD, 18));
		frmS.setBounds(100, 100, 249, 237);
		frmS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textFieldNum1 = new JTextField();
		textFieldNum1.setBounds(10, 44, 99, 20);
		textFieldNum1.setColumns(10);
		
		textFieldNum2 = new JTextField();
		textFieldNum2.setBounds(119, 44, 99, 20);
		textFieldNum2.setColumns(10);
		
		JLabel lblFirstNumber = new JLabel("First Number");
		lblFirstNumber.setBounds(10, 17, 132, 21);
		lblFirstNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		
		JLabel lblSecondNumber = new JLabel("Second Number");
		lblSecondNumber.setBounds(119, 17, 105, 21);
		lblSecondNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		
		JButton btnAdd = new JButton("+");
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(Color.RED);
		btnAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				double n1,n2,res;
				try{
					n1 = Double.parseDouble(textFieldNum1.getText());
					n2 = Double.parseDouble(textFieldNum2.getText());
					res=n1+n2;
					textFieldRes.setText(Double.toString(res));
				}catch(Exception a){
					JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");
					
				}
			}
		});
		btnAdd.setBounds(10, 82, 43, 33);
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JButton btnSub = new JButton("-");
		btnSub.setForeground(Color.BLACK);
		btnSub.setBackground(Color.ORANGE);
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double n1,n2,res;
				try{
					n1 = Double.parseDouble(textFieldNum1.getText());
					n2 = Double.parseDouble(textFieldNum2.getText());
					res=n1-n2;
					textFieldRes.setText(Double.toString(res));
				}catch(Exception a){
					JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");
					
				}
			}
		});
		btnSub.setBounds(63, 82, 43, 33);
		btnSub.setFont(new Font("Dialog", Font.BOLD, 18));
		
		JButton btnMulti = new JButton("x");
		btnMulti.setForeground(Color.BLACK);
		btnMulti.setBackground(Color.GREEN);
		btnMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double n1,n2,res;
				try{
					n1 = Double.parseDouble(textFieldNum1.getText());
					n2 = Double.parseDouble(textFieldNum2.getText());
					res=n1*n2;
					textFieldRes.setText(Double.toString(res));
				}catch(Exception a){
					JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");
					
				}
			}
		});
		btnMulti.setBounds(122, 82, 43, 33);
		btnMulti.setFont(new Font("Dialog", Font.BOLD, 17));
		
		JButton btnDiv = new JButton("/");
		btnDiv.setBackground(new Color(255, 0, 255));
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double n1,n2,res;
				try{
					n1 = Double.parseDouble(textFieldNum1.getText());
					n2 = Double.parseDouble(textFieldNum2.getText());
					res=n1/n2;
					textFieldRes.setText(Double.toString(res));
				}catch(Exception a){
					JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");
					
				}
			}
		});
		btnDiv.setBounds(175, 82, 43, 33);
		btnDiv.setFont(new Font("Dialog", Font.BOLD, 18));
		frmS.getContentPane().setLayout(null);
		frmS.getContentPane().add(btnAdd);
		frmS.getContentPane().add(btnSub);
		frmS.getContentPane().add(btnMulti);
		frmS.getContentPane().add(btnDiv);
		frmS.getContentPane().add(textFieldNum1);
		frmS.getContentPane().add(textFieldNum2);
		frmS.getContentPane().add(lblFirstNumber);
		frmS.getContentPane().add(lblSecondNumber);
		
		JLabel lblResult = new JLabel("Result =");
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblResult.setBounds(10, 130, 69, 55);
		frmS.getContentPane().add(lblResult);
		
		textFieldRes = new JTextField();
		textFieldRes.setBounds(80, 149, 138, 20);
		frmS.getContentPane().add(textFieldRes);
		textFieldRes.setColumns(10);
	}

}