package com.atguigu.java3;

/**
 * 测试方法的重写（override / overwrite)
 *
 * 1. 举例：
 * class Account{ //账户
 *     private double balance = 100;//余额
 *
 *     public void withdraw(double amt){} //取钱
 * }
 *
 * class CheckingAccount extends Account{//信用卡账户
 *      private double protectedInit = 5000;//透支额度
 *
 * }
 *
 *  2.诉求：子类继承父类以后，从父类继承过来的方法不适用子类，则子类可以对父类继承来的方法进行覆盖、复写操作。
 *  那这个过程，就称为方法的重写。
 *
 *  3. 方法重写的细节：
 *   权限修饰符  返回值类型 方法名(形参列表){
 *       方法体
 *   }
 *
 *   ① 子类重写的方法的权限修饰符不小于父类被重写的方法的权限修饰符。
 *      特别的：子类不能重写父类中声明为private权限的方法。
 *   ② 返回值类型 ：
 *     如果父类被重写的方法的返回值类型为void,则子类重写的方法的返回值类型也必须为void
 *     如果父类被重写的方法的返回值类型是基本数据类型，则子类重写的方法的返回值类型必须为相同的基本数据类型
 *     如果父类被重写的方法的返回值类型是引用数据类型，则子类重写的方法的返回值类型可以与父类的方法的返回值类型相同或是其返回值类型的子类
 *   ③ 子类重写的方法的方法名、形参列表与父类被重写的方法的方法名、形参列表相同
 *   ④ 子类重写的方法的方法体一定与父类被重写的方法的方法体不同
 *
 *   总结：实际开发中，子类重写父类的方法的整体声明都相同。
 *   ###############################
 *     子父类中同名同参数的方法要么都声明为static，要么都不能声明为static（认为要重写）
 *
 *   4. 当子类重写了父类的方法之后，通过子类的对象调用此方法时，执行的是子类重写父类的方法。
 *
 * 面试题：区分方法的重载和重写？
 *
 * @author shkstart
 * @create 16:06
 */
public class OverWriteTest {
    public static void main(String[] args) {
        CheckingAccount acct = new CheckingAccount();
        acct.withdraw(300);
        System.out.println("账户余额为：" + acct.getBalance());
        System.out.println("账户透支额度为：" + acct.getProtectedInit());
    }
}

class Account{ //账户
    private double balance = 100;//余额
    public void withdraw(double amt){ //取钱  父类被重写的方法
        if(amt <= balance){
            balance -= amt;
            System.out.println("成功取出：" + amt);
        }else{
            System.out.println("取款失败");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long methodA(){
        return 0L;
    }

    public String methodB(){

        return null;
    }

}

class CheckingAccount extends Account {//信用卡账户
    private double protectedInit = 5000;//透支额度

    public void withdraw(double amt){ //子类重写的方法
        if(amt <= getBalance()){
            setBalance(getBalance() - amt);
            System.out.println("成功取出：" + amt);
        }else if(amt <= getBalance() + protectedInit){
            protectedInit -= (amt - getBalance());
            setBalance(0);
            System.out.println("使用了信用资金。成功取出：" + amt);
        }else{
            System.out.println("取款失败");
        }
    }

    public double getProtectedInit() {
        return protectedInit;
    }

    public long methodA(){
        return 0;
    }

    @Override
    public String methodB() {
        return null;
    }
}
