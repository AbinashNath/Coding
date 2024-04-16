//https://leetcode.com/problems/find-and-replace-pattern/description/
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for(String word: words){
            if(isSame(word,pattern)){
                res.add(word);
            }
        }
        return res;
    }

    private boolean isSame(String word, String pattern) {
        if(pattern.length()!=word.length()){
            return false;
        }
        Map<Character,Character> characterMap = new HashMap<>();
        for(int i=0; i<word.length(); i++){
            char wC = word.charAt(i);
            char pC = pattern.charAt(i);
            if(characterMap.containsKey(wC)){
                char expPat = characterMap.get(wC);
                if(expPat!=pC){
                    return false;
                }
            }
            if(!characterMap.containsKey(wC)){
                if(characterMap.containsValue(pC)){
                    return false;
                }
                characterMap.put(wC,pC);
            }
        }
        return true;
    }
}
