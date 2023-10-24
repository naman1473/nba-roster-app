// --== CS400 Spring 2023 File Header Information ==--
// Name: Naman Parekh
// Email: ncparekh@wisc.edu
// Team: DT
// TA: Daniel Finer
// Lecturer: Florian Heimerl (004)
// Notes to Grader: <optional extra notes>

/**
 * PlaceHolder Class that mimcs the implements the implementation of the DataWrangler
 * @author Naman Parekh
 *
 */
public class NBAPlayerInterfaceBD implements NBAPlayerInterface {

    private String name;
    private int points;
    private int rebounds;
    private int steals;
    private int assists;
    private int blocks;
    private int numGames;

    public NBAPlayerInterfaceBD(String name, int points, int rebounds, int steals,
                                int assists, int blocks, int numGames) {
        this.name = name;
        this.points = points;
        this.rebounds = rebounds;
        this.steals = steals;
        this.assists = assists;
        this.blocks = blocks;
        this.numGames = numGames;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public int getRebounds() {
        return rebounds;
    }

    @Override
    public int getSteals() {
        return steals;
    }

    @Override
    public int getAssists() {
        return assists;
    }

    @Override
    public int getBlocks() {
        return blocks;
    }

    @Override
    public int getNumGames() {
        return numGames;
    }

    @Override
    public int compareTo(NBAPlayerInterface o) {
        return 0;
    }
}
