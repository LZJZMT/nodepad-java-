package com.lzj.server;

import com.lzj.bean.NTextArea;
import com.lzj.inter.TextAreaMgmtInter;

/**
 * �ı���������
 * @author lzj
 *
 */
public class TextAreaMgmtServer implements TextAreaMgmtInter {
	private NTextArea usingTextArea;
	
	public TextAreaMgmtServer(NTextArea usingTextArea) {
		super();

		setUsingTextArea(usingTextArea);
	}

	@Override
	public NTextArea getUsingTextArea() {
		return this.usingTextArea;
	}

	@Override
	public void setUsingTextArea(NTextArea usingTextArea) {
		this.usingTextArea = usingTextArea;
	}


}
