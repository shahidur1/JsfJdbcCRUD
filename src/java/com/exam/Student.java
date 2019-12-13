/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

/**
 *
 * @author apcl
 */
@ManagedBean
public class Student {

    private int id;
    private String name;
    private String email;
    private int phone;

    private List<Student> stList = new ArrayList<Student>();
    DBConnection dBConnection = new DBConnection();
    //for dropdown list
    private int selectedId;

    public Student() {
    }

    public Student(int id, String name, String email, int phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void doInsert() {
        try {

            Connection con = dBConnection.doConnection();

            String ss = "insert into work1 values (?,?,?,?)";

            PreparedStatement psment = con.prepareStatement(ss);

            psment.setInt(1, id);
            psment.setString(2, name);
            psment.setString(3, email);
            psment.setInt(4, phone);

            int n = psment.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void doUpdate() {
        try {
            Connection con = dBConnection.doConnection();
            String q = "update work1 set name = ?, email = ? , phone = ? where id = ?";

            PreparedStatement psment = con.prepareStatement(q);

            psment.setString(1, name);
            psment.setString(2, email);
            psment.setInt(3, phone);
            psment.setInt(4, selectedId);

            int n = psment.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void doDelete() {
        try {
            Connection con = dBConnection.doConnection();

            String ss = "delete from work1 where id  = ?";

            PreparedStatement psment = con.prepareStatement(ss);

            psment.setInt(1, selectedId);

            int n = psment.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void show() {
        try {
            Connection con = dBConnection.doConnection();

            String ss = "select * from work1";

            PreparedStatement psment = con.prepareStatement(ss);

            ResultSet rs = psment.executeQuery();

            while (rs.next()) {
                Student s = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                stList.add(s);
            }

        } catch (Exception e) {
        }
    }

//    public List<SelectItem> getLoad(){
//        List<SelectItem> ladd = new ArrayList<SelectItem>();
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ss", "root", "apcl123456");
//
//            String ss = "select * from work1";
//
//            PreparedStatement psment = con.prepareStatement(ss);
//            
//            ResultSet rs = psment.executeQuery();
//            
//            while(rs.next()){
//                ladd.add(new SelectItem(rs.getInt(1)));
//            }
//
//        } catch (Exception e) {
//        }
//        return ladd;
//    }
    private List<Integer> idList = new ArrayList<Integer>();

    public List<Integer> getIdList() {

        try {
            Connection con = dBConnection.doConnection();

            String ss = "select * from work1";

            PreparedStatement psment = con.prepareStatement(ss);

            ResultSet rs = psment.executeQuery();

            while (rs.next()) {
                Student s = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                idList.add(s.getId());
                //nameList.add(s.getName());
            }

        } catch (Exception e) {
        }
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

//    public List<Integer> getLoad() {
//        List<Integer> idList = new ArrayList<Integer>();
//        //List<String> nameList = new ArrayList<String>();
//        try {
//            Connection con = dBConnection.doConnection();
//
//            String ss = "select * from work1";
//
//            PreparedStatement psment = con.prepareStatement(ss);
//
//            ResultSet rs = psment.executeQuery();
//
//            while (rs.next()) {
//                Student s = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
//                idList.add(s.getId());
//                //nameList.add(s.getName());
//            }
//
//        } catch (Exception e) {
//        }
//        return idList;
//    }

    public List<Student> getStList() {
        return stList;
    }

    public void setStList(List<Student> stList) {
        this.stList = stList;
    }

    public int getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
    }

}
