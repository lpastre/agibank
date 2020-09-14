package com.agibank.startup;

import java.io.File;
import java.io.FilenameFilter;

import com.agibank.reader.Reader;
import com.agibank.util.AgilebankConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Start implements AgilebankConstants {

	public static void main(String[] args) {
		log.debug("Processo de leitura de arquivo iniciado.");

		try {
			while (true) {
				String homePath = System.getenv("HOMEPATH") + INPUT_PATH;
				File file = new File(homePath);
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
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		log.debug("Processo de leitura de arquivo finalizado.");

	}

}
