import com.sun.deploy.util.StringUtils;

public class StringPermRecursive {

    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]){
        char[] charArr = new char[]{'b','c','e','f'};

        String str = "bcef";
        permute(str, 0, str.length() - 1);
    }
    private static void permute(String str, int l, int r)
    {
        if (l == r) {
         System.out.println(str);
        }
        else
        {
            //System.out.println();
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                //System.out.println(str);

                permute(str, l+1, r);

                str = swap(str,l,i);
                //System.out.print(str);
            }
        }
    }
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();

        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;

        return String.valueOf(charArray);
    }
    public static void perm(char[] a, int i){
        if(i == a.length - 1){
            for(char c : a){
                System.out.print(c);
            }
            System.out.println();
            return;
        }
        for(int j = i; j < a.length - 1; j++){
            //swap
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;

            perm(a, i + 1);

            temp = a[i];
            a[i] = a[j];
            a[j] = temp;

        }
    }
}
