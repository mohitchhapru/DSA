/**
 * Given two sentences words1, words2 (each represented as an array of strings), 
 * and a list of similar word pairs pairs, determine if two sentences are similar.
 * 
 * For example, words1 = ["great", "acting", "skills"] and 
 * words2 = ["fine", "drama", "talent"] are similar, if the similar word pairs are 
 * pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
 * 
 * Note that the similarity relation is transitive. For example, if "great" and "good" are similar, 
 * and "fine" and "good" are similar, then "great" and "fine" are similar.
 * 
 * Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and 
 * "great" being similar.
 * 
 * Also, a word is always similar with itself. For example, the sentences 
 * words1 = ["great"], words2 = ["great"], pairs = [] are similar, 
 * even though there are no specified similar word pairs.
 * 
 * Finally, sentences can only be similar if they have the same number of words. 
 * So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].
 */


class Solution {
    public String getParentSynonym(Map<String, String> map, String str){
        if(!map.containsKey(str))
            map.put(str, str);
        return (map.get(str) == str? str : getParentSynonym(map,map.get(str)));
    }
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {        
        if(words1.length != words2.length)
            return false;
        
        Map<String, String> map = new HashMap<>();
        for(String[] pair : pairs){            
            String par1 = getParentSynonym(map,pair[0]);
            String par2 = getParentSynonym(map,pair[1]);
            if(!par1.equals(par2))
                map.put(par1,par2);
        }
        
        for(int i=0;i<words1.length;i++){
            if(!words1[i].equals(words2[i]) && !(getParentSynonym(map,words1[i]).equals(getParentSynonym(map,words2[i]))) )
                return false;
        }
        return true;
    }
}