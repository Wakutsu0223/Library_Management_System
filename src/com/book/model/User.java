package com.book.model;

/**
 * @ClassName User
 * @Author sdssy
 * @Date 2022/6/1 14:36
 * @Version 1.0
 **/
public class User {

    private int id = -1;//编号
    private String userName;//用户名
    private String password;//密码
    private String classification;//身份组
    private String name;//姓名
    private String sex;//性别
    private String classTxt;//班级
    private String college;//学院
    private String studentId;//学号
    
    static String userName_cc = "";
    static int id_cc = -1;
    
    
    public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    public User(int id) {
		super();
		// TODO Auto-generated constructor stub
		this.id = id;
	}
    

	public User(String userName, String password, String name, String sex, String classTxt,
			String college, String studentId) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.classTxt = classTxt;
		this.college = college;
		this.studentId = studentId;
	}
	
	public User(int id, String name, String sex, String classTxt, String college, String studentId) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.classTxt = classTxt;
		this.college = college;
		this.studentId = studentId;
	}

	public User(String userName, String password, String classification) {
		super();
		this.userName = userName;
		this.password = password;
		this.classification = classification;
		userName_cc = userName;
		id_cc = id;
	}

	public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    
    public String getClassification() {
        return classification;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setClassification(String classification) {
        this.classification = classification;
    }
    
    public String getUserName_cc(){
    	return userName_cc;
    }
    
    public int getId_cc() {
        return id_cc;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getClassTxt() {
		return classTxt;
	}

	public void setClassTxt(String classTxt) {
		this.classTxt = classTxt;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
    
    
}
