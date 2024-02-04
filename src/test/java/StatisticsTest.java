import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {

    Statistics statistics;

    @BeforeEach
    void setUp() {
        statistics = new Statistics("tdffinishers2023.csv");
    }

    @AfterEach
    void tearDown() {
        statistics = null;
    }


    @Test
    void getTeamsRight(){
        int expectedResult = 22;
        int actualResult = statistics.getTeams().size();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    void getTeamsWrong(){
        int expectedResult = 0;
        int actualResult = statistics.getTeams().size();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    void getTeamMembersRight() {
        int expectedResult = 7;
        int actualResult = statistics.getTeamMembers("Jumbo-Visma").size();

        assertEquals(expectedResult,actualResult);

    }

    @Test
    void getTeamMembersWrong() {
        int expectedResult = -1;
        int actualResult = statistics.getTeamMembers("Jumbo-Visma").size();

        assertEquals(expectedResult,actualResult);

    }
}