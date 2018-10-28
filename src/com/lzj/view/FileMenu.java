package com.lzj.view;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.lzj.bean.NMenu;
import com.lzj.inter.ResourceMgmt;
import com.lzj.util.MenuFontUtil;

/**
 * �ļ��˵�
 * 	����		newfile, open, save				�˵��еĲ˵���
 * 			resourceMgmt					������Դ�ӿ�
 * 	����		public void EditorMenuInit()
 * @author lzj
 *
 */
public class FileMenu extends NMenu {
	
	public static final String ActionCommand_newfile = "newfile";
	public static final String ActionCommand_open = "open";
	public static final String ActionCommand_save = "save";
	public static final String ActionCommand_saveas = "saveas";
	
	private JMenuItem newfile, open, save, saveas;
	ResourceMgmt resourceMgmt;
	
	public FileMenu(Action a, ResourceMgmt resourceMgmt) {
		super(a, resourceMgmt);
		
		FileMenuInit(resourceMgmt);
	}

	public FileMenu(ResourceMgmt resourceMgmt) {
		super(resourceMgmt);
		
		FileMenuInit(resourceMgmt);
	}

	public FileMenu(String s, boolean b, ResourceMgmt resourceMgmt) {
		super(s, b, resourceMgmt);
		
		FileMenuInit(resourceMgmt);
	}

	public FileMenu(String s, ResourceMgmt resourceMgmt) {
		super(s, resourceMgmt);
		
		FileMenuInit(resourceMgmt);
	}

	/**
	 * ��ʼ���˵�����
	 * 		Ϊ�ļ��˵���Ӳ˵���
	 * ʵ����������Դ�ӿ�
	 */
	public void FileMenuInit(ResourceMgmt resourceMgmt) {
		this.resourceMgmt = resourceMgmt;
		
		//ʵ����һ���˵���
		newfile = new JMenuItem("�½�");
		//Ϊ�ò˵�������ActionCommetֵ
		newfile.setActionCommand(ActionCommand_newfile);
		newfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		open = new JMenuItem("��");
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		open.setActionCommand(ActionCommand_open);
		save = new JMenuItem("����");
		save.setActionCommand(ActionCommand_save);
		//���ñ����ݼ�
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		saveas = new JMenuItem("���Ϊ");
		saveas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.SHIFT_DOWN_MASK ));
		saveas.setActionCommand(ActionCommand_saveas);
		
		//�����Ϊ���빫����Դ
		resourceMgmt.setAResource("JMenuItem_saveas", saveas);
		resourceMgmt.setAResource("JMenuItem_save", save);
		
		//���˵�����뵽�˵���
		add(newfile);
		add(open);
		add(save);
		add(saveas);
		
		//����Item��Ŀ�����С
		MenuFontUtil.setMenuItemFont(getMenuJMenuItems());
	}
}
