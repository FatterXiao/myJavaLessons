package com.atguigu.part9.coding_exers.exer01;

public class Person {
    private String name;
    private int lifeValue;

    public Person() {
        super();
    }

    public Person(String name, int lifeValue) {
        super();
        this.name = name;
        setLifeValue(lifeValue);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifeValue() {
        return lifeValue;
    }

    public void setLifeValue(int lifeValue) {
        if(lifeValue < 0){
            throw new NoLifeValueException("生命值不能为负数: "+ lifeValue);
        }
        this.lifeValue = lifeValue;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lifeValue=" + lifeValue +
                '}';
    }
}
