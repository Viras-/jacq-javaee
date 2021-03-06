package org.jacq.common.model.names.taxamatch;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

public class Searchresult {

    private String genus;
    private Integer distance;
    private Long ratio;
    private String taxon;
    private Long ID;
    private List<Species> species = new ArrayList<Species>();
    private Long taxonID;
    private String family;

    /**
     *
     * @return The genus
     */
    public String getGenus() {
        return genus;
    }

    /**
     *
     * @param genus The genus
     */
    public void setGenus(String genus) {
        this.genus = genus;
    }

    /**
     *
     * @return The distance
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     *
     * @param distance The distance
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    /**
     *
     * @return The ratio
     */
    public Long getRatio() {
        return ratio;
    }

    /**
     *
     * @param ratio The ratio
     */
    public void setRatio(Long ratio) {
        this.ratio = ratio;
    }

    /**
     *
     * @return The taxon
     */
    public String getTaxon() {
        return taxon;
    }

    /**
     *
     * @param taxon The taxon
     */
    public void setTaxon(String taxon) {
        this.taxon = taxon;
    }

    /**
     *
     * @return The ID
     */
    @XmlElement(name = "ID")
    public Long getID() {
        return ID;
    }

    /**
     *
     * @param ID The ID
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     *
     * @return The species
     */
    public List<Species> getSpecies() {
        return species;
    }

    /**
     *
     * @param species The species
     */
    public void setSpecies(List<Species> species) {
        this.species = species;
    }

    @XmlElement(name = "taxonID")
    public Long getTaxonID() {
        return taxonID;
    }

    public void setTaxonID(Long taxonID) {
        this.taxonID = taxonID;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
