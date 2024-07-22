package com.wjm.tliasdemo.controller;

import com.aliyuncs.exceptions.ClientException;
import com.wjm.tliasdemo.pojo.Result;
import com.wjm.tliasdemo.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

    /*
     * 客户端上传文件本地保存机制
     * */
//    @PostMapping("/upload")
//    public Result upload(String name,
//                         Integer age,
//                         @RequestParam("image") MultipartFile[] files) throws IOException {
//        log.info("文件上传：{}，{}，{}", name, age, files);
//        for (MultipartFile file : files) {
//            //获取原始文件名
//            String fileName = file.getOriginalFilename();
//            //获取文件名后缀
//            String suffix = fileName.substring(fileName.lastIndexOf("."));
//            //将文件存储到本地磁盘目录下并利用uuid命名
//            file.transferTo(new File("D:\\IDEA\\SavedFiles\\" + UUID.randomUUID().toString() + suffix));
//        }
//        return Result.success();
//    }

    /*
     * 云OSS上传文件并回显
     * */
    @PostMapping("/upload")
    public Result upload(@RequestParam("image") MultipartFile file) throws IOException, ClientException {
        log.info("上传文件名:{}", file.getOriginalFilename());
        //上传文件并返回回显网址
        String url = aliOSSUtils.upload(file);
        return Result.success(url);
    }
}
