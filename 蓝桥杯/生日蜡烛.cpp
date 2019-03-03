#include<stdio.h>
#include<stdlib.h>

int visited[10]={0};                            //查看该元素是否被访问
int a[10]={0,1,2,3,4,5,6,7,8,9};
int sum=0;                                      //定义全局变量sum来进行对符合条件的组合计数

int test(int n){                                //对不适合的进行剪枝
    if(n==2){
        if(a[0]<a[1]&&a[0]<a[2]){
            return 1;   
        }
        return 0;
    }
    else if(n==5){
        if(a[1]<a[3]&&a[1]<a[4]&&a[2]<a[4]&&a[2]<a[5]){
            return 1;
        }
        return 0;
    }
    else if(n==9){
        if(a[3]<a[6]&&a[3]<a[7]&&a[4]<a[7]&&a[4]<a[8]&&a[5]<a[8]&&a[5]<a[9]){
            sum++;
            return 1;
        }
        return 0;
    }
    else
        return 1;
}

void dfs(int n){
    int i;
    for(i=0;i<10;i++){
        if(!visited[i]){
            visited[i]=1;
            a[n]=i;
            if(!test(n)){
                visited[i]=0;
                continue;
            }
            dfs(n+1);
            visited[i]=0;
        }
    }
}

int main(){
    dfs(0);
    printf("%d\n",sum);
}