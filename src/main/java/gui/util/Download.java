package gui.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JFileChooser;

public class Download {
	
	public static void download(String origem) {

		try {

			File fileOrigem = new File(origem);
			
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.setSelectedFile(new File(fileOrigem.getName()));
			jFileChooser.showSaveDialog(jFileChooser);

			
			String dstino = jFileChooser.getCurrentDirectory()+"\\"+fileOrigem.getName();
			File fileDestino = new File(dstino);
			
			System.out.println(fileDestino);
			
			
			Path pathOrigem = fileOrigem.toPath();
			Path pathDestino = fileDestino.toPath();
	
			Files.copy(pathOrigem,pathDestino);
			
			//fileOrigem.renameTo(fileDestino);
			
			System.out.println(fileOrigem);
			System.out.println(fileDestino);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {

		download("src\\main\\resources\\out\\txt\\JC123456785BR_JC123456785BR.txt");
	}
}
