package com.atguigu.exer3;

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


}

class CheckingAccount extends Account {//信用卡账户
    private double protectedInit = 5000;//透支额度

    public void withdraw(double amt){ //子类重写的方法
        if(amt <= getBalance()){
            super.withdraw(amt);
            System.out.println("成功取出：" + amt);
        }else if(amt <= getBalance() + protectedInit){
            protectedInit -= (amt - getBalance());
            super.withdraw(getBalance());
            System.out.println("使用了信用资金。成功取出：" + amt);
        }else{
            System.out.println("取款失败");
        }
    }

    public double getProtectedInit() {
        return protectedInit;
    }

}
