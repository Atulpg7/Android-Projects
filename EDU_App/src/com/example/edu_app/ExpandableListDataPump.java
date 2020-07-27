package com.example.edu_app;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();
        List<String> syll = new ArrayList<String>();
        syll.add("Institute of Engineering and Technology");
        syll.add("Institute of Business Management");
        syll.add("Institute of Pharmaceutical Research");
        syll.add("Institute of Applied Sciences and Humanities");
        syll.add("Faculty of Education");
        syll.add("University Polytechnic");

       /* syll.add("B.TECH EC");
        syll.add("B.TECH ME");
        syll.add("B.TECH CS");
        syll.add("B.TECH EE");
        syll.add("B.TECH CE");
        syll.add("B.TECH EN");
        syll.add("M.TECH EC");
        syll.add("M.TECH EN");
        syll.add("M.TECH CS");
        syll.add("M.TECH ME");
        syll.add("M.TECH EE");
        syll.add("M.TECH CE");
        syll.add("MCA");
        syll.add("MBA");
        syll.add("BCA");
        syll.add("BBA");
        syll.add("BBA Familly Business");
        
        syll.add("DIPLOMA CE");
        syll.add("DIPLOMA EC");
        syll.add("DIPLOMA CS");
        syll.add("DIPLOMA EE");
        syll.add("DIPLOMA ME");        
        syll.add("M.Sc Micro");
        syll.add("M.Sc Bio");
        
        syll.add("B.Sc(PCM.)");
        syll.add("B.Sc Bio");
        
        syll.add("B.Ed");
        syll.add("B.PHARMA");
        syll.add("D.PHARMA");
        syll.add("M.PHARMA");
        syll.add("B.Com");*/
        
        List<String> uc = new ArrayList<String>();
        List<String> news = new ArrayList<String>();
        List<String> vc = new ArrayList<String>();
        List<String> sc = new ArrayList<String>();
        List<String> abtu = new ArrayList<String>();
      
     
        
        expandableListDetail.put("Employee Portal",news);
        expandableListDetail.put("Visited Company",vc);
     
        expandableListDetail.put("Upcoming Company", uc);
        expandableListDetail.put("Syllabus", syll);
        expandableListDetail.put("Student Corner", sc);
        expandableListDetail.put("About Us", abtu);
    
        return expandableListDetail;
    }
}