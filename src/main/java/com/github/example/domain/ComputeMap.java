package com.github.example.domain;

public class ComputeMap extends BaseDomain {

	private static final long serialVersionUID = 1L;
	private int cid;
	private int compute;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCompute() {
		return compute;
	}

	public void setCompute(int compute) {
		this.compute = compute;
	}
}
