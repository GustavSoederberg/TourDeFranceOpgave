import java.util.*;

public class Statistics {

    private List<Rider> riders;

    public Statistics(String filename) {
        TDFFileReader tdfFileReader = new TDFFileReader(filename);
        riders = tdfFileReader.readFile();
    }

    public Set<String> getTeams() {
        Set<String> teams = new TreeSet<>();

        for (Rider rider : riders) {
            teams.add(rider.getTeam());
        }
        return teams;
    }

    public Map<String, Set<String>> getTeamsWithMembers() {
        Map<String, Set<String>> teamsWithMembers = new TreeMap<>();
        for (Rider rider : riders) {
            if (!teamsWithMembers.containsKey(rider.getTeam())) {
                Set<String> riderNames = new TreeSet<>();
                riderNames.add(rider.getName());
                teamsWithMembers.put(rider.getTeam(), riderNames);
            } else {
                teamsWithMembers.get(rider.getTeam()).add(rider.getName());
            }
        }

        return teamsWithMembers;


    }

    public Set<String> getTeamMembers(String team){
        return getTeamsWithMembers().get(team);
    }
}
