package clanner.app.M;

/**
* Created by Clanner on 2016/7/1.
        */
public class UrlTools {
    /**
     * 返回1表示用户名和密码不能为空
     * 返回2表示用户名或密码错误
     * 返回3表示请求失败
     */
    public static final int ERRORCODE_CONTENT_EMPTY = 1;
    public static final int ERRORCODE_CONTENT_WRONG = 2;
    public static final int ERRORCODE_REQUEST_FAILURE = 3;

    public static final String BASE_URL = "http://119.29.61.123/LightMeeting";
    public static final String LOGIN_URL = BASE_URL+"/home/member/login";
}