package party.dhy.model;

import java.util.Map;

/**
 * @author hengyu.dai <dhytheone@163.com>
 * @date 2016/9/10 16:37
 */
public class MapVO {
    Map<String, String> map;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "MapVO{" +
                "map=" + map +
                '}';
    }
}
