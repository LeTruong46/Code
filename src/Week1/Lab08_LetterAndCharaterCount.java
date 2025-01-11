package Week1;

import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Map;

public class Lab08_LetterAndCharaterCount {
    private String input;

    public Lab08_LetterAndCharaterCount(String input) {
        this.input = input;
    }
    
    public Map<String, Integer> countWord(){
        Map<String, Integer> wordCount = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(input);
        
        while (tokenizer.hasMoreElements()) {
            String word = tokenizer.nextToken().toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }
    
    public Map<Character, Integer> countCharacter(){
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : input.toCharArray()){
            if(Character.isLetter(c)){
                c = Character.toLowerCase(c);
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }
        return charCount;
    }
    
}
