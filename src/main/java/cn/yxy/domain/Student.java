package cn.yxy.domain;

public class Student {
	private long id;
	private long createAt;
	private long updateAt;
	private String name;
	private long sno;// 线上学号
	private String moreInfo;
	private int periods;
	private String city;// 不用enum，试试其他方法限制值
	private Course course;
	private boolean passed;

	public Student() {
	}

	public Student(long id, long createAt, long updateAt, String name, long sno, String moreInfo, int periods,
			String city, Course course, boolean passed) {
		super();
		this.id = id;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.name = name;
		this.sno = sno;
		this.moreInfo = moreInfo;
		this.periods = periods;
		this.city = city;
		this.course = course;
		this.passed = passed;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", createAt=" + createAt + ", updateAt=" + updateAt + ", name=" + name + ", sno="
				+ sno + ", moreInfo=" + moreInfo + ", periods=" + periods + ", city=" + city + ", course=" + course
				+ ", passed=" + passed + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSno() {
		return sno;
	}

	public void setSno(long sno) {
		this.sno = sno;
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

	public long getid() {
		return id;
	}

	public void setid(long id) {
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
