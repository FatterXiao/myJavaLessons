package com.atguigu.part10.string_operation.exer02;

import java.util.Scanner;

/*
    键盘录入QQ号码，验证格式的正确性。

    - 必须是5—12位数字。
    - 0不能开头。
 */
public class Test02 {
    /**
     * 判断输入的是否是合法的qq号码
     * @param numbsers
     * @return
     * @throws Exception
     */
    public static boolean isCorrectedNumbers(String numbsers) throws Exception {
        try {
            numbsers = numbsers.trim();
            int length = numbsers.length();
            if(length < 5 || length > 12){
                return false;
            }
            if(numbsers.charAt(0) == '0' ){
                return false;
            }
            if(numbsers.matches("\\d+")){
                return true;
            }
            return false;
        }catch (Exception ex){
            throw new Exception("输入的字符不合法");
        }
    }

    public static void demo(){
        Scanner input = new Scanner(System.in);
        System.out.print("请输入qq号码：");
        String qq = input.next();

        System.out.print("这个qq号是否正确：");
        if(qq.matches("[1-9][0-9]{4,11}+")){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        input.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入qq号码：");
        String qqNumbsers = scanner.next();
        try {
            if(isCorrectedNumbers(qqNumbsers)){
                System.out.println("输入的qq号码合法。");
            }else{
                System.out.println("输入的qq号码不合法。");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
