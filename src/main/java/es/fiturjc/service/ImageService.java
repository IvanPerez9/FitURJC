package es.fiturjc.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import es.fiturjc.model.User;
import es.fiturjc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

    @Autowired
    private UserRepository userRepository;

	private static final SimpleDateFormat fileNameFormat = new SimpleDateFormat("'img-'yyyyMMdd-hhmmss-SSS");
	private static final String IMG_FOLDER = "/temp/images/";
	private static final String IMG_CONTROLLER_URL = "/uploads/img/";

	public boolean isValidImage(MultipartFile file) {
        return file != null && !file.isEmpty();
	}

	public String uploadImage(MultipartFile file, User u) {
        String fileName = generateFileName();
        File uploadFile = new File(new File(IMG_FOLDER).getAbsolutePath(), fileName);
        try {
            file.transferTo(uploadFile);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }

        String path = IMG_CONTROLLER_URL + fileName;
        u.setImgSrc(path);
        userRepository.save(u);
        return path;
    }

    public String uploadImage(MultipartFile file) {
        String fileName = generateFileName();
        File uploadFile = new File(new File(IMG_FOLDER).getAbsolutePath(), fileName);
        try {
            file.transferTo(uploadFile);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        return IMG_CONTROLLER_URL + fileName;
    }
	private synchronized String generateFileName() {
		return fileNameFormat.format(new Date());
	}

}
