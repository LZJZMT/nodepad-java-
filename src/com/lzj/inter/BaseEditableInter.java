package com.lzj.inter;

/**
 * �����༭�����жϽӿ�
 * @author lzj
 *
 */
public interface BaseEditableInter {
	
	/**
	 * �жϵ�ǰ�ı���ɷ��Ʋ���
	 * @return	�жϵĽ��
	 */
	public boolean canCopy();
	
	/**
	 * �жϵ�ǰ�ı���ɷ���в���
	 * @return	�жϵĽ��
	 */
	public boolean canCut();
	
	/**
	 * �жϵ�ǰ�ı���ɷ�ճ������
	 * @return	�жϵĽ��
	 */
	public boolean canPaste();
	
}
