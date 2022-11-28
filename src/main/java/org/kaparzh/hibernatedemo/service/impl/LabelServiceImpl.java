package org.kaparzh.hibernatedemo.service.impl;

import org.kaparzh.hibernatedemo.model.Label;
import org.kaparzh.hibernatedemo.repository.LabelRepository;
import org.kaparzh.hibernatedemo.repository.impl.LabelRepositoryImpl;
import org.kaparzh.hibernatedemo.service.LabelService;

import java.util.List;

public class LabelServiceImpl implements LabelService {

    private final LabelRepository labelRepository = new LabelRepositoryImpl();

    @Override
    public Label getById(Integer id) {
        return labelRepository.getById(id);
    }

    @Override
    public void delete(Integer id) {
        labelRepository.deleteById(id);
    }

    @Override
    public List<Label> getAll() {
        return labelRepository.getAll();
    }

    @Override
    public Label create(String labelName) {
        return labelRepository.save(new Label(1, labelName));
    }

    @Override
    public Label update(Integer id, String labelName) {
        return labelRepository.update(new Label(id, labelName));
    }
}
