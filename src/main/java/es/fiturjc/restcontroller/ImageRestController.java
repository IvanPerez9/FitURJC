package es.fiturjc.restcontroller;
import es.fiturjc.model.User;
import es.fiturjc.service.ImageService;
import es.fiturjc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;


@RestController
public class ImageRestController {

	interface UserDetail extends User.Basic,User.Details{
	}


	@Autowired
	private ImageService imageService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/image")
    public ResponseEntity<ImageUrl> uploadImage(@RequestParam MultipartFile file,Principal principal){
        if (principal==null)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        User u = userService.findByEmail(principal.getName());

        if(!imageService.isValidImage(file))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(new ImageUrl(imageService.uploadImage(file,u)), HttpStatus.OK);

    }

    private class ImageUrl{
        public String url;

        public ImageUrl(String image){
            this.url = image;
        }
    }
}
