
/**
 * This is a utility class that encrypts and decrypts a phrase using three
 * different approaches. 
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption 
 * is a method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph) 
 * at a time instead of just one.
 * 
 * The third approach is Caesar Cipher. It is a simple replacement cypher. 
 * 
 * @author Huseyin Aygun
 * @version 8/3/2025
 */

// For any of the methods that use 'PlainText' I set it to the String 'text' because it takes less time the writing 'plainText'
public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    // Use 64-character matrix (8X8) for Playfair cipher  
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !\"#$%&'()*+,-./:;<=>?@[\\]^_";

    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text 
	 * based on the letters of a keyword. It works as below:
	 * 		Choose a keyword (e.g., KEY).
	 * 		Repeat the keyword to match the length of the plaintext.
	 * 		Each letter in the plaintext is shifted by the position of the 
	 * 		corresponding letter in the keyword (A = 0, B = 1, ..., Z = 25).
	 */   
    public static String vigenereEncryption(String plainText, String key) {
    	String text = plainText;
        if (!isStringInBounds(text)){
            return "The selected string is not in bounds, Try again.";
        }
        String encryptedText = "";
        String repeatKey = "";

        for (int i = 0; i < text.length(); i++){
            repeatKey += key.charAt(i % key.length());
        }
        for (int i = 0; i < text.length(); i++){
            char message = text.charAt(i);
            char keyChar = repeatKey.charAt(i);
            int shift = keyChar - 'A';
            int newValue = message + shift;

            while (newValue > UPPER_RANGE){
                newValue = newValue - RANGE;
            }
            encryptedText += (char) newValue;
        }
        return encryptedText;
    }

    // Vigenere Decryption
    public static String vigenereDecryption(String encryptedText, String key) {
        if (!isStringInBounds(encryptedText)){
            return "The selected string is not in bounds, Try again.";
        }

        String text = "";
        String repeatKey = "";

        for (int i = 0; i < encryptedText.length(); i++){
            repeatKey += key.charAt(i % key.length());
        }

        for (int i = 0; i < encryptedText.length(); i++){
            char cipherChar = encryptedText.charAt(i);
            char keyChar = repeatKey.charAt(i);
            // This used to follow the logic in the pseduocode '(keyChar - SPACE)' but that not working
            // After messing around with the code for a bit is realized 'keyChar - 'A'' works best
            int shift = keyChar - 'A';
            int newValue = cipherChar - shift;

            while (newValue < LOWER_RANGE){
                newValue = newValue + RANGE;
            }
            text += (char) newValue;
        }
        return text;
    }


	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one.
	 * It works as follows:
	 * A matrix (8X8 in our case) is built using a keyword
	 * Plaintext is split into letter pairs (e.g., ME ET YO UR).
	 * Encryption rules depend on the positions of the letters in the matrix:
	 *     Same row: replace each letter with the one to its right.
	 *     Same column: replace each with the one below.
	 *     Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
	 */    

    public static String playfairEncryption(String plainText, String key) {
    	String text = plainText;
        if (!isStringInBounds(text)){
            return "The selected string is not in bounds, Try again.";
        } 

        char[][] grid = buildPFGrid(key);
        String preparedText = text;

        if (preparedText.length() % 2 != 0) {
            preparedText += "X";
        }
        String encryptedText = "";

        for (int i = 0; i < preparedText.length(); i += 2){
            char firstChar = preparedText.charAt(i);
            char secondChar = preparedText.charAt(i + 1);

            int[] firstPosition = findChar(grid, firstChar);
            int[] secondPosition = findChar(grid, secondChar);

            int row1 = firstPosition[0];
            int col1 = firstPosition[1];
            int row2 = secondPosition[0];
            int col2 = secondPosition[1];

            if (row1 == row2){
                encryptedText += grid[row1][(col1 + 1) % 8];
                encryptedText += grid[row2][(col2 + 1) % 8];
            } else if (col1 == col2) {
                encryptedText += grid[(row1 + 1) % 8][col1];
                encryptedText += grid[(row2 + 1) % 8][col2];
            } else {
                encryptedText += grid[row1][col2];
                encryptedText += grid[row2][col1];
            }
        }
        return encryptedText;
    }

    // Vigenere Decryption --- I missed this method in pseudocode, but pseudocode has now been updated in the zip file i'll submit!
    public static String playfairDecryption(String encryptedText, String key) {
    	if (!isStringInBounds(encryptedText)){
            return "The selected string is not in bounds, Try again.";
        }
        char[][] grid = buildPFGrid(key);
        String text = ""; 
 
        for (int i = 0; i < encryptedText.length(); i += 2){
            char firstChar = encryptedText.charAt(i);
            char secondChar = encryptedText.charAt(i + 1);

            int[] firstPosition = findChar(grid, firstChar);
            int[] secondPosition = findChar(grid, secondChar);

            int row1 = firstPosition[0];
            int col1 = firstPosition[1];
            
            int row2 = secondPosition[0];
            int col2 = secondPosition[1];

            if (row1 == row2){ 
                text += grid[row1][(col1 + 7) % 8];
                text += grid[row2][(col2 + 7) % 8];
            } else if (col1 == col2) {
                text += grid[(row1 + 7) % 8][col1];
                text += grid[(row2 + 7) % 8][col2];
            } else {
                text += grid[row1][col2];
                text += grid[row2][col1];
            }
        }
        if (text.length() > 0 && text.charAt(text.length() - 1) == 'X') {
            text = text.substring(0, text.length() - 1);
        }
        return text;
    }

    /**
     * Caesar Cipher is a simple substitution cipher that replaces each letter in a message 
     * with a letter some fixed number of positions down the alphabet. 
     * For example, with a shift of 3, 'A' would become 'D', 'B' would become 'E', and so on.
     */    
 
    public static String caesarEncryption(String plainText, int key) {
    	String text = plainText;
        if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }

        String encryptedText = "";

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            int newValue = character + key;

            while (newValue > UPPER_RANGE) {
                newValue = newValue - RANGE;
            }

            while (newValue < LOWER_RANGE) {
                newValue = newValue + RANGE;
            }

            encryptedText += (char) newValue;
        }

        return encryptedText;
    }

    // Caesar Decryption
    public static String caesarDecryption(String encryptedText, int key) {
        if (!isStringInBounds(encryptedText)){
            return "The selected string is not in bounds, Try again."; 
        }

        String text = "";

        for (int i = 0; i < encryptedText.length(); i++) {
            char character = encryptedText.charAt(i);
            int newValue = character - key;

            while (newValue < LOWER_RANGE) {
                newValue = newValue+ RANGE;
            }

            while (newValue > UPPER_RANGE) {
                newValue = newValue - RANGE;
            }

            text += (char) newValue;
        }
        return text;
    }
    
    //Helper Methods:
    
    // builds the 8x8 grid so that there are no duplicate characters
    private static char[][] buildPFGrid(String key) {
        String gridCharacters = "";

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (ALPHABET64.indexOf(c) != -1 && gridCharacters.indexOf(c) == -1) {
                gridCharacters += c;
            }
        }

        for (int i = 0; i < ALPHABET64.length(); i++) {
            char c = ALPHABET64.charAt(i);
            if (gridCharacters.indexOf(c) == -1) {
                gridCharacters += c;
            }
        }

        char[][] grid = new char[8][8];
        int index = 0;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                grid[row][col] = gridCharacters.charAt(index);
                index++;
            }
        }

        return grid;
    }

    // finds where a character is in grid
    private static int[] findChar(char[][] grid, char target) {
        int[] position = new int[2];

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (grid[row][col] == target) {
                    position[0] = row;
                    position[1] = col;
                    return position;
                }
            }
        }
        return position;
    }
}

