// --== CS400 Spring 2023 File Header Information ==--
// Name: Naman Parekh
// Email: ncparekh@wisc.edu
// Team: DT
// TA: Daniel Finer
// Lecturer: Florian Heimerl (004)
// Notes to Grader: <optional extra notes>

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * Class that implements the testers for the BackendDeveloper class
 * @author Naman Parekh
 *
 */
class BackendDeveloperTests {

    /**
     * Tester that checks if the loadData() method works and if a player list containing all the NBA
     * players from the csv file is correctly made.
     *
     * @throws FileNotFoundException if file is not found
     */
    @Test
    void Test1() throws FileNotFoundException {

        NBAPlayerRedBlackTreeInterface rbt = new NBAPlayerRedBlackTreeInterfaceBD();
        NBAPlayerReaderInterface playerReader = new NBAPlayerReaderInterfaceBD();
        NBATeamBackend backEnd = new NBATeamBackend(rbt, playerReader);

        assertNull(backEnd.playersInfo); // tests if the list containing NBA players is null initially

        backEnd.playersInfo = playerReader.readPlayersFromFile("test.txt");
        assertEquals(3, backEnd.playersInfo.size());
        assertEquals("Lebron James", backEnd.playersInfo.get(0).getName());
        assertEquals(48, backEnd.playersInfo.get(1).getBlocks());

    }

    /**
     * Tester that checks if the findNBAPlayerByName() method works and correctly returns the NBA
     * object prompted for & it's statistics.
     *
     * @throws FileNotFoundException if file is not found
     */
    @Test
    void Test2() throws FileNotFoundException {

        NBAPlayerRedBlackTreeInterface rbt = new NBAPlayerRedBlackTreeInterfaceBD();
        NBAPlayerReaderInterface playerReader = new NBAPlayerReaderInterfaceBD();
        NBATeamBackend backEnd = new NBATeamBackend(rbt, playerReader);

        backEnd.playersInfo = playerReader.readPlayersFromFile("test2.txt");
        backEnd.addPlayer("kyrie irving");
        String expected = "Kyrie Irving";
        NBAPlayerInterface actual = backEnd.findNBAPlayerByName(backEnd.playersInfo.get(2).getName());
        String name = actual.getName();
        assertEquals(expected, name);

        NBAPlayerInterface pointCheck = backEnd.findNBAPlayerByName(backEnd.playersInfo.get(2).getName());
        int points = actual.getPoints();

        assertEquals(22, points);
    }

    /**
     * Tester that checks if the findNBAPlayerByName() method works and correctly returns the NBA
     * object prompted for & it's statistics. Also checks the addPlayer() method works correctly
     * and calls the algorithm engineer's insert() method to add the object in an RBT.
     *
     * @throws FileNotFoundException if file is not found
     */
    @Test
    void Test3() throws FileNotFoundException {

        NBAPlayerRedBlackTreeInterface rbt = new NBAPlayerRedBlackTreeInterfaceBD();
        NBAPlayerReaderInterface playerReader = new NBAPlayerReaderInterfaceBD();
        NBATeamBackend backEnd = new NBATeamBackend(rbt, playerReader);

        backEnd.playersInfo = playerReader.readPlayersFromFile("test3.txt");
        backEnd.addPlayer("Lebron james");
        backEnd.addPlayer("steph curry");

        assertTrue(backEnd.addPlayer("kyrie Irving"));
        assertEquals(3, backEnd.players);

    }

    /**
     * Tester that checks if the removePlayer() method works and correctly calls the Algorithm
     * Engineer's removeByName() method to remove the object from the RBT.
     *
     * @throws FileNotFoundException if file is not found
     */
    @Test
    void Test4() throws FileNotFoundException {

        NBAPlayerRedBlackTreeInterface rbt = new NBAPlayerRedBlackTreeInterfaceBD();
        NBAPlayerReaderInterface playerReader = new NBAPlayerReaderInterfaceBD();
        NBATeamBackend backEnd = new NBATeamBackend(rbt, playerReader);

        backEnd.playersInfo = playerReader.readPlayersFromFile("test4.txt");
        backEnd.addPlayer("Lebron james");
        backEnd.addPlayer("steph curry");
        backEnd.addPlayer("kyrie irving");
        assertEquals(3, backEnd.players);


        assertTrue(backEnd.removePlayer("kyrie irving"));
        assertEquals(2, backEnd.players);

    }

    /**
     * Tester that checks if the getStatistics() method works and correctly returns the output
     * it is supposed to.
     *
     * @throws FileNotFoundException if file is not found
     */
    @Test
    void Test5() throws FileNotFoundException {

        NBAPlayerRedBlackTreeInterface rbt = new NBAPlayerRedBlackTreeInterfaceBD();
        NBAPlayerReaderInterface playerReader = new NBAPlayerReaderInterfaceBD();
        NBATeamBackend backEnd = new NBATeamBackend(rbt, playerReader);

        backEnd.playersInfo = playerReader.readPlayersFromFile("test4.txt");

        backEnd.addPlayer("kyrie irving");

        assertEquals(backEnd.getStatisticsString
                ("kyrie irving"), backEnd.getStatisticsString("kyrie irving") );

    }

