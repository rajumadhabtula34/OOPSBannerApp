package com.oopsbannerapp;

public class OOPSBannerAPPUC7 {

   
    static class CharacterPatternMap {

        private Character character;
        private String[] pattern;

      
        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

       
        public Character getCharacter() {
            return character;
        }

        
        public String[] getPattern() {
            return pattern;
        }
    }

    /**
     * Creates character pattern mappings.
     *
     * @return array of CharacterPatternMap objects
     */
    public static CharacterPatternMap[] createCharacterPatternMaps() {

        String[] oPattern = {
                " *** ",
                "** **",
                "** **",
                "** **",
                "** **",
                "** **",
                " *** "
        };

        String[] pPattern = {
                "*****",
                "** **",
                "** **",
                "*****",
                "**   ",
                "**   ",
                "**   "
        };

        String[] sPattern = {
                "*****",
                "**   ",
                "**   ",
                "*****",
                "   **",
                "   **",
                "*****"
        };

        String[] spacePattern = {
                "     ",
                "     ",
                "     ",
                "     ",
                "     ",
                "     ",
                "     "
        };

        CharacterPatternMap[] charMaps = new CharacterPatternMap[4];

        charMaps[0] = new CharacterPatternMap('O', oPattern);
        charMaps[1] = new CharacterPatternMap('P', pPattern);
        charMaps[2] = new CharacterPatternMap('S', sPattern);
        charMaps[3] = new CharacterPatternMap(' ', spacePattern);

        return charMaps;
    }

   
    public static String[] getCharacterPattern(
            char ch,
            CharacterPatternMap[] charMaps) {

        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == Character.toUpperCase(ch)) {
                return map.getPattern();
            }
        }

        return charMaps[3].getPattern(); // space pattern
    }

    public static void printMessage(
            String message,
            CharacterPatternMap[] charMaps) {

        for (int row = 0; row < 7; row++) {

            StringBuilder line = new StringBuilder();

            for (char ch : message.toCharArray()) {
                String[] pattern = getCharacterPattern(ch, charMaps);
                line.append(pattern[row]).append(" ");
            }

            System.out.println(line);
        }
    }

 
    public static void main(String[] args) {

        CharacterPatternMap[] charMaps =
                createCharacterPatternMaps();

        String message = "OOPS";

        printMessage(message, charMaps);
    }
}