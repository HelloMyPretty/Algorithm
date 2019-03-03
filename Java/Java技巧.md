### 测试Java代码运行时间

```java
long startTime = System.currentTimeMillis();    //获取开始时间

doSomething();    //测试的代码段

long endTime = System.currentTimeMillis();    //获取结束时间

System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
```

