package com.lzj.inter;
/**
 * TextArea���ܽӿ�
 * @author lzj
 *
 */
public interface TextAreaInter extends UndoRedoInter, BaseEditableInter {
	
	/**
	 * ����frame���ڱ���,Ϊ������״̬��ʾ
	 */
	public void updateTitle();
	
	/**
	 * ��ȫ����ı���
	 */
	public void clearEdit();
	
	/**
	 * ����ı�����״̬
	 */
	public void clearState();
	
}
