package jeudame;


public interface JeuDameGame {
	
	/**
	 * Play a chip in a given column.
	 * @param colour
	 * @param column
	 * @throws GameException if it is not allowed to play in that cell.
	 * if direction = 0 => right , 2 => left 
	 */
    void play(Pion pion,Direction direction) throws GameException;

    /**
     * Returns the colour of the chip in a given cell, null if no
     * chip is present.
     * @param column
     * @param row
     * @return
     */
    ColorChip getCell(int abs, int ord);

    /**
     * Returns the number of abscisse.
     * @return
     */
    int getAbs();

    /**
     * Returns the number of Ordonne.
     * @return
     */
    int getOrd();

    
    /**
     * Returns the colour of the winner, null if no winner.
     * @return
     */
    ColorChip getWinner();
}
