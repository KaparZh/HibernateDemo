package org.kaparzh.hibernatedemo.service;

import org.kaparzh.hibernatedemo.model.Label;

public interface LabelService extends GenericService<Label, Integer> {

    Label create(String labelName);

    Label update(Integer id, String labelName);
}
