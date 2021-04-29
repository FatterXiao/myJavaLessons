package com.atguigu.day16.part09_ppt;

public class EcmDef {
    public static void main(String[] args) {
        try {
            String param1 = args[0];
            String param2 = args[1];

            int a = Integer.parseInt(param1);
            int b = Integer.parseInt(param2);

            EcmDef ecmDef = new EcmDef();
            ecmDef.ecm(a,b);

        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        } catch (EcDefException e) {
            e.printStackTrace();
        }
    }

    public void ecm(int a,int b) throws ArithmeticException, EcDefException {
            if(a < 0 || b < 0){
                throw new EcDefException("输入类型不正确，不能输入负数");
            }
        System.out.println(" a + b = " + (a + b));
        System.out.println("a / b = " + (a / b ));
    }
}