    /**
     * Tester that checks if the data wrangler is able to correctly parse objects into a list from
     * the csv file. Additionally, checks if the list properties hold and the objects return their
     * correct value
     *
     * @throws FileNotFoundException if file is not found
     */
    @Test
    void CodeReviewOfDataWranglerTest1() throws FileNotFoundException {

        NBAPlayerReaderDW playerReader = new NBAPlayerReaderDW();

        // loads the CSV file our project is using
        List<NBAPlayerInterface> list = playerReader.readPlayersFromFile("NBAStats2023.csv");

        String player = "Joel Embiid\n    " + " Points: " + 2031 + " Rebounds: " + 622 +
                " Steals: " + 67 + " Assists: " + 256 + " Blocks: " + 103 +
                " Number of Games: " + 61;

        assertTrue(!list.isEmpty());
        assertEquals("LeBron James", list.get(8).getName());
        assertEquals(player, list.get(0).toString());
    }

    /**
     * Tester that checks if the data wrangler's constructor and getter methods work as
     * expected.
     *
     * @throws FileNotFoundException if file is not found
     */
    @Test
    void CodeReviewOfDataWranglerTest2() throws FileNotFoundException {

        NBAPlayerDW player1 = new NBAPlayerDW("Giannis Antetokounmpo", 1834,
                696, 47, 330, 47, 59);
        NBAPlayerDW player2 = new NBAPlayerDW("Jayson Tatum", 2076,
                614, 69, 324, 48, 69);

        assertEquals(696, player1.getRebounds());
        assertEquals(47, player1.getBlocks());
        assertEquals("Jayson Tatum", player2.getName());
        assertTrue(player1.compareTo(player2) < 0);
    }

    /**
     * Integration test that uses the TextUITester class to check if the front-end, back-end
     * and data wrangler's code work together to load a file (fake or the actual file)
     *
     * @throws FileNotFoundException if file is not found
     */
    @Test
    void IntegrationTest1() throws FileNotFoundException {

        NBAPlayerRedBlackTreeInterface rbt = new NBAPlayerRedBlackTree();
        NBAPlayerReaderInterface playerReader = new NBAPlayerReaderDW();
        NBATeamBackend backEnd = new NBATeamBackend(rbt, playerReader);

        try {
            String fileName = "NBAStats2023.csv";
            backEnd.loadData(fileName);
            TextUITester tester1 = new TextUITester("l\nNBAStats2023.csv\nq\n");
            Scanner input = new Scanner(System.in);
            NBATeamFrontend frontEnd = new NBATeamFrontend(input, backEnd);
            frontEnd.runCommandLoop();
            String output = tester1.checkOutput();
            String checker = "Error: Could not find or load file: ";

            assertFalse(output.contains(checker));
            input.close();

        } catch (FileNotFoundException e) {
        }

        try {
            String fileName1 = "fake.csv";
            backEnd.loadData(fileName1);
            TextUITester tester2 = new TextUITester("l\nfake.csv\nq\n");
            Scanner input1 = new Scanner(System.in);
            NBATeamFrontend frontEnd1 = new NBATeamFrontend(input1, backEnd);
            frontEnd1.runCommandLoop();
            String output = tester2.checkOutput();
            String checker = "Error: Could not find or load file: ";

            assertTrue(output.contains(checker));
            input1.close();

        } catch (FileNotFoundException e) {
        }

    }

    /**
     * Integration test that uses the TextUITester class to check if the front-end, back-end
     * and data wrangler's code work together to accurately search for a player's statistics
     *
     * @throws FileNotFoundException if file is not found
     */
    @Test
    void IntegrationTest2() throws FileNotFoundException {

        NBAPlayerRedBlackTreeInterface rbt = new NBAPlayerRedBlackTree();
        NBAPlayerReaderInterface playerReader = new NBAPlayerReaderDW();
        NBATeamBackend backEnd = new NBATeamBackend(rbt, playerReader);

        try {
            String fileName = "NBAStats2023.csv";
            backEnd.loadData(fileName);
            TextUITester tester = new TextUITester
                    ("l\nNBAStats2023.csv\nc\nStephen Curry\ndone\nd\nStephen Curry\nq\n");
            Scanner input = new Scanner(System.in);
            NBATeamFrontend frontEnd = new NBATeamFrontend(input, backEnd);
            frontEnd.runCommandLoop();
            String output = tester.checkOutput();
            String fail = "Player not found in the database.";
            String playerStat = "Stephen Curry\n Points: 1450 Rebounds: 303 Steals: 44 Assists: 308" +
                    "Blocks: 14 Number of Games: 49";

            assertFalse(output.contains(fail));
            assertTrue(output.contains(playerStat));

        } catch (Exception e) {
        }
    }

}