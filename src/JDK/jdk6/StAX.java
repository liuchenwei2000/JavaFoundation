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
 * 3��StAXʾ��
 * <p>
 * StAX(JSR 173)��JDK6�г���DOM��SAX֮�����һ�ִ���XML�ĵ���API.
 * <p>
 * ��JAXP1.3(JSR 206)�����ִ���XML�ĵ��ķ�����DOM(Document Object Model)��SAX(Simple API for XML)��
 * ����JDK6�е�JAXB2��JAX-WS�����õ�StAX������StAX�����뵽JAXP���嵱����������JAXP�İ汾������1.4��
 * <p>
 * StAX��The Streaming API for XML����д��һ��������ʽ����(pull-parsing)XML�ĵ���API��
 * 
 * StAXͨ���ṩһ�ֻ����¼�������(Iterator)��API�ó���Աȥ����xml�ĵ��������̣�
 * �����������¼�������ȥ����ÿһ�������¼��������¼����Կ����ǳ����������ģ�
 * Ҳ���ǳ����ʹ����������һ�������¼�Ȼ������¼���֮���ִ�ʹ������������һ�������¼������ѭ��ֱ�������ĵ���������
 * <p>
 * SAXҲ�ǻ����¼�����xml�ĵ�����ȴ������ʽ����������������������xml�ĵ��󣬲Ų��������¼���Ȼ���Ƹ�����ȥ������Щ�¼���
 * <p>
 * DOM���õķ�ʽ�ǽ�����xml�ĵ�ӳ�䵽һ���ڴ����������Ϳ��Ժ����׵صõ����ڵ���ӽ���Լ��ֵܽڵ�����ݣ�������ĵ��ܴ󣬽�������Ӱ�����ܡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-6-28
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
	 * ��StAX�ķ�ʽ��XMLEventReader������xml�ĵ�
	 */
	private static void readXMLByStAX(String inFilePath) throws Exception {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		XMLEventReader eventReader = inputFactory.createXMLEventReader(new FileInputStream(inFilePath));
		
		StringBuffer result = new StringBuffer();
		XMLEvent event;// һ��һ����XML�����¼�
		// ����XML�����¼�
		while (eventReader.hasNext()) {
			event = eventReader.nextEvent();
			if (event.isStartElement()) { // �������������ʼ��ǣ��� <name>
				StartElement startElement = event.asStartElement();
				result.append("<");
				result.append(startElement.getName());
				if (startElement.getName().getLocalPart().equals("catalog")) {
					result.append(" id=\"");
					// ��ȡԪ���е�����ֵ
					result.append(startElement.getAttributeByName(new QName("id")).getValue());
					result.append("\"");
				}
				result.append(">");
			} else if (event.isCharacters()) { // ������������ı����� 
				result.append(event.asCharacters().getData());
			} else if (event.isEndElement()) { // ����������ǽ�����ǣ��� </name>
				result.append("</");
				result.append(event.asEndElement().getName());
				result.append(">");
			}
		}
		
		System.out.println(result);
	}

	/**
	 * ��StAX�ķ�ʽ��XMLStreamWriter�����xml�ĵ�
	 */
	private static void writeXMLByStAX(String outFilePath) throws Exception  {
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		XMLStreamWriter streamWriter = outputFactory.createXMLStreamWriter(new FileOutputStream(outFilePath));

		String lineSeparator = System.getProperty("line.separator");
		// д��Ĭ�ϵ� XML������XML�ĵ�
		streamWriter.writeStartDocument();
		streamWriter.writeCharacters(lineSeparator);
		// д��ע�͵�XML�ĵ�
		streamWriter.writeComment("testing comment");
		streamWriter.writeCharacters(lineSeparator);
		// д��һ����Ԫ��
		streamWriter.writeStartElement("catalogs");
		streamWriter.writeNamespace("mine", "http://www.oracle.com.cn");
		streamWriter.writeAttribute("owner", "oracle");
		streamWriter.writeCharacters(lineSeparator);
		// д����Ԫ��
		streamWriter.writeStartElement("http://www.oracle.com.cn", "catalog");
		streamWriter.writeAttribute("id", "001");
		streamWriter.writeCharacters("Book");
		// д����Ԫ�صĽ�����ǩ
		streamWriter.writeEndElement();
		streamWriter.writeCharacters(lineSeparator);
		// ��д��һ����Ԫ��
		streamWriter.writeStartElement("http://www.oracle.com.cn", "catalog");
		streamWriter.writeAttribute("id", "002");
		streamWriter.writeCharacters("Video");
		streamWriter.writeEndElement();
		streamWriter.writeCharacters(lineSeparator);
		// д���Ԫ�صĽ�����ǩ
		streamWriter.writeEndElement();
		streamWriter.writeCharacters(lineSeparator);
		// ���� XML�ĵ�
		streamWriter.writeEndDocument();
		streamWriter.close();
	}
}
