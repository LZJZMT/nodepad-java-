package com.lzj.inter;

import java.io.File;

import com.lzj.bean.NTextArea;

/**
 * �ļ������ӿ�
 * @author lzj
 *
 */
public interface FileInter {
	/**
	 * �½��ļ�
	 */
	public int newFile(NTextArea textArea);
	
	/**
	 * ���ļ�
	 */
	public int open(File file, NTextArea textArea);
	
	/**
	 * �����ļ�
	 */
	public int save(File file, NTextArea textArea);
	
	/**
	 * ͨ��·������
	 */
	public int save(String path, NTextArea textArea);
	
	/**
	 * ͨ��·����
	 */
	public int open(String path, NTextArea textArea);
}
