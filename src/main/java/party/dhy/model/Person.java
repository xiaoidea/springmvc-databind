package party.dhy.model;

/**
 * @author hengyu.dai <dhytheone@163.com>
 * @date 2016/9/10 13:08
 */
public class Person {
    String name;

    Integer age;

    Contact contact;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", contact=" + contact +
                '}';
    }
}
