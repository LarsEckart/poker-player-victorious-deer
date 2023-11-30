package org.leanpoker.player;

import com.fasterxml.jackson.databind.JsonNode;

public class Player {

    static final String VERSION = "all in when pair, call when king or ace";

    public static int betRequest(JsonNode request) {
        if (request.get("players").get("hole_cards").get(0).get("rank").equals(request.get("players").get("hole_cards").get(1).get("rank"))) {
            return 5000;
        }
        // if we have king or ace, call
        if (request.get("players").get("hole_cards").get(0).get("rank").equals("K")
            || request.get("players").get("hole_cards").get(1).get("rank").equals("K")
            || request.get("players").get("hole_cards").get(0).get("rank").equals("A")
            || request.get("players").get("hole_cards").get(1).get("rank").equals("A")) {
            return request.get("current_buy_in").asInt() - request.get("players").get("in_action").get("bet").asInt() + request.get("minimum_raise").asInt();
        }
        return 0;
    }

    public static void showdown(JsonNode game) {
    }
}
