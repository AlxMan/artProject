package com.art.bean.request;

/*
　* @Description:
　* @user wangxianchao
　* @date 2018/9/26 17:58
*/
public class UserLoginRequest {
  private String name;
  private String pwd;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  @Override
  public String toString() {
    return "UserLoginRequest{" +
        "name='" + name + '\'' +
        ", pwd='" + pwd + '\'' +
        '}';
  }
}
