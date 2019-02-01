public class StringPatternRecursionMatch {
    public static void main(String args[]){

        String str = "geeksforgeeks";
        String pattern = "ge?ks*";

        boolean bool = isMatch(str.toCharArray(), pattern.toCharArray(), 0, 0);
        System.out.print(bool);
    }
    public static boolean isMatch(char[] str, char[] pattern, int strIndex, int patternIndex){
        if(pattern.length == 0 && str.length == 0){
            return true;
        }
        if(patternIndex < pattern.length && pattern[patternIndex] == '*' && !(pattern.length == 1) && str.length == 0){
            return false;
        }
        if((patternIndex < pattern.length && pattern[patternIndex] == '?')
                || (patternIndex < pattern.length && pattern[patternIndex] == str[strIndex])){
            return isMatch(str, pattern, strIndex + 1, patternIndex + 1);
        }
        if(patternIndex < pattern.length && pattern[patternIndex] == '*'){
             boolean withCurrChar = isMatch(str, pattern, strIndex,patternIndex + 1);
             boolean withoutCurrChar = isMatch(str, pattern ,strIndex + 1, patternIndex);

             return withCurrChar || withoutCurrChar;
        }
        return false;
    }
}
