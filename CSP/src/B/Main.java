package B;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    static long r, g, y, all;
    static long mod ;
    static void convert(long flag, long rest) {
        if (flag == 0) all += rest;
        else {
            if(flag==1) rest=r-rest;
            else if(flag==2) rest=y-rest+g+r;
            else if(flag==3) rest=g-rest+r;
            long cur = 0;
            cur += (rest + all);
            cur %= mod;
            if (0 <= cur && cur < r) {
                all += (r - cur);
            } else if (r + g <= cur && cur < r + g + y)
                all += (mod - cur + r);
        }
    }

    public static void main(String args[]) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        r = cin.nextInt();
        y = cin.nextInt();
        g = cin.nextInt();
        mod= r + g + y;
        int n = cin.nextInt();
        int flag, sec;
        for (int i = 1; i <= n; i++) {
            flag=cin.nextInt();
            sec=cin.nextInt();
            convert(flag,sec);
            //System.out.println("flag: "+flag+"sec: "+sec);
            //System.out.println(all);
        }
        System.out.println(all);
    }
}