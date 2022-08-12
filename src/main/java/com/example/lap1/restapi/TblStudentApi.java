package com.example.lap1.restapi;

import com.example.lap1.entity.TblStudent;
import com.example.lap1.service.TblStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tblstudents")
public class TblStudentApi {
    @Autowired
    TblStudentService tblStudentService;

    @PostMapping
    public ResponseEntity<TblStudent> save(@RequestBody TblStudent tblStudent){
        return ResponseEntity.ok(tblStudentService.save(tblStudent));
    }

    @GetMapping
    public ResponseEntity<List<TblStudent>> findAll(){
        return ResponseEntity.ok(tblStudentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<TblStudent> tblStudentOptional = tblStudentService.findById(id);
        if (tblStudentOptional.isPresent()){
            return ResponseEntity.ok(tblStudentOptional.get());
        }
        return ResponseEntity.badRequest().body("Student not found!");

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TblStudent tblStudentUpdate){
        TblStudent tblStudent = tblStudentService.update(id, tblStudentUpdate);
        if (tblStudent != null){
            return ResponseEntity.ok(tblStudent);
        }
        return ResponseEntity.badRequest().body("Student not found!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if (tblStudentService.delete(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body("Student not found!");
    }
}
