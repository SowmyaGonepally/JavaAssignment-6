import java.util.ArrayList;
import java.util.Collections;

public class VampireNumbers
{
    static  ArrayList<Long>vampireNumbers=new ArrayList<Long>();
    public static void main(String[] args) {
       System.out.println("First 100 vampire numbers");
       getVampireNumbers();
       Collections.sort(vampireNumbers);
       for (int i=0;i<100;i++)
       {
           System.out.println(i+1+"-"+vampireNumbers.get(i));
       }

    }
    public static void getVampireNumbers() {
        int count = 0;
        for (long j = 10; vampireNumbers.size()<=100; j++) {
             if ((numOfDigit(j) % 2) != 0)
             {
                      j = j * 10 - 1;
                     continue;
             }
            for (long fang1 = 2; fang1 <= Math.sqrt(j) + 1; fang1++) {
                if (j % fang1 == 0) {
                    long fang2 = j / fang1;
                    if (haveSameDigits(fang1, fang2, j) && fang1 <= fang2) {
                        vampireNumbers.add(j);
                        //System.out.println(fang1+"*"+fang2+"="+j);
                    }
                }
            }

        }
    }
    public static boolean haveSameDigits(long fang1,long fang2,long vn)
    {
        if(fang1%10==0 && fang2%10==0)
        {
            return false;
        }
        if(numOfDigit(fang1)!=numOfDigit(vn)/2 || numOfDigit(fang2)!=numOfDigit(vn)/2)
        {
            return false;
        }
        ArrayList<Long>fangDigits=new ArrayList<Long>();
        ArrayList<Long>vampireDigits=new ArrayList<Long>();
        while (fang1>0)
        {
            fangDigits.add(fang1%10);
            fang1=fang1/10;
        }
        while (fang2>0)
        {
            fangDigits.add(fang2%10);
            fang2=fang2/10;
        }
        while (vn>0)
        {
            vampireDigits.add(vn%10);
            vn=vn/10;
        }
        Collections.sort(fangDigits);
        Collections.sort(vampireDigits);

        return vampireDigits.equals(fangDigits);
    }
    public static int numOfDigit(long l){
        return Long.toString(Math.abs(l)).length();
    }
}
