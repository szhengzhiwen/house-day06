package com.team.house.pcontroller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.entity.Users;
import com.team.house.service.HouseService;
import com.team.house.util.HouseCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: zzw
 * @Date： 2019/10/21
 * @Description：
 * @Version: 1.0
 */
@Controller(value = "HouseController2")
@RequestMapping("/page/")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @RequestMapping("addHouse")
    public String addHouse(House house, HttpSession session,
                           @RequestParam(value = "pfile",required = false)MultipartFile pfile,
                           Integer type_id,Integer street_id){
        try {
            //1. 上传文件
            String sourceFile = pfile.getOriginalFilename(); //文件名
            String extName = sourceFile.substring(sourceFile.lastIndexOf("."));//扩展名
            String bh=System.currentTimeMillis()+"";
            String filename = bh+extName;
            String path = "d:\\images\\"+filename;
            File saveFile = new File(path);
            pfile.transferTo(saveFile);//上传
            //2. 调用业务将数据保存到数据库
            //设置编号
            house.setId(bh);
            //设置图片
            house.setPath(filename);
            //设置用户编号
            Users user = (Users) session.getAttribute("userinfo");
            house.setUserId(user.getId());
            house.setTypeId(type_id);
            house.setStreetId(street_id);
            house.setIspass(0);
            house.setIsdel(0);
            houseService.addHouse(house);//保存
            return "redirect:getUserHouse";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping("getUserHouse")
    public String getUserHouse(HttpSession session, Model model){
        //调用业务查询所有用户发布的出租房信息
        //设置用户编号
        Users user=(Users) session.getAttribute("userinfo");
        List<House> list=houseService.getHouseByUserid(user.getId());  //固定某值查询
        model.addAttribute("list",list);
        return "guanli";
    }

    @RequestMapping("showHouse")
    public String showHouse(String id,Model model){
        //调用业务查询所有用户发布的出租房信息
        House house = houseService.getHouseById(id);
        model.addAttribute("house",house);
        return "upfabu";
    }

    @RequestMapping("updateHouse")
    public String updateHouse(House house,String oldPic,@RequestParam(value = "pfile",required = false)MultipartFile pfile){
        //根据用户是否选择图片来判定需不需要上传图片
        try {
            if (!pfile.isEmpty()){
                //1.上传文件
                String sourceFile = pfile.getOriginalFilename();  //文件名
                String extName = sourceFile.substring(sourceFile.lastIndexOf(".")); //扩展名
                String bh=System.currentTimeMillis()+"";
                String filename=bh+extName;
                String path="d:\\images\\"+filename;
                File saveFile=new File(path);
                pfile.transferTo(saveFile);   //上传
                //设置图片
                house.setPath(filename);
            }
            //2.调用业务将数据保存到数据库
            houseService.updateHouse(house); //保存

            //删除旧图
            if (!pfile.isEmpty()){
                //删除旧的图片
                File file=new File("d:\\images\\"+oldPic);
                file.delete();
            }
            return "redirect:getUserHouse";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping("delHouse")
    @ResponseBody
    public String delHouse(String id){
        //调用业务删除
        int temp = houseService.delHouse(id, 1);
        return "{\"result\":"+temp+"}";
    }

    //查询用户浏览的出租房
    @RequestMapping("searchHouse")
    public String searchHouse(HouseCondition condition,Model model){
        if(condition.getPage()==null) condition.setPage(1);
        if(condition.getRows()==null) condition.setRows(5);
        //调用业务
        PageInfo<House> houses=this.houseService.getHouseByBroswer(condition);
        //填充信息到Model
        model.addAttribute("houses",houses);
        model.addAttribute("conditioin",condition);
        return "list";
    }
}
