package com.agibank.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.agibank.obj.ResultObject;
import com.agibank.util.AgilebankConstants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class Writer implements Runnable, AgilebankConstants{

	private String filename;
	private ResultObject resultObject;

	@Override
	public void run() {
		try {
			writeFile();
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
		}
	}

	
	private void writeFile() throws Exception {
		log.debug("Escrevendo ao arquivo de saída - " + filename);
		String homePath = System.getenv("HOMEPATH") + OUTPUT_PATH;
		File fileOut = new File(homePath);
		fileOut.mkdir();
		try (BufferedWriter objWriter = new BufferedWriter(new FileWriter(homePath + "/" + 
													filename.substring(0, filename.length()-4) + SUFIX_DONE + FILE_EXTENSION, StandardCharsets.UTF_8))) {
			objWriter.write(resultObject.toString());
			
		} catch (Exception e) {
			throw e;
		}
		new File(System.getenv("HOMEPATH") + INPUT_PATH + "/" + filename + SUFIX_READED).delete();
		log.debug("Escrita do arquivo de saida concluida - " + filename);
	}
	
}
