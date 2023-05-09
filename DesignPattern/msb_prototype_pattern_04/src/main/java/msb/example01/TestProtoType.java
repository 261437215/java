package msb.example01;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Created by yinrg on 2023/5/8 21:46
 * @description 浅克隆不会克隆原对象中的引用类型，仅仅拷贝了引用类型的指向
 * <a href="https://blog.csdn.net/jeffleo/article/details/76737560">浅拷贝和深拷贝区别</a>
 */
public class TestProtoType {

    @Test
    public void test01() throws CloneNotSupportedException {
        ConcreteProtoType c1 = new ConcreteProtoType();
        ConcreteProtoType c2 = c1.clone();

        System.out.println("对象c1和对象c2是同一个对象吗?" + (c1 == c2));

    }


    /**
     * 浅拷贝
     * 两个对象中的引用数据类型是相同的，基本数据类型是不同的
     */
    @Test
    public void test02() throws CloneNotSupportedException {
        ConcreteProtoType c1 = new ConcreteProtoType();
        Person p = new Person("张三");
        c1.setPerson(p);
        ConcreteProtoType c2 = c1.clone();
        c2.getPerson().setName("张三进化为李四");

        System.out.println("对象c1和对象c2是同一个对象吗?" + (c1 == c2)); // false
        System.out.println("对象c1.person(引用数据类型)和对象c2.person(引用数据类型)是同一个对象吗?"
                + (c1.getPerson() == c2.getPerson())); // true
        c1.show();
        c2.show();
    }


    /**
     * 深拷贝
     * 两个对象中的引用数据类型和基本数据类型均不相同
     */
    @Test
    public void test03() throws CloneNotSupportedException, IOException, ClassNotFoundException {
        ConcreteProtoType c1 = new ConcreteProtoType();
        Person p = new Person("张三");
        c1.setPerson(p);


        // 创建对象序列化输出流
        Path path = Paths.get("a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path));

        // 将c1对象写到a.txt文件中
        oos.writeObject(c1);
        oos.close();

        // 创建对象序列化输入流
        ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path));

        ConcreteProtoType c2 = (ConcreteProtoType) ois.readObject();
        c2.getPerson().setName("张三进化为李四");

        System.out.println("对象c1和对象c2是同一个对象吗?" + (c1 == c2)); // false
        System.out.println("对象c1.person(引用数据类型)和对象c2.person(引用数据类型)是同一个对象吗?"
                + (c1.getPerson() == c2.getPerson())); // true
        c1.show();
        c2.show();
    }

}
