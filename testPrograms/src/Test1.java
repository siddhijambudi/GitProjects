public class Test1 {
    public static void main(String args[]){
        System.out.println(strCopies("catcowcat", "cow", 1));
    }
    static int number = 0;
    public static boolean strCopies(String str, String sub, int n) {
        if(str.length() == 0 || str.length() < sub.length()){
            if(number == n){
                return true;
            }
            return false;
        }
        if(str.substring(0, sub.length()).equals(sub)){
            number = number + 1;
            return strCopies(str.substring(1) , sub, n);
        }
        return strCopies(str.substring(1), sub, n);
    }
}
