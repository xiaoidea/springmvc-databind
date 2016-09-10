package party.dhy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import party.dhy.model.ListVO;
import party.dhy.model.MapVO;


/**
 * 集合类型的绑定
 * @author hengyu.dai <dhytheone@163.com>
 * @date 2016/9/10 13:34
 */
@Controller
@RequestMapping("/collection")
public class CollectionController {

    // list
    /**
     * 使用新的对象把list包装起来,本质上和自定义数据类型一样
     * http://localhost:8080/collection/list1?list[0]=1&list[1]=2&contacts[0].email=dhytheone@163.com&contacts[0].phone=110&contacts[1].email=a@a&contacts[1].phone=123
     * ListVO{list=[1, 2], contacts=[Contact{email='dhytheone@163.com', phone='110'}, Contact{email='a@a', phone='123'}]}
     * @param listVO
     * @return
     */
    @RequestMapping("/list1")
    @ResponseBody
    String bindList1(ListVO listVO) {
        return listVO.toString();
    }

    //数组

    /**
     * http://localhost:8080/collection/array?array=1&array=2&array=3
     * 1 2 3
     * @param array
     * @return
     */
    @RequestMapping("/array")
    @ResponseBody
    String bindArray(Integer[] array) {
        String s = "";
        for (Integer integer : array) {
            s += integer + " ";
        }
        return s;
    }

    // map
    /**
     * http://localhost:8080/collection/map?map[name]=dhy&map[age]=10
     * MapVO{map={age=10, name=dhy}}
     * @param mapVO
     * @return
     */
    @RequestMapping("/map")
    @ResponseBody
    String bindMap(MapVO mapVO) {
        return mapVO.toString();
    }
}
