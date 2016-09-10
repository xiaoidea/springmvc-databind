package party.dhy.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义类型转换器，将string转为date
 * @author hengyu.dai <dhytheone@163.com>
 * @date 2016/9/10 16:43
 */
public class DateConverter implements Converter<String, Date>{
    public Date convert(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
