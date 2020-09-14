package com.bit.sts03.emp.model.entity;

import java.sql.Timestamp;

public class Emp03Vo {

	private int sabun;
	private String name;
	private Timestamp nalja;
	private int deptno,pay;
	
	public Emp03Vo() {
	}

	public Emp03Vo(int sabun, String name, Timestamp nalja, int deptno, int pay) {
		super();
		this.sabun = sabun;
		this.name = name;
		this.nalja = nalja;
		this.deptno = deptno;
		this.pay = pay;
	}

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getNalja() {
		return nalja;
	}

	public void setNalja(Timestamp nalja) {
		this.nalja = nalja;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptno;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pay;
		result = prime * result + sabun;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp03Vo other = (Emp03Vo) obj;
		if (deptno != other.deptno)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pay != other.pay)
			return false;
		if (sabun != other.sabun)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emp03Vo [sabun=" + sabun + ", name=" + name + ", nalja=" + nalja + ", deptno=" + deptno + ", pay=" + pay
				+ "]";
	}
	
	
}
