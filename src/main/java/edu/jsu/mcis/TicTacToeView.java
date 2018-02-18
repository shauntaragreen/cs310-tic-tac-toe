package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TicTacToeView extends JPanel implements ActionListener {
	
	
    /* CONSTRUCTOR */
	TicTacToeModel model;
	
		private JPanel squaresPanel;
		private JButton[][] grid;
		private JButton[][] squares;
		private JPanel panel;
		private JLabel resultLabel;
		private JPanel container;
		
    public TicTacToeView(TicTacToeModel model) {
		
		this.model = model;
		int width = model.getWidth();
		
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.squares = new JButton[model.getWidth()][model.getWidth()];
		this.squaresPanel = new JPanel (new GridLayout(width,width));
		this.resultLabel = new JLabel();
		this.resultLabel.setName("ResultLabel");
		this.container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		grid = new JButton[3][3];
    
		//* loop through every row and col *//
		
		for (int x = 0; x < width; x++) {
			for (int y =0; y < width; y++) {
				this.squares[x][y] = new JButton();
				this.squares[x][y].addActionListener(this);
				this.squares[x][y].setName("Square" + x + y);
				this.squares[x][y].setPreferredSize(new Dimension(64, 64));
				this.squaresPanel.add(squares[x][y]);
				
				
				//* finish initializing JButton; add to JPanel *//
				
			}
		}
		add(squaresPanel);
		add(resultLabel);
		resultLabel.setText("Welcome to the game Tic-Tac-Toe!");

	}
	
	@Override
	public void actionPerformed(ActionEvent event){

		 String name = ((JButton) event.getSource()).getName();


        int row;
        int col;

        row = Character.getNumericValue(name.charAt(6));
        col = Character.getNumericValue(name.charAt(7));

        model.makeMark(row, col);
		 
		updateSquares();
		showResult(" ");
		
		if (model.isGameover()){
				showResult(model.getResult().toString());
				for (int x=0; x<model.getWidth(); x++){
					for (int y=0; y<model.getWidth(); y++){
						squares[x][y].setEnabled(false);
                }
            }
        }
	}
	
	public void updateSquares() {

        for (int x=0; x<model.getWidth(); x++){
            for (int y=0; y<model.getWidth(); y++){
                squares[x][y].setText(model.getMark(x, y).toString());
            }
        }
    }

	
	public static void main(String[] args) {
        JFrame window = new JFrame("Tic-Tac-Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        //WINDOW CLOSES
    }
	
    public void showNextMovePrompt() {
        /* Display a prompt for the player's next move (see examples) */
		
        /* INSERT YOUR CODE HERE */
		if (model.isXTurn()) {
			System.out.println("Player X Turn:\n" + "Enter the row and column number, separated by a space.");
		}
		
			else {
				System.out.println("Player O Turn:\n" + "Enter the roe and column number, separated by a space.");
			}

    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */
        /* INSERT YOUR CODE HERE */
		System.out.println("Invalid Input!");
	
    }
       
        
    public static void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }

}