package jeudame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class JeuDameImpl implements JeuDameGame {
	
	public static final int BOARD_SIZE = 10;
    public static final int NUMBER_OF_PIONS_PER_PLAYER= 20;
    public static final String OUTSIDE_OF_BOARD_ERROR = "It is not possible to play outside of the board";
    public static final String NO_CHIP_ON_CELL_ERROR = "There is no chip on the board"; 
    public static final String NOT_PLAYERS_CHIP_ERROR = "That is not your chip";
    public static final String NO_PLAYER_ERROR = "No player has been found";
    public static final String NO_PLAYER_WIN_ERROR = "No winner";
    ColorChip player = ColorChip.WHITE;
    List<List<ColorChip>> board = new ArrayList<>(BOARD_SIZE);

	
	public  JeuDameImpl() {
		// TODO Auto-generated constructor stub
		initBoard();
	}
	
	public void initBoard(){
		for (int i = 0; i < BOARD_SIZE; i++) {
            board.add(new ArrayList<ColorChip>(BOARD_SIZE));
            for (int j = 0; j < BOARD_SIZE; j++){
            	if(i % 2 == j % 2 && i<4)board.get(i).add(ColorChip.WHITE);
            	else if(i % 2 == j % 2 && i>5)board.get(i).add(ColorChip.BLACK);
            	else board.get(i).add(ColorChip.NONE);
            } 
        }
	}
	
	@Override
	public void play(Pion pion,Direction direction) throws GameException {
		if(getCell(pion.getX(),pion.getY()) == ColorChip.NONE) throw new GameException(NO_CHIP_ON_CELL_ERROR) ;
		if(getCell(pion.getX(),pion.getY()) != player) throw new GameException(NOT_PLAYERS_CHIP_ERROR) ;
		
		Direction dir = direction;
		int newAbs = newAbs(pion.getX(), dir);
		int newOrd = newOrd(pion.getY(), dir);
		
		if (newAbs > BOARD_SIZE - 1 || newAbs < 0){
			throw new GameException(OUTSIDE_OF_BOARD_ERROR);
		}
		if (newOrd> BOARD_SIZE - 1 || newOrd < 0){
			throw new GameException(OUTSIDE_OF_BOARD_ERROR);
		}
		
		//Test
		if(newAbs != pion.getX() && newOrd != pion.getY()){
			if(getCell(newAbs,newOrd)== ColorChip.NONE){
				if (dir == Direction.AvRIGHT || dir == Direction.AvLEFT){
					board.get(pion.getX()).set(pion.getY(), ColorChip.NONE);
					board.get(newOrd).set(newOrd, player);
					player = nextPlayer(player);
					System.out.println("Player " + player + " that's your turn");
				}else{
					System.out.println("Player : " + player.toString() +", you can't move backward");
				}
			}
			else if(getCell(newAbs,newOrd)== player){
				System.out.println("Player : " + player.toString() +", one of your chips blocks your move" );
			}
			else
			{
				eatChip(pion,dir);
			}
		}
		
		//après modifications des listes
		List<ColorChip> absList = board.get(pion.getX());
		List<ColorChip> newAbsList = board.get(newAbs);
		if (absList.size() >= BOARD_SIZE || newAbsList.size() >= BOARD_SIZE ) {
            throw new GameException(OUTSIDE_OF_BOARD_ERROR);
        }
		
		
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
	public int newAbs(int abs, Direction direction) {
		int newAbs=0;
		switch (direction) {
		case AvRIGHT:
			newAbs = abs + 1;
			break;
		case AvLEFT:
			newAbs = abs + 1;
			break;
		case ArRIGHT:
			newAbs = abs - 1;
			break;
		case ArLEFT:
			newAbs = abs - 1;
			break;

		default:
			System.out.println(direction + " doesn't work. Try : AvRIGHT, AvLEFT, ArRIGHT or ArLEFT");
			newAbs = abs;
		}
		return newAbs;
	}
	@Override
	public int newOrd(int ord, Direction direction) {
		int newOrd = 0;
		switch (direction) {
		case AvRIGHT:
			newOrd = ord + 1;
			break;
		case AvLEFT:
			newOrd = ord - 1;
			break;
		case ArRIGHT:
			newOrd = ord + 1;
			break;
		case ArLEFT:
			newOrd = ord - 1;
			break;

		default:
			System.out.println(direction + "  doesn't work. Try : AvRIGHT, AvLEFT, ArRIGHT or ArLEFT");
			newOrd = ord;
		}
		return newOrd;
	}
	@Override
	public ColorChip nextPlayer(ColorChip player) throws GameException{
		switch (player) {
		case WHITE:
			player = ColorChip.BLACK;
			break;
		case BLACK:
			player = ColorChip.WHITE;
			break;
		default:
			throw new GameException(NO_PLAYER_ERROR);
		}
		return player;
	}
	
	@Override
	public void eatChip(Pion pion, Direction direction) throws GameException {
		
		int ordEatenChip = newOrd(pion.getY(),direction);
		int absEatenCHip = newAbs(pion.getX(),direction);
		int newOrd = 2*ordEatenChip;
		int newAbs = 2*absEatenCHip;
		
		Scanner scanner = new Scanner(System.in);
		String command;
		
		ColorChip ChipNewPosition = getCell(newOrd,newAbs);
		
		if( ChipNewPosition != pion.getColor() || ChipNewPosition != ColorChip.NONE){
			System.out.println("ERRORRRRRRRRRRRRRRRR You can't eat this chip, play again !");
		}else{
			board.get(pion.getX()).set(pion.getY(), ColorChip.NONE);
			board.get(absEatenCHip).set(ordEatenChip, ColorChip.NONE);
			board.get(newAbs).set(newOrd, player);
			System.out.println(player + " : you eat a chip");
			
			if(eatMoreThanOnce(newAbs,newOrd, player) == true ){
				System.out.println("Player " + player + " you can eat again, Try : AvRIGHT, AvLEFT, ArRIGHT or ArLEFT : ");
				command = scanner.nextLine();
				scanner.close();
				Direction dir = Direction.valueOf(command);
				play(pion,dir);
			}else{
				player = nextPlayer(player);
				System.out.println(player + " that's your turn");
			}
		}
	}
	@Override
	public boolean eatMoreThanOnce(int abs, int ord, ColorChip color) {
		
		
		ColorChip ChipAvD = getCell(newAbs(abs,Direction.AvRIGHT), newOrd(ord,Direction.AvRIGHT));
		ColorChip ChipArD = getCell(newAbs(abs,Direction.ArRIGHT), newOrd(ord,Direction.ArRIGHT));
		ColorChip ChipAvG = getCell(newAbs(abs,Direction.AvLEFT), newOrd(ord,Direction.AvLEFT));
		ColorChip ChipArG = getCell(newAbs(abs,Direction.ArLEFT), newOrd(ord,Direction.ArLEFT));
		
		if( ChipAvD != ColorChip.NONE && ChipAvD != color){
			if(getCell(2*newAbs(abs,Direction.AvRIGHT),2*newOrd(ord,Direction.AvRIGHT)) == ColorChip.NONE){
				return true;
			}
		}
		if( ChipAvG != ColorChip.NONE && ChipAvG != color){
			if(getCell(2*newAbs(abs,Direction.AvLEFT),2*newOrd(ord,Direction.AvLEFT)) == ColorChip.NONE){
				return true;
			}
		}
		if( ChipArD != ColorChip.NONE && ChipArD != color){
			if(getCell(2*newAbs(abs,Direction.ArRIGHT),2*newOrd(ord,Direction.ArRIGHT)) == ColorChip.NONE){
				return true;
			}
		}
		if( ChipArG != ColorChip.NONE && ChipArG != color){
			if(getCell(2*newAbs(abs,Direction.ArLEFT),2*newOrd(ord,Direction.ArLEFT)) == ColorChip.NONE){
				return true;
			}
		}
		
		return false;
	}
	@Override
	public ColorChip getWinner() {
		int nbWhiteChip = 0;
		int nbBlackChip = 0;
		
		for (int i = 0; i< BOARD_SIZE; i++){
			for (int j = 0; j< BOARD_SIZE; j++){
				if (board.get(i).get(j) == ColorChip.WHITE){
					nbWhiteChip++;
				}
				if (board.get(i).get(j) == ColorChip.BLACK){
					nbBlackChip++;
				}
			}
		}
		
		if (nbWhiteChip == 0 && nbBlackChip != 0){
			return ColorChip.BLACK;
		} else if ( nbBlackChip == 0 && nbWhiteChip != 0){
			return ColorChip.WHITE;
		} else if (nbWhiteChip == 0 && nbBlackChip == 0) {
			throw new GameException(NO_PLAYER_WIN_ERROR);
		} else {
			return null;
		}
	}

	@Override
	public void showBoardState() {
		for (int i = 9; i >= 0; i--){
			for (int j = 0; j< BOARD_SIZE; j++){
				System.out.print(board.get(i).get(j) + " ");
			}
		}
	}
}
