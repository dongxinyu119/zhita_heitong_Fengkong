package com.zhita.Model;

//申请人基本信息表
public class ApplierInfo {
    private Integer id;

    private Integer xiaodaiUserid;//用户id

    private String name;//姓名

    private String gender;//性别

    private Integer age;//年龄

    private String phoneNumber;//手机号

    private String phoneMark;//号码标记

    private String idcard;//身份证号

    private String idcardLocation;//身份证归属地

    private String homeTelephoneNumber;//家庭号码

    private String homeAddress;//家庭住址

    private String homeFormattedAddress;//居住地在地图中定位后的输出地址

    private String homeLevel;//匹配水平

    private String homeLatitude;//定位经度

    private String homeLongitude;//定位纬度

    private String companyTelephoneNumber;//工作单位联系号码

    private String companyAddress;//工作单位地址

    private String companyFormattedAddress;//工作地在地 

    private String companyLevel;//匹配水平

    private String companyLatitude;//定位经度

    private String companyLongitude;//定位纬度

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getXiaodaiUserid() {
        return xiaodaiUserid;
    }

    public void setXiaodaiUserid(Integer xiaodaiUserid) {
        this.xiaodaiUserid = xiaodaiUserid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getPhoneMark() {
        return phoneMark;
    }

    public void setPhoneMark(String phoneMark) {
        this.phoneMark = phoneMark == null ? null : phoneMark.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getIdcardLocation() {
        return idcardLocation;
    }

    public void setIdcardLocation(String idcardLocation) {
        this.idcardLocation = idcardLocation == null ? null : idcardLocation.trim();
    }

    public String getHomeTelephoneNumber() {
        return homeTelephoneNumber;
    }

    public void setHomeTelephoneNumber(String homeTelephoneNumber) {
        this.homeTelephoneNumber = homeTelephoneNumber == null ? null : homeTelephoneNumber.trim();
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress == null ? null : homeAddress.trim();
    }

    public String getHomeFormattedAddress() {
        return homeFormattedAddress;
    }

    public void setHomeFormattedAddress(String homeFormattedAddress) {
        this.homeFormattedAddress = homeFormattedAddress == null ? null : homeFormattedAddress.trim();
    }

    public String getHomeLevel() {
        return homeLevel;
    }

    public void setHomeLevel(String homeLevel) {
        this.homeLevel = homeLevel == null ? null : homeLevel.trim();
    }

    public String getHomeLatitude() {
        return homeLatitude;
    }

    public void setHomeLatitude(String homeLatitude) {
        this.homeLatitude = homeLatitude == null ? null : homeLatitude.trim();
    }

    public String getHomeLongitude() {
        return homeLongitude;
    }

    public void setHomeLongitude(String homeLongitude) {
        this.homeLongitude = homeLongitude == null ? null : homeLongitude.trim();
    }

    public String getCompanyTelephoneNumber() {
        return companyTelephoneNumber;
    }

    public void setCompanyTelephoneNumber(String companyTelephoneNumber) {
        this.companyTelephoneNumber = companyTelephoneNumber == null ? null : companyTelephoneNumber.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public String getCompanyFormattedAddress() {
        return companyFormattedAddress;
    }

    public void setCompanyFormattedAddress(String companyFormattedAddress) {
        this.companyFormattedAddress = companyFormattedAddress == null ? null : companyFormattedAddress.trim();
    }

    public String getCompanyLevel() {
        return companyLevel;
    }

    public void setCompanyLevel(String companyLevel) {
        this.companyLevel = companyLevel == null ? null : companyLevel.trim();
    }

    public String getCompanyLatitude() {
        return companyLatitude;
    }

    public void setCompanyLatitude(String companyLatitude) {
        this.companyLatitude = companyLatitude == null ? null : companyLatitude.trim();
    }

    public String getCompanyLongitude() {
        return companyLongitude;
    }

    public void setCompanyLongitude(String companyLongitude) {
        this.companyLongitude = companyLongitude == null ? null : companyLongitude.trim();
    }
}