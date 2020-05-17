package dev.srjoeraj.pokedex;

import android.graphics.Color;

public class Common {

    public  String toTitleCase(String input) {
        StringBuilder titleCase = new StringBuilder(input.length());
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }

            titleCase.append(c);
        }

        return titleCase.toString();
    }

    public String getColorByType(String type) {
        switch(type)
        {

            case "Normal":
                return "#A4A27A" ;


            case "Dragon":
                return "#743BFB";



            case "Psychic":
                return "#F15B85";


            case "Electric":
                return "#E9CA3C";


            case "Ground":
                return "#D9BF6C";

            case "Grass":
                 return "#81C85B";

            case "Poison":
                return "#A441A3";

            case "Steel":
                return "#BAB7D2";


            case "Fairy":
                return "#DDA2DF";


            case "Fire":
                return "#F48130";


            case "Fight":
                return "#BE3027";


            case "Bug":
                return "#A8B822";


            case "Ghost":
                return "#705693";


            case "Dark":
                return "#745945";


            case "Ice":
                return "#9BD8D8";


            case "Water":
                return "#658FF1";
            default:
                return "#658FA0";
        }
    }
}
