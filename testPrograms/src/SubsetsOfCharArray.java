import java.io.IOException;

public class SubsetsOfCharArray {
    public static void main(String args[]) throws IOException {
        char[] arr= new char[]{'t','c'};
        char[] subsetSofarArr = new char[arr.length];

        perm(arr,0, subsetSofarArr, 0);

    }
    public static void perm(char[] arr, int arrayIndex, char[] subsetSofar, int subsetIndex) throws IOException {
        for(int i = 0; i < Thread.currentThread().getStackTrace().length; i++){
            StackTraceElement s = Thread.currentThread().getStackTrace()[i];
            if(!s.getMethodName().equals("getStackTrace")) {
                Runtime.getRuntime().exec("clear");
                System.out.println("Frame: " + i + " Line: " + s.getLineNumber() + " ---> " + s.getMethodName() + " arrayIndex: " + arrayIndex + " subsetIndex: " + subsetIndex);
                for(int i1 = 0; i1 < subsetIndex; i1++){
                    System.out.print(subsetSofar[i1]);
                }
            }
        }

        if(arrayIndex == arr.length){

            /*for(int i = 0; i < subsetIndex; i++){
                System.out.print(subsetSofar[i]);
            }*/
            System.out.println();
            System.out.println("*******************************************************");
            System.out.println();
            /*for(int i = 0; i < Thread.currentThread().getStackTrace().length; i++){
                StackTraceElement s = Thread.currentThread().getStackTrace()[i];
                if(!s.getMethodName().equals("getStackTrace")) {
                    System.out.println("Frame: " + i + " Line: " + s.getLineNumber() + " ---> " + s.getMethodName() + " arrayIndex: " + arrayIndex + " subsetIndex: " + subsetIndex);
                }
            }*/
            return;
        }
        else{
            //No a[i]
            perm(arr, arrayIndex + 1, subsetSofar, subsetIndex);

            /*for(int i = 0; i < Thread.currentThread().getStackTrace().length; i++){
                StackTraceElement s = Thread.currentThread().getStackTrace()[i];
                if(!s.getMethodName().equals("getStackTrace")) {
                    System.out.println("Frame: " + i + " Line: " + s.getLineNumber() + " ---> " + s.getMethodName() + " arrayIndex: " + arrayIndex + " subsetIndex: " + subsetIndex);
                }
            }*/

            //add a[i] in subset so far
            subsetSofar[subsetIndex] = arr[arrayIndex];

            /*for(int i = 0; i < Thread.currentThread().getStackTrace().length; i++){
                StackTraceElement s = Thread.currentThread().getStackTrace()[i];
                if(!s.getMethodName().equals("getStackTrace")) {
                    System.out.println("Frame: " + i + " Line: " + s.getLineNumber() + " ---> " + s.getMethodName() + " arrayIndex: " + arrayIndex + " subsetIndex: " + subsetIndex);
                }
            }*/

            //
            perm(arr, arrayIndex + 1, subsetSofar, subsetIndex + 1);

            /*for(int i = 0; i < Thread.currentThread().getStackTrace().length; i++){
                StackTraceElement s = Thread.currentThread().getStackTrace()[i];
                if(!s.getMethodName().equals("getStackTrace")) {
                    System.out.println("Frame: " + i + " Line: " + s.getLineNumber() + " ---> " + s.getMethodName() + " arrayIndex: " + arrayIndex + " subsetIndex: " + subsetIndex);
                }
            }*/

            return;
        }
    }
}
