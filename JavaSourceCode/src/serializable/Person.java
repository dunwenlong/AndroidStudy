package serializable;

import java.io.Serializable;

/**
 * @author Dun Wenlong
 * @time 2020/7/22 20:13
 */
public class Person implements Serializable {
    private String name;
    private int age;

    //我不提供无参构造器  
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
