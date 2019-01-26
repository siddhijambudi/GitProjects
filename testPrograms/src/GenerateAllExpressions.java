import java.util.ArrayList;
import java.util.List;

public class GenerateAllExpressions {
    public static void main(String args[]){
        List<String> result = new ArrayList<>();
        generateAllExpressions(0,"",0, "123", 6, result);

        //print result
        for(String resString : result){
            System.out.println(resString);
        }
    }
    public static void generateAllExpressions(int arrayIndex, String holdStringExprSofar, int holdCurrValuesForStrExprSoFar,
                                                       String inputString, int target, List<String> result){

        //when a leaf node is holding value same as target add it into result array
        if(holdCurrValuesForStrExprSoFar == target){
            result.add(holdStringExprSofar);
            return;
        }

        //loop through each index
        for(int i = arrayIndex; i < inputString.length(); i++){

            //check what is the string so far
            String currString = inputString.substring(arrayIndex, i + 1);

            //check what is the value so far
            int currValue = Integer.valueOf(currString);

            //are you at first index where there is nothing to check for valid expressions?
            //go to the deep of first character of the input string
            if(arrayIndex == 0){
                generateAllExpressions(arrayIndex + 1, holdStringExprSofar + currString,
                        currValue, inputString, target, result);
            }

            //next index check with all possible values
            else{
                generateAllExpressions(arrayIndex + 1, holdStringExprSofar + "" + currString,
                        Integer.valueOf(inputString.substring(0, i + 1)), inputString, target, result);

                generateAllExpressions(arrayIndex + 1, holdStringExprSofar + "*" + currString,
                        holdCurrValuesForStrExprSoFar * currValue, inputString, target, result);

                generateAllExpressions(arrayIndex + 1, holdStringExprSofar + "+" + currString,
                        holdCurrValuesForStrExprSoFar + currValue, inputString, target, result);
            }
        }
    }
}
