package com.art.bean.response;

/*
　* @Description:
　* @user wangxianchao
　* @date 2018/9/26 17:59
*/
public class UserLoginResponse extends CommonResponse {
  private String name;
  private Integer userState;
  private Integer userType;
  private String jwt;

  public String getJwt() {
    return jwt;
  }

  public void setJwt(String jwt) {
    this.jwt = jwt;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getUserState() {
    return userState;
  }

  public void setUserState(Integer userState) {
    this.userState = userState;
  }

  public Integer getUserType() {
    return userType;
  }

  public void setUserType(Integer userType) {
    this.userType = userType;
  }

  @Override
  public String toString() {
    return "UserLoginResponse{" +
        "name='" + name + '\'' +
        ", userState=" + userState +
        ", userType=" + userType +
        ", jwt='" + jwt + '\'' +
        '}';
  }
}
