package day0109;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 * �÷Ÿ��� �������� ����Ǵ� ���<br>
 * �÷Ÿ��� �Է¹޾� �ش� �÷������� ��ȸ
 * EMP���̺� ��ȸ �����ȣ�� �÷Ÿ�()�� �Է¹޾� ��ȸ 
 * @author SIST
 *
 */
public class DynamicColumn {

	public DynamicColumn() throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String[] columnName= {"ename","job","mgr","hiredate","sal","comm","deptno"};
		
		String input=JOptionPane.showInputDialog("�����ȣ�� �÷����ϳ��� �Է����ּ���.\n ��)�����ȣ,�÷���");
		String[] temp=input.split(",");
		
		if(temp.length !=2) {
			JOptionPane.showMessageDialog(null, "�Է������� Ȯ���ϼ���.");
			return;
		}
		try {
		int empno=Integer.parseInt(temp[0].trim());
		String inputColumn=temp[1].trim();
		
		boolean columnFlag=false;
		for(String column:columnName) {
			if(column.equals(inputColumn.toLowerCase())) {//DB���̺��� �÷���� ���� �÷����̶�� 
				columnFlag=true;
			}
		}
		if(!columnFlag) {
			JOptionPane.showMessageDialog(null, 
					inputColumn+"�� EMP���̺� �÷����� �������� �ʽ��ϴ�.");
			return;//�Ʒ��ٷ��帣�����ϰ�
		}
		try {
		//1. 
		//2.
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
		//3.
			//�÷��� hiredate�� ��� ���ڿ��� ó���ϱ� ���ؼ� to_char�Լ��� ���.
			if(inputColumn.equals("hiredate")) {
			   inputColumn="to_char(hiredate,'yyyy-mm-dd day') hiredate";
			}
			
			StringBuilder selectEmp=new StringBuilder();
			//�÷���,���̺���� bind����(select ? from emp)�� ó������ �ʴ´�. �������� ���� �־� ����Ѵ�.
			selectEmp.append("select ").append(inputColumn).append(" from emp ")
			.append(" where empno=?");//���� ����
			
			pstmt=con.prepareStatement(selectEmp.toString());
			
		//4.
//			pstmt.setString(1, inputColumn);//���ε庯���ιٲ㺸�� ->�ȵ�
			pstmt.setInt(1, empno);
		//5.
			rs=pstmt.executeQuery();
			
			if(rs.next()) {//�����ȣ�� ��ȸ�� ���ڵ尡 �����Ѵٸ�
				
				String stringData="";
				int intData=0;
				
				if(temp[1].trim().equals("ename")|| temp[1].trim().equals("job")|| temp[1].trim().equals("hiredate")) {
					stringData=rs.getString(1);//(1)=temp[1].trim()
				}else {
					intData=rs.getInt(1);
				}
				JOptionPane.showMessageDialog(null, temp[1]+"���� ��ȸ�� �� : " +(intData==0? stringData:intData));
			}else {
				JOptionPane.showMessageDialog(null,"�Է��� �����ȣ�� �������� �ʽ��ϴ�.");
			}
		}finally {
		//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "�����ȣ�� �����̾�� �մϴ�.");
		}
	}
	public static void main(String[] args) {
		try {
			new DynamicColumn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
