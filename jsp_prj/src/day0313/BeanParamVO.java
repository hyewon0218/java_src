package day0313;

import java.util.Arrays;

/**
 * HTML Form Control의 이름과 VO에 instance변수명이 반드시 같아야 한다.
 * @author SIST
 *
 */
public class BeanParamVO {
	
	private String id,pass1,name,ssn1,ssn2,gender,marrigeFlag,m_year,m_month,m_day,zipcode,addr1,addr2,greetings;
	private int b_year,b_month,b_day,age;
	private String[] interestlang;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass1() {
		return pass1;
	}
	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn1() {
		return ssn1;
	}
	public void setSsn1(String ssn1) {
		this.ssn1 = ssn1;
	}
	public String getSsn2() {
		return ssn2;
	}
	public void setSsn2(String ssn2) {
		this.ssn2 = ssn2;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMarrigeFlag() {
		return marrigeFlag;
	}
	public void setMarrigeFlag(String marrigeFlag) {
		this.marrigeFlag = marrigeFlag;
	}
	public String getM_year() {
		return m_year;
	}
	public void setM_year(String m_year) {
		this.m_year = m_year;
	}
	public String getM_month() {
		return m_month;
	}
	public void setM_month(String m_month) {
		this.m_month = m_month;
	}
	public String getM_day() {
		return m_day;
	}
	public void setM_day(String m_day) {
		this.m_day = m_day;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getGreetings() {
		return greetings;
	}
	public void setGreetings(String greetings) {
		this.greetings = greetings;
	}
	public int getB_year() {
		return b_year;
	}
	public void setB_year(int b_year) {
		this.b_year = b_year;
	}
	public int getB_month() {
		return b_month;
	}
	public void setB_month(int b_month) {
		this.b_month = b_month;
	}
	public int getB_day() {
		return b_day;
	}
	public void setB_day(int b_day) {
		this.b_day = b_day;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String[] getInterestlang() {
		return interestlang;
	}
	public void setInterestlang(String[] interestlang) {
		this.interestlang = interestlang;
	}
	@Override
	public String toString() {
		return "BeanParamVO [id=" + id + ", pass1=" + pass1 + ", name=" + name + ", ssn1=" + ssn1 + ", ssn2=" + ssn2
				+ ", gender=" + gender + ", marrigeFlag=" + marrigeFlag + ", m_year=" + m_year + ", m_month=" + m_month
				+ ", m_day=" + m_day + ", zipcode=" + zipcode + ", addr1=" + addr1 + ", addr2=" + addr2 + ", greetings="
				+ greetings + ", b_year=" + b_year + ", b_month=" + b_month + ", b_day=" + b_day + ", age=" + age
				+ ", interestlang=" + Arrays.toString(interestlang) + "]";
	}
	
	
	
}
