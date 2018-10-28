package com.lzj.listener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JMenuItem;

import com.lzj.bean.NTextArea;
import com.lzj.inter.ResourceMgmt;
import com.lzj.util.AlertWindows;

/**
 * MainFrame��ܼ����߼�
 * 	����
 * 		resourceMgmt 		������Դ�ӿ�
 * @author lzj
 *
 */
public class MainFrameListener extends WindowAdapter {
	private ResourceMgmt resourceMgmt;
	
	/**
	 * ʵ����������Դ�ӿ�resourceMgmt
	 * @param resourceMgmt		������Դ�ӿ�ʵ��
	 */
	public MainFrameListener(ResourceMgmt resourceMgmt) {
		this.resourceMgmt = resourceMgmt;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		//ȡ��������Դ�е�textArea��Դ
		NTextArea textArea = (NTextArea) resourceMgmt.getAResource("NTextArea_textArea");
		////�жϸ��ı������Ƿ���δ���������
		if (!textArea.isSaved()) {
			//����δ��������,��������
			if (AlertWindows.showConfirmDialog(textArea.getFrame(), 
											   "�Ƿ񱣴浱ǰ�ĵ�", 
											   "�����������ܻᵼ���ĵ���ʧ")) {
				((JMenuItem) resourceMgmt.getAResource("JMenuItem_save")).doClick();
				return;
			}
		}
		
		super.windowClosing(e);
		
		System.exit(0);
		
	}
}
