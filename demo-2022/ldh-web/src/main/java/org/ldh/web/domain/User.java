package org.ldh.web.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    /**
     * 用户ID
     */


    private Long id;

    /**
     * 用户身份证ID
     */


    private String idCard;

    /**
     * 用户账号
     */

    private String userAcct;

    /**
     * 用户姓名
     */

    private String userName;

    /**
     * 拼音
     */

    private String userPinyin;

    /**
     * 手机号码
     */
    private String userMobnum;

    /**
     * 短信通知号码
     */
    private String phoneSms;

    /**
     * 邮箱
     */
    private String userEmail;


    /**
     * 用户状态(用户状态(0：离职；1：在职；2：锁定) 对应大运(D：删除；N：正常；L：锁定))
     */
    private String userSts;


    /**
     * 用户座机
     */

    private String userTelnum;

    /**
     * 记录标志(0删除;1有效;)
     */

    private String recFlag;

    /**
     * 所属部门
     */

    private Long theDept;

    /**
     * 用户状态(0：汽运；1：分拨；2：网点,后续可扩展)
     */
    private String userType;

}