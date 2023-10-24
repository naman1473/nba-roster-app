// --== CS400 Spring 2023 File Header Information ==--
// Name: Naman Parekh
// Email: ncparekh@wisc.edu
// Team: DT
// TA: Daniel Finer
// Lecturer: Florian Heimerl (004)
// Notes to Grader: <optional extra notes>

/**
 * PlaceHolder Class that mimcs the implements the implementation of the Algorithm Engineer
 * @author Naman Parekh
 *
 */
public class NBAPlayerRedBlackTreeInterfaceBD implements NBAPlayerRedBlackTreeInterface {

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public NBAPlayerInterface getByName(String name) {

        NBAPlayerInterfaceBD player = new NBAPlayerInterfaceBD("Kyrie Irving", 22, 5,
                35, 8, 34, 20);
        return player;
    }

    @Override
    public NBAPlayerInterface removeByName(String name) {
        return null;
    }

    @Override
    public boolean insert(NBAPlayerInterface data) throws NullPointerException, IllegalArgumentException {
        return true;
    }

    @Override
    public boolean remove(NBAPlayerInterface data) throws NullPointerException, IllegalArgumentException {
        return true;
    }

    @Override
    public boolean contains(NBAPlayerInterface data) {

        return true;
    }

    @Override
    public int size() {
        return 3;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}

