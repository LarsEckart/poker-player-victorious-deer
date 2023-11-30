package org.leanpoker.player;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class Player {

    private static final Logger log = getLogger(Player.class);

    static final String VERSION = "v4 handle exceptions and log them";

    public static int betRequest(JsonNode request) {
        try {
        if (request.get("players").get("hole_cards").get(0).get("rank").equals(request.get("players").get("hole_cards").get(1).get("rank"))) {
            return 5000;
        }
        // if we have king or ace, call
        if (request.get("players").get("hole_cards").get(0).get("rank").asText().equals("K")
            || request.get("players").get("hole_cards").get(1).get("rank").asText().equals("K")
            || request.get("players").get("hole_cards").get(0).get("rank").asText().equals("A")
            || request.get("players").get("hole_cards").get(1).get("rank").asText().equals("A")) {
            return request.get("current_buy_in").asInt() - request.get("players").get("in_action").get("bet").asInt() + request.get("minimum_raise").asInt();
        }
        return 0; }
        catch (Exception e) {
            log.error(e.getMessage());
            return 0;
        }
    }

    public static void showdown(JsonNode game) {
    }
}
