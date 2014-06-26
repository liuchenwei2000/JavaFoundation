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
 * Desktop和SystemTray类示例
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-26
 */
public class DesktopAndSystemTray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Workbentch().starts();
	}
	
	/**
	 * 工作台
	 */
	private static class Workbentch {
		
		/** 浏览器主页 */
		private static final String HOME_PAGE = "http://www.baidu.com";
		/** 邮件发送地址 */
		private static final String MAIL_ADDRESS = "liuchenwei2000@163.com";
		
		/**
		 * Desktop 类允许 Java 应用程序启动已在本机桌面上注册的关联应用程序，以处理 URI 或文件。 
		 * <p>
		 * 支持的操作包括： 
		 * 启动用户默认浏览器来显示指定的 URI； 
		 * 启动带有可选 mailto URI 的用户默认邮件客户端； 
		 * 启动已注册的应用程序，以打开、编辑或打印指定的文件。 
		 * <p>
		 * 此类提供与这些操作对应的方法。这些方法查找在当前平台上注册的关联应用程序，并启动该应用程序来处理 URI 或文件。
		 * 如果没有关联应用程序或关联应用程序无法启动，则抛出异常。 
		 */
		private Desktop desktop;
		
		/**
		 * SystemTray 类表示桌面的系统托盘。
		 * <p>
		 * 在 Microsoft Windows 上，它被称为 任务栏状态区域 (Taskbar Status Area)。
		 * 在某些平台上，可能不存在或不支持系统托盘，在这种情况下 getSystemTray() 将抛出 UnsupportedOperationException。
		 */
		private SystemTray tray;
		
		public Workbentch(){
			super();
			init();
		}
		
		private void init() {
			// 判断当前平台是否支持Desktop类
			if (Desktop.isDesktopSupported()) {
				this.desktop = Desktop.getDesktop();
			}
			// 判断当前平台是否支持系统托盘
			if (SystemTray.isSupported()) {
				/*
				 * 每个 Java 应用程序都有一个 SystemTray 实例，在应用程序运行时，它允许应用程序与桌面系统托盘建立连接。
				 * SystemTray 实例可以通过 getSystemTray() 方法获得，应用程序不能创建自己的 SystemTray 实例。 
				 */
				this.tray = SystemTray.getSystemTray();
			}
		}

		public void starts() {
			/*
			 * SystemTray 可以包含一个或多个 TrayIcon，可以使用 add(java.awt.TrayIcon) 方法将它们添加到托盘。
			 * 当不再需要托盘时，使用 remove(java.awt.TrayIcon) 移除它。
			 * TrayIcon 由图像、弹出菜单和一组相关监听器组成。
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
			// 相关监听器
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
				// Desktop支持每个操作都是由 Desktop.Action 类表示的一种动作类型。
				// 判断当前平台是否支持指定操作
				if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
					try {
						// 启动默认浏览器来显示 URI
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
						// 启动用户默认邮件客户端的邮件组合窗口
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
						// 启动关联编辑器应用程序并打开用于编辑的文件
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
