package cn.stylefeng.guns.modular.thing.controller;

import cn.stylefeng.guns.core.log.LogObjectHolder;
import cn.stylefeng.guns.modular.system.model.Thing;
import cn.stylefeng.guns.modular.thing.service.IThingService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 事件审核控制器
 *
 * @author fengshuonan
 * @Date 2019-04-01 10:48:13
 */
@Controller
@RequestMapping("/thing")
public class ThingController extends BaseController {

    private String PREFIX = "/thing/thing/";

    @Autowired
    private IThingService thingService;

   
    
    /**
     * 跳转到事件审核首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "thing.html";
    }

    /**
     * 跳转到添加事件审核
     */
    @RequestMapping("/thing_add")
    public String thingAdd() {
        return PREFIX + "thing_add.html";
    }

    /**
     * 跳转到修改事件审核
     */
    @RequestMapping("/thing_update/{thingId}")
    public String thingUpdate(@PathVariable Integer thingId, Model model) {
        Thing thing = thingService.selectById(thingId);
        model.addAttribute("item",thing);
        LogObjectHolder.me().set(thing);
        return PREFIX + "thing_edit.html";
    }

    /**
     * 获取事件审核列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    	List<Thing> selectList = thingService.selectList(null);
    	for(Thing ts : selectList) {
    		Integer type = ts.getType();
    		if(type == 0) {
    			ts.setThing("待审核");
    		}
    		if(type == 1) {
    			ts.setThing("已审核");
    		}
    	}
        return selectList;//thingService.selectList(null);
    }

    /**
     * 新增事件审核
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Thing thing) {
        thingService.insert(thing);
        return SUCCESS_TIP;
    }

    /**
     * 删除事件审核
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer thingId) {
        thingService.deleteById(thingId);
        return SUCCESS_TIP;
    }

    /**
     * 修改事件审核
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Thing thing) {
        thingService.updateById(thing);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        return SUCCESS_TIP;
    }

    /**
     * 事件审核详情
     */
    @RequestMapping(value = "/detail/{thingId}")
    @ResponseBody
    public Object detail(@PathVariable("thingId") Integer thingId) {
        return thingService.selectById(thingId);
    }
}
