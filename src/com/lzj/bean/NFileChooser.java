package com.lzj.bean;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 * �Զ���JFileChooser
 * ֻ���� html �� txt
 * @author lzj
 *
 */
public class NFileChooser extends JFileChooser {
	public NFileChooser() {
		super();

		FileFilter txtFilter = new AutoFileFilter(".txt");
		FileFilter logFilter = new AutoFileFilter(".log");
		FileFilter javaFilter = new AutoFileFilter(".java");
		FileFilter htmlFilter = new AutoFileFilter(".html");
		FileFilter xmlFilter = new AutoFileFilter(".xml");
		addChoosableFileFilter(htmlFilter); 
		addChoosableFileFilter(txtFilter);
		addChoosableFileFilter(javaFilter);
		addChoosableFileFilter(logFilter);
		addChoosableFileFilter(xmlFilter);
	
		setFileFilter(txtFilter);
	}

}