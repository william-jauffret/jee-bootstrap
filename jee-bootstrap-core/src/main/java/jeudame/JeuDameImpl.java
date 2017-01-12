package jeudame;

import java.util.ArrayList;
import java.util.List;




public class JeuDameImpl implements JeuDameGame {
	public static final int COLUMNS_NUMBER = 10;
    public static final int ROWS_NUMBER = 10;
    public static final int numberOfPionsPerPLayer = 20;
    public static final String OUTSIDE_OF_BOARD_ERROR = "It is not possible to play outside of the board";
    
    List<List<ColorChip>> board = new ArrayList<>(COLUMNS_NUMBER);
    List<Pion> whitePlayerPions = new ArrayList<>(numberOfPionsPerPLayer);
    List<Pion> blackPlayerPions = new ArrayList<>(numberOfPionsPerPLayer);

	
	public  JeuDameImpl() {
		// TODO Auto-generated constructor stub
		initBoard();
	}
	
	private void initBoard() {

        for (int i = 0; i < COLUMNS_NUMBER; i++) {
            board.add(new ArrayList<ColorChip>(ROWS_NUMBER));
        }
    }
	
	@Override
	public void play(Pion pion,Direction direction) throws GameException {
		// TODO Auto-generated method stub
		// Here we have to define the play function 
		
	}

	@Override
	public ColorChip getCell(int abs, int ord) {
		// TODO Auto-generated method stub
		/*if (abs < 0 || ord >= getAbs()) {
            return null;
        }
        List<ColorChip> column = board.get(abs);
        return ord < column.size() && ord >= 0 ? column.get(ord) : null;*/
		return board.get(abs).get(ord);
		
	}

	@Override
	public int getAbs() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getOrd() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	@Override
	public ColorChip getWinner() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
