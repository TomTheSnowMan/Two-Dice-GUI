//Filename TwoDiceGUI.java
//Tom 3/5/2020

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoDiceGUI extends JFrame implements ActionListener
{
	//instance variables and objects for this class
	JLabel title = new JLabel("Two Dice");
	JLabel firstDieRoll = new JLabel("First Die Roll is: ");
	JLabel secondDieRoll = new JLabel("Second Die Roll is: ");
	JLabel summary = new JLabel("");
	JButton button = new JButton("Play Game");

	Font headlineFont = new Font("Times New Roman", Font.BOLD, 36);
	Font gameFont = new Font("Times New Roman", Font.ITALIC, 18);
	Font displayFont = new Font("Arial", Font.PLAIN, 18);

	//Constructor method for this class
	public TwoDiceGUI()
	{
		super("Java Final");
		setBounds(450, 300, 400, 300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setBackground(Color.GREEN);

		//Layout manager for the GUI
		setLayout(new GridLayout(5, 1));

		//set fonts
		title.setFont(headlineFont);
		firstDieRoll.setFont(gameFont);
		secondDieRoll.setFont(gameFont);
		button.setFont(displayFont);
		summary.setFont(displayFont);


		//Align items horizontally to appear in center of GUI
		title.setHorizontalAlignment(JLabel.CENTER);
		firstDieRoll.setHorizontalAlignment(JLabel.CENTER);
		secondDieRoll.setHorizontalAlignment(JLabel.CENTER);
		button.setHorizontalAlignment(JLabel.CENTER);
		summary.setHorizontalAlignment(JLabel.CENTER);

		add(title);
		add(firstDieRoll);
		add(secondDieRoll);
		add(button);
		add(summary);

		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// objects 
		Die firstDie = new Die();
		Die secondDie = new Die();
		
		// variables and constants
		int value1 = firstDie.getValue();
		int value2 = secondDie.getValue();
		String msg;
		String x;
		String y;

		// calculation phase
		if(value1 == value2)
		{
			msg = "It's a TIE!";
			getContentPane().setBackground(Color.GREEN);
			title.setForeground(Color.BLACK);
			firstDieRoll.setForeground(Color.BLACK);
			secondDieRoll.setForeground(Color.BLACK);
			summary.setForeground(Color.BLACK);
		}
		else
		{
			if(value1 > value2)
			{
				msg = "Player 1 WINS!";
				getContentPane().setBackground(Color.BLUE);
				title.setForeground(Color.WHITE);
				firstDieRoll.setForeground(Color.WHITE);
				secondDieRoll.setForeground(Color.WHITE);
				summary.setForeground(Color.WHITE);
			}
			else
			{
				msg = "Player 2 WINS!";
				getContentPane().setBackground(Color.RED);
				title.setForeground(Color.WHITE);
				firstDieRoll.setForeground(Color.WHITE);
				secondDieRoll.setForeground(Color.WHITE);
				summary.setForeground(Color.WHITE);
			}
		}
		
		x = Integer.toString(value1);
		y = Integer.toString(value2);
		firstDieRoll.setText("First Die roll is: " + x);
		secondDieRoll.setText("Second Die roll is: " + y);
		summary.setText(msg);
	}

	public static void main(String[] args)
	{
		TwoDiceGUI game1 = new TwoDiceGUI();
	}
}