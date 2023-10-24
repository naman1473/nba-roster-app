// --== CS400 Spring 2023 File Header Information ==--
// Name: Naman Parekh
// Email: ncparekh@wisc.edu
// Team: DT
// TA: Daniel Finer
// Lecturer: Florian Heimerl (004)
// Notes to Grader: <optional extra notes>

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * PlaceHolder Class that mimcs the implements the implementation of the DataWrangler
 * @author Naman Parekh
 *
 */
public class NBAPlayerReaderInterfaceBD implements NBAPlayerReaderInterface{
    @Override
    public List<NBAPlayerInterface> readPlayersFromFile(String filename) throws FileNotFoundException {

        List<NBAPlayerInterface> list = new ArrayList<>();

        NBAPlayerInterfaceBD player1 = new NBAPlayerInterfaceBD("Lebron James", 23, 12,
                30, 12, 45, 50);

        NBAPlayerInterfaceBD player2 = new NBAPlayerInterfaceBD("Steph Curry", 20, 11,
                25, 10, 48, 49);

        NBAPlayerInterfaceBD player3 = new NBAPlayerInterfaceBD("Kyrie Irving", 22, 5,
                35, 8, 34, 20);

        list.add(player1);
        list.add(player2);
        list.add(player3);

        return list;
    }
}

