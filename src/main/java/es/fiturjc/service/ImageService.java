package es.fiturjc.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

	private static final SimpleDateFormat fileNameFormat = new SimpleDateFormat("'img-'yyyyMMdd-hhmmss-SSS");
	public static final String IMG_FOLDER = "app/images";
	public static final String IMG_CONTROLLER_URL = "/uploads/img/";

	public boolean isValidImage(MultipartFile file) {
        return file != null && !file.isEmpty();
	}

	public String uploadImage(MultipartFile file) {
		String fileName = generateFileName();
		File uploadFile = new File(new File(IMG_FOLDER).getAbsolutePath(), fileName);
		try {
			file.transferTo(uploadFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return IMG_CONTROLLER_URL + fileName;
	}

	private synchronized String generateFileName() {
		return fileNameFormat.format(new Date());
	}

}
