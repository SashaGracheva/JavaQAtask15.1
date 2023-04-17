package ru.netology.tournament;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Eddard Stark", 1000);
    Player player2 = new Player(2, "Daenerys Targaryen", 20000);
    Player player3 = new Player(3, "Cersei Lannister", 500);
    Player player4 = new Player(4, "Stannis Baratheon", 700);
    Player player5 = new Player(5, "Oberyn Martell", 500);
    Player player6 = new Player(6, "Jon Snow", 50000);
    Player player7 = new Player(7, "Theon Greyjoy", 100);

    @BeforeEach
    public void addPlayers() throws NotRegisteredException {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player7);
    }

    @Test
    public void comparePlayersWhenFirstIsWeakerThanSecond() throws NotRegisteredException {


        int expected = 2;
        int actual = game.round("Cersei Lannister", "Eddard Stark");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void comparePlayersWhenFirstIsStrongerThanSecond() throws NotRegisteredException {

        int expected = 1;
        int actual = game.round("Stannis Baratheon", "Theon Greyjoy");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void comparePlayersOfEqualStrength() throws NotRegisteredException {

        int expected = 0;
        int actual = game.round("Cersei Lannister", "Oberyn Martell");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void compareStrengthsPlayersIfBothAreUnregistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Catelyn Stark", "Jaime Lannister");
        });
    }

    @Test
    public void compareStrengthPlayersIfFirstIsUnregistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Jaime Lannister", "Cersei Lannister");
        });

    }

    @Test
    public void compareStrengthPlayersIfSecondIsUnregistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Eddard Stark", "Catelyn Stark");
        });

    }

    @Test
    public void compareStrengthsPlayersNamesNotIncluded() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("", "");
        });

    }

    @Test
    public void addPlayerWhoseNameAlreadyUse() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.register(player1);
        });


    }
}


