package com.lzj.server;

import java.awt.Font;

import com.lzj.bean.NTextArea;
import com.lzj.inter.ConfigInter;
import com.lzj.inter.ResourceMgmt;
import com.lzj.util.MQFontChooser;
import com.lzj.util.TextAreaUtil;

/**
 * ���ò˵�����
 * @author lzj
 *
 */
public class ConfigServer implements ConfigInter {
	public static final int success = 1;
	public static final int fileNotSave = 2;
	private TextAreaMgmtServer textAreaServer;
	
	public ConfigServer(TextAreaMgmtServer textAreaServer) {
		super();
		
		this.textAreaServer = textAreaServer;
	}

	//ʹ��UTF-8��������
	public int useUTF(boolean force) {
		NTextArea textArea = textAreaServer.getUsingTextArea();
		
		//�жϵ�ǰ�ı������Ƿ���δ���������
		if (!force && !textArea.isSaved()) {
			//����δ��������,���ؽ��
			return fileNotSave;
		} 
		//�����ı�����뻷��ΪUTF-8
		textArea.setEncoded("UTF-8");
		
		//�����ǰ�ı�����ڹ����ļ� ���������ļ�
		if (textArea.getFile() != null) {
			TextAreaUtil.reload(textArea);
		}

		return success;
	}

	//ʹ��GBK��������
	public int useGBK(boolean force) {
		NTextArea textArea = textAreaServer.getUsingTextArea();
		
		//�жϵ�ǰ�ı������Ƿ���δ���������
		if (!force && !textArea.isSaved()) {
			//����δ��������,���ؽ��
			return fileNotSave;
		} 
		//�����ı�����뻷��ΪGBK
		textArea.setEncoded("GBK");
		
		//�����ǰ�ı�����ڹ����ļ� ���������ļ�
		if (textArea.getFile() != null) {
			TextAreaUtil.reload(textArea);
		}
		
		return success;
	}

	public void setFont() {
		NTextArea textArea = textAreaServer.getUsingTextArea();
			
		 // ��������ѡ��������������ΪԤ��ֵ  
        MQFontChooser fontChooser = new MQFontChooser(textArea.getFont());  
        // ��һ������ѡ�������ڣ�����Ϊ���������ߴ��塣����һ�����ͣ�������������ʱ������ȷ������ȡ�����ɲο�MQFontChooser.APPROVE_OPTION��MQFontChooser.CANCEL_OPTION  
        int returnValue = fontChooser.showFontDialog(textArea.getFrame());  
        // ������µ���ȷ����ť  
        if (returnValue == MQFontChooser.APPROVE_OPTION) {  
            // ��ȡѡ�������  
            Font font = fontChooser.getSelectFont();  
            // ���������õ�JTextArea��  
            textArea.setFont(font);  
        }
	}
	public void setAutoNewLine(ResourceMgmt resourceMgmt){
		NTextArea textArea = textAreaServer.getUsingTextArea();
		textArea.setLineWrap(!(boolean)resourceMgmt.getAResource("isAutoNewLine"));
		resourceMgmt.setAResource("isAutoNewLine",!(boolean)resourceMgmt.getAResource("isAutoNewLine"));
	}
}
