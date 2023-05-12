package ibf2022.batch2.csf.backend.repositories;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@Repository
public class ImageRepository {
	@Autowired
    private AmazonS3 amazonS3;
	
	@Value("${do.storage.bucketname}")
    private String s3BucketName;
	
	//TODO: Task 3
	// You are free to change the parameter and the return type
	// Do not change the method's name
	public String upload(File file, String title, String name, String comments, String bundledId) {
		Map<String, String> userData = new HashMap<>();
		ObjectMetadata metadata = new ObjectMetadata();
		try {
			System.out.println(file.getName());
        	userData.put("name", name);
			userData.put("date", LocalDateTime.now().toString());
			userData.put("filename", file.getName());
			userData.put("title", title);
			userData.put("comments", comments);
			Path path = file.toPath();
    		String mimeType = Files.probeContentType(path);
			long bytes = Files.size(path);
			
			metadata.setContentType(mimeType.trim());
			metadata.setContentLength(bytes / 1024);
			metadata.setUserMetadata(userData);
			String key = UUID.randomUUID().toString()
            .substring(0, 8);
			StringTokenizer tk = new StringTokenizer(file.getName(), ".");
			int count = 0;
			String filenameExt = "";
			while(tk.hasMoreTokens()){
				if(count == 1){
					filenameExt = tk.nextToken();
					break;
				}else{
					filenameExt = tk.nextToken();
					count++;
				}
			}
			
			if(filenameExt.equals("blob"))
				filenameExt = filenameExt + ".png";

				PutObjectRequest putRequest = 
				new PutObjectRequest(
					s3BucketName, key + file.getName()
							, new FileInputStream(file), metadata);		

			putRequest.withCannedAcl(CannedAccessControlList.PublicRead);
			amazonS3.putObject(putRequest.withCannedAcl(CannedAccessControlList.PublicRead));
		
			return key + file.getName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Faild";
	}

	public String getImageUrlsFromS3(String fileName) {
		return amazonS3.getUrl(s3BucketName, fileName).toString();
	}
}
