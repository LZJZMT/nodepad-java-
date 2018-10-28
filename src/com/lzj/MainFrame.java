package com.lzj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.lzj.bean.NFrame;
import com.lzj.bean.NTextArea;
import com.lzj.listener.MainFrameListener;
import com.lzj.listener.RightPopupMenuListener;
import com.lzj.listener.TextAreaListener;
import com.lzj.server.ConfigServer;
import com.lzj.server.EditorServer;
import com.lzj.server.FileIOServer;
import com.lzj.server.FileServer;
import com.lzj.server.TextAreaMgmtServer;
import com.lzj.util.TextAreaUtil;
import com.lzj.view.NMenuBar;
import com.lzj.view.RightPopupMenu;

/**
 * notepad������� �̳�NFrame ���� menuBar �����Ϸ��˵��� textArea �����е��ı��������� scrollwriteArea
 * ����ʵ�ֻ��� nPopupMenu �Ҽ��˵� �������� public static void main(String[] args) public
 * void MainFrameInit() public void initResource()
 * 
 * @author lzj
 *
 */
public class MainFrame extends NFrame {

	private Font textAreaFont = new Font("΢��", Font.PLAIN, 14);

	private JMenuBar menuBar;

	private NTextArea textArea;
	private JScrollPane scrollwriteArea;
	private RightPopupMenu rightPopupMenu;

	public static void main(String[] args) {
		MainFrame man = new MainFrame();

		if (args.length > 0) {
			TextAreaUtil.appendInitText(new FileIOServer().readCharFile(args[0]), man.textArea);
			// ����textArea��file�ļ�����
			man.textArea.setFile(new File(args[0]));
		}
	}

	public MainFrame() throws HeadlessException {
		super();

		MainFrameInit();
	}

	public MainFrame(GraphicsConfiguration gc) {
		super(gc);

		MainFrameInit();
	}

	public MainFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);

		MainFrameInit();
	}

	public MainFrame(String title) throws HeadlessException {
		super(title);

		MainFrameInit();
	}

	/**
	 * ��ʼ������ ���ڳ�ʼ�������Լ�������Դ
	 */
	public void MainFrameInit() {
		System.setProperty("java.awt.im.style", "on-the-spot");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		// ��ʼ�����ԣ�������Ҫ���������ý�������Դ��
		initResource();

		// ���ó�ʼ���ڴ�С
		setBounds(0, 0, 600, 600);
		// ���ùرհ�ť����
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// ������Ļ������ʾ
		setLocationRelativeTo(null);
		// ���ò���ΪBorderLayout
		getContentPane().setLayout(new BorderLayout());
		// ���ü����߼�
		addWindowListener(new MainFrameListener(this));

		// ����textArea���������
		textArea.setFont(textAreaFont);
		// ΪtextArea��Ӽ����߼�
		textArea.addMouseListener(new TextAreaListener(this));
		textArea.setLineWrap(true);
		// ���Ҽ��˵�nPopupMenu��Ӽ����߼�
		RightPopupMenuListener rightPopupMenuListener = new RightPopupMenuListener(this);
		rightPopupMenu.addActionListener(rightPopupMenuListener);
		rightPopupMenu.addPopupMenuListener(rightPopupMenuListener);

		// ��textArea��ӽ�scrollwriteArea��ʵ�ֻ���
		scrollwriteArea.getViewport().add(textArea);

		// ��scrollwriteArea������BorderLayout.CENTER
		getContentPane().add(scrollwriteArea, BorderLayout.CENTER);

		// ����menuBar������ɫ
		menuBar.setBackground(Color.white);
		// ��menuBar������BorderLayout.NORTH
		getContentPane().add(menuBar, BorderLayout.NORTH);
		// ����ͼ��
		setIconImage(new ImageIcon(this.getClass().getResource("nodepad.png").getFile()).getImage());

		// ����frame���ڿ���
		setVisible(true);
	}

	/**
	 * ��Դ��ʼ������ ����ʵ�������ԣ�������Ҫ���������ý�������Դ��
	 */
	public void initResource() {
		// ʵ��������textArea
		textArea = new NTextArea(this);
		// textAreaΪ������Դ,���빫����Դ����
		setAResource("NTextArea_textArea", textArea);
		TextAreaMgmtServer textAreaServer = new TextAreaMgmtServer(textArea);
		setAResource("textAreaServer", textAreaServer);
		setAResource("fileServer", new FileServer(this));
		setAResource("editorServer", new EditorServer(this));
		setAResource("configServer", new ConfigServer(textAreaServer));
		setAResource("isAutoNewLine", false);
		scrollwriteArea = new JScrollPane();

		menuBar = new NMenuBar(this);

		rightPopupMenu = new RightPopupMenu(this);
		setAResource("RightPopupMenu_rightPopupMenu", rightPopupMenu);
	}
}
