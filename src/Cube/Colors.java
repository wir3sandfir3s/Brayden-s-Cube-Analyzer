package Cube;

import java.util.HashMap;

public enum Colors {

    WHITE,
    GREEN,
    RED,
    YELLOW,
    BLUE,
    ORANGE;

    private static final HashMap<Colors, String> stringMap = new HashMap<Colors, String>(){

        {

            put(WHITE, "W");
            put(GREEN, "G");
            put(RED, "R");
            put(YELLOW, "Y");
            put(BLUE, "B");
            put(ORANGE, "O");

        }

    };

    @Override
    public String toString(){

        return stringMap.get(this);

    }

}
