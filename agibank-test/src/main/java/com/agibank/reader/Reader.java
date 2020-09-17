package com.agibank.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.agibank.obj.Customer;
import com.agibank.obj.ObjectBase;
import com.agibank.obj.Sale;
import com.agibank.obj.Salesman;
import com.agibank.process.ProcessObject;
import com.agibank.util.AgilebankConstants;
import com.agibank.util.Mapper;
import com.agibank.writer.Writer;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
public class Reader implements Runnable, AgilebankConstants {

	private String filename;
	private ProcessObject processObject;
	
	public Reader(String filename) {
		this.filename = filename;
	}
	
	@Override
	public void run() {
		readFile();
		writeFile();
	}

	private void readFile() {
		log.debug("Lendo o arquivo de entrada - " + filename);
		String homePath = System.getenv("HOMEPATH") + INPUT_PATH;
		try (BufferedReader objReader = new BufferedReader(
				new FileReader(homePath + "/" + filename + SUFIX_READED, StandardCharsets.UTF_8))) {

			processObject = new ProcessObject();
			String contentLine = objReader.readLine();
			while (contentLine != null) {
				try {
					if ("".equals(contentLine.trim())) {
						contentLine = objReader.readLine();
						continue;
					}
					ObjectBase obj = Mapper.convertToObject(contentLine);

					if (obj instanceof Customer)
						processObject.process((Customer) obj);
					else if (obj instanceof Salesman)
						processObject.process((Salesman) obj);
					else {
						processObject.process((Sale) obj);
					}

					contentLine = objReader.readLine();
				} catch (Exception e) {
					log.error("Erro na leitura da linha: " + contentLine + " - Erro: " + e.getMessage());
				}
			}

		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
		}

		log.debug("Leitura do arquivo de entrada concluida - " + filename);
	}
	
	private void writeFile() {
		log.debug("Lendo o arquivo de entrada - " + filename);
		Writer writeFile = new Writer(filename, processObject.getResultObject());
		Thread threadWriteFile = new Thread(writeFile);
		threadWriteFile.start();

	}

}
