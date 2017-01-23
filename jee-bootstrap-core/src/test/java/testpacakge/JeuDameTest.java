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
    	assertThat(game.getCell(0, 0)).isEqualTo(ColorChip.BLACK);
    }
}
