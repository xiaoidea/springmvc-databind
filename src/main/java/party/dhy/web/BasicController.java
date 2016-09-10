package party.dhy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 基本类型数据绑定
 * 本质上是把参数（类型是String）转换为其他基本类型，如果转换失败，报异常400
 * RequestParam最好加上，指明参数的名字
 * @author hengyu.dai <dhytheone@163.com>
 * @date 2016/9/10 12:20
 */
@Controller
@RequestMapping("/basic")
public class BasicController {

    //下面两个方法是int型数据绑定，参数必须能够转换为int，不能出现 ?param=value，而value无法转换为int的情况
    /**
     * 参数为int时，当传入的参数为null时，出现400错误
     * @param param
     * @return
     */
    @RequestMapping("/int")
    @ResponseBody
    String bindInt(@RequestParam("param") int param) {
        return "get int " + param;
    }

    /**
     * 参数为integer，允许传入的参数为null
     * http://localhost:8080/basic/integer?param=
     * get Integer null
     * @param param
     * @return
     */
    @RequestMapping("/integer")
    @ResponseBody
    String bindInteger(@RequestParam("param") Integer param) {
        return "get Integer " + param;
    }

    //float和double类型数据绑定

    /**
     * http://localhost:8080/basic/floatAndDouble?float=1.1&double=1.2
     * get float 1.1 get double 1.2
     * @param f
     * @param d
     * @return
     */
    @RequestMapping("/floatAndDouble")
    @ResponseBody
    String bindFloatAndDouble(@RequestParam("float") float f, @RequestParam("double") double d) {
        return "get float " + f + " get double " + d;
    }

    /**
     * http://localhost:8080/basic/floatAndDouble2?float=&double=1.2
     * get Float null get Double 1.2
     * @param f
     * @param d
     * @return
     */
    @RequestMapping("/floatAndDouble2")
    @ResponseBody
    String bindFloatAndDouble2(@RequestParam("float") Float f, @RequestParam("double") Double d) {
        return "get Float " + f + " get Double " + d;
    }

    //布尔数据类型绑定

    /**
     * http://localhost:8080/basic/boolean?bool=1 (传入的参数只能为1/0或true/false)
     * get boolean true
     * @param b
     * @return
     */
    @RequestMapping("/boolean")
    @ResponseBody
    String bindBoolean(@RequestParam("bool") boolean b) {
        return "get boolean " + b;
    }

    /**
     * 允许传入空参数
     * @param b
     * @return
     */
    @RequestMapping("/boolean2")
    @ResponseBody
    String bindBoolean2(@RequestParam("bool") Boolean b) {
        return "get Boolean " + b;
    }

    //最常使用的string类型数据绑定

    /**
     * http://localhost:8080/basic/string?s=got it
     * get string got it
     * @param s
     * @return
     */
    @RequestMapping("/string")
    @ResponseBody
    String bindString(@RequestParam("s") String s) {
        return "get string " + s;
    }
}
