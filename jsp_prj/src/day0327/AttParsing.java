package day0327;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class AttParsing {
	
	public List<AttVO> personData(String lastName) throws MalformedURLException, JDOMException, IOException {
		List<AttVO> list=new ArrayList<AttVO>();
		
		//1. Builder ����(Parser)
		SAXBuilder builder=new SAXBuilder();
		//2. xml�� �о�鿩 ��ü ����
		Document doc=builder.build(new URL("http://localhost:8080/jsp_prj/xml0327/att.xml"));
		//3. �ֻ��� �θ���(persons) ���
		Element rootNode=doc.getRootElement();
		//4. ó�� �ڽĳ���(person) ���
		Iterator<Element> personNodes=rootNode.getChildren().iterator();
		//5. �� ��� person node�� �ݺ�
		Element personNode=null;
		Attribute lastAtt=null;//lastName �Ӽ��� ����
		Attribute cityAtt=null;//city�Ӽ��� ����
		Attribute zipcodeAtt=null;//zipcode �Ӽ��� ����
		String lastNameAtt="";
		
		Iterator<Element> personSubNodes=null; 
		Element someNode=null;//person�� �ڽ� ���� �ޱ� name
		
		AttVO avo=null;
		
		while(personNodes.hasNext()) {//personNodes��� �ݺ�
			personNode=personNodes.next();//�ݺ����� personNode �ϳ� ���
			//person�� �ڽĳ��� ���(name,address)
			personSubNodes=personNode.getChildren().iterator();
			//�Էµ� ������ ���� �����ؾ��ϹǷ� ������ �ִ� nameNode�� ��
			while(personSubNodes.hasNext()) {
				someNode=personSubNodes.next();//name,add
				if("name".equals(someNode.getName())) {
					lastAtt=someNode.getAttribute("lastName");//
					lastNameAtt=lastAtt.getValue();//�Ӽ� �� ���
					
					if(lastName.equals(lastNameAtt)) {//�达�� ����
						avo=new AttVO();//���� ������ vo����
						avo.setLastName(lastNameAtt);
						avo.setFirstName(someNode.getValue());
					}
				}//end if

				if(lastName.equals(lastNameAtt)) {//�Ű������� �Էµ� ������ ���� ��
					if("address".equals(someNode.getName())) {//address ��� ���
						cityAtt=someNode.getAttribute("city");//���üӼ�
						zipcodeAtt=someNode.getAttribute("zipcode");//zipcode�Ӽ����
						
						avo.setCity(cityAtt.getValue());//������ vo�� city�� 
						avo.setZipcode(zipcodeAtt.getValue());//address��
						avo.setAddress(someNode.getText());//�������ǰ� �߰�
						list.add(avo);//������ġ������ parsing�� ��ü�� list�� �߰�
					}//end if
				}//end if
			}//end while
		}//end while
		System.out.println(list);
		return list;
	}
		

	public static void main(String[] args) {
		AttParsing a=new AttParsing();
		try {
			System.out.println( a.personData("��"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main

}//class
