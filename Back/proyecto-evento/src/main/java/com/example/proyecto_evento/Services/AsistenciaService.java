package com.example.proyecto_evento.Services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.example.proyecto_evento.Models.asistencia;
import com.example.proyecto_evento.Repositories.AsistenciaRepository;

@Service
//public class AsistenciaService implements AsistenciaRepository{
public class AsistenciaService {
    @Autowired
    public AsistenciaRepository asistenciaRepository;

    /* @Override
    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllByIdInBatch'");
    }

    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
    }

    @Override
    public void deleteAllInBatch(Iterable<asistencia> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
    }

    @Override
    public <S extends asistencia> List<S> findAll(Example<S> example) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        return asistenciaRepository.findAll(example);
    }

    @Override
    public <S extends asistencia> List<S> findAll(Example<S> example, Sort sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'flush'");
    }

    @Override
    public asistencia getById(Integer arg0) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getById'");
        return asistenciaRepository.getById(arg0);
    }

    @Override
    public asistencia getOne(Integer arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOne'");
    }

    @Override
    public asistencia getReferenceById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
    }

    @Override
    public <S extends asistencia> List<S> saveAllAndFlush(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
    }

    @Override
    public <S extends asistencia> S saveAndFlush(S entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
    }
 */
   
    public List<asistencia> findAll() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        return asistenciaRepository.findAll();
    }

   /*  @Override
    public List<asistencia> findAllById(Iterable<Integer> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }

    @Override
    public <S extends asistencia> List<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return asistenciaRepository.saveAll(entities);
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return asistenciaRepository.count();
    }

    @Override
    public void delete(asistencia entity) {
        // TODO Auto-generated method stub
        asistenciaRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        asistenciaRepository.deleteAll();
    }

    @Override
    public void deleteAll(Iterable<? extends asistencia> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        asistenciaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        // TODO Auto-generated method stub
        return asistenciaRepository.existsById(id);
    }

    @Override
    public Optional<asistencia> findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public <S extends asistencia> S save(S entity) {
        // TODO Auto-generated method stub
        return asistenciaRepository.save(entity);
    }

    @Override
    public List<asistencia> findAll(Sort sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Page<asistencia> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends asistencia> long count(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public <S extends asistencia> boolean exists(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public <S extends asistencia> Page<S> findAll(Example<S> example, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends asistencia, R> R findBy(Example<S> arg0, Function<FetchableFluentQuery<S>, R> arg1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBy'");
    }

    @Override
    public <S extends asistencia> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

 */    public void confirmarAsistencia(Integer idUsuario, Integer idEvento) {
        // TODO Auto-generated method stub
        asistenciaRepository.confirmarAsistencia(idUsuario, idEvento);
    }

    public void actualizaAsistencia(Integer idUsuario, Integer idEvento, Boolean estado) {
        // TODO Auto-generated method stub
        asistenciaRepository.actualizaAsistencia(idUsuario, idEvento, estado);
    }

}
