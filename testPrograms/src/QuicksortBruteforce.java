import java.util.*;

public class QuicksortBruteforce {

    static NameObjectComparator nameObjectComparator = new NameObjectComparator();
    public static void main(String args[]){
        List<NameObject> arr = new ArrayList<>();

        NameObject n1 = new NameObject();
        n1.setFirstName("Siddhi");
        n1.setLastName("Shah");
        n1.setAge(20);

        NameObject n2 = new NameObject();
        n2.setFirstName("Siddhi");
        n2.setLastName("abc");
        n2.setAge(30);

        NameObject n3 = new NameObject();
        n3.setFirstName("Siddhi");
        n3.setLastName("shah");
        n3.setAge(42);

        NameObject n4 = new NameObject();
        n4.setFirstName("Siddhi");
        n4.setLastName("shah");
        n4.setAge(37);

        NameObject n5 = new NameObject();
        n5.setFirstName("Siddhi");
        n5.setLastName("shah");
        n5.setAge(40);

        NameObject n6 = new NameObject();
        n6.setFirstName("Siddhi");
        n6.setLastName("shah");
        n6.setAge(36);

        arr.add(n1);
        arr.add(n2);
        arr.add(n3);
        arr.add(n4);
        arr.add(n5);
        arr.add(n6);

        List<NameObject> sortedArr = quicksort(arr);
        for(NameObject i : sortedArr){
            System.out.println(i.getFirstName() + i.getLastName() + i.getAge());
        }
    }
    public static List<NameObject> quicksort(List<NameObject> arr){
        int sizeOfArray = arr.size();

        if(sizeOfArray <= 1){
            return arr;
        }
        int pivotIndex = sizeOfArray / 2;
        NameObject pivotVal = arr.get(pivotIndex);

        List<NameObject> smaller = new ArrayList();
        List<NameObject> bigger = new ArrayList();

        for(int i = 0; i < sizeOfArray; i++){
             if(i != pivotIndex){
                NameObject arrValue = arr.get(i);

                if(nameObjectComparator.compare(arrValue, pivotVal) < 0){
                    smaller.add(arrValue);
                }
                else if(nameObjectComparator.compare(arrValue, pivotVal) > 0){
                    bigger.add(arrValue);
                }
                else{
                    if(i < pivotIndex){
                        smaller.add(arrValue);
                    }
                    else{
                        bigger.add(arrValue);
                    }
                }
            }
        }
        List<NameObject> returnList = quicksort(smaller); returnList.add(pivotVal); returnList.addAll(quicksort(bigger));
        return returnList;

    }
}
//sort first on firstName
//if firstname is same then lastName
//if lastName is same then age

class NameObject{
    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class NameObjectComparator implements Comparator<NameObject>{
    @Override
    public int compare(final NameObject o1, final NameObject o2) {
        if(o1.getFirstName().equals(o2.getFirstName())){
            if(o1.getLastName().equals(o2.getLastName())){
                return 0;
            }
            else {
                int val = o1.getLastName().compareTo(o2.getLastName());
                if(val < 0){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        }else{
            int val = o1.getFirstName().compareTo(o2.getFirstName());
            if(val < 0){
                return -1;
            }else{
                return 1;
            }
        }
    }
}
