package party.dhy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import party.dhy.model.Person;

import java.util.Date;

/**
 * 使用converter将参数转换为指定类型，再绑定
 * @author hengyu.dai <dhytheone@163.com>
 * @date 2016/9/10 16:55
 */
@RequestMapping("/converter")
@Controller
public class ConverterController {

    /**
     * http://localhost:8080/converter/date?date=2016-09-10 16:58:00
     * get date: Sat Sep 10 16:58:00 CST 2016
     * @param date
     * @return
     */
    @RequestMapping("/date")
    @ResponseBody
    String dateBind(@RequestParam("date") Date date) {
        return "get date: " + date.toString();
    }

    /**
     * http://localhost:8080/converter/person?person=dhy|15|dhytheone@163.com|110
     * get person: Person{name='dhy', age=15, contact=Contact{email='dhytheone@163.com', phone='110'}}
     * @param person
     * @return
     */
    @RequestMapping("/person")
    @ResponseBody
    String personBind(@RequestParam("person") Person person) {
        return "get person: " + person.toString();
    }
}
