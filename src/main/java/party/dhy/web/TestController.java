package party.dhy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import party.dhy.model.Contact;
import party.dhy.model.Person;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author hengyu.dai <dhytheone@163.com>
 * @date 2016/9/10 17:50
 */
@RequestMapping("/test")
@Controller
public class TestController {
    //测试REST风格URL

    /**
     * http://localhost:8080/test/rest/dhy
     * get name: dhy
     * @param name
     * @return
     */
    @RequestMapping("/rest/{name}")
    @ResponseBody
    String rest(@PathVariable("name") String name) {
        return "get name: " + name;
    }

    //测试CookieValue
    /**
     * 种下cookie
     * @param response
     * @return
     */
    @RequestMapping("/cookie")
    @ResponseBody
    String addCookie(@RequestParam("name")String name,  HttpServletResponse response) {
        Cookie cookie = new Cookie("name", name);
        response.addCookie(cookie);
        return "add cookie " + cookie;
    }

    /**
     * 通过CookieValue拿到cookie
     * http://localhost:8080/test/getCookie
     * get cookie name: dhy
     * @param name
     * @return
     */
    @RequestMapping("/getCookie")
    @ResponseBody
    String getCookie(@CookieValue("name") String name) {
        return "get cookie name: " + name;
    }


    //测试RequestHeader

    /**
     * 通过@RequestHeader拿到请求头信息，这些信息也可以通过HttpServletRequest拿到
     * http://localhost:8080/test/header
     * host: localhost:8080
     * Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp
     * ...
     */
    @RequestMapping("/header")
    @ResponseBody
    String requestHeader(@RequestHeader("host") String host,
                         @RequestHeader("Accept") String accept,
                         @RequestHeader("Accept-Language") String lang,
                         @RequestHeader("Accept-Encoding") String encoding,
                         @RequestHeader("Cache-Control") String cache,
                         @RequestHeader("Cookie") String cookie,
                         @RequestHeader("User-Agent") String agent) {
        return "host: " + host + "<br>"
                + "Accept: " + accept + "<br>"
                + "Accept-Language: " + lang + "<br>"
                + "Accept-Encoding: " + encoding + "<br>"
                + "Cache-Control: " + cache + "<br>"
                + "Cookie: " + cookie + "<br>"
                + "User-Agent: " + agent;
    }

    //测试ModelAttribute,下面两个方法作用一样，都能将contact自动加入返回的model中，jsp页面可以获得这个model

    /**
     * 当把ModelAttribute注解标注在参数上时，自动将参数的对象加入返回的model中
     * http://localhost:8080/test/modelAttribute?email=dhy@163.com&phone=110
     * jsp页面： Contact{email='dhy@163.com', phone='110'}
     * @param contact
     * @return
     */
    @RequestMapping("/modelAttribute")
    ModelAndView modelAttribute(@ModelAttribute("contact")Contact contact) {
        ModelAndView modelAndView = new ModelAndView("test");
        return modelAndView;
    }

    @RequestMapping("/modelAttribute2")
    String modelAttribute2(@ModelAttribute("contact")Contact contact) {
        return "test";
    }

    /**
     * 返回的model加入由ModelAttribute标注的方法返回的对象
     * http://localhost:8080/test/modelAttribute3
     * Person{name='dhy', age=15, contact=Contact{email='dhytheone@163.com', phone='110'}}
     * @return
     */
    @RequestMapping("/modelAttribute3")
    String modelAttribute3() {
        return "test";
    }

    /**
     * 当ModelAttribute注解标注在方法（非请求的处理方法）上时，所有请求返回的model都会带上该方法的返回对象
     * @return
     */
    @ModelAttribute
    Person getPerson() {
        Contact contact = new Contact();
        contact.setPhone("110");
        contact.setEmail("dhytheone@163.com");

        Person person = new Person();
        person.setName("dhy");
        person.setAge(15);
        person.setContact(contact);

        return person;
    }

    //测试SessionAttributes

    /**
     * 向session中加入attribute
     * http://localhost:8080/test/session/add
     * add session attribute id = 1
     * @param request
     * @return
     */
    @RequestMapping("/session/add")
    @ResponseBody
    String addSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("id", 1);
        return "add session attribute id = 1";
    }

    /**
     * 使用@SessionAttributes从session中取出属性
     * http://localhost:8080/test/session/get
     * get id from Session: 1
     * @param id
     * @return
     */
    @RequestMapping("/session/get")
    @ResponseBody
    String getSession(@SessionAttribute("id") Integer id) {
        return "get id from Session: " + id;
    }

    //测试@RequestBody

    /**
     * 需要在spring配置文件中配置messageConverter
     * 需要引入jackson包
     * 作用是把json形式的参数绑定到对象上，不推荐使用。
     * contentType为json/application，method为POST，参数为json
     * 常用于ajax发送的请求
     * @param contact
     * @return
     */
    @RequestMapping("/requestBody")
    @ResponseBody
    String requestBody(@RequestBody Contact contact) {
        return contact.toString();
    }
}
