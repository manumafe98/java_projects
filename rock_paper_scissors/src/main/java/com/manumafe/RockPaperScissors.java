package com.manumafe;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class RockPaperScissors {
    
    private List<String> list = new ArrayList<>() {{
        add("rock");
        add("paper");
        add("scissors");
    }};

    private Map<String, String> map = new HashMap<>() {{
        put("rock","scissors");
        put("paper","rock");
        put("scissors","paper");
    }};

    public GameResult logic(int userChoice, int cpuChoice) {
        if (userChoice == cpuChoice) {
            return GameResult.DRAW;
        } 

        if (map.get(list.get(userChoice)) == list.get(cpuChoice)) {
            return GameResult.WIN;
        }

        return GameResult.LOST;
    }
}
