import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
//        for (Player existingPlayer : players) {
//            if (existingPlayer.equals(player)) {
//                throw new AlreadyRegisteredException(
//                        "Пользователь с именем: " + player.getName() + " уже зарегистрирован!"
//                );
//            }
//        }
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int round(String playerName1, String playerName2) {

        if (!players.contains(playerName1)) {
            throw new NotRegisteredException("Один из игроков не зарегистрирован!");
        }
        if (!players.contains(playerName2)) {
            throw new NotRegisteredException("Jllll")
        }

        Player player1 = null;
        Player player2 = null;


        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        return player1.compareTo(player2);
    }
}


//        Выигрывает тот игрок, у которого больше strength (сила), если сила одинаковая,
////// то будет ничья. Метод должен возвращать одно число — 0 в случае ничьи,
////// 1 в случае победы первого игрока и 2 в случае победы второго игрока.


//Сам же турнир описывается классом Game с методами:
////
////register (Player player) — метод регистрации игрока, если игрок не зарегистрирован,
//// то он не сможет играть в турнире.
//// Вам нужно хранить всех зарегистрированных игроков в поле класса Game в виде списка.
////round (String playerName1, String playerName2) — метод соревнования между двумя игроками.
//// Если хотя бы один из игроков не зарегистрирован, должно выкинуться исключение NotRegisteredException —
//// сами создайте его класс. Обратите внимание, что игроки передаются методу через имя —
//// полную информацию об игроке нужно будет найти в коллекции зарегистрированных игроков
//// (см. аналог в виде findById из прошлых домашних заданий).
//// Выигрывает тот игрок, у которого больше strength (сила), если сила одинаковая,
//// то будет ничья. Метод должен возвращать одно число — 0 в случае ничьи,
//// 1 в случае победы первого игрока и 2 в случае победы второго игрока.

