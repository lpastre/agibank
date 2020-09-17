package com.agibank.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.nio.channels.FileChannel;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;

import com.agibank.reader.Reader;
import com.agibank.util.AgilebankConstants;
import com.agibank.writer.Writer;

public class CompleteTest implements AgilebankConstants {

	@Test
	public void test() {
		try {
			String homePath = System.getenv("HOMEPATH") + INPUT_PATH;
			File file = new File(homePath);
			file.mkdirs();

			copyFilesTo(file);
			
			for (String pathname : file.list(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.toLowerCase().endsWith(FILE_EXTENSION);
				}
			})) {

				File oldFile = new File(homePath + "/" + pathname);
				oldFile.renameTo(new File(homePath + "/" + pathname + SUFIX_READED));
				Reader readerFile = new Reader(pathname);
				readerFile.run();
				Writer writeFile = new Writer(readerFile.getFilename(), readerFile.getProcessObject().getResultObject());
				writeFile.run();
			}

		} catch (Exception e) {
			fail(ExceptionUtils.getStackTrace(e));
		}finally {
			deleteOutFiles();
		}

		assertTrue(true);

	}

	private void copyFilesTo(File destination) throws Exception {
		File currentFiles = new File("in");
		for (String pathname : currentFiles.list()){
			try (FileChannel sourceChannel = new FileInputStream(currentFiles.getAbsolutePath() + "/" + pathname).getChannel();
					FileChannel destinationChannel = new FileOutputStream(destination + "/" + pathname).getChannel()) {
				sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
			}	
		}
	}


	private void deleteOutFiles() {
		File inFiles = new File(System.getenv("HOMEPATH") + INPUT_PATH);
		File outFiles = new File(System.getenv("HOMEPATH") + OUTPUT_PATH);
		for (String pathname : inFiles.list()){
			new File(inFiles.getAbsolutePath() + "/" + pathname).deleteOnExit();
		}
		for (String pathname : outFiles.list()){
			new File(outFiles.getAbsolutePath() + "/" + pathname).deleteOnExit();
		}
	}
}
