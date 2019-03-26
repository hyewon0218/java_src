package day0326;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class JtbcRssParsing {
	private static JtbcRssParsing jrp;
	
	public JtbcRssParsing() {

	}
	public static JtbcRssParsing getInstance() {
		if(jrp==null) {
			jrp=new JtbcRssParsing();
		}
		return jrp;
	}
	
	public List<RssVO> getNews(String rssName)throws IOException, JDOMException {
		List<RssVO> list=new ArrayList<>();
		
		
		//1. Builder ����
		SAXBuilder builder=new SAXBuilder();
		//2.URL�� �ܺ� �������� �����ϴ� RSS ���� ��ü ���
		Document doc=builder.build(new URL("http://fs.jtbc.joins.com/RSS/"+rssName+".xml"));
		//3.  �ֻ��� �θ� ��� ���
		Element rootNode=doc.getRootElement();//rss
		//4. �ڽ� ���(channel) ���
		Element channalNode=rootNode.getChild("channel");
		//5. ä�� ����� �ڽ� ������ ���
		Iterator<Element>someNodes=channalNode.getChildren().iterator();
		
		Element someNode=null;
		Iterator<Element> itemSubNodes=null;
		Element itemSubNode=null;
		
		RssVO rv=null;
		while(someNodes.hasNext() ) {//ä�� ����� �ڽ� ������ ��ȯ
			someNode=someNodes.next();
			if("item".equals(someNode.getName())) {
				itemSubNodes=someNode.getChildren().iterator();
				rv=new RssVO();
				while(itemSubNodes.hasNext()) {
					itemSubNode=itemSubNodes.next();
					if("title".equals(itemSubNode.getName())) {
						rv.setTitle(itemSubNode.getText());
					}
					if("link".equals(itemSubNode.getName())) {
						rv.setLink(itemSubNode.getText());
					}
					if("description".equals(itemSubNode.getName())) {
						rv.setDescription(itemSubNode.getText());
					}
					if("pubDate".equals(itemSubNode.getName())) {
						rv.setPubDate(itemSubNode.getText());
					}
				}//end while
				list.add(rv);
			}
		}//end while
		return list;
	}

}
