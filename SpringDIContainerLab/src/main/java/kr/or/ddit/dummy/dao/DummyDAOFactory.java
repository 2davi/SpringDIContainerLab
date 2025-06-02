package kr.or.ddit.dummy.dao;

public class DummyDAOFactory {
	public static DummyDAO getDummyDAO() {
		return new DummyDAOImpl_MariaDB();
	}
}
