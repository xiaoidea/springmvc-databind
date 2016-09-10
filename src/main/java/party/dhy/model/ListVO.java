package party.dhy.model;

import java.util.List;

/**
 * @author hengyu.dai <dhytheone@163.com>
 * @date 2016/9/10 16:17
 */
public class ListVO {
    List<Integer> list;

    List<Contact> contacts;

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "ListVO{" +
                "list=" + list +
                ", contacts=" + contacts +
                '}';
    }
}
