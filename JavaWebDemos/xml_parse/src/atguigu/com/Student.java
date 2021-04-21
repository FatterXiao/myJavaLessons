package atguigu.com;

/**
 * @author Mr.Helianthus
 * @create 2021-04-17 10:17 AM
 */
public class Student {
    private String id;
    private String name;
    private String age;
    private String gender;
    private String address;

    public Student() {
    }

    public Student(String id, String name, String age, String gender, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
