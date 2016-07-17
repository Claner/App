package clanner.app.M.entity;

/**
 * Created by Clanner on 2016/7/1.
 */
public class LoginHelper {

    /**
     * code : 20000
     * response : {"id":"47","username":"a","nickname":"a","sex":"m","company":null,"position":null,"phone":null,"email":"1067081452@qq.com","birth":"0","ctime":"1467361812","cIP":"221.4.190.75","lasttime":"1467361812","lastIP":"221.4.190.75"}
     */

    private int code;
    /**
     * id : 47
     * username : a
     * nickname : a
     * sex : m
     * company : null
     * position : null
     * phone : null
     * email : 1067081452@qq.com
     * birth : 0
     * ctime : 1467361812
     * cIP : 221.4.190.75
     * lasttime : 1467361812
     * lastIP : 221.4.190.75
     */

    private ResponseBean response;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public static class ResponseBean {
        private String id;
        private String username;
        private String nickname;
        private String sex;
        private Object company;
        private Object position;
        private Object phone;
        private String email;
        private String birth;
        private String ctime;
        private String cIP;
        private String lasttime;
        private String lastIP;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Object getCompany() {
            return company;
        }

        public void setCompany(Object company) {
            this.company = company;
        }

        public Object getPosition() {
            return position;
        }

        public void setPosition(Object position) {
            this.position = position;
        }

        public Object getPhone() {
            return phone;
        }

        public void setPhone(Object phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getBirth() {
            return birth;
        }

        public void setBirth(String birth) {
            this.birth = birth;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getCIP() {
            return cIP;
        }

        public void setCIP(String cIP) {
            this.cIP = cIP;
        }

        public String getLasttime() {
            return lasttime;
        }

        public void setLasttime(String lasttime) {
            this.lasttime = lasttime;
        }

        public String getLastIP() {
            return lastIP;
        }

        public void setLastIP(String lastIP) {
            this.lastIP = lastIP;
        }
    }
}
