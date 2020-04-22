package com.xzsd.app.imageupload.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.imageupload.entity.ImageUploadInfo;
import com.xzsd.pc.util.COSClientUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * ImageUploadService
 * @author linxianghang
 * @date 2020-04-20
 */
@Service
public class ImageUploadService {
    /**
     * 图片上传
     * @param
     * @return
     * @author linxianghang
     * @Date 2020-04-20
     */
    public AppResponse uploadImage(List<MultipartFile> imageFile) {
        COSClientUtil cosClientUtil = new COSClientUtil();
        String name, imgUrl;
        String  url = "";
        System.out.println(imageFile.size());
        List<String> listImage = new ArrayList<>();
        try {
            if(imageFile.size() == 1){
                //上传一张图片
                name = cosClientUtil.uploadFile2Cos(imageFile.get(0));
                imgUrl = cosClientUtil.getImgUrl(name);
                String[] split = imgUrl.split("\\?");
                url = split[0];
                listImage.add(split[0]);
            }else if(imageFile.size() > 1){
                //上传多张图片
                for (MultipartFile image : imageFile) {
                    name = cosClientUtil.uploadFile2Cos(image);
                    imgUrl = cosClientUtil.getImgUrl(name);
                    String[] split = imgUrl.split("\\?");
                    url = url + split[0] + ",";
                    listImage.add(split[0]);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        //封装数据
        ImageUploadInfo upload = new ImageUploadInfo();
        upload.setImagePath(url);
        for (int i = 0; i < listImage.size(); i++) {
            System.out.println(listImage.get(i));
        }
        return AppResponse.success("图片上传成功！", upload);
    }

    /**
     * 图片上传
     * @param images
     * @return
     * @throws Exception
     */
    /*public AppResponse uploadImage(List<MultipartFile> images)throws Exception {
        ImageUploadInfo upload = new ImageUploadInfo();
        COSClientUtil cosClientUtil = new COSClientUtil();
        String name, imgUrl;
        String  url = "";
        for (MultipartFile image : images) {
            name = cosClientUtil.uploadFile2Cos(image);
            imgUrl = cosClientUtil.getImgUrl(name);
            String[] split = imgUrl.split("\\?");
            url = url + split[0] + ",";
        }
        upload.setImagePath(url);
        System.out.println(upload.getImagePath());
        return AppResponse.success("图片上传成功！", upload.getImagePath());
    }*/

}
