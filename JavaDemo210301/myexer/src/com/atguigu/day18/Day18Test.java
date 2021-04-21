package com.atguigu.day18;

class Season{
    private final String seasonName;
    private final String seasonDescription;
    private Season(String seasonName,String seasonDescription){
        this.seasonName = seasonName;
        this.seasonDescription = seasonDescription;
    }
    public static final Season SPRING = new Season("chuantian","chuantianDemiaoshu");
    public static final Season SUNMMER = new Season("xiatian","xiatianDemiaoshu");
    public static final Season AUTUMN = new Season("qiutian","qiutianDemiaoshu");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDescription() {
        return seasonDescription;
    }
}
enum EnumSeason{
    SPRING("春天","春天的描述"),
    SUNMMER("夏天","夏天的描述"),
    AUTUMN("秋天","秋天的描述");
    private final String seasonName;
    private final String seasnonDescription;

    private EnumSeason(String seasonName, String seasnonDescription) {
        this.seasonName = seasonName;
        this.seasnonDescription = seasnonDescription;
    }
    public String getSeasonName(){
        return this.seasonName;
    }
}
// Test
public class Day18Test {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring.getSeasonDescription());

        EnumSeason summber = EnumSeason.SUNMMER;
        System.out.println(summber.getSeasonName());
    }
}
