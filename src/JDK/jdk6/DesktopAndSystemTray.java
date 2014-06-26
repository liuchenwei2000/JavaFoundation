/**
 * 
 */
package jdk6;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Desktop��SystemTray��ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-6-26
 */
public class DesktopAndSystemTray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Workbentch().starts();
	}
	
	/**
	 * ����̨
	 */
	private static class Workbentch {
		
		/** �������ҳ */
		private static final String HOME_PAGE = "http://www.baidu.com";
		/** �ʼ����͵�ַ */
		private static final String MAIL_ADDRESS = "liuchenwei2000@163.com";
		
		/**
		 * Desktop ������ Java Ӧ�ó����������ڱ���������ע��Ĺ���Ӧ�ó����Դ��� URI ���ļ��� 
		 * <p>
		 * ֧�ֵĲ��������� 
		 * �����û�Ĭ�����������ʾָ���� URI�� 
		 * �������п�ѡ mailto URI ���û�Ĭ���ʼ��ͻ��ˣ� 
		 * ������ע���Ӧ�ó����Դ򿪡��༭���ӡָ�����ļ��� 
		 * <p>
		 * �����ṩ����Щ������Ӧ�ķ�������Щ���������ڵ�ǰƽ̨��ע��Ĺ���Ӧ�ó��򣬲�������Ӧ�ó��������� URI ���ļ���
		 * ���û�й���Ӧ�ó�������Ӧ�ó����޷����������׳��쳣�� 
		 */
		private Desktop desktop;
		
		/**
		 * SystemTray ���ʾ�����ϵͳ���̡�
		 * <p>
		 * �� Microsoft Windows �ϣ�������Ϊ ������״̬���� (Taskbar Status Area)��
		 * ��ĳЩƽ̨�ϣ����ܲ����ڻ�֧��ϵͳ���̣������������ getSystemTray() ���׳� UnsupportedOperationException��
		 */
		private SystemTray tray;
		
		public Workbentch(){
			super();
			init();
		}
		
		private void init() {
			// �жϵ�ǰƽ̨�Ƿ�֧��Desktop��
			if (Desktop.isDesktopSupported()) {
				this.desktop = Desktop.getDesktop();
			}
			// �жϵ�ǰƽ̨�Ƿ�֧��ϵͳ����
			if (SystemTray.isSupported()) {
				/*
				 * ÿ�� Java Ӧ�ó�����һ�� SystemTray ʵ������Ӧ�ó�������ʱ��������Ӧ�ó���������ϵͳ���̽������ӡ�
				 * SystemTray ʵ������ͨ�� getSystemTray() ������ã�Ӧ�ó����ܴ����Լ��� SystemTray ʵ���� 
				 */
				this.tray = SystemTray.getSystemTray();
			}
		}

		public void starts() {
			/*
			 * SystemTray ���԰���һ������ TrayIcon������ʹ�� add(java.awt.TrayIcon) ������������ӵ����̡�
			 * ��������Ҫ����ʱ��ʹ�� remove(java.awt.TrayIcon) �Ƴ�����
			 * TrayIcon ��ͼ�񡢵����˵���һ����ؼ�������ɡ�
			 */
			Image image = Toolkit.getDefaultToolkit().getImage("files/jdk6/mywork.png");
			TrayIcon trayIcon = new TrayIcon(image, "Workbentch", createPopupMenu());
			try {
				tray.add(trayIcon);
			} catch (AWTException ex) {
				ex.printStackTrace();
			}
		}

		private PopupMenu createPopupMenu() {
			PopupMenu popupMenu = new PopupMenu();
			
			MenuItem openBrowser = new MenuItem("Home Page");
			// ��ؼ�����
			openBrowser.addActionListener(new BrowserAction());

			MenuItem sendMail = new MenuItem("Send Mail");
			sendMail.addActionListener(new MailAction());

			MenuItem edit = new MenuItem("Edit txt File");
			edit.addActionListener(new EditAction());

			MenuItem exit = new MenuItem("Exit");
			exit.addActionListener(new ExitAction());
			
			popupMenu.add(openBrowser);
			popupMenu.add(sendMail);
			popupMenu.add(edit);
			popupMenu.addSeparator();
			popupMenu.add(exit);
			
			return popupMenu;
		}
		
		private class BrowserAction implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Desktop֧��ÿ������������ Desktop.Action ���ʾ��һ�ֶ������͡�
				// �жϵ�ǰƽ̨�Ƿ�֧��ָ������
				if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
					try {
						// ����Ĭ�����������ʾ URI
						desktop.browse(new URI(HOME_PAGE));
					} catch (IOException ex) {
						ex.printStackTrace();
					} catch (URISyntaxException ex) {
						ex.printStackTrace();
					}
				}
			}
		}
		
		private class MailAction implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (desktop != null && desktop.isSupported(Desktop.Action.MAIL)) {
					try {
						// �����û�Ĭ���ʼ��ͻ��˵��ʼ���ϴ���
						desktop.mail(new URI("mailto:" + MAIL_ADDRESS));
					} catch (IOException ex) {
						ex.printStackTrace();
					} catch (URISyntaxException ex) {
						ex.printStackTrace();
					}
				}
			}
		}
		
		private class EditAction implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (desktop != null && desktop.isSupported(Desktop.Action.EDIT)) {
					try {
						String userDir = System.getProperty("user.home");
						File txtFile = new File(userDir + File.separator + "temp.txt");
						if (!txtFile.exists()) {
							txtFile.createNewFile();
						}
						// ���������༭��Ӧ�ó��򲢴����ڱ༭���ļ�
						desktop.edit(txtFile);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		}
		
		private class ExitAction implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
	}
}
