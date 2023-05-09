package msb.example01;

import java.io.Serializable;

/**
 * @author Created by yinrg on 2023/5/8 21:40
 * @description 具体原型类
 * 实现Cloneable接口,表示当前类对象可复制
 */
public class ConcreteProtoType implements Cloneable, Serializable {


    private Person person;

    public ConcreteProtoType() {
        System.out.println("具体的原型对象构造成功!");
    }

    public void show() {
        System.out.println("person对象中的name属性值为:" + person.getName());
    }

    @Override
    protected ConcreteProtoType clone() throws CloneNotSupportedException {
        System.out.println("克隆对象复制成功!");
        return (ConcreteProtoType) super.clone();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
