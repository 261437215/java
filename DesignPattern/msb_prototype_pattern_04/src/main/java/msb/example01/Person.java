package msb.example01;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Created by yinrg on 2023/5/8 22:00
 * @description
 */

@Data
public class Person implements Serializable {
    private String name;

    public Person(String name) {
        this.name = name;
    }
}
