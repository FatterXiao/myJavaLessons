package com.atguigu.day12.part07doc.doc01;

/**
 * 可透支的账户
 * - 提示：
 *  - 子类CheckAccount的构造方法需要将从父类继承的3个属性和子类自己的属性全部初始化
 *  - 父类Account的属性balance被设置为private，但在子类CheckAccount的withdraw方法中需要修改它的值，
 *    因此应修改父类的balance属性，定义其为protected
 */
public class CheckAccount extends Account{
    private double overdraft;


    public CheckAccount(int id, double balance, double annuallnterestRate, double overdraft) {
        super(id, balance, annuallnterestRate);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    @Override
    public void withdraw(double amount) {
        if(amount <= super.getBalance()){
            super.withdraw(amount);
            return;
        }

        // 取款金额>账户余额
        double overdrawMoney  = amount - super.getBalance();
        if(overdrawMoney > this.overdraft){
            System.out.println("已经超过透支金额，无法取款。");
            return;
        }

        this.overdraft -= overdrawMoney;
        super.setBalance(0);

    }

    @Override
    public String toString() {
        return "CheckAccount{" +
                "账户余额 =" + super.getBalance() + "," +
                "可透支余额 =" + overdraft +
                '}';
    }
}
