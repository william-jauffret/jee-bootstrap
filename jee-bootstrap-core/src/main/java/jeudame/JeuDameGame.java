package jeudame;


public interface JeuDameGame {
	
	/**
	 * Play a chip in a given column.
	 * @param colour
	 * @param column
	 * @throws GameException if it is not allowed to play in that cell.
	 */
    void play(ColorChip colour, int abs, int ord) throws GameException;

    /**
     * Returns the colour of the chip in a given cell, null if no
     * chip is present.
     * @param column
     * @param row
     * @return
     */
    ColorChip getCell(int abs, int ord);

    /**
     * Returns the number of columns.
     * @return
     */
    int getAbs();

    /**
     * Returns the number of rows.
     * @return
     */
    int getOrd();

    /**
     * Returns the colour of the winner, null if no winner.
     * @return
     */
    ColorChip getWinner();
}
