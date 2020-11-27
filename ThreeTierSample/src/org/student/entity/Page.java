package org.student.entity;

import java.util.List;

//分页的帮助类
public class Page {
	private int currentPage;// 当前页
	private int pageSize;// 页面大小
	private int totalCount;// 数据总数
	private int totalPage;// 总页数
	private List<Student> students;// 当前页的数据集合

	public Page() {

	}

	public Page(int currentPage, int pageSize, int totalCount, int totalPage, List<Student> students) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.students = students;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	//
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		// 自动计算总页数
		this.totalPage = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize: (this.totalCount / this.pageSize) + 1;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	// 给总页数赋值
	// public void setTotalPage(int totalPage) {
	// this.totalPage = totalPage;
	// }
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
