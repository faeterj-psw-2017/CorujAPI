package org.faeterj.apicoruja.coruja.service;

import org.faeterj.apicoruja.coruja.model.entity.ATCOM;

import java.util.List;


public interface AtcomService {
    ATCOM create(final ATCOM atcom);
    ATCOM findById(final String atcomId);
    List<ATCOM> findAll();
    ATCOM update(ATCOM atcom);
    void delete(final String atcomId);
}
