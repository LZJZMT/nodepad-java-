package com.lzj.util;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JMenuItem;

import com.lzj.bean.NMenu;

/**
 * �˵��������������
 * 		���������˵�����
 * @author lzj
 *
 */
public class MenuFontUtil {
	//�˵�����
	public static final Font MenuFont = new Font("΢��",Font.PLAIN,14);
	//�˵��Ĳ˵���Ŀ����
	public static final Font MenuItemFont = new Font("΢��", Font.PLAIN, 12);
	
	/**
	 * ���ò˵�����Ŀ������
	 * @param items	�˵���Ŀ����
	 */
	public static void setMenuItemFont(ArrayList<JMenuItem> items) {
		for (JMenuItem item : items) {
			item.setFont(MenuItemFont);
		}
	}
	
	/**
	 * ���ò˵�������
	 * @param menu	�˵�
	 */
	public static void setMenuFont(NMenu menu) {
		menu.setFont(MenuFont);
	}
	
}