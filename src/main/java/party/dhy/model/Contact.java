package party.dhy.model;

/**
 * @author hengyu.dai <dhytheone@163.com>
 * @date 2016/9/10 13:10
 */
public class Contact {
    String email;

    String phone;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   /* public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }*/

    @Override
    public String toString() {
        return "Contact{" +
                "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
