package cn.yxy.domain;

import java.util.Date;

public class AutoLogins {
	private Integer id;

	private String username;

	private String series;

	private String token;

	private Date validtime;

	public Integer getid() {
		return id;
	}

	public void setid(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series == null ? null : series.trim();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token == null ? null : token.trim();
	}

	public Date getValidtime() {
		return validtime;
	}

	public void setValidtime(Date validtime) {
		this.validtime = validtime;
	}
}