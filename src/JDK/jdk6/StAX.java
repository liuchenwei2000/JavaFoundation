/**
 * 
 */
package jdk6;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * 3，StAX示例
 * <p>
 * StAX(JSR 173)是JDK6中除了DOM和SAX之外的又一种处理XML文档的API.
 * <p>
 * 在JAXP1.3(JSR 206)有两种处理XML文档的方法：DOM(Document Object Model)和SAX(Simple API for XML)。
 * 由于JDK6中的JAXB2和JAX-WS都会用到StAX，所以StAX被加入到JAXP家族当中来，并将JAXP的版本升级到1.4。
 * <p>
 * StAX是The Streaming API for XML的缩写，一种利用拉式解析(pull-parsing)XML文档的API。
 * 
 * StAX通过提供一种基于事件迭代器(Iterator)的API让程序员去控制xml文档解析过程，
 * 程序遍历这个事件迭代器去处理每一个解析事件，解析事件可以看做是程序拉出来的，
 * 也就是程序促使解析器产生一个解析事件然后处理该事件，之后又促使解析器产生下一个解析事件，如此循环直到碰到文档结束符。
 * <p>
 * SAX也是基于事件处理xml文档，但却是用推式解析，解析器解析完整个xml文档后，才产生解析事件，然后推给程序去处理这些事件。
 * <p>
 * DOM采用的方式是将整个xml文档映射到一颗内存树，这样就可以很容易地得到父节点和子结点以及兄弟节点的数据，但如果文档很大，将会严重影响性能。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-28
 */
public class StAX {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String inFilePath = "files/jdk6/stax_in.xml";
		String outFilePath = "files/jdk6/stax_out.xml";
		try {
			readXMLByStAX(inFilePath);
			writeXMLByStAX(outFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 用StAX的方式（XMLEventReader）解析xml文档
	 */
	private static void readXMLByStAX(String inFilePath) throws Exception {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		XMLEventReader eventReader = inputFactory.createXMLEventReader(new FileInputStream(inFilePath));
		
		StringBuffer result = new StringBuffer();
		XMLEvent event;// 一个一个的XML解析事件
		// 遍历XML解析事件
		while (eventReader.hasNext()) {
			event = eventReader.nextEvent();
			if (event.isStartElement()) { // 如果解析的是起始标记，即 <name>
				StartElement startElement = event.asStartElement();
				result.append("<");
				result.append(startElement.getName());
				if (startElement.getName().getLocalPart().equals("catalog")) {
					result.append(" id=\"");
					// 获取元素中的属性值
					result.append(startElement.getAttributeByName(new QName("id")).getValue());
					result.append("\"");
				}
				result.append(">");
			} else if (event.isCharacters()) { // 如果解析的是文本内容 
				result.append(event.asCharacters().getData());
			} else if (event.isEndElement()) { // 如果解析的是结束标记，即 </name>
				result.append("</");
				result.append(event.asEndElement().getName());
				result.append(">");
			}
		}
		
		System.out.println(result);
	}

	/**
	 * 用StAX的方式（XMLStreamWriter）输出xml文档
	 */
	private static void writeXMLByStAX(String outFilePath) throws Exception  {
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		XMLStreamWriter streamWriter = outputFactory.createXMLStreamWriter(new FileOutputStream(outFilePath));

		String lineSeparator = System.getProperty("line.separator");
		// 写入默认的 XML声明到XML文档
		streamWriter.writeStartDocument();
		streamWriter.writeCharacters(lineSeparator);
		// 写入注释到XML文档
		streamWriter.writeComment("testing comment");
		streamWriter.writeCharacters(lineSeparator);
		// 写入一个根元素
		streamWriter.writeStartElement("catalogs");
		streamWriter.writeNamespace("mine", "http://www.oracle.com.cn");
		streamWriter.writeAttribute("owner", "oracle");
		streamWriter.writeCharacters(lineSeparator);
		// 写入子元素
		streamWriter.writeStartElement("http://www.oracle.com.cn", "catalog");
		streamWriter.writeAttribute("id", "001");
		streamWriter.writeCharacters("Book");
		// 写入子元素的结束标签
		streamWriter.writeEndElement();
		streamWriter.writeCharacters(lineSeparator);
		// 再写入一个子元素
		streamWriter.writeStartElement("http://www.oracle.com.cn", "catalog");
		streamWriter.writeAttribute("id", "002");
		streamWriter.writeCharacters("Video");
		streamWriter.writeEndElement();
		streamWriter.writeCharacters(lineSeparator);
		// 写入跟元素的结束标签
		streamWriter.writeEndElement();
		streamWriter.writeCharacters(lineSeparator);
		// 结束 XML文档
		streamWriter.writeEndDocument();
		streamWriter.close();
	}
}
