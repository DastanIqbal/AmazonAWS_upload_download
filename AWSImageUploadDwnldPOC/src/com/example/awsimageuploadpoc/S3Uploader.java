package com.example.awsimageuploadpoc;

import java.net.URL;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

@SuppressLint("NewApi")
public class S3Uploader {
	// Bucket name
	private String bucketName = "eventimagebucket";
	// Name of the object that is going to be retrieved
	private String objectKey;
	private URL url;

	public S3Uploader(String objectK) {
		objectKey = objectK;
	}

	// This method is for obtaining the URL (with permissions) of the object to
	// retrieve
	public URL setFile(String file) {
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);

		AmazonS3 s3client = new AmazonS3Client(
				new ClasspathPropertiesFileCredentialsProvider());
		url = null;
		s3client.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
		// s3client.createBucket(bucketName);
		PutObjectRequest por = new PutObjectRequest(
				Constants.getPictureBucket(), Constants.PICTURE_NAME,
				new java.io.File(file));
		por.setCannedAcl(CannedAccessControlList.PublicRead);
		por.setBucketName(bucketName);
		por.setKey("iqbal_123.png");

		PutObjectResult result = s3client.putObject(por);
		Log.i("Result:", result.toString());
		return url;
	}
}
