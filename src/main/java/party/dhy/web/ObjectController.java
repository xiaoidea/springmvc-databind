package party.dhy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import party.dhy.model.Contact;
import party.dhy.model.Person;

/**
 * 自定义类型数据绑定
 * @author hengyu.dai <dhytheone@163.com>
 * @date 2016/9/10 13:11
 */
@Controller
@RequestMapping("/object")
public class ObjectController {

    /**
     * 不含嵌套类型
     * 注意：绑定的目标bean必须有属性的setter方法！否则无法完成绑定！
     * http://localhost:8080/object/contact?email=dhytheone@163.com&phone=110
     * Contact{email='dhytheone@163.com', phone='110'}
     * @param contact
     * @return
     */
    @RequestMapping("/contact")
    @ResponseBody
    String bindObject(Contact contact) {
        return contact.toString();
    }


    /**
     * Person中嵌套Contact，神奇的是若Person类中没有Contact的getter方法，就无法完成绑定（只需要这一个getter方法）
     * http://localhost:8080/object/person?name=dhy&age=5&contact.email=dhytheone@163.com&contact.phone=110
     * Person{name='dhy', age=5, contact=Contact{email='dhytheone@163.com', phone='110'}}
     * @param person
     * @return
     */
    @RequestMapping("/person")
    @ResponseBody
    String bindNestedObject(Person person) {
        return person.toString();
    }
}
