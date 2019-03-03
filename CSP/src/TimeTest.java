/**
 * @Project: CSP
 * @Package: PACKAGE_NAME
 * @ClassName: TimeTest
 * @Description: TODO
 * @Author: 刘志磊
 * @Date: 2019/2/25 17:53
 * @Version: 1.0
 **/
public class TimeTest {
    static void f() {
        for(int i=1;i<=10;i++)
        { int x=1;}
    }

    void g() {
        for(int i=1;i<=10;i++)
        {int x=1;}
    }
    void test(int loops){
        System.out.println("all loops: "+loops);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loops; i++) {
            f();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("static method run times:" + (endTime - startTime) + "ms");


        TimeTest t=new TimeTest();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < loops; i++) {
            t.g();
        }
        endTime = System.currentTimeMillis();
        System.out.println("non-static method run time:" + (endTime - startTime) + "ms");

    }
    public static void main(String[] args) {
        int loops=(int)1e4;
         for(;loops<=(int)1e9;loops=loops*10){
             new TimeTest().test(loops);
             System.out.println();
         }
    }
}