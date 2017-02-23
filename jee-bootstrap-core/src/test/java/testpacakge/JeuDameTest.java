package testpacakge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import org.junit.Before;
import org.junit.Test;

import jeudame.ColorChip;
import jeudame.Direction;
import jeudame.JeuDameGame;
import jeudame.JeuDameImpl;
import jeudame.Pion;

public class JeuDameTest {

	private JeuDameGame game;

    @Before
    public void doBefore() throws Exception{
        game = new JeuDameImpl();
    }
    
    @Test 
    public void getRightCase() throws Exception{
    	
    	// On test si la première rangé est bien placé un blanc puis rien puis un blanc ect 
    	assertThat(game.getCell(0, 0)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(0, 1)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(0, 2)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(0, 3)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(0, 4)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(0, 5)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(0, 6)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(0, 7)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(0, 8)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(0, 9)).isEqualTo(ColorChip.BLACK);
    	
    	// On test si la deuxième rangé est bien placé un rien puis blanc puis un rien ect 
    	assertThat(game.getCell(1, 0)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(1, 1)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(1, 2)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(1, 3)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(1, 4)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(1, 5)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(1, 6)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(1, 7)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(1, 8)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(1, 9)).isEqualTo(ColorChip.WHITE);


    }
    
    
	@Test
    public void testPlay() throws Exception{   	
    	game.play(0, 0, "AvRIGHT");
		assertThat(game.getCell(1,1)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(0,0)).isNull();
    	
    	game.play(8, 8, "AvRIGHT");
    	assertThat(game.getCell(7,7)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(8,8)).isNull();
    	
    	game.play(1, 1, "AvLEFT");
		assertThat(game.getCell(0,2)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(1,1)).isNull();
    	
    	game.play(7, 7, "AvLEFT");
		assertThat(game.getCell(8,6)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(7, 7)).isNull();
    	
    	game.play(0, 2, "ArRIGHT");
		assertThat(game.getCell(1,1)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(0,2)).isNull();
    	
    	game.play(8, 6, "ArRIGHT");
		assertThat(game.getCell(7,7)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(8,6)).isNull();
    	
    	game.play(1, 1, "ArLEFT");
		assertThat(game.getCell(0,0)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(1, 1)).isNull();
    	
    	game.play(7, 7, "ArLEFT");
    	assertThat(game.getCell(8,8)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(7, 7)).isNull();
	
	}
	@Test
	public void itCantplayOutsideBoard() throws Exception{
		try{
			game.play(0, 0, "ArRIGHT");
			fail("Impossible to play out the board");
		}catch(Exception e)
		{}
		
	}
	@Test
	public void testCheepHasBeenEat() throws Exception{
		game.play(1, 3, "AvRIGHT");
		game.play(4, 6, "AvRIGHT");
		game.play(2, 4, "AvRIGHT");
//		assertThat(game.getCell(3,5)).isEqualTo(ColorChip.NONE); //Le pion noir à été mangé
//		assertThat(game.getCell(4,6)).isEqualTo(ColorChip.WHITE);
	}
	
}
