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
    	//game.play(ColorChip.BLACK, 0, 0);
    	// On test si la première rangé est bien placé un blanc puis rien puis un blanc ect 
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
    	
    	// On test si la deuxième rangé est bien placé un rien puis blanc puis un rien ect 
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
    	
    	// ON test si tous les pions noir sont bien placé dans la rangé du haut  
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
    	
    	// On test la deuxième rangé en partant du haut 
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
    public void play() throws Exception{
    	
    }
}
