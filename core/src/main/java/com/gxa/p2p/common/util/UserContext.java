package com.gxa.p2p.common.util;

import com.gxa.p2p.common.domain.Account;
import com.gxa.p2p.common.domain.Logininfo;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.vo.VerifyCodeVO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserContext {
    public static final String USER_IN_SESSION = "logininfo";

    public static final String ACCOUNT_IN_SESSION = "account";

    public static final String USERINFO_IN_SESSION="userinfo";


    /**
     * web.xml 中提前配置 RequestContextListener 监听
     *
     * 通过 RequestContextHolder 获取 session
     *
     * @return session
     */
    private static HttpSession getSession() {
        ServletRequestAttributes threadAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = threadAttributes.getRequest();
        HttpSession session = request.getSession();
        return session;
    }

    public static void putLoginInfo(Logininfo loginInfo) {
        // 得到session,并把current放到session中
        /*session存的是对象，里面存了在数据库里面查询的所有信息,可以使用getter方法输出信息*/
        getSession().setAttribute(USER_IN_SESSION, loginInfo);
    }

    public static Logininfo getLoginInfo() {
        return (Logininfo) getSession().getAttribute(USER_IN_SESSION);
    }

    public static final String VERIFYCODE_IN_SESSION = "verifyCodeVO_in_session";

    /*
     * 得到session,并把verifyCodeVO存放到session中
     */
    public static void putVerifyCode(VerifyCodeVO verifyCodeVO) {
        getSession().setAttribute(VERIFYCODE_IN_SESSION, verifyCodeVO);
    }

    /*
     * 取出session中的verifyCodeVO
     */
    public static VerifyCodeVO getVerifyCode() {
        VerifyCodeVO verifyCodeVO = (VerifyCodeVO) getSession().getAttribute(VERIFYCODE_IN_SESSION);
        return verifyCodeVO;
    }

}
