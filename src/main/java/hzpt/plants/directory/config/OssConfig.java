package hzpt.plants.directory.config;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/12
 */
@Configuration
@Data
public class OssConfig {
    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    @Value("${aliyun.oss.domain}")
    private String domain;


    public String uploadImage(MultipartFile file) {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        if (file != null) {
            String originalFilename = file.getOriginalFilename();
            PutObjectRequest putObjectRequest = null;
            try {
                putObjectRequest = new PutObjectRequest(bucketName, originalFilename, new ByteArrayInputStream(file.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ossClient.putObject(putObjectRequest);
            ossClient.shutdown();

            return domain + originalFilename;
        }
        return null;
    }

}
