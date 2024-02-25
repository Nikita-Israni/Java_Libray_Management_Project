package com.libraryManagment.demo.entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name="members")
public class Members {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="memberid")
	    private Integer memberid;
		 @Column(name="name")
		private String name;
		 @Column(name="gender")
		private String gender;
		 @Column(name="age")
		private Integer age;
		 @Column(name="mobileno")
		private String mobileno;
		 @Column(name="joiningyear")
		private Integer joiningyear;
		public Integer getMemberid() {
			return memberid;
		}
		public void setMemberid(Integer memberid) {
			this.memberid = memberid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getMobileno() {
			return mobileno;
		}
		public void setMobileno(String mobileno) {
			this.mobileno = mobileno;
		}
		public Integer getJoiningyear() {
			return joiningyear;
		}
		public void setJoiningyear(Integer joiningyear) {
			this.joiningyear = joiningyear;
		}


}
