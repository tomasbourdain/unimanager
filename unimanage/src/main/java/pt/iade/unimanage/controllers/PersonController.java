package pt.iade.unimanage.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping(path="/api/persons")
public class PersonController{
    private Logger logger=LoggerFactory.getLogger(StudentController.class);
    
    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getPersons() {
        logger.info("Sending all persons");
        ArrayList<Person> persons = new ArrayList<>();
        persons.addAll(StudentRepository.getStudents());
        persons.addAll(TeacherRepository.getTeachers());
        return persons;
    }
    @GetMapping(path = "/search",produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Person> searchPersons(
        @RequestParam(value = "name",defaultValue="") String name,
        @RequestParam(value = "email",defaultValue="") String email) {
        ArrayList<Person> persons = getAllPersons();
            persons.removeIf(
                (p) -> !(p.getName().contains(name) &&
                         p.getEmail().contains(email)));
            return persons;
    }
    @GetMapping(path="{reference}",
    produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getReference(@PathVariable("reference")String reference)
                                                    throws NotFoundException{
        logger.info("Sending person with reference"+reference);
        ArrayList<Person> persons = new ArrayList<>();
        persons.addAll(StudentRepository.getStudents(reference));
        persons.addAll(TeacherRepository.getTeachers(reference));
        if(person!=null)return person;
        else throw new NotFoundException(""+reference,"Person","reference");
    }
    @GetMapping(path="{email}",
    produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getPersonEmail(@PathVariable("email")String email)
                                                    throws NotFoundException{
        logger.info("Sending person with email"+email);
        ArrayList<Person> persons = new ArrayList<>();
        persons.addAll(StudentRepository.getStudents(email));
        persons.addAll(TeacherRepository.getTeachers(email));
        if(person!=null)return person;
        else throw new NotFoundException(""+email,"Person","email");
    }
    @GetMapping(path="{name}",
    produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getPersonName(@PathVariable("name")String name)
                                                    throws NotFoundException{
        logger.info("Sending person with name"+name);
        ArrayList<Person> persons = new ArrayList<>();
        persons.addAll(StudentRepository.getStudents(name));
        persons.addAll(TeacherRepository.getTeachers(name));
        if(person!=null)return person;
        else throw new NotFoundException(""+email,"Person","name");    
    }
}