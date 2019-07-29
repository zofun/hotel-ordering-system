package com.web.core.controller;


import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FileUploadController {


    @Value("${baseDir}")
    private String baseDir;

    @RequestMapping("uploader")
    @ResponseBody
    public String uploader(@RequestParam("file") MultipartFile multipartFile, HttpSession session) throws IOException {

        System.out.println("baseDir-->"+baseDir);


        Map<String,String> result=new HashMap<>();

        ObjectMapper mapper=new ObjectMapper();
        if (!StringUtils.isEmpty(multipartFile) && multipartFile.getSize()>0){
            String filename = multipartFile.getOriginalFilename();
            String suffix = filename.substring(filename.lastIndexOf(".") + 1);
            if (filename.endsWith("jpg")||filename.endsWith("png")){

                String path="image/"+System.currentTimeMillis()+"."+suffix;
                String realPath = baseDir+"/image/"+System.currentTimeMillis()+"."+suffix;
                System.out.println("realPath--->"+realPath);
                File newfile = new File(realPath);
                try {
                    multipartFile.transferTo(newfile);
                    result.put("msg","上传成功");
                    result.put("code","1");
                    result.put("url",path);
                    return mapper.writeValueAsString(result);
                } catch (IOException e) {
                    e.printStackTrace();
                    result.put("msg","上传过程中发生错误");
                    result.put("code","0");
                    return mapper.writeValueAsString(result);
                }
            }else {
                result.put("msg","不支持该文件的上传");
                result.put("code","0");
                return mapper.writeValueAsString(result);
            }
        }else {
            result.put("msg","该文件为空");
            result.put("code","0");
            return mapper.writeValueAsString(result);
        }
    }
}
