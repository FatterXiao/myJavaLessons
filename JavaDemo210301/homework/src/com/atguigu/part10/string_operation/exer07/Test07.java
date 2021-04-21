package com.atguigu.part10.string_operation.exer07;

/*
    - 判断回文字符串。如果一个字符串，从前向后读和从后向前读，都是一个字符串，称为回文串，比如mom，dad，noon
 */
public class Test07 {

    public static void test(){
        String str = "noon";
        System.out.println(str);
        char[] arr = str.toCharArray();
        boolean flag = true;
        for (int left = 0,right=arr.length-1; left <=right; left++,right--) {
            if(arr[left] != arr[right]){
                flag = false;
                break;
            }
        }
        System.out.print("回文数：");
        if(flag){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }

    public static void main(String[] args) {
        String str = "noon";
        System.out.println(str);
        StringBuilder s = new StringBuilder(str);
        String string = s.reverse().toString();
        System.out.print("回文数：");
        if(str.equals(string)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }

}
