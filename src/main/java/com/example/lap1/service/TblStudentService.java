package com.example.lap1.service;

import com.example.lap1.entity.TblClass;
import com.example.lap1.entity.TblStudent;
import com.example.lap1.repository.TblClassRepository;
import com.example.lap1.repository.TblStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class TblStudentService {
    @Autowired
    TblStudentRepository tblStudentRepository;

    @Autowired
    public TblStudentService(TblStudentRepository tblStudentRepository){
        this.tblStudentRepository = tblStudentRepository;
    }

    public TblStudent save(TblStudent tblStudent){
        return tblStudentRepository.save(tblStudent);
    }

    public List<TblStudent> findAll(){
        return tblStudentRepository.findAll();
    }

    public Optional<TblStudent> findById(Long id){
        return tblStudentRepository.findById(id);
    }

    public TblStudent update(Long id, TblStudent tblStudentUpdate){
        Optional<TblStudent> tblStudentOptional = tblStudentRepository.findById(id);
        if (tblStudentOptional.isPresent()){
            TblStudent tblStudent = tblStudentOptional.get();
            tblStudent.setName(tblStudentUpdate.getName());
            tblStudent.setEmail(tblStudentUpdate.getEmail());
            tblStudent.setPhone(tblStudentUpdate.getPhone());
            tblStudent.setGender(tblStudentUpdate.getGender());
            tblStudent.setNote(tblStudentUpdate.getNote());
            tblStudentRepository.save(tblStudent);
            return tblStudent;
        }
        return null;
    }

    public boolean delete(Long id){
        Optional<TblStudent> tblStudentOptional = tblStudentRepository.findById(id);
        if (tblStudentOptional.isPresent()){
            tblStudentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
