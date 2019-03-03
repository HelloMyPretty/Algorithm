package com.company;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int r,y,g;
        //Scanner cin=new Scanner(new BufferedInputStream(System.in));
        Scanner cin=new Scanner(System.in);
        r=cin.nextInt();
        y=cin.nextInt();
        g=cin.nextInt();
        int n,m;
        n=cin.nextInt();
        int ans=0;
        for(int i=1;i<=n;i++){
            int flag,sec;
            flag=cin.nextInt();
            sec=cin.nextInt();
            if(flag==0) ans+=sec;
            else if(flag==1)
                ans+=sec;
            else if(flag==2)
                ans+=(sec+r);
        }
        System.out.println(ans);
    }
}
