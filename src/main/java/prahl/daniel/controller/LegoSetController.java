package prahl.daniel.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import prahl.daniel.model.LegoSet;
import prahl.daniel.repository.LegoSetRepository;

import javax.inject.Inject;
import java.util.ArrayList;

@RequestMapping("/sets")
@RestController
@CrossOrigin//("http://localhost:8100")
public class LegoSetController {

    @Inject
    private LegoSetRepository legoSetRepository;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ResponseEntity<ArrayList<LegoSet>> getAllLegoSets() {
        if(legoSetRepository.count() > 0) {
            ArrayList<LegoSet> allLegoSets = (ArrayList<LegoSet>) legoSetRepository.findAll();
            return new ResponseEntity<>(allLegoSets, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{legoSetId}", method= RequestMethod.GET)
    public ResponseEntity<LegoSet> getLegoSet(@PathVariable Long legoSetId) {
        if(legoSetRepository.exists(legoSetId)) {
            LegoSet legoSet = legoSetRepository.findOne(legoSetId);
            return new ResponseEntity<>(legoSet, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{legoSetId}/url", method= RequestMethod.GET)
    public ResponseEntity<String> getLegoSetUrl(@PathVariable Long legoSetId) {
        if(legoSetRepository.exists(legoSetId)) {
            LegoSet legoSet = legoSetRepository.findOne(legoSetId);
            String url = legoSet.getUrl();
            return new ResponseEntity<>(url, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value="/", method = RequestMethod.POST)
    public ResponseEntity<LegoSet> createLegoSet(@RequestBody LegoSet legoSet, UriComponentsBuilder ucBuilder){
        legoSet = legoSetRepository.save(legoSet);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("{id}")
                .buildAndExpand(legoSet.getId())
                .toUri());
        return new ResponseEntity<>(legoSet, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{legoSetId}", method = RequestMethod.PUT)
    public ResponseEntity<LegoSet> updateLegoSet(@RequestBody LegoSet legoSet, @PathVariable Long legoSetId){
        if(legoSetRepository.exists(legoSetId)) {
            legoSet = legoSetRepository.save(legoSet);
            return new ResponseEntity<>(legoSet, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{legoSetId}", method = RequestMethod.DELETE)
    public ResponseEntity<LegoSet> deleteLegoSet(@PathVariable Long legoSetId) {
        legoSetRepository.delete(legoSetId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/", method = RequestMethod.DELETE)
    public ResponseEntity<LegoSet> deleteAllLegoSets() {
        if(legoSetRepository.count() > 0) {
            legoSetRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value="/description/{description}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<LegoSet>> searchByDescription(@PathVariable String description){
        ArrayList<LegoSet> shortList = (ArrayList<LegoSet>)legoSetRepository.findByDescriptionContainsIgnoreCase(description);
        return new ResponseEntity<>(shortList, HttpStatus.OK);
    }

    @RequestMapping(value="/number/{setNumber}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<LegoSet>> searchBySetNumber(@PathVariable String setNumber){
        ArrayList<LegoSet> shortList = (ArrayList<LegoSet>)legoSetRepository.findBySetNumberContains(setNumber);
        return new ResponseEntity<>(shortList, HttpStatus.OK);
    }

}