package cn.yxy.controller;

import cn.yxy.domain.Student;
import cn.yxy.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.DispatcherServlet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/student")
public class StudentController {

//    @Resource(name="studentService1")
    private StudentService studentService1;
//    @Resource(name="studentService2")
    private StudentService studentService2;

    private StudentService CurrentStudentService;
    private Logger logger = LogManager.getLogger(this.getClass());

//    @PostConstruct
//    public void initService(){
//        CurrentStudentService=Math.random()>0.5?studentService:studentServiceA;
//    }//感觉只会执行一次，不会随机

    @RequestMapping(method = RequestMethod.GET)
    public String stuHome(Model model) {
        model.addAttribute("message", "这是一个student表的主页，可能在将来提供一些链接");
        return "student/home";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(Model model, @RequestBody Student stu, HttpServletRequest request) {
        CurrentStudentService = getRandomOne(request);
        long id = CurrentStudentService.insert(stu);
        model.addAttribute("message", "插入成功了吧，你的ID是：" + id);
        return "student/home";
    }

    @RequestMapping(value = "/u/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Student get(@PathVariable long id, HttpServletRequest request) {
        CurrentStudentService = getRandomOne(request);
        Student stu = CurrentStudentService.get(id);
        return stu;
    }

    @RequestMapping(value = "/u/{id}", method = RequestMethod.DELETE)
    public String delete(Model model, @PathVariable long id, HttpServletRequest request) {
        CurrentStudentService = getRandomOne(request);
        boolean tf = CurrentStudentService.delete(id);
        model.addAttribute("message", id + "删了吗" + tf);
        return "student/home";
    }

    @RequestMapping(value = "/u", method = RequestMethod.PUT)
    public String update(Model model, @RequestBody Student stu, HttpServletRequest request) {
        CurrentStudentService = getRandomOne(request);
        boolean tf = CurrentStudentService.update(stu);
        model.addAttribute("message", stu.getid() + "更新了吗" + tf);
        return "student/home";
    }

    public StudentService getRandomOne(HttpServletRequest request){
        StudentService currentSS;
        ApplicationContext context= (ApplicationContext) request.getAttribute("org.springframework.web.servlet.DispatcherServlet.CONTEXT");
        logger.debug(context);
        boolean flag=Math.random()<0.5 ? true:false;
        try {
            if(flag){
                logger.info(flag+" in try s1");
                studentService1= (StudentService) context.getBean("studentService1");
                currentSS=studentService1;
            } else{
                logger.info(flag+" in try s2");
                studentService2=(StudentService) context.getBean("studentService2");
                currentSS=studentService2;
            }
        } catch (Exception e) {
            if(flag){
                logger.info(flag+" in catch s2");
                studentService2= (StudentService) context.getBean("studentService2");
                currentSS=studentService2;
            } else{
                logger.info(flag+" in catch s1");
                studentService1= (StudentService) context.getBean("studentService1");
                currentSS=studentService1;
            }
        }
        logger.debug(currentSS);
        return currentSS;
    }
}
