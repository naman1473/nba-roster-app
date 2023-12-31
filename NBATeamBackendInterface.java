import java.io.FileNotFoundException;
import java.util.List;

public interface NBATeamBackendInterface {
    // public NBATeamBackendInterface(NBAPlayerRedBlackTreeInterface nbaRBT, NBAPlayerReaderInterface playerReader);
    public void loadData(String filename) throws FileNotFoundException;
    public NBAPlayerInterface findNBAPlayerByName(String name);
    public String getStatisticsString(String name);
    public List<NBAPlayerInterface> getAllPlayers();
    public boolean addPlayer(String name);
    public boolean removePlayer(String name);

}

