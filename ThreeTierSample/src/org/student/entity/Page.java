package org.student.entity;

import java.util.List;

//��ҳ�İ�����
public class Page {
	private int currentPage;// ��ǰҳ
	private int pageSize;// ҳ���С
	private int totalCount;// ��������
	private int totalPage;// ��ҳ��
	private List<Student> students;// ��ǰҳ�����ݼ���

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
		// �Զ�������ҳ��
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

	// ����ҳ����ֵ
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
