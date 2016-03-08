package com.zghw.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JAXPxml {
	static void f(Object object){
		System.out.println(object);
		}
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		//通过静态工厂方法创建DocumentBuilderFactory实例
		DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
		//通过工厂创建一个文档解析器
		DocumentBuilder builder=factory.newDocumentBuilder();
		//builder有parse可以解析不同来源的资源
		// 读到的xml文件是以document对象的方式保存在内存中的
		Document document=builder.parse(new File("pom-test.xml"));
		//document就像颗树 
		
		f(document.getBaseURI());
		f(document.getDocumentURI());
		document.createTextNode("testsdsd");
		addNode(document);
		removeNode(document);
		getText(document,"person");
		getText(document,"version");
		
		//listAllNode(document.getFirstChild());
		
	}
	/**
	 * 删除某节点
	 * @param document
	 */
	public static void removeNode(Document document){
		NodeList nodeList =document.getElementsByTagName("version");
		for(int i=0;i<nodeList.getLength();i++){
			if(nodeList.item(i)!=null){
				nodeList.item(i).getParentNode().removeChild(nodeList.item(i));
			}
		}
		transformer(document);
	}
	
	/**
	 * 增加一个节点
	 * @param document
	 * @throws TransformerException 
	 */
	public static void addNode(Document document) throws TransformerException{
		//创建一个元素
		Element ele1=document.createElement("person");
		//创建一个属性
		Attr attr1=document.createAttribute("name");
		//设置属性值
		attr1.setValue("zhangsan");
		//把属性加入元素中
		ele1.setAttributeNode(attr1);
		//设置元素内容
		ele1.setTextContent("i ‘m a person");
		//把元素挂在节点上
		Node person=document.getElementsByTagName("dependency").item(0);
		person.appendChild(ele1);
		transformer(document);
	}
	/**
	 * 把修改后的doucument文件写入到XML文件中
	 * @param document
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerConfigurationException
	 * @throws TransformerException
	 */
	public static void transformer(Document document)
			{
		//通过transformer方法把一个内存中的document写到文件中去 
		TransformerFactory tff=TransformerFactory.newInstance();
		Transformer tf;
		try {
			tf = tff.newTransformer();
			tf.transform(new DOMSource(document), new StreamResult(new File("pom-test.xml")));
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	/**
	 * 读取某个叶子标签的内容值
	 * @param document
	 * @param tag
	 */
	public static void getText(Document document,String tag){
		NodeList nodeList= document.getElementsByTagName(tag);
		for(int i=0;i<nodeList.getLength();i++){
			f(tag+" ="+nodeList.item(i).getTextContent());
		}
	}
	
	/**
	 * 读取所有字节点信息
	 * @param node
	 */
	public static void listAllNode(Node node){
		//f("文件地址："+node.getBaseURI());
		//f("本地名称："+node.getLocalName());
		//f("空间地址："+node.getNamespaceURI());
		f("节点名称："+node.getNodeName().trim());
		f("节点类型："+node.getNodeType());
		f("节点值："+node.getNodeValue());
		//f("节点前缀："+node.getPrefix());
		//f("节点内容"+node.getTextContent());
		NodeList nodeList= node.getChildNodes();
		for(int i=0;i<nodeList.getLength();i++){
			listAllNode(nodeList.item(i));
		}
	}
	
}
