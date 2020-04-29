package CaseStudy.Model;

import java.util.Comparator;

public class SortNameAndYear implements Comparator<Customer> {
public int compare(Customer s1,Customer s2){
    int resultCompareName=s1.getName_customer().compareTo(s2.getName_customer());
    if (resultCompareName==0){
        return compareYear(s1,s2);
    }
    return resultCompareName;
}
private int compareYear(Customer s1,Customer s2){
    int yearCus1 = Integer.parseInt(s1.getBirthday().substring(6,10));
    int yearCus2 = Integer.parseInt(s2.getBirthday().substring(6,10));
    if (yearCus1==yearCus2){
        return 0;
    }else if (yearCus1>yearCus2){
        return 1;
    }else{
        return -1;
    }
}

}
