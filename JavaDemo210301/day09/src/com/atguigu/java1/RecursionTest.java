package com.atguigu.java1;

/**
 * 递归方法的说明：
 *
 * 1. 概念：一个方法体内调用它自身，就构成了递归方法的调用。
 *
 * 2. 递归方法的调用，要避免出现 StackOverflowError异常。
 *     此情况类似于死循环。
 *
 * 3. 递归一定要向已知方向递归，否则这种递归就变成了无穷递归，类似于死循环。
 *
 * @author shkstart
 * @create 11:07
 */
public class RecursionTest {

    public static void main(String[] args) {
        RecursionTest test = new RecursionTest();
//        test.show();//StackOverflowError异常

        System.out.println(test.sum(100));
        System.out.println(test.sum1(100));
        System.out.println(test.multiply(10));

        System.out.println(test.func(10));
        System.out.println(test.fei(10));
    }

    public void show(){
        System.out.println("递归调用");

        show();

    }

    //举例1：求100以内自然数的和
    //不使用递归方法
    public int sum(int num){
        int sum = 0;
        for(int i = 1;i <= num;i++){
            sum += i;
        }
        return sum;
    }

    public int sum1(int num){
        if(num == 1){
            return 1;
        }else{
            return sum1(num - 1) + num;
        }
    }

    //举例2：求n!
    public int multiply(int n){
        if(n == 1){
            return 1;
        }else{
            return multiply(n - 1) * n;
        }
    }

    //举例3：已知有一个数列：f(0) = 1,f(1) = 4,f(n+2) = 2*f(n+1) + f(n),
    //其中n是大于0的整数，求f(10)的值。
    public int f(int n){
        if(n == 0){
            return 1;
        }else if(n == 1){
            return 4;
        }else{
            return 2 * f(n - 1) + f(n - 2);
        }
    }

    //举例4:已知一个数列：f(20) = 1,f(21) = 4,f(n+2) = 2*f(n+1)+f(n),
    //其中n是大于0的整数，求f(10)的值。
    public int func(int m){
        if(m == 20){
            return 1;
        }else if(m == 21){
            return 4;
        }else{
            return func(m + 2) - 2 * func(m + 1);
//            return 2 * func(m - 1) + func(m - 2);//错误的
        }
    }

    //举例5：斐波那契数列： 1 1 2 3 5 8 13 21 34 55 ...
    //f(1) = 1,f(2) = 1, f(n) = f(n - 1) + f(n - 2)
    //走n级台阶，每次只能走一个台阶或两个台阶。问n级台阶有多少种走法？
    public int fei(int n){
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 1;
        }else {
            return fei(n - 1) + fei(n - 2);
        }
    }

    //举例6：汉诺塔

    //举例7：通过递归遍历文件目录，获取文件目录的大小（或删除文件目录）

    //举例8：快速排序


}
