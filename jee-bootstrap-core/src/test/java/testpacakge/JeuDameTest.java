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
    	
    	// On test si la premi�re rang� est bien plac� un blanc puis rien puis un blanc ect 
    	assertThat(game.getCell(0, 0)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(0, 1)).isEqualTo(ColorChip.NONE);
    	assertThat(game.getCell(0, 2)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(0, 3)).isEqualTo(ColorChip.NONE);
    	assertThat(game.getCell(0, 4)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(0, 5)).isEqualTo(ColorChip.NONE);
    	assertThat(game.getCell(0, 6)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(0, 7)).isEqualTo(ColorChip.NONE);
    	assertThat(game.getCell(0, 8)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(0, 9)).isEqualTo(ColorChip.NONE);
    	
    	// On test si la deuxi�me rang� est bien plac� un rien puis blanc puis un rien ect 
    	assertThat(game.getCell(1, 0)).isEqualTo(ColorChip.NONE);
    	assertThat(game.getCell(1, 1)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(1, 2)).isEqualTo(ColorChip.NONE);
    	assertThat(game.getCell(1, 3)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(1, 4)).isEqualTo(ColorChip.NONE);
    	assertThat(game.getCell(1, 5)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(1, 6)).isEqualTo(ColorChip.NONE);
    	assertThat(game.getCell(1, 7)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(1, 8)).isEqualTo(ColorChip.NONE);
    	assertThat(game.getCell(1, 9)).isEqualTo(ColorChip.WHITE);
    	
    	// ON test si tous les pions noir sont bien plac� dans la rang� du haut  
    	assertThat(game.getCell(9, 0)).isEqualTo(ColorChip.NONE);
    	assertThat(game.getCell(9, 1)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(9, 2)).isEqualTo(ColorChip.NONE);
    	assertThat(game.getCell(9, 3)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(9, 4)).isEqualTo(ColorChip.NONE);
    	assertThat(game.getCell(9, 5)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(9, 6)).isEqualTo(ColorChip.NONE);
    	assertThat(game.getCell(9, 7)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(9, 8)).isEqualTo(ColorChip.NONE);
    	assertThat(game.getCell(9, 9)).isEqualTo(ColorChip.BLACK);
    	
    	// On test la deuxi�me rang� en partant du haut 
    	assertThat(game.getCell(8, 0)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(8, 1)).isEqualTo(ColorChip.NONE);
    	assertThat(game.getCell(8, 2)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(8, 3)).isEqualTo(ColorChip.NONE);
    	assertThat(game.getCell(8, 4)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(8, 5)).isEqualTo(ColorChip.NONE);
    	assertThat(game.getCell(8, 6)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(8, 7)).isEqualTo(ColorChip.NONE);
    	assertThat(game.getCell(8, 8)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(8, 9)).isEqualTo(ColorChip.NONE);



    	

    }
    
    
	@Test
    public void testPlay() throws Exception{   	
    	game.play(0, 0, "AvRIGHT");
    	assertStart(game.getCell(1,1)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(0,0)).isNull();
    	
    	game.play(8, 8, "AvRIGHT");
    	assertStart(game.getCell(7,7)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(8,8)).isNull();
    	
    	game.play(1, 1, "AvLEFT");
    	assertStart(game.getCell(0,2)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(1,1)).isNull();
    	
    	game.play(7, 7, "AvLEFT");
    	assertStart(game.getCell(8,6)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(7, 7)).isNull();
    	
    	game.play(0, 2, "ArRIGHT");
    	assertStart(game.getCell(1,1)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(0,2)).isNull();
    	
    	game.play(8, 6, "ArRIGHT");
    	assertStart(game.getCell(7,7)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(8,6)).isNull();
    	
    	game.play(1, 1, "ArLEFT");
    	assertStart(game.getCell(0,0)).isEqualTo(ColorChip.WHITE);
    	assertThat(game.getCell(1, 1)).isNull();
    	
    	game.play(7, 7, "ArLEFT");
    	assertStart(game.getCell(8,8)).isEqualTo(ColorChip.BLACK);
    	assertThat(game.getCell(7, 7)).isNull();
	
	}
}
