import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    Game game = new Game();

    Player player1 = new Player(1, "Nick", 200);
    Player player2 = new Player(2, "Doozy", 250);

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
    }

    @Test
    public void test() {

    }
}
