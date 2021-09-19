package com.hiber.demo.HiberDemo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Emp {

    @Id
    @GeneratedValue
    @Column(name = "emp_id")
    private int empId;

    @Column(name = "emp_name")
    private String empName;


    @OneToMany(mappedBy = "emp",fetch = FetchType.EAGER)
    private List<Project> project;


    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", project=" + project +
                '}';
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }


    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

}

@Entity
class Project {


    @Id
    @GeneratedValue
    @Column(name = "p_id")
    private int pId;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Emp emp;

    @Column(name = "p_name")
    private String pName;

    @Override
    public String toString() {
        return "Project [pId=" + pId + ", pName=" + pName + "]";
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

}
