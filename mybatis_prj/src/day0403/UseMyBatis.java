package day0403;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UseMyBatis {
	public UseMyBatis() {
	org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}
	
	public SqlSessionFactory getSessionFactory ()throws IOException {
		//1. ȯ�漳�� xml�� stream ����
		Reader reader=Resources.getResourceAsReader("day0403/mybatis_config.xml"); 
		//2. mybatis framework ����
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		//3. mybatis framework�� db������ ��ü ���(��ü�� �ϳ��� ����)
		SqlSessionFactory ssf=ssfb.build(reader);
		
		if(reader!=null) {
			reader.close();
		}
		return ssf;
	}//getSessionFactory
	
	public void insertCpDept(DeptVO dv) throws IOException, SQLException {
		//4. maybatis handler ���
		SqlSession ss=getSessionFactory().openSession();
		//5. handler�� ����Ͽ� DB�۾� ����
		int cnt= ss.insert("insertCpDept", dv );
		ss.commit();
		System.out.println("�߰� �۾�"+cnt);
	}
	
	
	
	public void selectAllDept() throws IOException {
		//4. mybatis handler ���
		SqlSession ss=getSessionFactory().openSession();
		//5. handler�� ����Ͽ� db�۾��� ����
		List<DeptDomain> list=ss.selectList("kr.co.sist.selectAllDept");
		DeptDomain dd=null;
		
		for(int i=0; i<list.size(); i++) {
			dd=list.get(i);
			System.out.println(dd.getDeptno()+"/"+dd.getDname()+"/"+dd.getLoc());
		}//end for
		//6. ����� ����� SqlSession �ݴ´�.
		ss.close();
		
	}//selectAllDept
	
	public void updateCpDept(DeptVO dv) throws IOException,SQLException {
		//4. mybatis handler ���
		SqlSession ss=getSessionFactory().openSession();
		//5. ������ ����
		int cnt=ss.update("updateCpDept",dv);
		ss.commit();
		System.out.println("���� ����"+cnt);
	}//updateCpDept
	
	public void deleteCpDept(int deptno) throws SQLException, IOException {
		//4. mybatis handler ���
		SqlSession ss=getSessionFactory().openSession();
		//5. handler ����Ͽ� ���� ����
		int cnt= ss.delete("deleteCpDept",deptno);
		ss.commit();
		
		if(cnt==1) {
			System.out.println(deptno+ "�� �μ������� �����Ͽ����ϴ�.");
		}else {
		System.out.println("�ش� �μ��� �������� �ʽ��ϴ�.");
		}//end else
	}//deleteCpDept
	
	
	public static void main(String[] args) {
		UseMyBatis umb=new UseMyBatis();
		try {
			DeptVO dv=new DeptVO(11, "SM ����", "����");
				//umb.insertCpDept(dv);
				//umb.updateCpDept(dv);
				umb.deleteCpDept(11);
				umb.selectAllDept();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
			}
	}//main
	
	
}//class
