package org.faeterj.apicoruja.coruja.model.repository;

import org.faeterj.apicoruja.coruja.model.entity.TokenJwt;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Rodrigo Sudano on 22-Jul-17.
 */

public interface TokenJwtRepository extends PagingAndSortingRepository<TokenJwt,Long>
{
    TokenJwt findByMatricula(String matricula);
}

