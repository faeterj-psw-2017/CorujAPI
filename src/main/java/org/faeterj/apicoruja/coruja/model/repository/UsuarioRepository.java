package org.faeterj.apicoruja.coruja.model.repository;

import org.faeterj.apicoruja.coruja.model.entity.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Rodrigo Sudano on 21-Jul-17.
 */
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario,Long>
{
    Usuario findByMatricula(String matricula);
}
