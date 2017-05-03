package cn.yxy.data_object;

public class StudentDO {
	private long id;
	private long createAt;
	private long updateAt;
	private String name;
	private String moreInfo;
	private int periods;
	private String city;//不用enum，试试其他方法限制值
	private Course course;
	private boolean passed;
	
	public StudentDO(){
		this.createAt=System.currentTimeMillis();
		this.name="";
		this.periods=(int)(Math.random()*1000);
		this.city="wuhai";
		this.course=Course.JAVA;
		this.passed=false;
	}
	public StudentDO(int rLevel){
		//TODO random generate student object
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMoreInfo() {
		return moreInfo;
	}
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
	public int getPeriods() {
		return periods;
	}
	public void setPeriods(int periods) {
		this.periods = periods;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public boolean isPassed() {
		return passed;
	}
	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCreateAt() {
		return createAt;
	}
	public void setCreateAt(long createAt) {
		this.createAt = createAt;
	}
	public long getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(long updateAt) {
		this.updateAt = updateAt;
	}
	
}
