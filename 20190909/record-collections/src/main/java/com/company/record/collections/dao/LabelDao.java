package com.company.record.collections.dao;

import com.company.record.collections.model.Label;

import java.util.List;

public interface LabelDao {

    /**
     * Gets label
     * @param id
     * @return
     */
    Label getLabel(int id);

    /**
     * Gets all labels
     * @return
     */
    List<Label> getAllLabels();

    /**
     * Adds labels
     * @param label
     * @return
     */
    Label addLabel(Label label);

    /**
     * Updates label
     * @param label
     */
    void updateLabel(Label label);

    /**
     * Deletes label
     * @param id
     */
    void deleteLabel(int id);


}
