package com.lzj.inter;

/**
 * ���ù��ܽӿ�
 * @author lzj
 *
 */
public interface ConfigInter {
	/**
	 * ʹ��UTF-8����
	 */
	public int useUTF(boolean force);
	
	/**
	 * ʹ��GBK����
	 */
	public int useGBK(boolean force);
	
	/**
	 * ��������
	 */
	public void setFont();
}
