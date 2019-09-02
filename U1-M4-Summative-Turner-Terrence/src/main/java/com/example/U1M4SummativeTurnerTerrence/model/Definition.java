package com.example.U1M4SummativeTurnerTerrence.model;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class Definition {

    @NotEmpty(message = "You must supply a value for word")
    private String word;

    @NotEmpty(message = "You must supply a value for definition")
    private String definition;

    public Definition(@NotEmpty(message = "You must supply a value for word") String word,
                      @NotEmpty(message = "You must supply a value for definition") String definition) {
        this.word = word;
        this.definition = definition;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public static List<Definition> definitionList = new ArrayList<Definition>();

    public static List<Definition> getDefinitionList() {
        return definitionList;
    }

    public void setDefinitionList(List<Definition> definitionList) {
        Definition.definitionList = definitionList;
    }



}
