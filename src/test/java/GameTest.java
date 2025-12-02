import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GameTest {
    Game game = new Game();

    Player player1 = new Player(1, "Nick", 100);
    Player player2 = new Player(2, "Doozy", 0);
    Player player3 = new Player(3, "Loo", 100);

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
    }

    @Test
    public void shouldFindByName() {
        Player expected = player2;
        Player actual = game.findByName("Doozy");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByName() {
        Player expected = null;
        Player actual = game.findByName("Aa");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundFirstPlayerWin() {
        int expected = 2;
        int actual = game.round("Nick", "Doozy");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundSecondPlayerWin() {
        int expected = 1;
        int actual = game.round("Doozy", "Nick");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundDraw() {
        game.register(player3);

        int expected = 0;
        int actual = game.round("Nick", "Loo");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTrowNotRegisteredExceptionForFirstPlayer() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("aa", "Doozy");
        });
    }

    @Test
    public void shouldTrowNotRegisteredExceptionForSecondPlayer() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Nick", "Dooz");
        });
    }

    @Test
    public void shouldTrowNotRegisteredExceptionForAllPlayers() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("aa", "oozy");
        });
    }

    @Test
    public void shouldThrowAlreadyException() {

        Assertions.assertThrows(AlreadyRegisteredException.class, () -> {
            game.register(player1);
        });
    }
}
