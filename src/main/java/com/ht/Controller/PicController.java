package com.ht.Controller;

import com.ht.bean.Pictures;
import com.ht.service.IPicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/pic")
public class PicController {

    @Resource
    private IPicService is;

    @RequestMapping("/list")
    public String list(Model model){
        List<Pictures> list = is.slepic();
        model.addAttribute("list",list);
        return "upload";
    }

    @RequestMapping("/upload")
    public String upload(MultipartFile file, Pictures pic) throws IOException {
        // 把文件保存到upload目录下
        // 保存文件，这个文件名有的时候文件名可能会重复，你保存多了会把原来的图片给覆盖掉，这就不太合适了。
        // 所以为每个文件生成一个新的文件名
        String picName = UUID.randomUUID().toString();
        // 截取文件的扩展名(如.jpg)
        String oriName = file.getOriginalFilename();
        System.out.println("--上传文件名-->>"+oriName);
        String extName = oriName.substring(oriName.lastIndexOf("."));

//        String path = request.getSession().getServletContext().getRealPath("\\");  //获取项目路径
        String dirName = "D:\\temp\\img\\";
        //创建文件夹
        File dirFile = new File(dirName);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        //新文件名
        String newFileName = picName + extName;
        File targetFile = new File(dirName , newFileName);
        // 保存文件
        file.transferTo(targetFile);
        /* 把文件名保存到数据库 */
        System.out.println("本地路径---->>"+(dirName + newFileName));
        String jsonStr = "{\"code\" : 0 , \"relativePath\" : \""+(dirName + newFileName)+"\"}";

        pic.setPtime(new Date());
        pic.setPsrc("/img/"+newFileName);

        is.addpic(pic);

        return "redirect:list";
    }
}
