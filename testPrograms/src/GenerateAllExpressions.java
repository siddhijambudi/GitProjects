import java.util.*;

public class GenerateAllExpressions {
    static int countLeaf = 1;
    public static void main(String args[]){
        Set<String> result = new HashSet<>();


        generateAllExpressions(0,"",0, 0, "1234", 11, result);

        //print result
        int k = 0;
        String[] strArray = new String[result.size()];
        for(Object str : result.toArray()){
            strArray[k] = (String) str;
            k++;
        }
        for(String s : strArray){
            //System.out.println(s);
        }
        System.out.println("Total leaves: " + countLeaf);
    }
    public static void generateAllExpressions(int arrayIndex, String holdStringExprSofar, int holdCurrValuesForStrExprSoFar,
                                                       int last, String inputString, int target, Set<String> result){

        //when a leaf node is holding value same as target add it into result array
        /*if(holdCurrValuesForStrExprSoFar == target){
            result.add(holdStringExprSofar);
            return;
        }*/
        if(arrayIndex == inputString.length()){
            System.out.println("leaf : " + holdStringExprSofar + " leaf count: " + countLeaf + " value leaf is holding " + holdCurrValuesForStrExprSoFar + " with last value: " + last);
            countLeaf ++;
            System.out.println("return 1");
            return;
        }

        //loop through each index
        //int i = arrayIndex;
        //while( i < inputString.length()){

            //System.out.println(holdStringExprSofar + " at " + " i: " + i + " array index : " + arrayIndex);

            //check what is the string so far
            String currString = String.valueOf(inputString.charAt(arrayIndex));//inputString.substring(arrayIndex, i + 1);

            //check what is the value so far
            int currValue = Integer.valueOf(currString);

            //are you at first index where there is nothing to check for valid expressions?
            //go to the deep of first character of the input string
            if(arrayIndex == 0){
                generateAllExpressions(arrayIndex + 1, holdStringExprSofar + currString,
                        currValue, currValue, inputString, target, result);
            }

            //next index check with all possible values
            else{
                generateAllExpressions(arrayIndex + 1, holdStringExprSofar + "" + currString,
                        holdCurrValuesForStrExprSoFar, currValue, inputString, target, result);

                generateAllExpressions(arrayIndex + 1, holdStringExprSofar + "*" + currString,
                        holdCurrValuesForStrExprSoFar - last + last * currValue, last * currValue, inputString, target, result);

                generateAllExpressions(arrayIndex + 1, holdStringExprSofar + "+" + currString,
                        holdCurrValuesForStrExprSoFar + currValue, currValue, inputString, target, result);

                return;
            }
            //i++;
        //}
        //System.out.println("return 3: explicit " + " value of i: " + i);
    }
    /*static Integer convertExpression(String str){

        int multiPlayIndex = str.indexOf('*'); //3
        int additionIndex = str.indexOf('+'); //1

        if(multiPlayIndex == -1 && additionIndex == -1){
            return null;
        }
        Integer mul = null;
        Integer add = null;

        if(multiPlayIndex != -1){
            mul = 1;
        }
        if(additionIndex != -1){
            add = 0;
        }
        Integer mcount = null;
        String[] mulArray;
        if(mul != null) {
           mcount = 1;
           mulArray = str.split("\\*");
           for(String m : mulArray){
              mcount = mcount * Integer.valueOf(m);
           }
        }
        String[] addArray;
        Integer addCount = null;
        if(add != null) {
           addCount = 0;
           addArray = str.split("\\+");
           for(String m1 : addArray){
             addCount = addCount + Integer.valueOf(m1);
           }
        }
        if(mcount == null){
            return addCount;
        }
        if(addCount == null){
            return mcount;
        }
        return mcount + addCount;
    }*/
}
