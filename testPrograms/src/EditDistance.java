public class EditDistance {
    public static void main(String[] args){
        System.out.print(editDist("siddhi", 0, "ssssssssssss", 0));
    }
    public static int editDist(String str1, int i, String str2, int j){
        if(str1.length() == i){
            return str2.length() - j;
        }
        if(str2.length() == j){
            return str1.length() - i;
        }
        if(str1.charAt(i) == str2.charAt(j)){
            return editDist(str1, i+1, str2, j+1); // move ahead - do not do anything
        }
        return 1 + min(
                editDist(str1, i+1, str2, j), // remove
                editDist(str1, i, str2, j+1), //add
                editDist(str1, i+1,str2, j+1) //modify
        );
    }
    static int min(int x,int y,int z)
    {
        if (x<=y && x<=z) return x;
        if (y<=x && y<=z) return y;
        else return z;
    }
}
