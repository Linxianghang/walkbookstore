package com.xzsd.pc.imageupload.controller;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.imageupload.service.ImageUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * ImageUploadController
 * @author linxianghang
 * @date 2020-04-20
 */
@RestController
@RequestMapping("/imageUpload")
public class ImageUploadController {

    private static final Logger logger = LoggerFactory.getLogger(ImageUploadController.class);

    @Resource
    private ImageUploadService imageUploadService;

    /**
     * 图片上传
     * @param imageFile
     * @return
     * @author linxianghang
     * @date 2020-04-20
     */
    @PostMapping("uploadImage")
    public AppResponse uploadImage(List<MultipartFile> imageFile) {
        try{
            return imageUploadService.uploadImage(imageFile);
        }catch (Exception e){
            logger.error("图片上传失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
