package com.yzc.forum.oss;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aliyun.oss.*;
import com.yzc.forum.provider.AliyunProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


/**
 * 把文件保存到阿里云OSS，返回文件访问路径
 */

@Service
public class Oss {
    @Value("${aliyun.endpoint}")
    private String endpoint;

    @Value("${aliyun.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.accessKeySecret}")
    private String accessKeySecret;

    @Value("${aliyun.bucketName}")
    private String bucketName;

    public String getFileUrl(MultipartFile fileupload) throws OSSException, ClientException, IOException {
        // 获取文件后缀名
        String suffix =getSuffix(fileupload);
        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 文件名格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 该桶中的文件key
        String dateString = sdf.format(new Date()) + "."+suffix; // 20200301.jpg
        // 上传文件
        ossClient.putObject(bucketName, dateString, new ByteArrayInputStream(fileupload.getBytes()));
        // 设置URL过期时间为1小时
        Date expiration = new Date(new Date().getTime() + 3600 * 1000);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, dateString, expiration);
        return url.toString();
    }

    // 获取文 MultipartFile 文件后缀名工具
    public static String getSuffix(MultipartFile fileupload){
        String originalFilename = fileupload.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        System.out.println(suffix);
        return suffix;
    }
}
