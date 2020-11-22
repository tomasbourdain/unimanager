package pt.iade.unimanage.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimanage.models.Teacher;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping(path="/api/teachers")
public class TeacherController{
    private Logger logger=LoggerFactory.getLogger(StudentController.class);
    
    
    @GetMapping(path="",produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Teacher> getTeachers(){
        logger.info("Sending all teachers");
        return TeacherRepository.getTeachers();
    }
    @GetMapping(path="{mecNumber}",
    produces=MediaType.APPLICATION_JSON_VALUE)
    public Teacher getTeacher(@PathVariable("number")int mecNumber)
                                                    throws NotFoundException{
        logger.info("Sending teacher with number"+mecNumber);
        Teacher teacher=TeacherRepository.getTeacher(mecNumber);
        if(teacher!=null)return teacher;
        else throw new NotFoundException(""+mecNumber,"Teacher","number");
    }
    @PostMapping(path="{teacher}/{unitId}",
    produces=MediaType.APPLICATION_JSON_VALUE)
    public Teacher addTeacherUnit(@RequestBody Teacher teacher){
        logger.info("adding unit with number"+unitId);
        if(TeacherRepository.addTeacherUnit(unitId))
            return new Response(unitId+"was deleted.",null);
        else return new Response(unitId+"not found.",null);
    }
    @DeleteMapping(path="{unitId}",produces=MediaType.APPLICATION_JSON_VALUE)
    public Response deleteTeacherUnit(@PathVariable int unitId){
        logger.info("deleting unit with number"+unitId);
        if(TeacherRepository.deleteTeacherUnit(unitId))
            return new Response(unitId+"was deleted.",null);
        else return new Response(unitId+"not found.",null);
    }
}