package party.dhy.converter;

import com.google.common.base.Splitter;
import org.springframework.core.convert.converter.Converter;
import party.dhy.model.Contact;
import party.dhy.model.Person;

import java.util.List;

/**
 * 将一个string转换为person对象
 * string 形如: dhy|15|dhytheone@163.com|110
 * @author hengyu.dai <dhytheone@163.com>
 * @date 2016/9/10 16:45
 */
public class PersonConverter implements Converter<String, Person> {
    public Person convert(String s) {
        List<String> list = Splitter.on("|").splitToList(s);

        Contact contact = new Contact();
        contact.setEmail(list.get(2));
        contact.setPhone(list.get(3));

        Person person = new Person();
        person.setName(list.get(0));
        person.setAge(Integer.valueOf(list.get(1)));
        person.setContact(contact);

        return person;
    }
}
