import java.util.HashMap;
import java.util.Map;

public class Game {
    protected Map<String, Player> players = new HashMap<>();


    public void register(Player player) {
        if (players.containsKey(player.getName())) {
            throw new AlreadyRegisteredException("Игрок с ником: " + player.getName() + " уже зарешистрирован!");
        }
        players.put(player.getName(), player);
    }

    public Player findByName(String name) {
        return players.get(name);
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