package com.mvc.style.controller;

import com.mvc.style.entity.BaseInfo;
import com.mvc.style.entity.BaseInfoExample;
import com.mvc.style.model.InfoModel;
import com.mvc.style.service.BaseInfoService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/baseInfo")
public class BaseInfoController {

    @Resource
    private BaseInfoService baseInfoService ;

    /**
     * 新增
     */
    @PostMapping("/insert")
    public Integer insert (@RequestBody BaseInfo baseInfo){
        return baseInfoService.insert(baseInfo);
    }
    /**
     * 更新
     */
    @PutMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id,
                         @RequestBody BaseInfo baseInfo) {
        if (id<1){
            return "error";
        }
        baseInfo.setId(id);
        return "update="+baseInfoService.update(baseInfo);
    }
    /**
     * 主键查询
     */
    @GetMapping("/detail/{id}")
    public InfoModel detail(@PathVariable(value = "id") Integer id) {
        return baseInfoService.detail(id) ;
    }
    /**
     * 主键删除
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id) {
        baseInfoService.delete(id) ;
        return "SUS" ;
    }
    /**
     * 列表加载
     */
    @GetMapping("/list")
    public List<BaseInfo> list() {
        return baseInfoService.list(new BaseInfoExample()) ;
    }
    /**
     * 列表搜索
     */
    @PostMapping("/search")
    public List<BaseInfo> search (@RequestParam("userName") String userName,
                                  @RequestParam("phone") String phone) {
        return baseInfoService.search(userName,phone) ;
    }
    /**
     * 自定义主键查询
     */
    @GetMapping("/getBy/{id}")
    public BaseInfo getById (@PathVariable(value = "id") Integer id) {
        return baseInfoService.getById(id) ;
    }

}
