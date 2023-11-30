package org.leanpoker.player;

import com.fasterxml.jackson.databind.JsonNode;

public class Player {

    static final String VERSION = "all in when pair";

    public static int betRequest(JsonNode request) {
        // if we have a pair, go all in
        if (request.get("players").get("hole_cards").get(0).get("rank").equals(request.get("players").get("hole_cards").get(1).get("rank"))) {
            return 5000;
        }
        return 0;
    }

    public static void showdown(JsonNode game) {
    }
}
