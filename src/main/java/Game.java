import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        for (Player existingPlayer : players) {
            if (existingPlayer.equals(player)) {
                throw new AlreadyRegisteredException(
                        "Пользователь с именем: " + player.getName() + " уже зарегистрирован!"
                );
            }
        }
        players.add(player);
    }


    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);


        if (player1 == null) {
            throw new NotRegisteredException("Игрок с ником: " + playerName1 + " не зарегистрирован!");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Игрок с ником: " + playerName2 + " не зарегистрирован!");
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 2;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 1;
        } else {
            return 0;
        }
    }
}