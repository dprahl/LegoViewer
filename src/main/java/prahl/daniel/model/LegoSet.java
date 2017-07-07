package prahl.daniel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LegoSet {

    @Id
    @GeneratedValue
    @Column(name="LEGOSET_ID")
    private Long id;

    @Column(name="SET_NUMBER")
    private String setNumber;

    @Column(name="URL")
    private String url;

    @Column(name="DESCRIPTION")
    private String description;

    public LegoSet(){}

    public LegoSet(String setNumber, String url, String description){
        this.setNumber = setNumber;
        this.url = url;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(String setNumber) {
        this.setNumber = setNumber;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}