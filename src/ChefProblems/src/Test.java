package ChefProblems.src;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    static void addScores(int pts,  int goalDiff, Map<String, Integer> map)
    {
        System.out.println("before "+map);
        if(map.isEmpty())
        {
            map.put("goal",goalDiff);
            map.put("points", pts);
        }
        else
        {
            map.put("goal",map.get("goal")+goalDiff);
            map.put("points", map.get("points")+pts);
        }
        System.out.println("after "+map);
    }
    static void processScores(String inputStr){
        String str[] = inputStr.split("\\n");
        Map<String, Map<String,Integer>> map = new HashMap<>();
        for(int i = 0; i<str.length;i++)
        {
            String teamStr[] = str[i].split("vs.");
            String homeTeamStr[] = teamStr[0].split("\\s");
            String awayTeamStr[] = teamStr[1].trim().split("\\s");

            String homeTeamName = homeTeamStr[0], awayTeamName = awayTeamStr[1];

            int goals_homeTeam = Integer.parseInt(homeTeamStr[1]);
            int goals_awayTeam = Integer.parseInt(awayTeamStr[0]);
            Map<String,Integer> homeTeam_scores = map.containsKey(homeTeamName)?map.get(homeTeamName):new HashMap<>();
            Map<String,Integer> awayTeam_scores = map.containsKey(awayTeamName)?map.get(awayTeamName):new HashMap<>();
            if(goals_homeTeam>=goals_awayTeam)
            {
                if(goals_homeTeam==goals_awayTeam)
                {
                    System.out.println(homeTeamName);
                    addScores(1,goals_homeTeam-goals_awayTeam,homeTeam_scores);
                    System.out.println(awayTeamName);
                    addScores(1,goals_awayTeam-goals_homeTeam,awayTeam_scores);
                }
                else{
                    System.out.println(homeTeamName);
                    addScores(3,goals_homeTeam-goals_awayTeam,homeTeam_scores);
                    System.out.println(awayTeamName);
                    addScores(0,goals_awayTeam-goals_homeTeam,awayTeam_scores);
                }
            }
            else{
                    System.out.println(homeTeamName);
                    addScores(0,goals_homeTeam-goals_awayTeam,homeTeam_scores);
                    System.out.println(awayTeamName);
                    addScores(3,goals_awayTeam-goals_homeTeam,awayTeam_scores);
            }
            map.put(homeTeamName,homeTeam_scores);
            map.put(awayTeamName,awayTeam_scores);
        }sortScores(map);
    }
    static void sortScores( Map<String, Map<String,Integer>> map){
         List list = map.entrySet().stream().sorted((x,y)->{
            return  (new Integer(x.getValue().get("points")+x.getValue().get("goal")))
                    .compareTo(new Integer(y.getValue().get("points")+y.getValue().get("goal")));
         }).collect(Collectors.toList());
        System.out.println(list);
    }
    public static void main(String args[]){
        String str = "manutd 8 vs. 2 arsenal\n" +
                "lyon 1 vs. 2 manutd\n" +
                "fcbarca 0 vs. 0 lyon\n" +
                "fcbarca 5 vs. 1 arsenal\n" +
                "manutd 3 vs. 1 fcbarca\n" +
                "arsenal 6 vs. 0 lyon\n" +
                "arsenal 0 vs. 0 manutd\n" +
                "manutd 4 vs. 2 lyon\n" +
                "arsenal 2 vs. 2 fcbarca\n" +
                "lyon 0 vs. 3 fcbarca\n" +
                "lyon 1 vs. 0 arsenal\n" +
                "fcbarca 0 vs. 1 manutd";
       processScores(str);
    }
}
