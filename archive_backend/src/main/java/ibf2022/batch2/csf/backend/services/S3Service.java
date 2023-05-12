package ibf2022.batch2.csf.backend.services;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

// @Service
// public class S3Service {

//     @Autowired
//     private AmazonS3 s3Client;

//     @Value("${DO_STORAGE_BUCKETNAME}")
//     private String bucketName;

//     public List<String> getImageUrlsFromS3() {
//         List<String> imageUrls = new ArrayList<>();

//         ObjectListing objectListing = s3Client.listObjects(bucketName);
//         List<S3ObjectSummary> objectSummaries = objectListing.getObjectSummaries();

//         for (S3ObjectSummary objectSummary : objectSummaries) {
//             String imageUrl = s3Client.getUrl(bucketName, objectSummary.getKey()).toString();
//             imageUrls.add(imageUrl);
//         }

//         return imageUrls;
//     }
// }

