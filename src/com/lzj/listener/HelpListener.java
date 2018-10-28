package com.lzj.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.lzj.bean.NTextArea;
import com.lzj.inter.ResourceMgmt;
import com.lzj.view.HelpDialog;

/**
 * HelpMenu�����߼�
 * 		�Ե���¼�������Ӧ
 * @author lzj
 *
 */
public class HelpListener extends MouseAdapter {
	private ResourceMgmt resourceMgmt;
	
	public HelpListener(ResourceMgmt resourceMgmt) {
		super();

		this.resourceMgmt = resourceMgmt;
	}

	public void mouseClicked(MouseEvent e) {
		//�Ե���¼�������Ӧ����HelpFrame����
		new HelpDialog(((NTextArea)resourceMgmt.getAResource("NTextArea_textArea")).getFrame());
	}
}
