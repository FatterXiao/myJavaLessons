package com.atguigu.day21.everydayreview_homework.exer01;

/**
 * @author Mr.Helianthus
 * @create 2021-03-30 7:20 PM
 */
public class Test {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();

        User user1 = new User(001,10,"Ming");
        User user2 = new User(002,20,"Hong");
        User user3 = new User(003,30,"Lan");
        User user4 = new User(004,40,"Hei");
        User user5 = new User(005,50,"Wang");
        User user6 = new User(006,60,"Zhao");

        dao.save(user1.getId()+"",user1);
        dao.save(user2.getId()+"",user2);
        dao.save(user3.getId()+"",user3);
        dao.save(user4.getId()+"",user4);
        dao.save(user5.getId()+"",user5);
        dao.save(user6.getId()+"",user6);

        System.out.println("保存数据：");
        System.out.println(dao.list());
        System.out.println("获取2号:");
        System.out.println(dao.get(user2.getId() + ""));

        System.out.println("删除2号：");
        dao.delete(user2.getId()+"");
        System.out.println(dao.list());

        System.out.println("更新3号：");
        dao.update("3",new User(9,32,"CaoFish"));
        System.out.println(dao.list());


    }
}
