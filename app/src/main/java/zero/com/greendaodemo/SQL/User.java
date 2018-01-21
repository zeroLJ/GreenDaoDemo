package zero.com.greendaodemo.SQL;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zero on 2018/1/8.
 */

@Entity
public class User extends BaseEntity {
    @Unique
    @Id(autoincrement =true)
    private Long id;
    @NotNull
    private String name;
    private int age;
    private int sex;
    private String country;



    //以下为自动生成的代码
    @Generated(hash = 818648874)
    public User(Long id, @NotNull String name, int age, int sex, String country) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.country = country;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getSex() {
        return this.sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public String getCountry() {
        return this.country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}
