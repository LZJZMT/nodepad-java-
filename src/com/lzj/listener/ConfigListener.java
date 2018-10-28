package com.lzj.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

import com.lzj.MainFrame;
import com.lzj.bean.NTextArea;
import com.lzj.inter.ResourceMgmt;
import com.lzj.server.ConfigServer;
import com.lzj.server.TextAreaMgmtServer;
import com.lzj.util.AlertWindows;
import com.lzj.view.ColorDialog;
import com.lzj.view.ConfigMenu;

/**
 * ���ò˵������߼� ���� resourceMgmt ������Դ�ӿ� textArea �������ı������ configServer ���÷���ʵ��
 * textAreaMgmtServer �ı������������
 * 
 * @author lzj
 *
 */
public class ConfigListener implements ActionListener {
	private ResourceMgmt resourceMgmt;
	private NTextArea textArea;
	private TextAreaMgmtServer textAreaMgmtServer;
	private ConfigServer configServer;

	/**
	 * ���캯�� ֱ�Ӵ���ʵ����������Դ�ӿ�resourceMgmt��ʵ����textArea�ı������
	 * 
	 * @param resourceMgmt
	 */
	public ConfigListener(ResourceMgmt resourceMgmt) {
		super();

		// ʵ����������Դ�ӿ�resourceMgmt
		this.resourceMgmt = resourceMgmt;

		// ʵ����textAreaMgmtServer����
		this.textAreaMgmtServer = (TextAreaMgmtServer) resourceMgmt.getAResource("textAreaServer");

		// ʵ����configServer����
		this.configServer = (ConfigServer) resourceMgmt.getAResource("configServer");

		// �Ƿ��Զ�����

	}

	/**
	 * ActionCommand�����߼�����
	 */
	public void actionPerformed(ActionEvent e) {
		// ���ACtionCommandֵ
		String actionCommand = e.getActionCommand();

		// ��õ�ǰѡ��textArea����
		textArea = textAreaMgmtServer.getUsingTextArea();

		// �ж�ActionCommand��Ӧ�Ĳ���
		if (actionCommand.equals(ConfigMenu.ActionCommand_toUTF)) {
			// ����ˡ�ʹ��UTF-8���롯��ť
			// �жϵ�ǰ�ı������Ƿ���δ���������
			if (!textArea.isSaved()) {
				// ����δ��������,��������
				if (!AlertWindows.showConfirmDialog(textArea.getFrame(), "�����������ܻᵼ���ĵ���ʧ", "����:��ǰ�ĵ�δ����")) {
					// ȡ���¼�����
					return;
				}
			}

			configServer.useUTF(true);

		} else if (actionCommand.equals(ConfigMenu.ActionCommand_toGBK)) {
			// ����ˡ�ʹ��GBK���롯��ť
			// �жϵ�ǰ�ı������Ƿ���δ���������
			if (!textArea.isSaved()) {
				// ����δ��������,��������
				if (!AlertWindows.showConfirmDialog(textArea.getFrame(), "�����������ܻᵼ���ĵ���ʧ", "����:��ǰ�ĵ�δ����")) {
					// ȡ���¼�����
					return;
				}
			}

			configServer.useGBK(true);
		} else if (actionCommand.equals(ConfigMenu.ActionCommand_font)) {
			// ����ˡ����塯��ť
			configServer.setFont();
		} else if (actionCommand.equals(ConfigMenu.AUTO_NEWLINE)) {
			configServer.setAutoNewLine(resourceMgmt);
		} else if (actionCommand.equals(ConfigMenu.FONT_COLOR)) {
			MainFrame main = (MainFrame)resourceMgmt.getAResource("main");
			Color color = JColorChooser.showDialog(main, "ѡɫ��", null);
			NTextArea textArea = (NTextArea) resourceMgmt.getAResource("NTextArea_textArea");
			textArea.setForeground(color);
		}
	}

}
