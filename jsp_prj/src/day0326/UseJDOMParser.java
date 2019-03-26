package day0326;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;



/**
 * JDOM ���
 * @author SIST
 *
 */
public class UseJDOMParser {

	public UseJDOMParser() throws JDOMException, IOException {
		//1. Paser����
		SAXBuilder builder=new SAXBuilder();
		//2. xml������ ��ü�� ����
		//local
			//Document doc=builder.build(new File("C:/dev/workspace/jsp_prj/WebContent/xml0326/names.xml"));
		//web server	
		Document doc=builder.build(new URL("http://localhost:8080/jsp_prj/xml0326/names.xml"));
		//3. ���� ��ü���� �ֻ��� �θ��� ���
		Element rootNode=doc.getRootElement();
		//4. �θ����� �ڽ� ��� ���
		Iterator<Element> namesNode=rootNode.getChildren().iterator();
		//�ڽĳ�� ��ȯ
		Element nameNode=null;
		while(namesNode.hasNext()) {
			//�ڽ� ��� ���
			nameNode=namesNode.next();
			System.out.println("���� : "+nameNode.getName());
			System.out.println("��尪 : "+nameNode.getText());
		}
		
	}//UseJDOMParser
	
	public static void main(String[] args) {
		try {
			new UseJDOMParser();
	} catch (JDOMException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
		

	}//main

}//class
