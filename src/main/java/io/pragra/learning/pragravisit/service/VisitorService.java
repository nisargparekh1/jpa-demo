package io.pragra.learning.pragravisit.service;

import io.pragra.learning.pragravisit.entity.PragraVisitor;
import io.pragra.learning.pragravisit.exceptions.InvalidDataException;
import io.pragra.learning.pragravisit.repo.VisitorRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class VisitorService {
    private VisitorRepo repo;

    public VisitorService(VisitorRepo repo) {
        this.repo = repo;
    }
    /* create a visitor */
    public PragraVisitor createVisitor(PragraVisitor visitor){
        return repo.save(visitor);
    }

    public PragraVisitor updateVisitor( PragraVisitor visitor) {
        validateId(visitor.getId());
//        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$/g");
//
//        if (!pattern.matcher(visitor.getEmail()).matches()) {
//            throw new InvalidDataException("Email is not valid");
//        }
        visitor.setUpdateDate(Instant.now());

        return repo.save(visitor);
    }

    public PragraVisitor getById(Integer id)  {

        log.debug("Searching Visitor for id {} ", id);
        validateId(id);

        Optional<PragraVisitor> byId = repo.findById(id);
        return byId.orElseThrow(()->new RuntimeException("No DataFound for id "+ id));

    }

    private void validateId(Integer id) {
        if(id ==null ||  id <= 0) {
            throw  new InvalidDataException("ID pass is not valid");
        }
    }

    public List<PragraVisitor> getAll(){
        return repo.findAll();
    }

    public List<PragraVisitor> createBatch(List<PragraVisitor> visitors) {
        return repo.saveAll(visitors);
    }

    public void deleteById(int id ){
        repo.deleteById(id);
    }

    public List<PragraVisitor> getAllbyLastName(String lastname) {
        return repo.findAllByLastName(lastname);
    }

    public List<PragraVisitor> getAllByLastNameAndFirstName(String lastname, String fistname) {
        return repo.findAllByLastNameAndFirstName(lastname,fistname);
    }

    public List<PragraVisitor> getAllbyFirstName(String firstname) {
        return  repo.findAllByFirstName(firstname);
    }
}
