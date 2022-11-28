package org.kaparzh.hibernatedemo.service.impl;

import org.kaparzh.hibernatedemo.model.Post;
import org.kaparzh.hibernatedemo.model.Writer;
import org.kaparzh.hibernatedemo.repository.WriterRepository;
import org.kaparzh.hibernatedemo.repository.impl.WriterRepositoryImpl;
import org.kaparzh.hibernatedemo.service.WriterService;

import java.util.ArrayList;
import java.util.List;

public class WriterServiceImpl implements WriterService {

    private final WriterRepository writerRepository = new WriterRepositoryImpl();

    @Override
    public Writer getById(Integer id) {
        return writerRepository.getById(id);
    }

    @Override
    public void delete(Integer id) {
        writerRepository.deleteById(id);
    }

    @Override
    public List<Writer> getAll() {
        return writerRepository.getAll();
    }

    @Override
    public Writer create(String firstName, String lastName, List<Post> postList) {
        return writerRepository.save(new Writer(firstName, lastName, postList));
    }

    @Override
    public Writer update(Integer id, String firstName, String lastName) {
        return writerRepository.update(new Writer(id, firstName, lastName, new ArrayList<>()));
    }
}
