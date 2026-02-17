package com.example.proyecto_evento.Services;

import java.time.LocalDateTime;
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

import com.example.proyecto_evento.Models.usuario;
import com.example.proyecto_evento.Repositories.UsuarioRepository;

@Service
public class UsuarioService implements UsuarioRepository{
    @Autowired
    public UsuarioRepository usuarioRepository;


<<<<<<< HEAD
    public Optional<usuario> findByUsernameAndPassword(String email, String ps){
    return usuarioRepository.findByUsernameAndPassword(email, ps);
}
    /* @Override
=======
    @Override
>>>>>>> 6bae718bad2f83c8114090b558cb9c3a71c45ec1
    public void flush() {
        // TODO Auto-generated method stub
        usuarioRepository.flush();
    }

    @Override
    public <S extends usuario> S saveAndFlush(S entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
    }

    @Override
    public <S extends usuario> List<S> saveAllAndFlush(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
    }

    @Override
    public void deleteAllInBatch(Iterable<usuario> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllByIdInBatch'");
    }

    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub
        usuarioRepository.deleteAllInBatch();
    }

    @Override
    public usuario getOne(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOne'");
    }

    @Override
    public usuario getById(Integer id) {
        // TODO Auto-generated method stub
        return usuarioRepository.getById(id);
    }

    @Override
    public usuario getReferenceById(Integer id) {
        // TODO Auto-generated method stub
        return usuarioRepository.getReferenceById(id);
    }

    @Override
    public <S extends usuario> List<S> findAll(Example<S> example) {
        // TODO Auto-generated method stub
       return usuarioRepository.findAll(example);
    }

    @Override
    public <S extends usuario> List<S> findAll(Example<S> example, Sort sort) {
        // TODO Auto-generated method stub
       return usuarioRepository.findAll(example,  sort);
    }

    @Override
    public <S extends usuario> List<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return usuarioRepository.saveAll(entities);
    }

    @Override
    public List<usuario> findAll() {
        // TODO Auto-generated method stub
        return usuarioRepository.findAll();
    }

    @Override
    public List<usuario> findAllById(Iterable<Integer> ids) {
        // TODO Auto-generated method stub
        return usuarioRepository.findAllById(ids);
    }

    @Override
    public <S extends usuario> S save(S entity) {
        // TODO Auto-generated method stub
        return usuarioRepository.save(entity);
    }

    @Override
    public Optional<usuario> findById(Integer id) {
        // TODO Auto-generated method stub
        return usuarioRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        // TODO Auto-generated method stub
        return usuarioRepository.existsById(id);
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return usuarioRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
       usuarioRepository.deleteById(id);
    }

    @Override
    public void delete(usuario entity) {
        // TODO Auto-generated method stub
        usuarioRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        // TODO Auto-generated method stub
        usuarioRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAll(Iterable<? extends usuario> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        usuarioRepository.deleteAll();
    }

    @Override
    public List<usuario> findAll(Sort sort) {
        // TODO Auto-generated method stub
        return usuarioRepository.findAll(sort);
    }

    @Override
    public Page<usuario> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends usuario> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public <S extends usuario> Page<S> findAll(Example<S> example, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends usuario> long count(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public <S extends usuario> boolean exists(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public <S extends usuario, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBy'");
    }

    @Override
    public Optional<usuario> findByUsernameAndPassword(String nombre, String ps) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUsernameAndPassword'");
    }
    public boolean login(String email, String ps) {
        return usuarioRepository.findByUsernameAndPassword(email, ps).isPresent();
    }

    @Override
    public void insertarUsuario(String nombre, String apellido, String email, String password) {
        // TODO Auto-generated method stub
        usuarioRepository.insertarUsuario(nombre, apellido, email, password);
        
    }

    @Override
    public Integer findIdByUsername(String nombre) {
        // TODO Auto-generated method stub
        return usuarioRepository.findIdByUsername(nombre);
    }

    @Override
    public List<String> findAllEmail() {
        // TODO Auto-generated method stub
        return usuarioRepository.findAllEmail();
    }



}
 