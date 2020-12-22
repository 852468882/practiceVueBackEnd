package com.example.practicevue.controller;

import com.example.practicevue.common.APIResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zcy
 * @date 2020/12/21
 */
@RestController
public class UploadPictureController {

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public APIResponse uploadPicture(MultipartFile file, HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        String fileName = file.getName();
        String originalFilename = file.getOriginalFilename();
        String requestUri = request.getRequestURI();
        String requestUrl = request.getRequestURL().toString();

        map.put("fileName", fileName);
        map.put("originalFileName", originalFilename);
        map.put("requestURI", requestUri);
        map.put("requestURL", requestUrl);

        String tempPath = "tmp_uploads/" + originalFilename;
        map.put("temp_path", tempPath);
        String url = requestUrl.substring(0, requestUrl.length() - requestUri.length()) + tempPath;
        map.put("url", url);
        return APIResponse.success("上传成功", map);
    }
}
