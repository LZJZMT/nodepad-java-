package com.lzj.server;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JMenuItem;

import com.lzj.bean.NMenu;
import com.lzj.bean.NTextArea;
import com.lzj.inter.ConfigInter;
import com.lzj.inter.ResourceMgmt;
import com.lzj.util.MQFontChooser;
import com.lzj.util.TextAreaUtil;
import com.lzj.view.NMenuBar;

/**
 * 设置菜单服务
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

	//使用UTF-8编码事务
	public int useUTF(boolean force) {
		NTextArea textArea = textAreaServer.getUsingTextArea();
		
		//判断当前文本域内是否有未保存的内容
		if (!force && !textArea.isSaved()) {
			//存在未保存内容,返回结果
			return fileNotSave;
		} 
		//设置文本域编码环境为UTF-8
		textArea.setEncoded("UTF-8");
		
		//如果当前文本域存在关联文件 重新载入文件
		if (textArea.getFile() != null) {
			TextAreaUtil.reload(textArea);
		}

		return success;
	}

	//使用GBK编码事务
	public int useGBK(boolean force) {
		NTextArea textArea = textAreaServer.getUsingTextArea();
		
		//判断当前文本域内是否有未保存的内容
		if (!force && !textArea.isSaved()) {
			//存在未保存内容,返回结果
			return fileNotSave;
		} 
		//设置文本域编码环境为GBK
		textArea.setEncoded("GBK");
		
		//如果当前文本域存在关联文件 重新载入文件
		if (textArea.getFile() != null) {
			TextAreaUtil.reload(textArea);
		}
		
		return success;
	}

	public void setFont() {
		NTextArea textArea = textAreaServer.getUsingTextArea();
			
		 // 构造字体选择器，参数字体为预设值  
        MQFontChooser fontChooser = new MQFontChooser(textArea.getFont());  
        // 打开一个字体选择器窗口，参数为父级所有者窗体。返回一个整型，代表设置字体时按下了确定或是取消，可参考MQFontChooser.APPROVE_OPTION和MQFontChooser.CANCEL_OPTION  
        int returnValue = fontChooser.showFontDialog(textArea.getFrame());  
        // 如果按下的是确定按钮  
        if (returnValue == MQFontChooser.APPROVE_OPTION) {  
            // 获取选择的字体  
            Font font = fontChooser.getSelectFont();  
            // 将字体设置到JTextArea中  
            textArea.setFont(font);  
        }
	}
	public void setAutoNewLine(ResourceMgmt resourceMgmt){
		NTextArea textArea = textAreaServer.getUsingTextArea();
		boolean isAutoNewLine = (boolean)resourceMgmt.getAResource("isAutoNewLine");
		isAutoNewLine = isAutoNewLine?false:true;
		textArea.setLineWrap(isAutoNewLine);
		resourceMgmt.getResource().replace("isAutoNewLine", isAutoNewLine);
		NMenuBar menuBar = (NMenuBar)resourceMgmt.getAResource("menuBar");
		NMenu configMenu = menuBar.getConfigMenu();
		ArrayList<JMenuItem> items = configMenu.getMenuJMenuItems();
		
		if(isAutoNewLine){
			configMenu.updateItemsAutoNewLine("自动换行 √");
		}else{
			configMenu.updateItemsAutoNewLine("自动换行");
		}
		
	}
}
