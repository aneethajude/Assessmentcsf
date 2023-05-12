package ibf2022.batch2.csf.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Base64;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

@Controller
@CrossOrigin
@RequestMapping
public class UploadController {

	// TODO: Task 2, Task 3, Task 4
	@PostMapping(path="/upload",
	consumes=MediaType.MULTIPART_FORM_DATA_VALUE,
	produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> upload(
		@RequestPart MultipartFile file
	){
		String key ="";


		return null;
	}

	// TODO: Task 5
	

	// TODO: Task 6

}
