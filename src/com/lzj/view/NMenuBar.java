package com.lzj.view;

import javax.swing.JMenuBar;

import com.lzj.bean.NMenu;
import com.lzj.inter.ResourceMgmt;
import com.lzj.listener.ConfigListener;
import com.lzj.listener.EditorListener;
import com.lzj.listener.FileListener;
import com.lzj.listener.HelpListener;
import com.lzj.util.MenuFontUtil;

/**
 * �˵�������
 * 	����
 * 		fileMenu, editorMenu, config, help		�˵����еĲ˵�
 * @author lzj
 *
 */
public class NMenuBar extends JMenuBar {
	private NMenu fileMenu, editorMenu, config, about;

	/**
	 * ���췽���жԲ˵������в���
	 * @param resourceMgmt			���Ĵ������Ĺ�����Դ����ӿ�    �ɴ��л�ȡ������Դ
	 */
	public NMenuBar(ResourceMgmt resourceMgmt) {
		super();
		
		//�½�һ���˵�
		fileMenu = new FileMenu("�ļ�", resourceMgmt);
		//���øò˵�������
		MenuFontUtil.setMenuFont(fileMenu);
		
		
		editorMenu = new EditorMenu("�༭", resourceMgmt);
		MenuFontUtil.setMenuFont(editorMenu);
		
		config = new ConfigMenu("����", resourceMgmt);
		MenuFontUtil.setMenuFont(config);
	
		about = new NMenu("����", resourceMgmt);
		MenuFontUtil.setMenuFont(about);
		
		//Ϊ�ò˵���Ӷ�Ӧ�ļ����߼�
		fileMenu.addActionListener(new FileListener(resourceMgmt));
		EditorListener editorListener = new EditorListener(resourceMgmt);
		editorMenu.addMenuListener(editorListener);
		editorMenu.addActionListener(editorListener);
		config.addActionListener(new ConfigListener(resourceMgmt));
		about.addMouseListener(new HelpListener(resourceMgmt));
		
		//���ò˵��ӵ��˵�����
		add(fileMenu);
		add(editorMenu);
		add(config);
		add(about);
	}
}
