package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        
        /* INSERT YOUR CODE HERE */
		System.out.print("\n" + "  ");


       for(int i = 0; i < model.getWidth(); i++){

		   System.out.print(i);

	   }

	   System.out.print("\n\n");

	   for(int i = 0; i < model.getWidth(); i++){

			System.out.print(i + " ");

			for(int j = 0; j < model.getWidth(); j++){

				System.out.print(model.getMark(i, j));

				if(j == (model.getWidth()-1) ){

						System.out.print("\n");

				}

			}

		}

		System.out.println("\n");

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

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}