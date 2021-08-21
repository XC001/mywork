package com.learn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

@Controller
public class DownloadController {

    @Value("${downloadDir}")
    private String rootPath;

    @RequestMapping("/")
    public ModelAndView getDownload(){
        List list = getFileList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("download");
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @RequestMapping("/{fileName}")
    public void doGet(@PathVariable String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filePath = rootPath + "/" + fileName;
        String fileType = "application/octet-stream";

        response.setContentType(fileType);
        response.setHeader("Content-disposition", "attachment; filename="+fileName);
        try(FileInputStream inputStream = new FileInputStream(filePath);
            OutputStream outputStream = response.getOutputStream();) {

            byte bytes[] = new byte[4096];
            int length;

            while ((length = inputStream.read(bytes)) > 0) {
                outputStream.write(bytes, 0, length);
            }

            outputStream.flush();
        }
    }

    private List getFileList(){
        File dir = new File(rootPath);
        if(dir.exists() && dir.isDirectory()){
            return Arrays.asList(dir.list());
        }
        return null;
    }
}
