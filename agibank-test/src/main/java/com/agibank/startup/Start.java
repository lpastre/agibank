package com.agibank.startup;

import java.io.File;
import java.io.FilenameFilter;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.agibank.exception.PathOfFilesNotFoundException;
import com.agibank.reader.Reader;
import com.agibank.util.AgilebankConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Start implements AgilebankConstants {

	public static void main(String[] args) {
		log.debug("Processo de leitura de arquivo iniciado.");

		try {
			
			String homePath = System.getenv("HOMEPATH") + INPUT_PATH;
			File file = new File(homePath);
			if(!file.exists()) {
				throw new PathOfFilesNotFoundException("Caminho de arquivos não encontrado. " + homePath);
			}

			while (true) {
				
				for (String pathname : file.list(new FilenameFilter() {
							@Override
							public boolean accept(File dir, String name) {
								return name.toLowerCase().endsWith(FILE_EXTENSION);
							}
						})) {
					
					File oldFile = new File(homePath + "/" + pathname);
					oldFile.renameTo(new File(homePath + "/" + pathname + SUFIX_READED));
					
					
					Reader readerFile = new Reader(pathname);
					Thread threadReaderFile = new Thread(readerFile);
					threadReaderFile.start();
					
				}
				Thread.currentThread().sleep(1000L);
			}
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
		}
		log.debug("Processo de leitura de arquivo finalizado.");

	}

}
