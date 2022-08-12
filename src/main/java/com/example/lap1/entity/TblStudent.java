package com.example.lap1.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "tblstudents")
public class TblStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name must be required")
    @Size(min = 5, message = "Name length must be greater or equal 5 characters")
    private String name;
    @Email
    @NotEmpty(message = "Email must be required")
    private String email;
    @NotEmpty(message = "Phone must be required")
    private String phone;
    private String gender;
    private String note;
    private Long classId;
    @ManyToOne
    @JoinColumn(name = "classId", insertable = false, updatable = false)
    private TblClass tblClass;
}

